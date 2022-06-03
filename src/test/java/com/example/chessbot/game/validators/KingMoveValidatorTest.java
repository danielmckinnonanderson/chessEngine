package com.example.chessbot.game.validators;

import com.example.chessbot.game.state.GameState;
import com.example.chessbot.game.state.GameStateFactory;
import com.example.chessbot.game.state.player.PlayerState;
import com.example.chessbot.game.state.player.PlayerStateFactory;
import com.example.chessbot.game.validators.movement.KingMoveValidator;
import com.example.chessbot.model.board.BoardFactory;
import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.board.position.Pair;
import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.piece.PieceNames;
import com.example.chessbot.model.piece.PieceTeam;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class KingMoveValidatorTest {

    private Map<BoardPosition, Piece> emptyBoard;
    private Pair<PlayerState, PlayerState> playerStates;

    @BeforeEach
    public void setupBoard() {
        this.playerStates = new Pair<>(PlayerStateFactory.createInitialPlayerState(PieceTeam.WHITE), PlayerStateFactory.createInitialPlayerState(PieceTeam.BLACK));
        this.emptyBoard = BoardFactory.createEmptyBoard();
    }

    @Test
    public void testGivenNoPiecesOnBoard_KingCanMoveOmnidirectionally() {
        Map<BoardPosition, Piece> board = emptyBoard;

        final BoardPosition start = new BoardPosition(2, 2);
        final BoardPosition up = new BoardPosition(2, 3);
        final BoardPosition right = new BoardPosition(3, 2);
        final BoardPosition down = new BoardPosition(2, 1);
        final BoardPosition left = new BoardPosition(1, 2);
        final BoardPosition upRight = new BoardPosition(3, 3);
        final BoardPosition downRight = new BoardPosition(3, 1);
        final BoardPosition downLeft = new BoardPosition(1, 1);
        final BoardPosition upLeft = new BoardPosition(1, 3);

        final Piece blackKing = new Piece(PieceNames.KING, PieceTeam.BLACK);

        board.put(start, blackKing);

        GameState gameState = GameStateFactory.createNewGameState(333, board, new HashMap<>(), this.playerStates);

        final boolean result1 = KingMoveValidator.validate(gameState, start, up);
        final boolean result2 = KingMoveValidator.validate(gameState, start, right);
        final boolean result3 = KingMoveValidator.validate(gameState, start, down);
        final boolean result4 = KingMoveValidator.validate(gameState, start, left);
        final boolean result5 = KingMoveValidator.validate(gameState, start, upRight);
        final boolean result6 = KingMoveValidator.validate(gameState, start, downRight);
        final boolean result7 = KingMoveValidator.validate(gameState, start, downLeft);
        final boolean result8 = KingMoveValidator.validate(gameState, start, upLeft);

        Assertions.assertThat(result1).isTrue();
        Assertions.assertThat(result2).isTrue();
        Assertions.assertThat(result3).isTrue();
        Assertions.assertThat(result4).isTrue();
        Assertions.assertThat(result5).isTrue();
        Assertions.assertThat(result6).isTrue();
        Assertions.assertThat(result7).isTrue();
        Assertions.assertThat(result8).isTrue();
    }

    @Test
    public void testGivenNoPiecesOnBoard_KingCannotMoveFurtherThanOneSpace() {
        Map<BoardPosition, Piece> board = emptyBoard;

        final BoardPosition start = new BoardPosition(4, 4);
        final BoardPosition one = new BoardPosition(5, 6);
        final BoardPosition two = new BoardPosition(2, 2);
        final BoardPosition three = new BoardPosition(1, 1);
        final BoardPosition four = new BoardPosition(1, 8);
        final BoardPosition five = new BoardPosition(5, 6);
        final BoardPosition six = new BoardPosition(3, 7);
        final BoardPosition seven = new BoardPosition(8, 4);
        final BoardPosition eight = new BoardPosition(1, 6);

        final Piece blackKing = new Piece(PieceNames.KING, PieceTeam.BLACK);

        board.put(start, blackKing);

        GameState gameState = GameStateFactory.createNewGameState(333, board, new HashMap<>(), this.playerStates);

        final boolean result1 = KingMoveValidator.validate(gameState, start, one);
        final boolean result2 = KingMoveValidator.validate(gameState, start, two);
        final boolean result3 = KingMoveValidator.validate(gameState, start, three);
        final boolean result4 = KingMoveValidator.validate(gameState, start, four);
        final boolean result5 = KingMoveValidator.validate(gameState, start, five);
        final boolean result6 = KingMoveValidator.validate(gameState, start, six);
        final boolean result7 = KingMoveValidator.validate(gameState, start, seven);
        final boolean result8 = KingMoveValidator.validate(gameState, start, eight);

        Assertions.assertThat(result1).isFalse();
        Assertions.assertThat(result2).isFalse();
        Assertions.assertThat(result3).isFalse();
        Assertions.assertThat(result4).isFalse();
        Assertions.assertThat(result5).isFalse();
        Assertions.assertThat(result6).isFalse();
        Assertions.assertThat(result7).isFalse();
        Assertions.assertThat(result8).isFalse();
    }

    @Test
    public void givenEnemyOnDesiredSpace_KingCanCapture() {
        Map<BoardPosition, Piece> board = emptyBoard;

        final BoardPosition start = new BoardPosition(2, 2);
        final BoardPosition up = new BoardPosition(2, 3);
        final BoardPosition right = new BoardPosition(3, 2);
        final BoardPosition down = new BoardPosition(2, 1);
        final BoardPosition left = new BoardPosition(1, 2);
        final BoardPosition upRight = new BoardPosition(3, 3);
        final BoardPosition downRight = new BoardPosition(3, 1);
        final BoardPosition downLeft = new BoardPosition(1, 1);
        final BoardPosition upLeft = new BoardPosition(1, 3);

        final Piece blackKing = new Piece(PieceNames.KING, PieceTeam.BLACK);
        final Piece whitePawn = new Piece(PieceNames.PAWN, PieceTeam.WHITE);

        board.put(start, blackKing);
        board.put(up, whitePawn);
        board.put(right, whitePawn);
        board.put(down, whitePawn);
        board.put(left, whitePawn);
        board.put(upRight, whitePawn);
        board.put(downRight, whitePawn);
        board.put(downLeft, whitePawn);
        board.put(upLeft, whitePawn);

        GameState gameState = GameStateFactory.createNewGameState(333, board, new HashMap<>(), this.playerStates);

        final boolean result1 = KingMoveValidator.validate(gameState, start, up);
        final boolean result2 = KingMoveValidator.validate(gameState, start, right);
        final boolean result3 = KingMoveValidator.validate(gameState, start, down);
        final boolean result4 = KingMoveValidator.validate(gameState, start, left);
        final boolean result5 = KingMoveValidator.validate(gameState, start, upRight);
        final boolean result6 = KingMoveValidator.validate(gameState, start, downRight);
        final boolean result7 = KingMoveValidator.validate(gameState, start, downLeft);
        final boolean result8 = KingMoveValidator.validate(gameState, start, upLeft);

        Assertions.assertThat(result1).isTrue();
        Assertions.assertThat(result2).isTrue();
        Assertions.assertThat(result3).isTrue();
        Assertions.assertThat(result4).isTrue();
        Assertions.assertThat(result5).isTrue();
        Assertions.assertThat(result6).isTrue();
        Assertions.assertThat(result7).isTrue();
        Assertions.assertThat(result8).isTrue();
    }

    @Test
    public void givenFriendlyOnDesiredSpace_KingCannotCapture() {
        Map<BoardPosition, Piece> board = emptyBoard;

        final BoardPosition start = new BoardPosition(2, 2);
        final BoardPosition up = new BoardPosition(2, 3);
        final BoardPosition right = new BoardPosition(3, 2);
        final BoardPosition down = new BoardPosition(2, 1);
        final BoardPosition left = new BoardPosition(1, 2);
        final BoardPosition upRight = new BoardPosition(3, 3);
        final BoardPosition downRight = new BoardPosition(3, 1);
        final BoardPosition downLeft = new BoardPosition(1, 1);
        final BoardPosition upLeft = new BoardPosition(1, 3);

        final Piece blackKing = new Piece(PieceNames.KING, PieceTeam.BLACK);
        final Piece blackPawn = new Piece(PieceNames.PAWN, PieceTeam.BLACK);

        board.put(start, blackKing);
        board.put(up, blackPawn);
        board.put(right, blackPawn);
        board.put(down, blackPawn);
        board.put(left, blackPawn);
        board.put(upRight, blackPawn);
        board.put(downRight, blackPawn);
        board.put(downLeft, blackPawn);
        board.put(upLeft, blackPawn);

        GameState gameState = GameStateFactory.createNewGameState(333, board, new HashMap<>(), this.playerStates);

        final boolean result1 = KingMoveValidator.validate(gameState, start, up);
        final boolean result2 = KingMoveValidator.validate(gameState, start, right);
        final boolean result3 = KingMoveValidator.validate(gameState, start, down);
        final boolean result4 = KingMoveValidator.validate(gameState, start, left);
        final boolean result5 = KingMoveValidator.validate(gameState, start, upRight);
        final boolean result6 = KingMoveValidator.validate(gameState, start, downRight);
        final boolean result7 = KingMoveValidator.validate(gameState, start, downLeft);
        final boolean result8 = KingMoveValidator.validate(gameState, start, upLeft);

        Assertions.assertThat(result1).isFalse();
        Assertions.assertThat(result2).isFalse();
        Assertions.assertThat(result3).isFalse();
        Assertions.assertThat(result4).isFalse();
        Assertions.assertThat(result5).isFalse();
        Assertions.assertThat(result6).isFalse();
        Assertions.assertThat(result7).isFalse();
        Assertions.assertThat(result8).isFalse();
    }

    @Test
    public void givenEnemyKingOnDesiredSpace_KingCannotCapture() {
        Map<BoardPosition, Piece> board = emptyBoard;

        final BoardPosition start = new BoardPosition(2, 2);
        final BoardPosition up = new BoardPosition(2, 3);
        final BoardPosition right = new BoardPosition(3, 2);
        final BoardPosition down = new BoardPosition(2, 1);
        final BoardPosition left = new BoardPosition(1, 2);
        final BoardPosition upRight = new BoardPosition(3, 3);
        final BoardPosition downRight = new BoardPosition(3, 1);
        final BoardPosition downLeft = new BoardPosition(1, 1);
        final BoardPosition upLeft = new BoardPosition(1, 3);

        final Piece blackKing = new Piece(PieceNames.KING, PieceTeam.BLACK);
        final Piece whiteKing = new Piece(PieceNames.KING, PieceTeam.WHITE);

        board.put(start, blackKing);
        board.put(up, whiteKing);
        board.put(right, whiteKing);
        board.put(down, whiteKing);
        board.put(left, whiteKing);
        board.put(upRight, whiteKing);
        board.put(downRight, whiteKing);
        board.put(downLeft, whiteKing);
        board.put(upLeft, whiteKing);

        GameState gameState = GameStateFactory.createNewGameState(333, board, new HashMap<>(), this.playerStates);

        final boolean result1 = KingMoveValidator.validate(gameState, start, up);
        final boolean result2 = KingMoveValidator.validate(gameState, start, right);
        final boolean result3 = KingMoveValidator.validate(gameState, start, down);
        final boolean result4 = KingMoveValidator.validate(gameState, start, left);
        final boolean result5 = KingMoveValidator.validate(gameState, start, upRight);
        final boolean result6 = KingMoveValidator.validate(gameState, start, downRight);
        final boolean result7 = KingMoveValidator.validate(gameState, start, downLeft);
        final boolean result8 = KingMoveValidator.validate(gameState, start, upLeft);

        Assertions.assertThat(result1).isFalse();
        Assertions.assertThat(result2).isFalse();
        Assertions.assertThat(result3).isFalse();
        Assertions.assertThat(result4).isFalse();
        Assertions.assertThat(result5).isFalse();
        Assertions.assertThat(result6).isFalse();
        Assertions.assertThat(result7).isFalse();
        Assertions.assertThat(result8).isFalse();
    }
}
