package com.example.chessbot.game.state.player.attributes;

import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.Pair;
import com.example.chessbot.model.piece.Piece;

import java.util.List;

public class ConcreteCheckState implements CheckState {

    private final CheckStatus status;
    private final List<Pair<BoardPosition, Piece>> inCheckFrom;

    public ConcreteCheckState(CheckStatus status, List<Pair<BoardPosition, Piece>> inCheckFrom) {
        this.status = status;
        this.inCheckFrom = inCheckFrom;
    }

    @Override
    public CheckStatus getStatus() {
        return this.status;
    }

    @Override
    public List<Pair<BoardPosition, Piece>> getInCheckFrom() {
        return this.inCheckFrom;
    }
}
