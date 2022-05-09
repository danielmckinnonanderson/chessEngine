package com.example.chessbot.model.board;

import com.example.chessbot.model.board.exceptions.IllegalTeamException;
import com.example.chessbot.model.board.position.BoardPositionX;
import com.example.chessbot.model.board.position.BoardPositionY;
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
            initialBoard.put(new BoardPosition(BoardPositionX.A, BoardPositionY.TWO), new Piece(PieceNames.PAWN, 0));
            initialBoard.put(new BoardPosition(BoardPositionX.B, BoardPositionY.TWO), new Piece(PieceNames.PAWN, 0));
            initialBoard.put(new BoardPosition(BoardPositionX.C, BoardPositionY.TWO), new Piece(PieceNames.PAWN, 0));
            initialBoard.put(new BoardPosition(BoardPositionX.D, BoardPositionY.TWO), new Piece(PieceNames.PAWN, 0));
            initialBoard.put(new BoardPosition(BoardPositionX.E, BoardPositionY.TWO), new Piece(PieceNames.PAWN, 0));
            initialBoard.put(new BoardPosition(BoardPositionX.F, BoardPositionY.TWO), new Piece(PieceNames.PAWN, 0));
            initialBoard.put(new BoardPosition(BoardPositionX.G, BoardPositionY.TWO), new Piece(PieceNames.PAWN, 0));
            initialBoard.put(new BoardPosition(BoardPositionX.H, BoardPositionY.TWO), new Piece(PieceNames.PAWN, 0));

            initialBoard.put(new BoardPosition(BoardPositionX.A, BoardPositionY.ONE), new Piece(PieceNames.ROOK, 0));
            initialBoard.put(new BoardPosition(BoardPositionX.B, BoardPositionY.ONE), new Piece(PieceNames.KNIGHT, 0));
            initialBoard.put(new BoardPosition(BoardPositionX.C, BoardPositionY.ONE), new Piece(PieceNames.BISHOP, 0));
            initialBoard.put(new BoardPosition(BoardPositionX.D, BoardPositionY.ONE), new Piece(PieceNames.QUEEN, 0));
            initialBoard.put(new BoardPosition(BoardPositionX.E, BoardPositionY.ONE), new Piece(PieceNames.KING, 0));
            initialBoard.put(new BoardPosition(BoardPositionX.F, BoardPositionY.ONE), new Piece(PieceNames.BISHOP, 0));
            initialBoard.put(new BoardPosition(BoardPositionX.G, BoardPositionY.ONE), new Piece(PieceNames.KNIGHT, 0));
            initialBoard.put(new BoardPosition(BoardPositionX.H, BoardPositionY.ONE), new Piece(PieceNames.ROOK, 0));

            initialBoard.put(new BoardPosition(BoardPositionX.A, BoardPositionY.SEVEN), new Piece(PieceNames.PAWN, 0));
            initialBoard.put(new BoardPosition(BoardPositionX.B, BoardPositionY.SEVEN), new Piece(PieceNames.PAWN, 0));
            initialBoard.put(new BoardPosition(BoardPositionX.C, BoardPositionY.SEVEN), new Piece(PieceNames.PAWN, 0));
            initialBoard.put(new BoardPosition(BoardPositionX.D, BoardPositionY.SEVEN), new Piece(PieceNames.PAWN, 0));
            initialBoard.put(new BoardPosition(BoardPositionX.E, BoardPositionY.SEVEN), new Piece(PieceNames.PAWN, 0));
            initialBoard.put(new BoardPosition(BoardPositionX.F, BoardPositionY.SEVEN), new Piece(PieceNames.PAWN, 0));
            initialBoard.put(new BoardPosition(BoardPositionX.G, BoardPositionY.SEVEN), new Piece(PieceNames.PAWN, 0));
            initialBoard.put(new BoardPosition(BoardPositionX.H, BoardPositionY.SEVEN), new Piece(PieceNames.PAWN, 0));

            initialBoard.put(new BoardPosition(BoardPositionX.A, BoardPositionY.EIGHT), new Piece(PieceNames.ROOK, 0));
            initialBoard.put(new BoardPosition(BoardPositionX.B, BoardPositionY.EIGHT), new Piece(PieceNames.KNIGHT, 0));
            initialBoard.put(new BoardPosition(BoardPositionX.C, BoardPositionY.EIGHT), new Piece(PieceNames.BISHOP, 0));
            initialBoard.put(new BoardPosition(BoardPositionX.D, BoardPositionY.EIGHT), new Piece(PieceNames.QUEEN, 0));
            initialBoard.put(new BoardPosition(BoardPositionX.E, BoardPositionY.EIGHT), new Piece(PieceNames.KING, 0));
            initialBoard.put(new BoardPosition(BoardPositionX.F, BoardPositionY.EIGHT), new Piece(PieceNames.BISHOP, 0));
            initialBoard.put(new BoardPosition(BoardPositionX.G, BoardPositionY.EIGHT), new Piece(PieceNames.KNIGHT, 0));
            initialBoard.put(new BoardPosition(BoardPositionX.H, BoardPositionY.EIGHT), new Piece(PieceNames.ROOK, 0));
        } catch(IllegalTeamException exception) {
            System.out.println(exception.getMessage());
        }
        return initialBoard;
    }
}
