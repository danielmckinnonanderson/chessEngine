package com.example.chessbot.engine;

import com.example.chessbot.model.board.BoardFactory;
import com.example.chessbot.model.board.BoardPosition;
import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.piece.PieceNames;
import com.example.chessbot.model.piece.PieceTeam;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class ValidMoveGeneratorTest {
    static final Piece whitePawn = new Piece(PieceNames.PAWN, PieceTeam.WHITE, true);
    static final Piece blackPawn = new Piece(PieceNames.PAWN, PieceTeam.BLACK, true);
    static final Piece rook = new Piece(PieceNames.PAWN, PieceTeam.WHITE, true);
    static final Piece knight = new Piece(PieceNames.PAWN, PieceTeam.BLACK, true);
    static final Piece bishop = new Piece(PieceNames.PAWN, PieceTeam.WHITE, true);
    static final Piece queen = new Piece(PieceNames.PAWN, PieceTeam.BLACK, true);
    static final Piece king = new Piece(PieceNames.PAWN, PieceTeam.WHITE, true);

    static Map<BoardPosition, Piece> board;

    @BeforeEach
    public void setup() {
        board = BoardFactory.createEmptyBoard();
    }

    @Test
    public void testGeneratePawnPath() {
        int x = 4;
        int y = 2;
        final BoardPosition pos = new BoardPosition(4, 2);

        board.put(pos, whitePawn);

        final List<BoardPosition> result = ValidMoveGenerator.generateListOfValidMoves(whitePawn, pos, board);

        Assertions.assertThat(result.contains(new BoardPosition(x + 1, y + 1))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x, y + 2))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x, y + 1))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x - 1, y + 1))).isTrue();
        Assertions.assertThat(result.size()).isEqualTo(4);
    }
}
