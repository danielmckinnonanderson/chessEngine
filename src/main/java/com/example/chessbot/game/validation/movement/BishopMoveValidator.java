package com.example.chessbot.game.validation.movement;

import com.example.chessbot.game.utility.CaptureUtility;
import com.example.chessbot.game.utility.EmptyPieceUtility;
import com.example.chessbot.game.utility.EnemyPieceUtility;
import com.example.chessbot.game.utility.PathCollisionUtility;
import com.example.chessbot.game.state.GameState;
import com.example.chessbot.model.board.BoardPosition;
import com.example.chessbot.model.piece.Piece;

import java.util.Map;

public class BishopMoveValidator implements MoveValidator {
    @Override
    public boolean validate(GameState gameState, BoardPosition currentPosition, BoardPosition desiredPosition) {
       Map<BoardPosition, Piece> board = gameState.getBoard();
       Piece pieceToMove = board.get(currentPosition);
       Piece pieceInDesiredPosition = board.get(desiredPosition);

        if(!desiredPositionIsDiagonal(currentPosition, desiredPosition)) {
            return false;
        }
        return validateDiagonalMove(board, currentPosition, desiredPosition, pieceToMove, pieceInDesiredPosition);
    }

    private boolean desiredPositionIsDiagonal(BoardPosition currentPosition, BoardPosition desiredPosition) {
        int deltaX = Math.abs(currentPosition.getX() - desiredPosition.getX());
        int deltaY = Math.abs(currentPosition.getY() - desiredPosition.getY());

        return deltaX == deltaY && deltaX != 0;
    }

    private boolean validateDiagonalMove(Map<BoardPosition, Piece> board, BoardPosition current, BoardPosition desired, Piece toMove, Piece inDesired) {
        if(PathCollisionUtility.checkForCollisionsOnDiagonalPath(board, current, desired)) {
            return false;
        } else {
            if(EnemyPieceUtility.isPieceEnemy(toMove, inDesired)) {
                return CaptureUtility.canCapture(toMove, inDesired);
            } else return EmptyPieceUtility.isPieceEmpty(inDesired);
        }
    }
}
