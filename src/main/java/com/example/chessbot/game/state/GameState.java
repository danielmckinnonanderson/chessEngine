package com.example.chessbot.game.state;

import com.example.chessbot.model.board.Board;

public interface GameState {
    Board getBoard();
    int getMoveNumber();
}
