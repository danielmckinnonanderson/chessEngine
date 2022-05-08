package com.example.chessbot.model.board.position;

public enum BoardPositionX {
    A(1),
    B(2),
    C(3),
    D(4),
    E(5),
    F(6),
    G(7),
    H(8);

    private final int value;

    BoardPositionX(final int value) {
        this.value = value;
    }

    int getValue() { return this.value; }
}
