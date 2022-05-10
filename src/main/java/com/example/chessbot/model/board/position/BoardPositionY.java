package com.example.chessbot.model.board.position;

public enum BoardPositionY {
    ONE (0),
    TWO(1),
    THREE(2),
    FOUR(3),
    FIVE(4),
    SIX(5),
    SEVEN(6),
    EIGHT(7);

    private final int value;

    BoardPositionY(final int value) {
        this.value = value;
    }

    public int getValue() { return this.value; }
}
