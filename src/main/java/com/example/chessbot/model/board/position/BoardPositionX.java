package com.example.chessbot.model.board.position;

public enum BoardPositionX implements BoardPositionPoint {
    NONE(-1),
    A(0),
    B(1),
    C(2),
    D(3),
    E(4),
    F(5),
    G(6),
    H(7);

    private final int value;

    BoardPositionX(final int value) {
        this.value = value;
    }

    public int getValue() { return this.value; }

    public BoardPositionX fromValue(int value) {
        return switch(value) {
            case 0 -> BoardPositionX.A;
            case 1 -> BoardPositionX.B;
            case 2 -> BoardPositionX.C;
            case 3 -> BoardPositionX.D;
            case 4 -> BoardPositionX.E;
            case 5 -> BoardPositionX.F;
            case 6 -> BoardPositionX.G;
            case 7 -> BoardPositionX.H;
            default -> BoardPositionX.NONE;
        };
    }
}
