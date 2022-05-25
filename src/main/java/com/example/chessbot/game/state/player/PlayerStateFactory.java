package com.example.chessbot.game.state.player;

import com.example.chessbot.game.state.player.attributes.*;
import com.example.chessbot.model.piece.PieceTeam;

import java.util.List;

public class PlayerStateFactory {
    public static PlayerState createInitialPlayerState(PieceTeam team) {
        return new ConcretePlayerState(team, new ConcreteCheckState(CheckStatus.NONE, List.of()), new ConcreteCastleState(false, true));

    }

    public static PlayerState createNewPlayerState(PieceTeam team, CheckState checkState, CastleState castleState) {
        return new ConcretePlayerState(team, checkState, castleState);
    }
}

class ConcretePlayerState implements PlayerState {

    private final PieceTeam team;
    private final CheckState checkState;
    private final CastleState castleState;

    protected ConcretePlayerState(PieceTeam team, CheckState checkState, CastleState castleState) {
        this.team = team;
        this.checkState = checkState;
        this.castleState = castleState;
    }

    @Override
    public PieceTeam getTeam() {
        return this.team;
    }

    @Override
    public CheckState getCheckState() {
        return this.checkState;
    }

    @Override
    public CastleState getCastleState() {
        return this.castleState;
    }
}
