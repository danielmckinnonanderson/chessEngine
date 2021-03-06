package com.example.chessbot.game.validation.movement;

import com.example.chessbot.game.utility.CaptureUtility;
import com.example.chessbot.game.utility.EmptyPieceUtility;
import com.example.chessbot.game.utility.EnemyPieceUtility;
import com.example.chessbot.game.utility.PathCollisionUtility;
import com.example.chessbot.game.state.GameState;
import com.example.chessbot.model.board.BoardPosition;
import com.example.chessbot.model.piece.Piece;

import java.util.Map;

public class RookMoveValidator implements MoveValidator {

    public boolean validate(GameState gameState, BoardPosition currentPosition, BoardPosition desiredPosition) {
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

    private boolean moveIsEitherHorizontalOrVertical(BoardPosition current, BoardPosition desired) {
        return (current.getY() != desired.getY()
                && current.getX() == current.getX())
                ^ (current.getX() != desired.getX()
                && current.getY() == desired.getY());
    }

    private boolean moveIsHorizontal(BoardPosition current, BoardPosition desired) {
        return current.getX() != desired.getX();
    }

    private boolean validateHorizontalMove(Map<BoardPosition, Piece> board, BoardPosition currentPosition, BoardPosition desiredPosition, Piece pieceToMove, Piece pieceInDesiredPosition) {
        // if there are no pieces in path then it is valid
        if (PathCollisionUtility.checkForCollisionsOnHorizontalPath(board, currentPosition, desiredPosition)) {
            return false;
        } else {
            // if piece in position is enemy, return true if can capture
            if(EnemyPieceUtility.isPieceEnemy(pieceToMove, pieceInDesiredPosition)) {
                return CaptureUtility.canCapture(pieceToMove, pieceInDesiredPosition);
            } else return EmptyPieceUtility.isPieceEmpty(pieceInDesiredPosition);
        }
    }

    private boolean validateVerticalMove(Map<BoardPosition, Piece> board, BoardPosition currentPosition, BoardPosition desiredPosition, Piece pieceToMove, Piece pieceInDesiredPosition) {
        // if there are no pieces in path then it is valid
        if (PathCollisionUtility.checkForCollisionsOnVerticalPath(board, currentPosition, desiredPosition)) {
            return false;
        } else {
            // if piece in position is enemy, return true if can capture
            if (EnemyPieceUtility.isPieceEnemy(pieceToMove, pieceInDesiredPosition)) {
                return CaptureUtility.canCapture(pieceToMove, pieceInDesiredPosition);
            } else return EmptyPieceUtility.isPieceEmpty(pieceInDesiredPosition);
        }
    }
}
