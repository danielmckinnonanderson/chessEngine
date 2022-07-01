package com.example.chessbot.game.validators.exceptions;

import com.example.chessbot.model.piece.PieceTeam;
import com.example.chessbot.model.state.player.attributes.CheckStatus;

public class IllegalCheckStatusException extends Exception {

    public IllegalCheckStatusException(PieceTeam blame, CheckStatus expected, CheckStatus actual) {
        super("Expected player " + blame + " to have CheckStatus " + expected + ", but was " + actual);
    }
}
