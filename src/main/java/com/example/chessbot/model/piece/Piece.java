package com.example.chessbot.model.piece;

public class Piece {
    private PieceNames name;
    private PieceTeam team;

    private Piece() {}

    public Piece(PieceNames name, PieceTeam team) {
        this.team = team;
        this.name = name;
    }

    public PieceTeam getPieceTeam() {
        return this.team;
    }

    public PieceNames getPieceName() {
        return this.name;
    }
}
