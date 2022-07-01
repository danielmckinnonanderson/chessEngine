package com.example.chessbot.game.utility;

import com.example.chessbot.model.board.BoardFactory;
import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.utility.Pair;
import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.piece.PieceNames;
import com.example.chessbot.model.piece.PieceTeam;
import com.example.chessbot.model.state.player.attributes.CheckState;
import com.example.chessbot.model.state.player.attributes.CheckStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class CheckUtilTest {
    private final Map<BoardPosition, Piece> emptyBoard = BoardFactory.createEmptyBoard();

    private final Piece whiteKing = new Piece(PieceNames.KING, PieceTeam.WHITE);
    private final Piece whiteQueen = new Piece(PieceNames.QUEEN, PieceTeam.WHITE);
    private final Piece whiteBishop = new Piece(PieceNames.BISHOP, PieceTeam.WHITE);
    private final Piece whiteKnight = new Piece(PieceNames.KNIGHT, PieceTeam.WHITE);
    private final Piece whiteRook = new Piece(PieceNames.ROOK, PieceTeam.WHITE);
    private final Piece whitepawn = new Piece(PieceNames.PAWN, PieceTeam.WHITE);


    private final Piece blackKing = new Piece(PieceNames.KING, PieceTeam.BLACK);
    private final Piece blackQueen = new Piece(PieceNames.QUEEN, PieceTeam.BLACK);
    private final Piece blackBishop = new Piece(PieceNames.BISHOP, PieceTeam.BLACK);
    private final Piece blackKnight = new Piece(PieceNames.KNIGHT, PieceTeam.BLACK);
    private final Piece blackRook = new Piece(PieceNames.ROOK, PieceTeam.BLACK);
    private final Piece blackpawn = new Piece(PieceNames.PAWN, PieceTeam.BLACK);


    private Map<BoardPosition, Piece> setupBoard_onlyOneKing() {
        Map<BoardPosition, Piece> result = emptyBoard;

        result.put(new BoardPosition(4, 1), whiteKing);

        return result;
    }

    private Map<BoardPosition, Piece> setupBoard_bothKings() {
        Map<BoardPosition, Piece> result = emptyBoard;

        result.put(new BoardPosition(6, 7), blackKing);
        result.put(new BoardPosition(3, 2), whiteKing);

        return result;
    }

    @Test
    public void testCheckFromOneLocation() {
        Map<BoardPosition, Piece> board = setupBoard_onlyOneKing();

        board.put(new BoardPosition(6, 3), blackBishop);

        Pair<CheckState, CheckState> newStates = CheckUtil.getCheckStatesFromBoard(board);

        Assertions.assertThat(newStates.getLeft().getStatus()).isEqualTo(CheckStatus.CHECK);
        Assertions.assertThat(newStates.getRight().getStatus()).isEqualTo(CheckStatus.NONE);
        Assertions.assertThat(newStates.getLeft().getInCheckFrom().size()).isEqualTo(1);
        Assertions.assertThat(newStates.getRight().getInCheckFrom().size()).isEqualTo(0);
    }

    @Test
    public void testCheckFromMultipleLocation() {
        Map<BoardPosition, Piece> board = setupBoard_onlyOneKing();

        board.put(new BoardPosition(6, 3), blackBishop);
        board.put(new BoardPosition(2, 2), blackKnight);
        board.put(new BoardPosition(4, 7), blackRook);
        board.put(new BoardPosition(4, 5), whiteRook);

        Pair<CheckState, CheckState> newStates = CheckUtil.getCheckStatesFromBoard(board);

        Assertions.assertThat(newStates.getLeft().getStatus()).isEqualTo(CheckStatus.CHECK);
        Assertions.assertThat(newStates.getRight().getStatus()).isEqualTo(CheckStatus.NONE);
        Assertions.assertThat(newStates.getLeft().getInCheckFrom().size()).isEqualTo(2);
        Assertions.assertThat(newStates.getRight().getInCheckFrom().size()).isEqualTo(0);
        Assertions.assertThat(newStates.getLeft().getInCheckFrom().contains(new Pair<>(new BoardPosition(4,7), blackRook))).isFalse();
    }

    @Test
    public void testKingIsPinned_IsInCheckmate() {
        Map<BoardPosition, Piece> board = setupBoard_bothKings();

        // friendly rooks on either side
        board.put(new BoardPosition(2, 2), whiteRook);
        board.put(new BoardPosition(4, 2), whiteRook);

        // black queen covering row below and diagonal right
        board.put(new BoardPosition(6, 1), blackQueen);

        // black rook covering column to left
        board.put(new BoardPosition(2, 8), blackRook);

        // black knight covering last option
        board.put(new BoardPosition(5, 4), blackKnight);

        Pair<CheckState, CheckState> newStates = CheckUtil.getCheckStatesFromBoard(board);

        Assertions.assertThat(newStates.getLeft().getStatus()).isEqualTo(CheckStatus.CHECKMATE);
        Assertions.assertThat(newStates.getRight().getStatus()).isEqualTo(CheckStatus.NONE);
        Assertions.assertThat(newStates.getLeft().getInCheckFrom().size()).isEqualTo(3);
        Assertions.assertThat(newStates.getLeft().getInCheckFrom().contains(new Pair<>(new BoardPosition(2, 2), whiteRook))).isFalse();
    }
}
