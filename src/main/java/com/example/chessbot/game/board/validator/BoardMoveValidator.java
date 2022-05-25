package com.example.chessbot.game.board.validator;

import com.example.chessbot.game.state.GameState;
import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.piece.Piece;

public class BoardMoveValidator implements MoveValidator {
    private final MoveValidator pawnMoveValidator;
    private final MoveValidator rookMoveValidator;
    private final MoveValidator knightMoveValidator;

    public BoardMoveValidator(MoveValidator pawnMoveValidator,
                              MoveValidator rookMoveValidator,
                              MoveValidator knightMoveValidator) {
        this.pawnMoveValidator = pawnMoveValidator;
        this.rookMoveValidator = rookMoveValidator;
        this.knightMoveValidator = knightMoveValidator;
    }

    public boolean validate(GameState gameState, BoardPosition currentPosition, BoardPosition desiredPosition) {
        Piece pieceToMove = gameState.getBoard().get(currentPosition);

        return switch (pieceToMove.getPieceName()) {
            case PAWN -> pawnMoveValidator.validate(gameState, currentPosition, desiredPosition);
            case ROOK -> rookMoveValidator.validate(gameState, currentPosition, desiredPosition);
            case KNIGHT -> knightMoveValidator.validate(gameState, currentPosition, desiredPosition);
            case BISHOP -> false;
            case QUEEN -> false;
            case KING -> false;
            case EMPTY -> false;
        };
    }
}
