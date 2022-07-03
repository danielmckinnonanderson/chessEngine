package com.example.chessbot.game.validation.movement;

import com.example.chessbot.game.utility.CaptureUtility;
import com.example.chessbot.game.utility.EmptyPieceUtility;
import com.example.chessbot.game.utility.EnemyPieceUtility;
import com.example.chessbot.game.utility.PathCollisionUtility;
import com.example.chessbot.game.state.GameState;
import com.example.chessbot.model.board.BoardPosition;
import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.piece.PieceNames;
import com.example.chessbot.model.piece.PieceTeam;

import java.util.Map;

public class PawnMoveValidator implements MoveValidator {
    // TODO properly implement this function / correct pawn movement
    public boolean validate(GameState gameState, BoardPosition currentPosition, BoardPosition desiredPosition) {
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
            if (PathCollisionUtility.checkForCollisionsOnVerticalPath(board, currentPosition, desiredPosition)) {
                return false;
            }
            Piece inDesired = board.get(desiredPosition);
            return EmptyPieceUtility.isPieceEmpty(inDesired);
        }

        // if move is 1 check for empty
        if (deltaY == 1 && deltaX == 0) {
            Piece inDesired = board.get(desiredPosition);
            return EmptyPieceUtility.isPieceEmpty(inDesired);
        }

        // if move is diagonal verify that there is piece in desired position to capture
        if (deltaY == 1 && deltaX == 1) {
            Piece inDesired = board.get(desiredPosition);
            if (!EmptyPieceUtility.isPieceEmpty(inDesired)) {
                if (EnemyPieceUtility.isPieceEnemy(toMove, inDesired)) {
                    return CaptureUtility.canCapture(toMove, inDesired);
                } else return false;
                // if desired is empty, check for en passant capture
            } else return captureEnPassant(gameState, currentPosition, desiredPosition, toMove.getPieceTeam());
        }
        // finally return false
        return false;
    }

    private boolean onlyMovesForward(PieceTeam pieceTeam, int deltaY) {
        return pieceTeam == PieceTeam.WHITE ? deltaY > 0 : deltaY < 0;
    }

    private boolean captureEnPassant(GameState gameState, BoardPosition current, BoardPosition desired, PieceTeam allies) {
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
        if (EmptyPieceUtility.isPieceEmpty(lastTurn.get(oneFileOverPos))) {
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
