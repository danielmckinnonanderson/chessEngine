package com.example.chessbot.model.state.player.attributes;

import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.board.position.Pair;
import com.example.chessbot.model.piece.Piece;

import java.util.List;

public interface CheckState {
    CheckStatus getStatus();
    List<Pair<BoardPosition, Piece>> getInCheckFrom();
}
