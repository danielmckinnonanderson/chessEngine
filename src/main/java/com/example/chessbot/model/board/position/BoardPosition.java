package com.example.chessbot.model.board.position;

public class BoardPosition {
    private int x;
    private int y;

    public BoardPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public BoardPosition setBoardPositionX(int x) {
        this.x = x;
        return this;
    }

    public BoardPosition setBoardPositionY(int y) {
        this.y = y;
        return this;
    }

    public int getPositionX() {
        return this.x;
    }

    public int getPositionY() {
        return this.y;
    }
}
