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
    static final Piece rook = new Piece(PieceNames.ROOK, PieceTeam.WHITE, true);
    static final Piece knight = new Piece(PieceNames.KNIGHT, PieceTeam.BLACK, true);
    static final Piece bishop = new Piece(PieceNames.BISHOP, PieceTeam.WHITE, true);
    static final Piece queen = new Piece(PieceNames.QUEEN, PieceTeam.BLACK, true);
    static final Piece king = new Piece(PieceNames.KING, PieceTeam.WHITE, true);

    static Map<BoardPosition, Piece> board;

    @BeforeEach
    public void setup() {
        board = BoardFactory.createEmptyBoard();
    }

    @Test
    public void testGenerateWhitePawnPath() {
        int x = 4;
        int y = 2;
        final BoardPosition pos = new BoardPosition(x, y);

        board.put(pos, whitePawn);

        final List<BoardPosition> result = ValidMoveGenerator.listOfPotentialMovesFromPieceName(whitePawn, pos);

        Assertions.assertThat(result.contains(new BoardPosition(x + 1, y + 1))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x, y + 2))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x, y + 1))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x - 1, y + 1))).isTrue();
        Assertions.assertThat(result.size()).isEqualTo(4);
    }

    @Test
    public void testGenerateBlackPawnPath() {
        int x = 7;
        int y = 4;
        final BoardPosition pos = new BoardPosition(x, y);

        board.put(pos, whitePawn);

        final List<BoardPosition> result = ValidMoveGenerator.listOfPotentialMovesFromPieceName(blackPawn, pos);

        Assertions.assertThat(result.contains(new BoardPosition(x + 1, y - 1))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x, y - 2))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x, y - 1))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x - 1, y -1))).isTrue();
        Assertions.assertThat(result.size()).isEqualTo(4);
    }

    @Test
    public void testGenerateRookPath() {
        int x = 1;
        int y = 1;
        final BoardPosition pos = new BoardPosition(x, y);

        final List<BoardPosition> result = ValidMoveGenerator.listOfPotentialMovesFromPieceName(rook, pos);

        Assertions.assertThat(result.contains(new BoardPosition(x + 1, y))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x + 2, y))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x + 3, y))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x + 4, y))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x + 5, y))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x + 6, y))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x + 7, y))).isTrue();

        Assertions.assertThat(result.contains(new BoardPosition(x, y + 1))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x, y + 2))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x, y + 3))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x, y + 4))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x, y + 5))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x, y + 6))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x, y + 7))).isTrue();

        Assertions.assertThat(result.size()).isEqualTo(14);
    }

    @Test
    public void testGenerateKnightPath() {
        int x = 6;
        int y = 3;
        final BoardPosition pos = new BoardPosition(x, y);

        final List<BoardPosition> result = ValidMoveGenerator.listOfPotentialMovesFromPieceName(knight, pos);

        Assertions.assertThat(result.contains(new BoardPosition(x + 1, y + 2))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x + 2, y + 1))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x - 1, y + 2))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x - 2, y + 1))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x + 1, y - 2))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x + 2, y - 1))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x - 1, y - 2))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x - 2, y - 1))).isTrue();
        Assertions.assertThat(result.size()).isEqualTo(8);

        int xX = 7;
        int yY = 7;
        final BoardPosition pos2 = new BoardPosition(xX, yY);

        final List<BoardPosition> result2 = ValidMoveGenerator.listOfPotentialMovesFromPieceName(knight, pos2);

        Assertions.assertThat(result2.contains(new BoardPosition(xX - 1, yY + 2))).isFalse();
        Assertions.assertThat(result2.contains(new BoardPosition(xX - 2, yY + 1))).isTrue();
        Assertions.assertThat(result2.contains(new BoardPosition(xX + 2, yY + 1))).isFalse();
        Assertions.assertThat(result2.contains(new BoardPosition(xX + 1, yY + 2))).isFalse();
        Assertions.assertThat(result2.contains(new BoardPosition(xX + 1, yY - 2))).isTrue();
        Assertions.assertThat(result2.contains(new BoardPosition(xX + 2, yY - 1))).isFalse();
        Assertions.assertThat(result2.contains(new BoardPosition(xX - 1, yY - 2))).isTrue();
        Assertions.assertThat(result2.contains(new BoardPosition(xX - 2, yY - 1))).isTrue();
        Assertions.assertThat(result2.size()).isEqualTo(4);
    }

    @Test
    public void testGenerateBishopPath() {
        int x = 3;
        int y = 5;
        final BoardPosition pos = new BoardPosition(x, y);

        final List<BoardPosition> result = ValidMoveGenerator.listOfPotentialMovesFromPieceName(bishop, pos);

        Assertions.assertThat(result.contains(new BoardPosition(x + 1, y + 1))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x + 2, y + 2))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x + 3, y + 3))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x + 4, y + 4))).isFalse();

        Assertions.assertThat(result.contains(new BoardPosition(x + 1, y -1))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x + 2, y -2))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x + 3, y -3))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x + 4, y -4))).isTrue();

        Assertions.assertThat(result.contains(new BoardPosition(x - 1, y - 1))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x - 2, y - 2))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x - 3, y - 3))).isFalse();
        Assertions.assertThat(result.contains(new BoardPosition(x - 4, y - 4))).isFalse();

        Assertions.assertThat(result.contains(new BoardPosition(x - 1, y + 1))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x - 2, y + 2))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x - 3, y + 2))).isFalse();

        Assertions.assertThat(result.size()).isEqualTo(11);
    }

    @Test
    public void testGenerateQueenPath() {
        int x = 4;
        int y = 4;
        final BoardPosition pos = new BoardPosition(x, y);

        final List<BoardPosition> result = ValidMoveGenerator.listOfPotentialMovesFromPieceName(queen, pos);

        Assertions.assertThat(result.contains(new BoardPosition(x + 1, y))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x + 2, y))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x + 3, y))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x + 4, y))).isTrue();

        Assertions.assertThat(result.contains(new BoardPosition(x, y + 1))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x, y + 2))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x, y + 3))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x, y + 4))).isTrue();

        Assertions.assertThat(result.contains(new BoardPosition(x + 1, y + 1))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x + 2, y + 2))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x + 3, y + 3))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x + 4, y + 4))).isTrue();

        Assertions.assertThat(result.contains(new BoardPosition(x + 1, y - 1))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x + 2, y - 2))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x + 3, y - 3))).isTrue();

        Assertions.assertThat(result.contains(new BoardPosition(x, y - 1))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x, y - 2))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x, y - 3))).isTrue();

        Assertions.assertThat(result.contains(new BoardPosition(x - 1, y - 1))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x - 2, y - 2))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x - 3, y - 3))).isTrue();

        Assertions.assertThat(result.contains(new BoardPosition(x - 1, y))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x - 2, y))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x - 3, y))).isTrue();

        Assertions.assertThat(result.contains(new BoardPosition(x - 1, y + 1))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x - 2, y + 2))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x - 3, y + 3))).isTrue();

        Assertions.assertThat(result.contains(new BoardPosition(9, 9 ))).isFalse();

        Assertions.assertThat(result.size()).isEqualTo(27);
    }

    @Test
    public void testGenerateKingPath() {
        int x = 5;
        int y = 7;
        final BoardPosition pos = new BoardPosition(x, y);

        final List<BoardPosition> result = ValidMoveGenerator.listOfPotentialMovesFromPieceName(king, pos);

        Assertions.assertThat(result.contains(new BoardPosition(x, y + 1))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x + 1, y + 1))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x + 1, y))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x + 1, y - 1))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x, y - 1))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x - 1, y - 1))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x - 1, y))).isTrue();
        Assertions.assertThat(result.contains(new BoardPosition(x - 1, y + 1))).isTrue();

        Assertions.assertThat(result.size()).isEqualTo(8);

        int xX = 1;
        int yY = 8;
        final BoardPosition pos2 = new BoardPosition(xX, yY);

        final List<BoardPosition> result2 = ValidMoveGenerator.listOfPotentialMovesFromPieceName(king, pos2);

        Assertions.assertThat(result2.contains(new BoardPosition(xX, yY + 1))).isFalse();
        Assertions.assertThat(result2.contains(new BoardPosition(xX + 1, yY + 1))).isFalse();
        Assertions.assertThat(result2.contains(new BoardPosition(xX + 1, yY))).isTrue();
        Assertions.assertThat(result2.contains(new BoardPosition(xX + 1, yY - 1))).isTrue();
        Assertions.assertThat(result2.contains(new BoardPosition(xX, yY - 1))).isTrue();
        Assertions.assertThat(result2.contains(new BoardPosition(xX - 1, yY - 1))).isFalse();
        Assertions.assertThat(result2.contains(new BoardPosition(xX - 1, yY))).isFalse();
        Assertions.assertThat(result2.contains(new BoardPosition(xX - 1, yY + 1))).isFalse();

        Assertions.assertThat(result2.size()).isEqualTo(3);
    }
}
