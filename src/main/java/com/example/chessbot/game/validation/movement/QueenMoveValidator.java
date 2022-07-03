package com.example.chessbot.game.validation.movement;

import com.example.chessbot.game.utility.CaptureUtility;
import com.example.chessbot.game.utility.EmptyPieceUtility;
import com.example.chessbot.game.utility.EnemyPieceUtility;
import com.example.chessbot.game.utility.PathCollisionUtility;
import com.example.chessbot.game.state.GameState;
import com.example.chessbot.model.board.BoardPosition;
import com.example.chessbot.model.piece.Piece;

import java.util.Map;

public class QueenMoveValidator implements MoveValidator {
    public boolean validate(GameState gameState, BoardPosition current, BoardPosition desired) {
        Map<BoardPosition, Piece> board = gameState.getBoard();
        Piece toMove = board.get(current);
        Piece inDesired = board.get(desired);

        return validateMoveBasedOnPath(board, current, desired);
    }

    private boolean validateMoveBasedOnPath(Map<BoardPosition, Piece> board, BoardPosition current, BoardPosition desired) {
        int differenceX = current.getX() - desired.getX();
        int differenceY = current.getY() - desired.getY();

        if(differenceX != 0 && differenceY == 0) {
            return validateMoveForHorizontalPath(board, current, desired);
        }
        if(differenceX == 0 && differenceY != 0) {
            return validateMoveForVerticalPath(board, current, desired);
        }

        int absDifX = Math.abs(differenceX);
        int absDifY = Math.abs(differenceY);

        if(absDifX == absDifY && absDifX != 0) {
            return validateMoveForDiagonalPath(board, current, desired);
        }

        return false;
    }

    private boolean validateMoveForVerticalPath(Map<BoardPosition, Piece> board, BoardPosition current, BoardPosition desired) {
        Piece toMove = board.get(current);
        Piece inDesired = board.get(desired);
        if(PathCollisionUtility.checkForCollisionsOnVerticalPath(board, current, desired)) {
            return false;
        } else {
            if(EnemyPieceUtility.isPieceEnemy(toMove, inDesired)) {
                return CaptureUtility.canCapture(toMove, inDesired);
            } else return EmptyPieceUtility.isPieceEmpty(inDesired);
        }
    }

    private boolean validateMoveForHorizontalPath(Map<BoardPosition, Piece> board, BoardPosition current, BoardPosition desired) {
        Piece toMove = board.get(current);
        Piece inDesired = board.get(desired);
        if(PathCollisionUtility.checkForCollisionsOnHorizontalPath(board, current, desired)) {
            return false;
        } else {
            if(EnemyPieceUtility.isPieceEnemy(toMove, inDesired)) {
                return CaptureUtility.canCapture(toMove, inDesired);
            } else return EmptyPieceUtility.isPieceEmpty(inDesired);
        }
    }

    private boolean validateMoveForDiagonalPath(Map<BoardPosition, Piece> board, BoardPosition current, BoardPosition desired) {
        Piece toMove = board.get(current);
        Piece inDesired = board.get(desired);
        if(PathCollisionUtility.checkForCollisionsOnDiagonalPath(board, current, desired)) {
            return false;
        } else {
            if(EnemyPieceUtility.isPieceEnemy(toMove, inDesired)) {
                return CaptureUtility.canCapture(toMove, inDesired);
            } else return EmptyPieceUtility.isPieceEmpty(inDesired);
        }
    }
}
