package com.example.chessbot.model.state;

import com.example.chessbot.model.state.player.PlayerState;
import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.utility.Pair;
import com.example.chessbot.model.piece.Piece;

import java.util.Map;

public interface GameState {
    int getMoveNumber();
    Map<BoardPosition, Piece> getBoard();
    Map<Integer, Map<BoardPosition, Piece>> getPreviousBoardStates();
    Pair<PlayerState, PlayerState> getPlayerStates();
}
