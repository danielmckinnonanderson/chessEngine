package com.example.chessbot.model.board.position;

public class BoardPosition {
    private BoardPositionX x;
    private BoardPositionY y;

    public BoardPosition(BoardPositionX x, BoardPositionY y) {
        this.x = x;
        this.y = y;
    }

    public BoardPosition setBoardPositionX(BoardPositionX x) {
        this.x = x;
        return this;
    }

    public BoardPosition setBoardPositionY(BoardPositionY y) {
        this.y = y;
        return this;
    }

    public BoardPositionX getPositionX() {
        return this.x;
    }

    public BoardPositionY getPositionY() {
        return this.y;
    }
}
