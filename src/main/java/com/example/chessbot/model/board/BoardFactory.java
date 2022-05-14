package com.example.chessbot.game.board;

import com.example.chessbot.model.board.Board;
import com.example.chessbot.model.board.ConcreteBoard;
import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.board.position.BoardPosition;

import java.util.Map;

public class BoardFactory {

    public static Board createInitialBoard() {
        return new ConcreteBoard().initializeBoard();
    }

    public static Board updateBoard(Map<BoardPosition, Piece> piecesInPlay) {
        return new ConcreteBoard().setPiecesInPlay(piecesInPlay);
    }
}
