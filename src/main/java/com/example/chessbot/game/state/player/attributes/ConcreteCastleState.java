package com.example.chessbot.game.state.player.attributes;

public class ConcreteCastleState implements CastleState {
    private final boolean hasCastled;
    private final boolean canCastle;

    public ConcreteCastleState(boolean hasCastled, boolean canCastle) {
        this.hasCastled = hasCastled;
        this.canCastle = canCastle;

    }

    @Override
    public boolean hasCastled() {
        return this.hasCastled;
    }

    @Override
    public boolean canCastle() {
        return this.canCastle;
    }
}
