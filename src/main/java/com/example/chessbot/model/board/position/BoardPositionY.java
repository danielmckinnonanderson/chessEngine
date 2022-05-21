package com.example.chessbot.model.board.position;

public enum BoardPositionY implements BoardPositionPoint {
    NONE(-1),
    ONE(0),
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

    public static BoardPositionPoint fromValue(int value) {
        return switch(value) {
            case 0 -> BoardPositionY.ONE;
            case 1 -> BoardPositionY.TWO;
            case 2 -> BoardPositionY.THREE;
            case 3 -> BoardPositionY.FOUR;
            case 4 -> BoardPositionY.FIVE;
            case 5 -> BoardPositionY.SIX;
            case 6 -> BoardPositionY.SEVEN;
            case 7 -> BoardPositionY.EIGHT;
            default -> BoardPositionY.NONE;
        };
    }

    public int getValue() { return this.value; }
}
