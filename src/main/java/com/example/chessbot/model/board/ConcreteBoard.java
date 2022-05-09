package com.example.chessbot.model.board;

import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.board.position.BoardPosition;

import java.util.HashMap;
import java.util.Map;

public class ConcreteBoard implements Board {

    private Map<BoardPosition, Piece> piecesInPlay = new HashMap<>();

    public ConcreteBoard() {
    }

    public Board setPiecesInPlay(Map<BoardPosition, Piece> piecesInPlay) {
        this.piecesInPlay = piecesInPlay;
        return this;
    }

    @Override
    public Map<BoardPosition, Piece> getPiecesInPlay() {
        return this.piecesInPlay;
    }
}
