package com.example.chessbot.game.validators.movement;

import com.example.chessbot.game.utility.CaptureUtil;
import com.example.chessbot.game.utility.EmptyPieceUtil;
import com.example.chessbot.game.utility.EnemyPieceUtil;
import com.example.chessbot.game.utility.PathCollisionUtil;
import com.example.chessbot.model.state.GameState;
import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.piece.PieceNames;
import com.example.chessbot.model.piece.PieceTeam;

import java.util.Map;

public final class PawnMoveValidator {
    // TODO properly implement this function / correct pawn movement
    public static boolean validate(GameState gameState, BoardPosition currentPosition, BoardPosition desiredPosition) {
        Piece toMove = gameState.getBoard().get(currentPosition);
        int difX = desiredPosition.getX() - currentPosition.getX();
        int difY = desiredPosition.getY() - currentPosition.getY();

        // filter out moves that are not 'forward' for given team
        if (!onlyMovesForward(toMove.getPieceTeam(), difY)) {
            return false;
        }

        // if move is straight ahead - one or two spaces - verify that there is nothing in path
        Map<BoardPosition, Piece> board = gameState.getBoard();
        int deltaX = Math.abs(difX);
        int deltaY = Math.abs(difY);

        // if move is 2 check for touched
        if (deltaY == 2 && deltaX == 0 && !toMove.getTouched()) {
            if (PathCollisionUtil.checkForCollisionsOnVerticalPath(board, currentPosition, desiredPosition)) {
                return false;
            }
            Piece inDesired = board.get(desiredPosition);
            return EmptyPieceUtil.isPieceEmpty(inDesired);
        }

        // if move is 1 check for empty
        if (deltaY == 1 && deltaX == 0) {
            Piece inDesired = board.get(desiredPosition);
            return EmptyPieceUtil.isPieceEmpty(inDesired);
        }

        // if move is diagonal verify that there is piece in desired position to capture
        if (deltaY == 1 && deltaX == 1) {
            Piece inDesired = board.get(desiredPosition);
            if (!EmptyPieceUtil.isPieceEmpty(inDesired)) {
                if (EnemyPieceUtil.isPieceEnemy(toMove, inDesired)) {
                    return CaptureUtil.canCapture(toMove, inDesired);
                } else return false;
                // if desired is empty, check for en passant capture
            } else return captureEnPassant(gameState, currentPosition, desiredPosition, toMove.getPieceTeam());
        }
        // finally return false
        return false;
    }

    private static boolean onlyMovesForward(PieceTeam pieceTeam, int deltaY) {
        return pieceTeam == PieceTeam.WHITE ? deltaY > 0 : deltaY < 0;
    }

    private static boolean captureEnPassant(GameState gameState, BoardPosition current, BoardPosition desired, PieceTeam allies) {
        Map<BoardPosition, Piece> board = gameState.getBoard();

        int difX = desired.getX() - current.getX();
        int oneFileOver = desired.getX();
        BoardPosition oneFileOverPos = new BoardPosition(desired.getX(), current.getY());

        Piece nextToCurrent = board.get(oneFileOverPos);

        // is square next to pawn occupied by enemy
        if (nextToCurrent.getPieceName() != PieceNames.PAWN || nextToCurrent.getPieceTeam() == allies) {
            return false;
        }

        // check previous turn
        Map<BoardPosition, Piece> lastTurn = gameState.getPreviousBoardStates().get(gameState.getMoveNumber() - 1);
        // was square occupied previous turn?
        if (EmptyPieceUtil.isPieceEmpty(lastTurn.get(oneFileOverPos))) {
            return false;
        }
        // was square one file & two rows back occupied by enemy last turn?
        int difY = desired.getY() - current.getY();
        int twoRowsFwd = desired.getY() + difY;
        BoardPosition oneFileTwoRowsFwd = new BoardPosition(oneFileOver, twoRowsFwd);
        Piece oneFileTwoRowsPiece = lastTurn.get(oneFileTwoRowsFwd);

        return oneFileTwoRowsPiece.getPieceName() == PieceNames.PAWN && oneFileTwoRowsPiece.getPieceTeam() != allies;
    }
}
