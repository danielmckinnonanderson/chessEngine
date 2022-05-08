package com.example.chessbot.game.board.validator;

import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.piece.Piece;

public class BoardMoveValidator {
    private PawnMoveValidator pawnMoveValidator = new PawnMoveValidator();

    public BoardMoveValidator(PawnMoveValidator pawnMoveValidator) {
        this.pawnMoveValidator = pawnMoveValidator;
    }

    public boolean isPositionValid(Piece piece, boolean isFirstTurn, boolean opponnentIsPresentInDesiredPosition, BoardPosition currentPosition, BoardPosition desiredPosition) {
        return switch (piece.getPieceName()) {
            case PAWN -> pawnMoveValidator.isMoveValid(piece.getPieceTeam(), isFirstTurn, opponnentIsPresentInDesiredPosition, currentPosition, desiredPosition);
            case ROOK -> false;
            case KNIGHT -> false;
            case BISHOP -> false;
            case QUEEN -> false;
            case KING -> false;
            case EMPTY -> false;
        };
    }
}
