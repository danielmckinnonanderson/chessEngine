package com.example.chessbot.game.utility;

import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.piece.PieceNames;
import com.example.chessbot.model.piece.PieceTeam;

import java.util.Map;

public final class MoveExecutorUtil {

    public static Map<BoardPosition, Piece> move(Map<BoardPosition, Piece> board, BoardPosition from, BoardPosition to) {
        Piece moveThis = board.get(from);

        if (EmptyPieceUtil.isPieceEmpty(moveThis)) {
            throw new IllegalArgumentException("Cannot move empty!");
        }

        board.put(to, moveThis);
        board.put(from, new Piece(PieceNames.EMPTY, PieceTeam.NONE, true));

        return board;
    }
}
