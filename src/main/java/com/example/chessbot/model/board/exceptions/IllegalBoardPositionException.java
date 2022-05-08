package com.example.chessbot.model.board.exceptions;

public class IllegalBoardPositionException extends Exception {
    public IllegalBoardPositionException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
