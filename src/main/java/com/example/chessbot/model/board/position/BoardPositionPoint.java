package com.example.chessbot.model.board.position;

public interface BoardPositionPoint {
    BoardPositionPoint fromValue(int value);
    int getValue();
}
