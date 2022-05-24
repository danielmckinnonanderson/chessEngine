package com.example.chessbot.game.board.validator;

import com.example.chessbot.game.state.GameState;
import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.piece.PieceNames;
import com.example.chessbot.model.piece.PieceTeam;

import java.util.Map;

public class RookMoveValidator implements MoveValidator {

    public boolean validate(GameState gameState, BoardPosition currentPosition, BoardPosition desiredPosition) {
        Map<BoardPosition, Piece> piecesInPlay = gameState.getBoard();
        Piece pieceToMove = piecesInPlay.get(currentPosition);
        Piece pieceInDesiredPosition = piecesInPlay.get(desiredPosition);
        if (!moveIsEitherHorizontalOrVertical(currentPosition, desiredPosition)) {
            return false;
        } else {
            if (moveIsHorizontal(currentPosition, desiredPosition)) {
                if (moveIsPositive(currentPosition.getX(), desiredPosition.getX())) {
                    return validateMoveToRight(piecesInPlay, currentPosition, desiredPosition, pieceToMove, pieceInDesiredPosition);
                } else {
                    return validateMoveToLeft(piecesInPlay, currentPosition, desiredPosition, pieceToMove, pieceInDesiredPosition);
                }
            } else {
                if (moveIsPositive(currentPosition.getY(), desiredPosition.getY())) {
                    return validateMoveUp(piecesInPlay, currentPosition, desiredPosition, pieceToMove, pieceInDesiredPosition);
                } else {
                    return validateMoveDown(piecesInPlay, currentPosition, desiredPosition, pieceToMove, pieceInDesiredPosition);
                }
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

    private boolean moveIsPositive(int current, int desired) {
        return (desired - current) > 0;
    }

    private boolean thereArePiecesInPathRight(Map<BoardPosition, Piece> piecesInPlay, BoardPosition current, BoardPosition desired) {
        int difference = desired.getX() - current.getX();
        // iterate through positions on board between current and desired
        for (int i = 1; i <= difference; i++) {
            BoardPosition positionToCheck = new BoardPosition(current.getX() + i, current.getY());
            Piece pieceInPosition = piecesInPlay.get(positionToCheck);
            if (pieceInPosition.getPieceTeam() != PieceTeam.NONE
                    || pieceInPosition.getPieceName() != PieceNames.EMPTY) {
                return true;
            }
        }
        return false;
    }

    private boolean validateMoveToRight(Map<BoardPosition, Piece> piecesInPlay, BoardPosition currentPosition, BoardPosition desiredPosition, Piece pieceToMove, Piece pieceInDesiredPosition) {
        // if there are no pieces in path then it is valid
        if (!thereArePiecesInPathRight(piecesInPlay, currentPosition, desiredPosition)) {
            return true;
        } else {
            // if piece in position is enemy, return true if can capture
            if (thereIsPieceInDesiredPosition(pieceToMove, pieceInDesiredPosition)
                    && pieceInDesiredPositionIsEnemy(pieceToMove, pieceInDesiredPosition)) {
                return canCapture(pieceToMove, pieceInDesiredPosition);
            }
        }
        return false;
    }

    private boolean thereArePiecesInPathLeft(Map<BoardPosition, Piece> piecesInPlay, BoardPosition current, BoardPosition desired) {
        int difference = Math.abs(desired.getX() - current.getX());
        // iterate through positions on board between current and desired
        for (int i = 1; i <= difference; i++) {
            BoardPosition positionToCheck = new BoardPosition(current.getX() - i, current.getY());
            Piece pieceInPosition = piecesInPlay.get(positionToCheck);
            if (pieceInPosition.getPieceTeam() != PieceTeam.NONE
                    || pieceInPosition.getPieceName() != PieceNames.EMPTY) {
                return true;
            }
        }
        return false;
    }

    private boolean validateMoveToLeft(Map<BoardPosition, Piece> piecesInPlay, BoardPosition currentPosition, BoardPosition desiredPosition, Piece pieceToMove, Piece pieceInDesiredPosition) {
        // if there are no pieces in path then it is valid
        if (!thereArePiecesInPathLeft(piecesInPlay, currentPosition, desiredPosition)) {
            return true;
        } else {
            // if piece in position is enemy, return true if can capture
            if (thereIsPieceInDesiredPosition(pieceToMove, pieceInDesiredPosition)
                    && pieceInDesiredPositionIsEnemy(pieceToMove, pieceInDesiredPosition)) {
                return canCapture(pieceToMove, pieceInDesiredPosition);
            }
        }
        return false;
    }

    private boolean thereArePiecesInPathUp(Map<BoardPosition, Piece> piecesInPlay, BoardPosition current, BoardPosition desired) {
        int difference = desired.getY() - current.getY();
        // iterate through positions on board between current and desired
        for (int i = 1; i <= difference; i++) {
            BoardPosition positionToCheck = new BoardPosition(current.getX(), current.getY() + i);
            Piece pieceInPosition = piecesInPlay.get(positionToCheck);
            if (pieceInPosition.getPieceTeam() != PieceTeam.NONE
                    || pieceInPosition.getPieceName() != PieceNames.EMPTY) {
                return true;
            }
        }
        return false;
    }

    private boolean validateMoveUp(Map<BoardPosition, Piece> piecesInPlay, BoardPosition currentPosition, BoardPosition desiredPosition, Piece pieceToMove, Piece pieceInDesiredPosition) {
        // if there are no pieces in path then it is valid
        if (!thereArePiecesInPathUp(piecesInPlay, currentPosition, desiredPosition)) {
            return true;
        } else {
            // if piece in position is enemy, return true if can capture
            if (thereIsPieceInDesiredPosition(pieceToMove, pieceInDesiredPosition)
                    && pieceInDesiredPositionIsEnemy(pieceToMove, pieceInDesiredPosition)) {
                return canCapture(pieceToMove, pieceInDesiredPosition);
            }
        }
        return false;
    }

    private boolean thereArePiecesInPathDown(Map<BoardPosition, Piece> piecesInPlay, BoardPosition current, BoardPosition desired) {
        int difference = Math.abs(desired.getY() - current.getY());
        // iterate through positions on board between current and desired
        for (int i = 1; i <= difference; i++) {
            BoardPosition positionToCheck = new BoardPosition(current.getX(), current.getY() - i);
            Piece pieceInPosition = piecesInPlay.get(positionToCheck);
            if (pieceInPosition.getPieceTeam() != PieceTeam.NONE
                    || pieceInPosition.getPieceName() != PieceNames.EMPTY) {
                return true;
            }
        }
        return false;
    }

    private boolean validateMoveDown(Map<BoardPosition, Piece> piecesInPlay, BoardPosition currentPosition, BoardPosition desiredPosition, Piece pieceToMove, Piece pieceInDesiredPosition) {
        // if there are no pieces in path then it is valid
        if (!thereArePiecesInPathDown(piecesInPlay, currentPosition, desiredPosition)) {
            return true;
        } else {
            // if piece in position is enemy, return true if can capture
            if (thereIsPieceInDesiredPosition(pieceToMove, pieceInDesiredPosition)
                    && pieceInDesiredPositionIsEnemy(pieceToMove, pieceInDesiredPosition)) {
                return canCapture(pieceToMove, pieceInDesiredPosition);
            }
        }
        return false;
    }

    private boolean thereIsPieceInDesiredPosition(Piece pieceToMove, Piece pieceInSpot) {
        return pieceInSpot.getPieceName() != PieceNames.EMPTY;
    }

    private boolean pieceInDesiredPositionIsEnemy(Piece pieceToMove, Piece pieceInSpot) {
        return pieceToMove.getPieceTeam() != pieceInSpot.getPieceTeam();
    }

    private boolean canCapture(Piece pieceToMove, Piece pieceInSpot) {
        return pieceToMove.getPieceTeam() != pieceInSpot.getPieceTeam() && pieceInSpot.getPieceName() != PieceNames.KING;
    }
}
