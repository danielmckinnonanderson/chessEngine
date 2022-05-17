package com.example.chessbot.game.board.validator;

import com.example.chessbot.game.state.GameState;
import com.example.chessbot.model.board.position.BoardPosition;

public class RookMoveValidator implements MoveValidator {

    public boolean validate(GameState gameState, BoardPosition currentPosition, BoardPosition desiredPosition) {
        return true;
    }

    private boolean isMoveHorizontalOrVertical() {
        return false;
    }
}
