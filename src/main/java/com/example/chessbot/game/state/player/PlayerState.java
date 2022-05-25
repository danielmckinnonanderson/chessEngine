package com.example.chessbot.game.state.player;

import com.example.chessbot.game.state.player.attributes.CastleState;
import com.example.chessbot.game.state.player.attributes.CheckState;
import com.example.chessbot.model.piece.PieceTeam;

public interface PlayerState {
    PieceTeam getTeam();
    CheckState getCheckState();
    CastleState getCastleState();
}
