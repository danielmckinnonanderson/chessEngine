package com.example.chessbot.model.board.position;

public class BoardPosition {
    private int x;
    private int y;

    public BoardPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getPositionX() {
        return this.x;
    }

    public int getPositionY() {
        return this.y;
    }
}
