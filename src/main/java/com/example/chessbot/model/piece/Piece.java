package com.example.chessbot.model.piece;

import com.example.chessbot.model.board.exceptions.IllegalTeamException;

public class Piece {
    private PieceNames name;
    private int team;

    private Piece() {}

    public Piece(PieceNames name, int team) throws IllegalTeamException {
        if (isTeamValid(team)) {
            this.team = team;
        }
        this.name = name;
    }

    public int getPieceTeam() {
        return this.team;
    }

    public PieceNames getPieceName() {
        return this.name;
    }

    static boolean isTeamValid(int team) throws IllegalTeamException {
        if(team == 1 || team == 0) {
            return true;
        } else {
            throw new IllegalTeamException(team);
        }
    }
}
