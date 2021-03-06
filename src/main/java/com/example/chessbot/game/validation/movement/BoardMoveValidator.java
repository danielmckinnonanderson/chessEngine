package com.example.chessbot.game.validation.movement;

import com.example.chessbot.game.state.GameState;
import com.example.chessbot.model.board.BoardPosition;
import com.example.chessbot.model.piece.Piece;

public class BoardMoveValidator implements MoveValidator {
    private final MoveValidator pawnMoveValidator;
    private final MoveValidator rookMoveValidator;
    private final MoveValidator knightMoveValidator;
    private final MoveValidator bishopMoveValidator;
    private final MoveValidator queenMoveValidator;
    private final MoveValidator kingMoveValidator;

    public BoardMoveValidator(MoveValidator pawnMoveValidator,
                              MoveValidator rookMoveValidator,
                              MoveValidator knightMoveValidator,
                              MoveValidator bishopMoveValidator,
                              MoveValidator queenMoveValidator,
                              MoveValidator kingMoveValidator) {
        this.pawnMoveValidator = pawnMoveValidator;
        this.rookMoveValidator = rookMoveValidator;
        this.knightMoveValidator = knightMoveValidator;
        this.bishopMoveValidator = bishopMoveValidator;
        this.queenMoveValidator = queenMoveValidator;
        this.kingMoveValidator = kingMoveValidator;
    }

    public boolean validate(GameState gameState, BoardPosition currentPosition, BoardPosition desiredPosition) {
        Piece pieceToMove = gameState.getBoard().get(currentPosition);

        return switch (pieceToMove.getPieceName()) {
            case PAWN -> pawnMoveValidator.validate(gameState, currentPosition, desiredPosition);
            case ROOK -> rookMoveValidator.validate(gameState, currentPosition, desiredPosition);
            case KNIGHT -> knightMoveValidator.validate(gameState, currentPosition, desiredPosition);
            case BISHOP -> bishopMoveValidator.validate(gameState, currentPosition, desiredPosition);
            case QUEEN -> queenMoveValidator.validate(gameState, currentPosition, desiredPosition);
            case KING -> kingMoveValidator.validate(gameState, currentPosition, desiredPosition);
            case EMPTY -> false;
        };
    }
}
