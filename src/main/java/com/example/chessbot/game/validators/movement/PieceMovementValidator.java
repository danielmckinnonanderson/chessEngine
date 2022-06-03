package com.example.chessbot.game.validators.movement;

import com.example.chessbot.model.state.GameState;
import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.piece.Piece;

public final class PieceMovementValidator {

    public static boolean validate(GameState gameState, BoardPosition currentPosition, BoardPosition desiredPosition) {
        Piece pieceToMove = gameState.getBoard().get(currentPosition);

        return switch (pieceToMove.getPieceName()) {
            case PAWN -> PawnMoveValidator.validate(gameState, currentPosition, desiredPosition);
            case ROOK -> RookMoveValidator.validate(gameState, currentPosition, desiredPosition);
            case KNIGHT -> KnightMoveValidator.validate(gameState, currentPosition, desiredPosition);
            case BISHOP -> BishopMoveValidator.validate(gameState, currentPosition, desiredPosition);
            case QUEEN -> QueenMoveValidator.validate(gameState, currentPosition, desiredPosition);
            case KING -> KingMoveValidator.validate(gameState, currentPosition, desiredPosition);
            case EMPTY -> false;
        };
    }
}
