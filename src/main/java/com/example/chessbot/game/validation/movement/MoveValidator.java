package com.example.chessbot.game.validation.movement;

import com.example.chessbot.game.state.GameState;
import com.example.chessbot.model.board.BoardPosition;

public interface MoveValidator {
    boolean validate(GameState gameState, BoardPosition currentPosition, BoardPosition desiredPosition);
}
