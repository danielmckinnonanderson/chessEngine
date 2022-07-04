package com.example.chessbot.game.utility;

import com.example.chessbot.model.board.BoardPosition;
import com.example.chessbot.model.piece.Piece;

import java.util.Map;

public class MoveExecutorUtility {
    private MoveExecutorUtility() {}

    public static Map<BoardPosition, Piece> exchangePositions(BoardPosition from,
                                                        BoardPosition to,
                                                        Map<BoardPosition, Piece> board) {
        Piece p1 = board.get(from);
        if(!p1.getTouched()) {
            p1 = new Piece(p1.getPieceName(), p1.getPieceTeam(), true);
        }

        Piece p2 = board.get(to);
        if(!p2.getTouched()) {
            p2 = new Piece(p2.getPieceName(), p2.getPieceTeam(), true);
        }

        board.put(to, p1);
        board.put(from, p2);

        return board;
    }
}
