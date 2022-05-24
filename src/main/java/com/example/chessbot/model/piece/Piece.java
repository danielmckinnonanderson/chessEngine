package com.example.chessbot.model.piece;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return name == piece.name && team == piece.team;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, team);
    }

    @Override
    public String toString() {
        return "Piece " + team + " " + name;
    }
}
