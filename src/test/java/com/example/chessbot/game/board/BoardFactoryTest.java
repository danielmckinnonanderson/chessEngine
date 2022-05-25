package com.example.chessbot.game.board;

import com.example.chessbot.model.board.BoardFactory;
import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.piece.PieceNames;
import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.piece.PieceTeam;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Hashtable;
import java.util.Map;

public class BoardFactoryTest {
    private Map<BoardPosition, Piece> constructMockboard_inInitialBoardPosition() {
        Map<BoardPosition, Piece> mockInitialBoard = new Hashtable<>();
        mockInitialBoard.put(new BoardPosition(1, 1), new Piece(PieceNames.ROOK, PieceTeam.WHITE));
        mockInitialBoard.put(new BoardPosition(2, 1), new Piece(PieceNames.KNIGHT, PieceTeam.WHITE));
        mockInitialBoard.put(new BoardPosition(3, 1), new Piece(PieceNames.BISHOP, PieceTeam.WHITE));
        mockInitialBoard.put(new BoardPosition(4, 1), new Piece(PieceNames.QUEEN, PieceTeam.WHITE));
        mockInitialBoard.put(new BoardPosition(5, 1), new Piece(PieceNames.KING, PieceTeam.WHITE));
        mockInitialBoard.put(new BoardPosition(6, 1), new Piece(PieceNames.BISHOP, PieceTeam.WHITE));
        mockInitialBoard.put(new BoardPosition(7, 1), new Piece(PieceNames.KNIGHT, PieceTeam.WHITE));
        mockInitialBoard.put(new BoardPosition(8, 1), new Piece(PieceNames.ROOK, PieceTeam.WHITE));

        mockInitialBoard.put(new BoardPosition(1, 2), new Piece(PieceNames.PAWN, PieceTeam.WHITE));
        mockInitialBoard.put(new BoardPosition(2, 2), new Piece(PieceNames.PAWN, PieceTeam.WHITE));
        mockInitialBoard.put(new BoardPosition(3, 2), new Piece(PieceNames.PAWN, PieceTeam.WHITE));
        mockInitialBoard.put(new BoardPosition(4, 2), new Piece(PieceNames.PAWN, PieceTeam.WHITE));
        mockInitialBoard.put(new BoardPosition(5, 2), new Piece(PieceNames.PAWN, PieceTeam.WHITE));
        mockInitialBoard.put(new BoardPosition(6, 2), new Piece(PieceNames.PAWN, PieceTeam.WHITE));
        mockInitialBoard.put(new BoardPosition(7, 2), new Piece(PieceNames.PAWN, PieceTeam.WHITE));
        mockInitialBoard.put(new BoardPosition(8, 2), new Piece(PieceNames.PAWN, PieceTeam.WHITE));

        mockInitialBoard.put(new BoardPosition(1, 3), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialBoard.put(new BoardPosition(2, 3), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialBoard.put(new BoardPosition(3, 3), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialBoard.put(new BoardPosition(4, 3), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialBoard.put(new BoardPosition(5, 3), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialBoard.put(new BoardPosition(6, 3), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialBoard.put(new BoardPosition(7, 3), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialBoard.put(new BoardPosition(8, 3), new Piece(PieceNames.EMPTY, PieceTeam.NONE));

        mockInitialBoard.put(new BoardPosition(1, 4), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialBoard.put(new BoardPosition(2, 4), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialBoard.put(new BoardPosition(3, 4), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialBoard.put(new BoardPosition(4, 4), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialBoard.put(new BoardPosition(5, 4), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialBoard.put(new BoardPosition(6, 4), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialBoard.put(new BoardPosition(7, 4), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialBoard.put(new BoardPosition(8, 4), new Piece(PieceNames.EMPTY, PieceTeam.NONE));

        mockInitialBoard.put(new BoardPosition(1, 5), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialBoard.put(new BoardPosition(2, 5), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialBoard.put(new BoardPosition(3, 5), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialBoard.put(new BoardPosition(4, 5), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialBoard.put(new BoardPosition(5, 5), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialBoard.put(new BoardPosition(6, 5), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialBoard.put(new BoardPosition(7, 5), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialBoard.put(new BoardPosition(8, 5), new Piece(PieceNames.EMPTY, PieceTeam.NONE));

        mockInitialBoard.put(new BoardPosition(1, 6), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialBoard.put(new BoardPosition(2, 6), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialBoard.put(new BoardPosition(3, 6), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialBoard.put(new BoardPosition(4, 6), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialBoard.put(new BoardPosition(5, 6), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialBoard.put(new BoardPosition(6, 6), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialBoard.put(new BoardPosition(7, 6), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialBoard.put(new BoardPosition(8, 6), new Piece(PieceNames.EMPTY, PieceTeam.NONE));

        mockInitialBoard.put(new BoardPosition(1, 7), new Piece(PieceNames.PAWN, PieceTeam.BLACK));
        mockInitialBoard.put(new BoardPosition(2, 7), new Piece(PieceNames.PAWN, PieceTeam.BLACK));
        mockInitialBoard.put(new BoardPosition(3, 7), new Piece(PieceNames.PAWN, PieceTeam.BLACK));
        mockInitialBoard.put(new BoardPosition(4, 7), new Piece(PieceNames.PAWN, PieceTeam.BLACK));
        mockInitialBoard.put(new BoardPosition(5, 7), new Piece(PieceNames.PAWN, PieceTeam.BLACK));
        mockInitialBoard.put(new BoardPosition(6, 7), new Piece(PieceNames.PAWN, PieceTeam.BLACK));
        mockInitialBoard.put(new BoardPosition(7, 7), new Piece(PieceNames.PAWN, PieceTeam.BLACK));
        mockInitialBoard.put(new BoardPosition(8, 7), new Piece(PieceNames.PAWN, PieceTeam.BLACK));

        mockInitialBoard.put(new BoardPosition(1, 8), new Piece(PieceNames.ROOK, PieceTeam.BLACK));
        mockInitialBoard.put(new BoardPosition(2, 8), new Piece(PieceNames.KNIGHT, PieceTeam.BLACK));
        mockInitialBoard.put(new BoardPosition(3, 8), new Piece(PieceNames.BISHOP, PieceTeam.BLACK));
        mockInitialBoard.put(new BoardPosition(4, 8), new Piece(PieceNames.QUEEN, PieceTeam.BLACK));
        mockInitialBoard.put(new BoardPosition(5, 8), new Piece(PieceNames.KING, PieceTeam.BLACK));
        mockInitialBoard.put(new BoardPosition(6, 8), new Piece(PieceNames.BISHOP, PieceTeam.BLACK));
        mockInitialBoard.put(new BoardPosition(7, 8), new Piece(PieceNames.KNIGHT, PieceTeam.BLACK));
        mockInitialBoard.put(new BoardPosition(8, 8), new Piece(PieceNames.ROOK, PieceTeam.BLACK));
        return mockInitialBoard;
    }


    @Test
    public void testBoardFactory_newBoard() {
        final Map<BoardPosition, Piece> RESULT = BoardFactory.createInitialBoard();

        Assertions.assertThat(RESULT).isNotNull();

        for (BoardPosition key : RESULT.keySet()) {
            Piece pieceInPlay = RESULT.get(key);
            PieceNames pieceName = pieceInPlay.getPieceName();

            switch (key.getY()) {

                case 3, 4, 5, 6 -> Assertions.assertThat(pieceName).isEqualTo(PieceNames.EMPTY);
                case 2, 7 -> Assertions.assertThat(pieceName).isEqualTo(PieceNames.PAWN);
                case 1, 8 -> {
                    switch (key.getX()) {
                        case 1, 8 -> Assertions.assertThat(pieceName)
                                .isEqualTo(PieceNames.ROOK);
                        case 2, 7 -> Assertions.assertThat(pieceName)
                                .isEqualTo(PieceNames.KNIGHT);
                        case 3, 6 -> Assertions.assertThat(pieceName)
                                .isEqualTo(PieceNames.BISHOP);
                        case 4 -> Assertions.assertThat(pieceName)
                                .isEqualTo(PieceNames.QUEEN);
                        case 5 -> Assertions.assertThat(pieceName)
                                .isEqualTo(PieceNames.KING);
                    }
                }
            }
        }
    }
}
