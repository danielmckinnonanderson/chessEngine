package com.example.chessbot.model.board;

import com.example.chessbot.model.board.exceptions.IllegalTeamException;
import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.piece.PieceNames;

import java.util.HashMap;
import java.util.Map;

public interface Board {
    Board setPiecesInPlay(Map<BoardPosition, Piece> piecesInPlay);
    Map<BoardPosition, Piece> getPiecesInPlay();

    default Map<BoardPosition, Piece> getInitialBoard() {
        Map<BoardPosition, Piece> initialBoard = new HashMap<>();
        try {
            initialBoard.put(new BoardPosition(0, 1), new Piece(PieceNames.PAWN, 0));
            initialBoard.put(new BoardPosition(1, 1), new Piece(PieceNames.PAWN, 0));
            initialBoard.put(new BoardPosition(2, 1), new Piece(PieceNames.PAWN, 0));
            initialBoard.put(new BoardPosition(3, 1), new Piece(PieceNames.PAWN, 0));
            initialBoard.put(new BoardPosition(4, 1), new Piece(PieceNames.PAWN, 0));
            initialBoard.put(new BoardPosition(5, 1), new Piece(PieceNames.PAWN, 0));
            initialBoard.put(new BoardPosition(6, 1), new Piece(PieceNames.PAWN, 0));
            initialBoard.put(new BoardPosition(7, 1), new Piece(PieceNames.PAWN, 0));
            initialBoard.put(new BoardPosition(0, 1), new Piece(PieceNames.ROOK, 0));
            initialBoard.put(new BoardPosition(7, 1), new Piece(PieceNames.ROOK, 0));
            initialBoard.put(new BoardPosition(2, 1), new Piece(PieceNames.BISHOP, 0));
            initialBoard.put(new BoardPosition(5, 1), new Piece(PieceNames.BISHOP, 0));
            initialBoard.put(new BoardPosition(1, 1), new Piece(PieceNames.KNIGHT, 0));
            initialBoard.put(new BoardPosition(6, 1), new Piece(PieceNames.KNIGHT, 0));
            initialBoard.put( new BoardPosition(3, 1),new Piece(PieceNames.QUEEN, 0));
            initialBoard.put(new BoardPosition(4, 1), new Piece(PieceNames.KING, 0));

            initialBoard.put(new BoardPosition(0, 6), new Piece(PieceNames.PAWN, 1));
            initialBoard.put(new BoardPosition(1, 6), new Piece(PieceNames.PAWN, 1));
            initialBoard.put(new BoardPosition(2, 6), new Piece(PieceNames.PAWN, 1));
            initialBoard.put(new BoardPosition(3, 6), new Piece(PieceNames.PAWN, 1));
            initialBoard.put(new BoardPosition(4, 6), new Piece(PieceNames.PAWN, 1));
            initialBoard.put(new BoardPosition(5, 6), new Piece(PieceNames.PAWN, 1));
            initialBoard.put(new BoardPosition(6, 6), new Piece(PieceNames.PAWN, 1));
            initialBoard.put(new BoardPosition(7, 6), new Piece(PieceNames.PAWN, 1));
            initialBoard.put(new BoardPosition(0, 7), new Piece(PieceNames.ROOK, 1));
            initialBoard.put(new BoardPosition(7, 7), new Piece(PieceNames.ROOK, 1));
            initialBoard.put(new BoardPosition(2, 7), new Piece(PieceNames.BISHOP, 1));
            initialBoard.put(new BoardPosition(5, 7), new Piece(PieceNames.BISHOP, 1));
            initialBoard.put(new BoardPosition(1, 7), new Piece(PieceNames.KNIGHT, 1));
            initialBoard.put(new BoardPosition(6, 7), new Piece(PieceNames.KNIGHT, 1));
            initialBoard.put(new BoardPosition(3, 7), new Piece(PieceNames.QUEEN, 1));
            initialBoard.put(new BoardPosition(4, 7), new Piece(PieceNames.KING, 1));
        } catch(IllegalTeamException exception) {
            System.out.println(exception.getMessage());
        }
        return initialBoard;
    }
}
