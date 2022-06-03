package com.example.chessbot.model.state.player;

import com.example.chessbot.model.piece.PieceTeam;
import com.example.chessbot.model.state.player.attributes.*;

public class PlayerStateFactory {
    public static PlayerState createInitialPlayerState(PieceTeam team) {
        return new ConcretePlayerState(team, CheckStateFactory.createInitialCheckState());

    }

    public static PlayerState createNewPlayerState(PieceTeam team, CheckState checkState) {
        return new ConcretePlayerState(team, checkState);
    }
}

class ConcretePlayerState implements PlayerState {

    private final PieceTeam team;
    private final CheckState checkState;

    protected ConcretePlayerState(PieceTeam team, CheckState checkState) {
        this.team = team;
        this.checkState = checkState;
    }

    @Override
    public PieceTeam getTeam() {
        return this.team;
    }

    @Override
    public CheckState getCheckState() {
        return this.checkState;
    }
}
