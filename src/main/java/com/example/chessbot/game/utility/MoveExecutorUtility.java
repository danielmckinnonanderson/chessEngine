package com.example.chessbot.game.utility;

import com.example.chessbot.model.board.BoardPosition;
import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.piece.PieceNames;
import com.example.chessbot.model.piece.PieceTeam;

import java.util.Map;

public class MoveExecutorUtility {
    public static Map<BoardPosition, Piece> executeMove(BoardPosition from,
                                                        BoardPosition to,
                                                        Map<BoardPosition, Piece> board) {
        Piece inPosition = board.get(from);
        Piece toMove = new Piece(inPosition.getPieceName(), inPosition.getPieceTeam(), true);

        if(!EmptyPieceUtility.isPieceEmpty(toMove)) {
            throw new IllegalArgumentException("Cannot move empty!");
        }

        board.put(to, toMove);
        board.put(from, new Piece(PieceNames.EMPTY, PieceTeam.NONE, true));

        return board;
    }
}
