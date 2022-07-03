package com.example.chessbot.game.state.player.attributes;

import com.example.chessbot.model.board.BoardPosition;
import com.example.chessbot.model.Pair;
import com.example.chessbot.model.piece.Piece;

import java.util.List;

public interface CheckState {
    CheckStatus getStatus();
    List<Pair<BoardPosition, Piece>> getInCheckFrom();
}
