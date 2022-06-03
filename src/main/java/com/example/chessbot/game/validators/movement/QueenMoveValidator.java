package com.example.chessbot.game.validators.movement;

import com.example.chessbot.game.utility.CaptureUtil;
import com.example.chessbot.game.utility.EmptyPieceUtil;
import com.example.chessbot.game.utility.EnemyPieceUtil;
import com.example.chessbot.game.utility.PathCollisionUtil;
import com.example.chessbot.model.state.GameState;
import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.piece.Piece;

import java.util.Map;

public final class QueenMoveValidator {

    public static boolean validate(GameState gameState, BoardPosition current, BoardPosition desired) {
        Map<BoardPosition, Piece> board = gameState.getBoard();
        Piece toMove = board.get(current);
        Piece inDesired = board.get(desired);

        return validateMoveBasedOnPath(board, current, desired);
    }

    private static boolean validateMoveBasedOnPath(Map<BoardPosition, Piece> board, BoardPosition current, BoardPosition desired) {
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

    private static boolean validateMoveForVerticalPath(Map<BoardPosition, Piece> board, BoardPosition current, BoardPosition desired) {
        Piece toMove = board.get(current);
        Piece inDesired = board.get(desired);
        if(PathCollisionUtil.checkForCollisionsOnVerticalPath(board, current, desired)) {
            return false;
        } else {
            if(EnemyPieceUtil.isPieceEnemy(toMove, inDesired)) {
                return CaptureUtil.canCapture(toMove, inDesired);
            } else return EmptyPieceUtil.isPieceEmpty(inDesired);
        }
    }

    private static boolean validateMoveForHorizontalPath(Map<BoardPosition, Piece> board, BoardPosition current, BoardPosition desired) {
        Piece toMove = board.get(current);
        Piece inDesired = board.get(desired);
        if(PathCollisionUtil.checkForCollisionsOnHorizontalPath(board, current, desired)) {
            return false;
        } else {
            if(EnemyPieceUtil.isPieceEnemy(toMove, inDesired)) {
                return CaptureUtil.canCapture(toMove, inDesired);
            } else return EmptyPieceUtil.isPieceEmpty(inDesired);
        }
    }

    private static boolean validateMoveForDiagonalPath(Map<BoardPosition, Piece> board, BoardPosition current, BoardPosition desired) {
        Piece toMove = board.get(current);
        Piece inDesired = board.get(desired);
        if(PathCollisionUtil.checkForCollisionsOnDiagonalPath(board, current, desired)) {
            return false;
        } else {
            if(EnemyPieceUtil.isPieceEnemy(toMove, inDesired)) {
                return CaptureUtil.canCapture(toMove, inDesired);
            } else return EmptyPieceUtil.isPieceEmpty(inDesired);
        }
    }
}
