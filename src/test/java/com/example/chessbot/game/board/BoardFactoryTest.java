package com.example.chessbot.game.board;

import com.example.chessbot.model.board.BoardFactory;
import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.piece.PieceNames;
import com.example.chessbot.model.board.position.BoardPosition;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class BoardFactoryTest {
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
