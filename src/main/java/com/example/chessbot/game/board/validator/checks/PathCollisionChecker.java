package com.example.chessbot.game.board.validator.checks;

import com.example.chessbot.model.board.BoardPosition;
import com.example.chessbot.model.piece.Piece;

import java.util.Map;

public final class PathCollisionChecker {
    /**
     * @param board representing current state of pieces on board for a game
     * @param current position of piece seeking to be moved
     * @param desired position where piece is attempting to be moved
     * @return true if a collision occurs on the given path
     */
    public static boolean checkForCollisionsOnHorizontalPath(Map<BoardPosition, Piece> board, BoardPosition current, BoardPosition desired) {
        int differenceX = desired.getX() - current.getX();

        if(differenceX < 0) {
            for (int i = -1; i > differenceX; i--) {
                BoardPosition positionToCheck = new BoardPosition(current.getX() + i, current.getY());
                Piece pieceInPosition = board.get(positionToCheck);
                if (!EmptyPieceChecker.isPieceEmpty(pieceInPosition)) {
                    return true;
                }
            }
        } else if(differenceX > 0) {
            for (int i = 1; i < differenceX; i++) {
                BoardPosition positionToCheck = new BoardPosition(current.getX() + i, current.getY());
                Piece pieceInPosition = board.get(positionToCheck);
                if (!EmptyPieceChecker.isPieceEmpty(pieceInPosition)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkForCollisionsOnVerticalPath(Map<BoardPosition, Piece> board, BoardPosition current, BoardPosition desired) {
        int differenceY = desired.getY() - current.getY();

        if(differenceY < 0) {
            for (int i = -1; i > differenceY; i--) {
                BoardPosition positionToCheck = new BoardPosition(current.getX(), current.getY() + i);
                Piece pieceInPosition = board.get(positionToCheck);
                if (!EmptyPieceChecker.isPieceEmpty(pieceInPosition)) {
                    return true;
                }
            }
        } else if(differenceY > 0) {
            for (int i = 1; i < differenceY; i++) {
                BoardPosition positionToCheck = new BoardPosition(current.getX(), current.getY() + i);
                Piece pieceInPosition = board.get(positionToCheck);
                if (!EmptyPieceChecker.isPieceEmpty(pieceInPosition)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkForCollisionsOnDiagonalPath(Map<BoardPosition, Piece> board, BoardPosition current, BoardPosition desired) {
        int differenceY = desired.getY() - current.getY();
        int differenceX = desired.getX() - current.getX();

        if(differenceX > 0 && differenceY > 0) {
            for(int i = 1; i < differenceY; i++) {
                BoardPosition positionToCheck = new BoardPosition(current.getX() + i, current.getY() + i);
                Piece inPosition = board.get(positionToCheck);
                if(!EmptyPieceChecker.isPieceEmpty(inPosition)) {
                    return true;
                }
            }
            return false;
        } else if(differenceX < 0 && differenceY < 0) {
            for(int i = -1; i > differenceY; i--) {
                BoardPosition positionToCheck = new BoardPosition(current.getX() + i, current.getY() + i);
                Piece inPosition = board.get(positionToCheck);
                if(!EmptyPieceChecker.isPieceEmpty(inPosition)) {
                    return true;
                }
            }
            return false;
        } else if(differenceX > 0 && differenceY < 0) {
            for(int i = 1; i < differenceX; i++) {
                BoardPosition positionToCheck = new BoardPosition(current.getX() + i, current.getY() - i);
                Piece inPosition = board.get(positionToCheck);
                if(!EmptyPieceChecker.isPieceEmpty(inPosition)) {
                    return true;
                }
            }
            return false;
        } else if(differenceX < 0 && differenceY > 0) {
            for(int i = 1; i < differenceY; i++) {
                BoardPosition positionToCheck = new BoardPosition(current.getX() - i, current.getY() + i);
                Piece inPosition = board.get(positionToCheck);
                if(!EmptyPieceChecker.isPieceEmpty(inPosition)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
