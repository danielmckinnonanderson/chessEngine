package com.example.chessbot.game.board.validator;

import com.example.chessbot.game.state.GameState;
import com.example.chessbot.model.board.position.BoardPosition;

public class KnightMoveValidator implements MoveValidator {

    @Override
    public boolean validate(GameState gameState, BoardPosition currentPosition, BoardPosition desiredPosition) {
        return false;
    }
}
