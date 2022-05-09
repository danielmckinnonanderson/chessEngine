package com.example.chessbot.model.board.position;

public enum BoardPositionX {
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
}
