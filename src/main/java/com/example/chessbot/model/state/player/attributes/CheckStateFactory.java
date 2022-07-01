package com.example.chessbot.model.state.player.attributes;

import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.utility.Pair;
import com.example.chessbot.model.piece.Piece;

import java.util.List;

public final class CheckStateFactory {

    public static CheckState createInitialCheckState() {
        return new ConcreteCheckState(CheckStatus.NONE, List.of());
    }

    public static CheckState createNewCheckState(CheckStatus status, List<Pair<BoardPosition, Piece>> from) {
        if(status == CheckStatus.NONE && from.size() != 0
            || (status == CheckStatus.CHECK || status == CheckStatus.CHECKMATE) && from.size() == 0) {
            throw new IllegalArgumentException("The size of List inCheckFrom is '" + from.size() + "', which is irreconcilable with status '" + status + "'!");
        }
        return new ConcreteCheckState(status, from);
    }
}

class ConcreteCheckState implements CheckState {

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
