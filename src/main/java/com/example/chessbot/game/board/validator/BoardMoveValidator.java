package com.example.chessbot.game.board.validator;

import com.example.chessbot.game.state.GameState;
import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.piece.Piece;

public class BoardMoveValidator implements MoveValidator {
    private PawnMoveValidator pawnMoveValidator = new PawnMoveValidator();
    private RookMoveValidator rookMoveValidator = new RookMoveValidator();

    public BoardMoveValidator(PawnMoveValidator pawnMoveValidator, RookMoveValidator rookMoveValidator) {
        this.pawnMoveValidator = pawnMoveValidator;
        this.rookMoveValidator = rookMoveValidator;
    }

    public boolean validate(GameState gameState, BoardPosition currentPosition, BoardPosition desiredPosition) {
        Piece pieceToMove = gameState.getBoard().getPiecesInPlay().get(currentPosition);

        return switch (pieceToMove.getPieceName()) {
            case PAWN -> pawnMoveValidator.validate(gameState, currentPosition, desiredPosition);
            case ROOK -> rookMoveValidator.validate(gameState, currentPosition, desiredPosition);
            case KNIGHT -> false;
            case BISHOP -> false;
            case QUEEN -> false;
            case KING -> false;
            case EMPTY -> false;
        };
    }
}
