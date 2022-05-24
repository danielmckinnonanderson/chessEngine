package com.example.chessbot.game.state;

import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.piece.Piece;

import java.util.Map;

public interface GameState {
    Map<BoardPosition, Piece> getBoard();
    int getMoveNumber();
}
