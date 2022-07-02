package com.example.chessbot.model.board;

import java.util.Objects;

public class BoardPosition {
    private final int x;
    private final int y;

    public BoardPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardPosition position = (BoardPosition) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "BoardPosition (" + x + "," + y + ")";
    }


    /**
     * @param one BoardPosition to compare with instance two
     * @param two BoardPosition to compare with instance one
     * @return BoardPosition representing difference on x & y axis between one & two
     */
    public static BoardPosition compare(BoardPosition one, BoardPosition two) {
        int differenceX = one.getX() - two.getX();
        int differenceY = one.getY() - two.getY();
        return new BoardPosition(differenceX, differenceY);
    }
}
