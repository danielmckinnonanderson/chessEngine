package com.example.chessbot.game.validators.movement;

import com.example.chessbot.game.validators.utility.CaptureUtil;
import com.example.chessbot.game.validators.utility.EmptyPieceUtil;
import com.example.chessbot.game.validators.utility.EnemyPieceUtil;
import com.example.chessbot.game.validators.utility.PathCollisionUtil;
import com.example.chessbot.game.state.GameState;
import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.piece.Piece;

import java.util.Map;

public class BishopMoveValidator {

    public static boolean validate(GameState gameState, BoardPosition currentPosition, BoardPosition desiredPosition) {
       Map<BoardPosition, Piece> board = gameState.getBoard();
       Piece pieceToMove = board.get(currentPosition);
       Piece pieceInDesiredPosition = board.get(desiredPosition);

        if(!desiredPositionIsDiagonal(currentPosition, desiredPosition)) {
            return false;
        }
        return validateDiagonalMove(board, currentPosition, desiredPosition, pieceToMove, pieceInDesiredPosition);
    }

    private static boolean desiredPositionIsDiagonal(BoardPosition currentPosition, BoardPosition desiredPosition) {
        int deltaX = Math.abs(currentPosition.getX() - desiredPosition.getX());
        int deltaY = Math.abs(currentPosition.getY() - desiredPosition.getY());

        return deltaX == deltaY && deltaX != 0;
    }

    private static boolean validateDiagonalMove(Map<BoardPosition, Piece> board, BoardPosition current, BoardPosition desired, Piece toMove, Piece inDesired) {
        if(PathCollisionUtil.checkForCollisionsOnDiagonalPath(board, current, desired)) {
            return false;
        } else {
            if(EnemyPieceUtil.isPieceEnemy(toMove, inDesired)) {
                return CaptureUtil.canCapture(toMove, inDesired);
            } else return EmptyPieceUtil.isPieceEmpty(inDesired);
        }
    }
}
