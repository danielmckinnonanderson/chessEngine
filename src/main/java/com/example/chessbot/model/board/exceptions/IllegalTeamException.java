package com.example.chessbot.model.board.exceptions;

public class IllegalTeamException extends Exception {

    public IllegalTeamException(String errorMessage) {
        super(errorMessage);
    }

    public IllegalTeamException(int invalidTeam) {
        super("Tried to initialize team with value " + invalidTeam + ", which is not 0 or 1!");
    }
}
