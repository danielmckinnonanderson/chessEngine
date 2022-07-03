package com.example.chessbot.game.state;

import com.example.chessbot.game.state.player.PlayerState;
import com.example.chessbot.model.board.BoardPosition;
import com.example.chessbot.model.Pair;
import com.example.chessbot.model.piece.Piece;

import java.util.Map;

public interface GameState {
    int getMoveNumber();
    Map<BoardPosition, Piece> getBoard();
    Map<Integer, Map<BoardPosition, Piece>> getPreviousBoardStates();
    Pair<PlayerState, PlayerState> getPlayerStates();
}
