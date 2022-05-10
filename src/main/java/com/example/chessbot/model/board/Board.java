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

    default Board initializeBoard() {
        Map<BoardPosition, Piece> initialBoard = new HashMap<>();
        // TODO refactor this lol
        try {
            initialBoard.put(new BoardPosition(BoardPositionX.A, BoardPositionY.ONE), new Piece(PieceNames.ROOK, 0));
            initialBoard.put(new BoardPosition(BoardPositionX.B, BoardPositionY.ONE), new Piece(PieceNames.KNIGHT, 0));
            initialBoard.put(new BoardPosition(BoardPositionX.C, BoardPositionY.ONE), new Piece(PieceNames.BISHOP, 0));
            initialBoard.put(new BoardPosition(BoardPositionX.D, BoardPositionY.ONE), new Piece(PieceNames.QUEEN, 0));
            initialBoard.put(new BoardPosition(BoardPositionX.E, BoardPositionY.ONE), new Piece(PieceNames.KING, 0));
            initialBoard.put(new BoardPosition(BoardPositionX.F, BoardPositionY.ONE), new Piece(PieceNames.BISHOP, 0));
            initialBoard.put(new BoardPosition(BoardPositionX.G, BoardPositionY.ONE), new Piece(PieceNames.KNIGHT, 0));
            initialBoard.put(new BoardPosition(BoardPositionX.H, BoardPositionY.ONE), new Piece(PieceNames.ROOK, 0));

            initialBoard.put(new BoardPosition(BoardPositionX.A, BoardPositionY.TWO), new Piece(PieceNames.PAWN, 0));
            initialBoard.put(new BoardPosition(BoardPositionX.B, BoardPositionY.TWO), new Piece(PieceNames.PAWN, 0));
            initialBoard.put(new BoardPosition(BoardPositionX.C, BoardPositionY.TWO), new Piece(PieceNames.PAWN, 0));
            initialBoard.put(new BoardPosition(BoardPositionX.D, BoardPositionY.TWO), new Piece(PieceNames.PAWN, 0));
            initialBoard.put(new BoardPosition(BoardPositionX.E, BoardPositionY.TWO), new Piece(PieceNames.PAWN, 0));
            initialBoard.put(new BoardPosition(BoardPositionX.F, BoardPositionY.TWO), new Piece(PieceNames.PAWN, 0));
            initialBoard.put(new BoardPosition(BoardPositionX.G, BoardPositionY.TWO), new Piece(PieceNames.PAWN, 0));
            initialBoard.put(new BoardPosition(BoardPositionX.H, BoardPositionY.TWO), new Piece(PieceNames.PAWN, 0));

            initialBoard.put(new BoardPosition(BoardPositionX.A, BoardPositionY.THREE), new Piece(PieceNames.EMPTY, 1));
            initialBoard.put(new BoardPosition(BoardPositionX.B, BoardPositionY.THREE), new Piece(PieceNames.EMPTY, 1));
            initialBoard.put(new BoardPosition(BoardPositionX.C, BoardPositionY.THREE), new Piece(PieceNames.EMPTY, 1));
            initialBoard.put(new BoardPosition(BoardPositionX.D, BoardPositionY.THREE), new Piece(PieceNames.EMPTY, 1));
            initialBoard.put(new BoardPosition(BoardPositionX.E, BoardPositionY.THREE), new Piece(PieceNames.EMPTY, 1));
            initialBoard.put(new BoardPosition(BoardPositionX.F, BoardPositionY.THREE), new Piece(PieceNames.EMPTY, 1));
            initialBoard.put(new BoardPosition(BoardPositionX.G, BoardPositionY.THREE), new Piece(PieceNames.EMPTY, 1));
            initialBoard.put(new BoardPosition(BoardPositionX.H, BoardPositionY.THREE), new Piece(PieceNames.EMPTY, 1));

            initialBoard.put(new BoardPosition(BoardPositionX.A, BoardPositionY.FOUR), new Piece(PieceNames.EMPTY, 1));
            initialBoard.put(new BoardPosition(BoardPositionX.B, BoardPositionY.FOUR), new Piece(PieceNames.EMPTY, 1));
            initialBoard.put(new BoardPosition(BoardPositionX.C, BoardPositionY.FOUR), new Piece(PieceNames.EMPTY, 1));
            initialBoard.put(new BoardPosition(BoardPositionX.D, BoardPositionY.FOUR), new Piece(PieceNames.EMPTY, 1));
            initialBoard.put(new BoardPosition(BoardPositionX.E, BoardPositionY.FOUR), new Piece(PieceNames.EMPTY, 1));
            initialBoard.put(new BoardPosition(BoardPositionX.F, BoardPositionY.FOUR), new Piece(PieceNames.EMPTY, 1));
            initialBoard.put(new BoardPosition(BoardPositionX.G, BoardPositionY.FOUR), new Piece(PieceNames.EMPTY, 1));
            initialBoard.put(new BoardPosition(BoardPositionX.H, BoardPositionY.FOUR), new Piece(PieceNames.EMPTY, 1));

            initialBoard.put(new BoardPosition(BoardPositionX.A, BoardPositionY.FIVE), new Piece(PieceNames.EMPTY, 1));
            initialBoard.put(new BoardPosition(BoardPositionX.B, BoardPositionY.FIVE), new Piece(PieceNames.EMPTY, 1));
            initialBoard.put(new BoardPosition(BoardPositionX.C, BoardPositionY.FIVE), new Piece(PieceNames.EMPTY, 1));
            initialBoard.put(new BoardPosition(BoardPositionX.D, BoardPositionY.FIVE), new Piece(PieceNames.EMPTY, 1));
            initialBoard.put(new BoardPosition(BoardPositionX.E, BoardPositionY.FIVE), new Piece(PieceNames.EMPTY, 1));
            initialBoard.put(new BoardPosition(BoardPositionX.F, BoardPositionY.FIVE), new Piece(PieceNames.EMPTY, 1));
            initialBoard.put(new BoardPosition(BoardPositionX.G, BoardPositionY.FIVE), new Piece(PieceNames.EMPTY, 1));
            initialBoard.put(new BoardPosition(BoardPositionX.H, BoardPositionY.FIVE), new Piece(PieceNames.EMPTY, 1));

            initialBoard.put(new BoardPosition(BoardPositionX.A, BoardPositionY.SIX), new Piece(PieceNames.EMPTY, 1));
            initialBoard.put(new BoardPosition(BoardPositionX.B, BoardPositionY.SIX), new Piece(PieceNames.EMPTY, 1));
            initialBoard.put(new BoardPosition(BoardPositionX.C, BoardPositionY.SIX), new Piece(PieceNames.EMPTY, 1));
            initialBoard.put(new BoardPosition(BoardPositionX.D, BoardPositionY.SIX), new Piece(PieceNames.EMPTY, 1));
            initialBoard.put(new BoardPosition(BoardPositionX.E, BoardPositionY.SIX), new Piece(PieceNames.EMPTY, 1));
            initialBoard.put(new BoardPosition(BoardPositionX.F, BoardPositionY.SIX), new Piece(PieceNames.EMPTY, 1));
            initialBoard.put(new BoardPosition(BoardPositionX.G, BoardPositionY.SIX), new Piece(PieceNames.EMPTY, 1));
            initialBoard.put(new BoardPosition(BoardPositionX.H, BoardPositionY.SIX), new Piece(PieceNames.EMPTY, 1));

            initialBoard.put(new BoardPosition(BoardPositionX.A, BoardPositionY.SEVEN), new Piece(PieceNames.PAWN, 1));
            initialBoard.put(new BoardPosition(BoardPositionX.B, BoardPositionY.SEVEN), new Piece(PieceNames.PAWN, 1));
            initialBoard.put(new BoardPosition(BoardPositionX.C, BoardPositionY.SEVEN), new Piece(PieceNames.PAWN, 1));
            initialBoard.put(new BoardPosition(BoardPositionX.D, BoardPositionY.SEVEN), new Piece(PieceNames.PAWN, 1));
            initialBoard.put(new BoardPosition(BoardPositionX.E, BoardPositionY.SEVEN), new Piece(PieceNames.PAWN, 1));
            initialBoard.put(new BoardPosition(BoardPositionX.F, BoardPositionY.SEVEN), new Piece(PieceNames.PAWN, 1));
            initialBoard.put(new BoardPosition(BoardPositionX.G, BoardPositionY.SEVEN), new Piece(PieceNames.PAWN, 1));
            initialBoard.put(new BoardPosition(BoardPositionX.H, BoardPositionY.SEVEN), new Piece(PieceNames.PAWN, 1));

            initialBoard.put(new BoardPosition(BoardPositionX.A, BoardPositionY.EIGHT), new Piece(PieceNames.ROOK, 1));
            initialBoard.put(new BoardPosition(BoardPositionX.B, BoardPositionY.EIGHT), new Piece(PieceNames.KNIGHT, 1));
            initialBoard.put(new BoardPosition(BoardPositionX.C, BoardPositionY.EIGHT), new Piece(PieceNames.BISHOP, 1));
            initialBoard.put(new BoardPosition(BoardPositionX.D, BoardPositionY.EIGHT), new Piece(PieceNames.KING, 1));
            initialBoard.put(new BoardPosition(BoardPositionX.E, BoardPositionY.EIGHT), new Piece(PieceNames.QUEEN, 1));
            initialBoard.put(new BoardPosition(BoardPositionX.F, BoardPositionY.EIGHT), new Piece(PieceNames.BISHOP, 1));
            initialBoard.put(new BoardPosition(BoardPositionX.G, BoardPositionY.EIGHT), new Piece(PieceNames.KNIGHT, 1));
            initialBoard.put(new BoardPosition(BoardPositionX.H, BoardPositionY.EIGHT), new Piece(PieceNames.ROOK, 1));

        } catch(IllegalTeamException exception) {
            System.out.println(exception.getMessage());
        }
        return this.setPiecesInPlay(initialBoard);
    }
}
