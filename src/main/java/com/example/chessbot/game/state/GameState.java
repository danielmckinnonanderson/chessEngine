package com.example.chessbot.game.state;

import com.example.chessbot.game.state.player.PlayerState;
import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.board.position.Pair;
import com.example.chessbot.model.piece.Piece;

import java.util.List;
import java.util.Map;

public interface GameState {
    int getMoveNumber();
    Map<BoardPosition, Piece> getBoard();
    List<Map<BoardPosition, Piece>> getLastFiftyMoves();
    Pair<PlayerState, PlayerState> getPlayerStates();
}
