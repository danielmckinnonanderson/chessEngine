package com.example.chessbot.model.board;

import com.example.chessbot.model.utility.Pair;
import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.piece.PieceNames;
import com.example.chessbot.model.piece.PieceTeam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardFactory {

    public static Map<BoardPosition, Piece> createInitialBoard() {
        Map<BoardPosition, Piece> initialBoard = new HashMap<>();
        // TODO refactor this lol
        initialBoard.put(new BoardPosition(1, 1), new Piece(PieceNames.ROOK, PieceTeam.WHITE));
        initialBoard.put(new BoardPosition(2, 1), new Piece(PieceNames.KNIGHT, PieceTeam.WHITE));
        initialBoard.put(new BoardPosition(3, 1), new Piece(PieceNames.BISHOP, PieceTeam.WHITE));
        initialBoard.put(new BoardPosition(4, 1), new Piece(PieceNames.QUEEN, PieceTeam.WHITE));
        initialBoard.put(new BoardPosition(5, 1), new Piece(PieceNames.KING, PieceTeam.WHITE));
        initialBoard.put(new BoardPosition(6, 1), new Piece(PieceNames.BISHOP, PieceTeam.WHITE));
        initialBoard.put(new BoardPosition(7, 1), new Piece(PieceNames.KNIGHT, PieceTeam.WHITE));
        initialBoard.put(new BoardPosition(8, 1), new Piece(PieceNames.ROOK, PieceTeam.WHITE));

        initialBoard.put(new BoardPosition(1, 2), new Piece(PieceNames.PAWN, PieceTeam.WHITE));
        initialBoard.put(new BoardPosition(2, 2), new Piece(PieceNames.PAWN, PieceTeam.WHITE));
        initialBoard.put(new BoardPosition(3, 2), new Piece(PieceNames.PAWN, PieceTeam.WHITE));
        initialBoard.put(new BoardPosition(4, 2), new Piece(PieceNames.PAWN, PieceTeam.WHITE));
        initialBoard.put(new BoardPosition(5, 2), new Piece(PieceNames.PAWN, PieceTeam.WHITE));
        initialBoard.put(new BoardPosition(6, 2), new Piece(PieceNames.PAWN, PieceTeam.WHITE));
        initialBoard.put(new BoardPosition(7, 2), new Piece(PieceNames.PAWN, PieceTeam.WHITE));
        initialBoard.put(new BoardPosition(8, 2), new Piece(PieceNames.PAWN, PieceTeam.WHITE));

        initialBoard.put(new BoardPosition(1, 3), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        initialBoard.put(new BoardPosition(2, 3), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        initialBoard.put(new BoardPosition(3, 3), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        initialBoard.put(new BoardPosition(4, 3), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        initialBoard.put(new BoardPosition(5, 3), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        initialBoard.put(new BoardPosition(6, 3), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        initialBoard.put(new BoardPosition(7, 3), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        initialBoard.put(new BoardPosition(8, 3), new Piece(PieceNames.EMPTY, PieceTeam.NONE));

        initialBoard.put(new BoardPosition(1, 4), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        initialBoard.put(new BoardPosition(2, 4), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        initialBoard.put(new BoardPosition(3, 4), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        initialBoard.put(new BoardPosition(4, 4), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        initialBoard.put(new BoardPosition(5, 4), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        initialBoard.put(new BoardPosition(6, 4), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        initialBoard.put(new BoardPosition(7, 4), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        initialBoard.put(new BoardPosition(8, 4), new Piece(PieceNames.EMPTY, PieceTeam.NONE));

        initialBoard.put(new BoardPosition(1, 5), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        initialBoard.put(new BoardPosition(2, 5), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        initialBoard.put(new BoardPosition(3, 5), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        initialBoard.put(new BoardPosition(4, 5), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        initialBoard.put(new BoardPosition(5, 5), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        initialBoard.put(new BoardPosition(6, 5), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        initialBoard.put(new BoardPosition(7, 5), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        initialBoard.put(new BoardPosition(8, 5), new Piece(PieceNames.EMPTY, PieceTeam.NONE));

        initialBoard.put(new BoardPosition(1, 6), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        initialBoard.put(new BoardPosition(2, 6), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        initialBoard.put(new BoardPosition(3, 6), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        initialBoard.put(new BoardPosition(4, 6), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        initialBoard.put(new BoardPosition(5, 6), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        initialBoard.put(new BoardPosition(6, 6), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        initialBoard.put(new BoardPosition(7, 6), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        initialBoard.put(new BoardPosition(8, 6), new Piece(PieceNames.EMPTY, PieceTeam.NONE));

        initialBoard.put(new BoardPosition(1, 7), new Piece(PieceNames.PAWN, PieceTeam.BLACK));
        initialBoard.put(new BoardPosition(2, 7), new Piece(PieceNames.PAWN, PieceTeam.BLACK));
        initialBoard.put(new BoardPosition(3, 7), new Piece(PieceNames.PAWN, PieceTeam.BLACK));
        initialBoard.put(new BoardPosition(4, 7), new Piece(PieceNames.PAWN, PieceTeam.BLACK));
        initialBoard.put(new BoardPosition(5, 7), new Piece(PieceNames.PAWN, PieceTeam.BLACK));
        initialBoard.put(new BoardPosition(6, 7), new Piece(PieceNames.PAWN, PieceTeam.BLACK));
        initialBoard.put(new BoardPosition(7, 7), new Piece(PieceNames.PAWN, PieceTeam.BLACK));
        initialBoard.put(new BoardPosition(8, 7), new Piece(PieceNames.PAWN, PieceTeam.BLACK));

        initialBoard.put(new BoardPosition(1, 8), new Piece(PieceNames.ROOK, PieceTeam.BLACK));
        initialBoard.put(new BoardPosition(2, 8), new Piece(PieceNames.KNIGHT, PieceTeam.BLACK));
        initialBoard.put(new BoardPosition(3, 8), new Piece(PieceNames.BISHOP, PieceTeam.BLACK));
        initialBoard.put(new BoardPosition(4, 8), new Piece(PieceNames.QUEEN, PieceTeam.BLACK));
        initialBoard.put(new BoardPosition(5, 8), new Piece(PieceNames.KING, PieceTeam.BLACK));
        initialBoard.put(new BoardPosition(6, 8), new Piece(PieceNames.BISHOP, PieceTeam.BLACK));
        initialBoard.put(new BoardPosition(7, 8), new Piece(PieceNames.KNIGHT, PieceTeam.BLACK));
        initialBoard.put(new BoardPosition(8, 8), new Piece(PieceNames.ROOK, PieceTeam.BLACK));

        return initialBoard;
    }

    public static Map<BoardPosition, Piece> createEmptyBoard() {
        Map<BoardPosition, Piece> emptyBoard = new HashMap<>();

        // TODO refactor this lol
        emptyBoard.put(new BoardPosition(1, 1), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(2, 1), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(3, 1), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(4, 1), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(5, 1), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(6, 1), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(7, 1), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(8, 1), new Piece(PieceNames.EMPTY, PieceTeam.NONE));

        emptyBoard.put(new BoardPosition(1, 2), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(2, 2), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(3, 2), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(4, 2), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(5, 2), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(6, 2), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(7, 2), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(8, 2), new Piece(PieceNames.EMPTY, PieceTeam.NONE));

        emptyBoard.put(new BoardPosition(1, 3), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(2, 3), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(3, 3), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(4, 3), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(5, 3), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(6, 3), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(7, 3), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(8, 3), new Piece(PieceNames.EMPTY, PieceTeam.NONE));

        emptyBoard.put(new BoardPosition(1, 4), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(2, 4), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(3, 4), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(4, 4), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(5, 4), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(6, 4), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(7, 4), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(8, 4), new Piece(PieceNames.EMPTY, PieceTeam.NONE));

        emptyBoard.put(new BoardPosition(1, 5), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(2, 5), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(3, 5), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(4, 5), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(5, 5), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(6, 5), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(7, 5), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(8, 5), new Piece(PieceNames.EMPTY, PieceTeam.NONE));

        emptyBoard.put(new BoardPosition(1, 6), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(2, 6), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(3, 6), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(4, 6), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(5, 6), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(6, 6), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(7, 6), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(8, 6), new Piece(PieceNames.EMPTY, PieceTeam.NONE));

        emptyBoard.put(new BoardPosition(1, 7), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(2, 7), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(3, 7), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(4, 7), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(5, 7), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(6, 7), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(7, 7), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(8, 7), new Piece(PieceNames.EMPTY, PieceTeam.NONE));

        emptyBoard.put(new BoardPosition(1, 8), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(2, 8), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(3, 8), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(4, 8), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(5, 8), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(6, 8), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(7, 8), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        emptyBoard.put(new BoardPosition(8, 8), new Piece(PieceNames.EMPTY, PieceTeam.NONE));

        return emptyBoard;
    }

    public static Map<BoardPosition, Piece> updateBoard(Map<BoardPosition, Piece> board, List<Pair<BoardPosition, Piece>> turn) {
        for( Pair<BoardPosition, Piece> move : turn) {
            board.put(move.getLeft(), move.getRight());
        }
        return board;
    }
}
