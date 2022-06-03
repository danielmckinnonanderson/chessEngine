package com.example.chessbot.model.state.player;

import com.example.chessbot.model.state.player.attributes.CheckState;
import com.example.chessbot.model.piece.PieceTeam;

public interface PlayerState {
    PieceTeam getTeam();
    CheckState getCheckState();
}
