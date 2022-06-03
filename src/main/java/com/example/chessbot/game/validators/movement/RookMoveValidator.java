package com.example.chessbot.game.validators.movement;

import com.example.chessbot.game.validators.utility.CaptureUtil;
import com.example.chessbot.game.validators.utility.EmptyPieceUtil;
import com.example.chessbot.game.validators.utility.EnemyPieceUtil;
import com.example.chessbot.game.validators.utility.PathCollisionUtil;
import com.example.chessbot.game.state.GameState;
import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.piece.Piece;

import java.util.Map;

public final class RookMoveValidator {

    public static boolean validate(GameState gameState, BoardPosition currentPosition, BoardPosition desiredPosition) {
        Map<BoardPosition, Piece> board = gameState.getBoard();
        Piece pieceToMove = board.get(currentPosition);
        Piece pieceInDesiredPosition = board.get(desiredPosition);

        if (!moveIsEitherHorizontalOrVertical(currentPosition, desiredPosition)) {
            return false;
        } else {
            if (moveIsHorizontal(currentPosition, desiredPosition)) {
                return validateHorizontalMove(board, currentPosition, desiredPosition, pieceToMove, pieceInDesiredPosition);
            } else {
                return validateVerticalMove(board, currentPosition, desiredPosition, pieceToMove, pieceInDesiredPosition);
            }
        }
    }

    private static boolean moveIsEitherHorizontalOrVertical(BoardPosition current, BoardPosition desired) {
        return (current.getY() != desired.getY()
                && current.getX() == current.getX())
                ^ (current.getX() != desired.getX()
                && current.getY() == desired.getY());
    }

    private static boolean moveIsHorizontal(BoardPosition current, BoardPosition desired) {
        return current.getX() != desired.getX();
    }

    private static boolean validateHorizontalMove(Map<BoardPosition, Piece> board, BoardPosition currentPosition, BoardPosition desiredPosition, Piece pieceToMove, Piece pieceInDesiredPosition) {
        // if there are no pieces in path then it is valid
        if (PathCollisionUtil.checkForCollisionsOnHorizontalPath(board, currentPosition, desiredPosition)) {
            return false;
        } else {
            // if piece in position is enemy, return true if can capture
            if(EnemyPieceUtil.isPieceEnemy(pieceToMove, pieceInDesiredPosition)) {
                return CaptureUtil.canCapture(pieceToMove, pieceInDesiredPosition);
            } else return EmptyPieceUtil.isPieceEmpty(pieceInDesiredPosition);
        }
    }

    private static boolean validateVerticalMove(Map<BoardPosition, Piece> board, BoardPosition currentPosition, BoardPosition desiredPosition, Piece pieceToMove, Piece pieceInDesiredPosition) {
        // if there are no pieces in path then it is valid
        if (PathCollisionUtil.checkForCollisionsOnVerticalPath(board, currentPosition, desiredPosition)) {
            return false;
        } else {
            // if piece in position is enemy, return true if can capture
            if (EnemyPieceUtil.isPieceEnemy(pieceToMove, pieceInDesiredPosition)) {
                return CaptureUtil.canCapture(pieceToMove, pieceInDesiredPosition);
            } else return EmptyPieceUtil.isPieceEmpty(pieceInDesiredPosition);
        }
    }
}
