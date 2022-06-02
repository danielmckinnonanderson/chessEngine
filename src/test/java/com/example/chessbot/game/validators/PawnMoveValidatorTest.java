package com.example.chessbot.game.validators;

import com.example.chessbot.game.state.GameState;
import com.example.chessbot.game.state.GameStateFactory;
import com.example.chessbot.game.state.player.PlayerState;
import com.example.chessbot.game.state.player.PlayerStateFactory;
import com.example.chessbot.game.validators.movement.PawnMoveValidator;
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

public class PawnMoveValidatorTest {
    private final PawnMoveValidator pawnMoveValidator = new PawnMoveValidator();

    private Map<BoardPosition, Piece> emptyBoard;
    private Pair<PlayerState, PlayerState> playerStates;

    @BeforeEach
    public void setupBoard() {
        this.playerStates = new Pair<>(PlayerStateFactory.createInitialPlayerState(PieceTeam.WHITE), PlayerStateFactory.createInitialPlayerState(PieceTeam.BLACK));
        this.emptyBoard = BoardFactory.createEmptyBoard();
    }

    @Test
    public void testGivenUntouchedAndNoEnemies_whenPawnMovesBackward_thenMoveIsInvalid() {
        Map<BoardPosition, Piece> board = emptyBoard;

        final Piece whitePawn = new Piece(PieceNames.PAWN, PieceTeam.WHITE);

        final BoardPosition start = new BoardPosition(3, 6);
        final BoardPosition backwards1 = new BoardPosition(3, 5);

        board.put(start, whitePawn);

        GameState gameState = GameStateFactory.createNewGameState(42, board, new HashMap<>(), playerStates);

        final boolean result = pawnMoveValidator.validate(gameState, start, backwards1);

        Assertions.assertThat(result).isFalse();

        Map<BoardPosition, Piece> board2 = emptyBoard;

        final Piece blackPawn = new Piece(PieceNames.PAWN, PieceTeam.BLACK);

        final BoardPosition backwards2 = new BoardPosition(3, 7);

        board2.put(start, blackPawn);

        GameState gameState2 = GameStateFactory.createNewGameState(42, board, new HashMap<>(), playerStates);

        final boolean result2 = pawnMoveValidator.validate(gameState2, start, backwards2);

        Assertions.assertThat(result2).isFalse();
    }

    @Test
    public void testGivenUntouchedAndNoEnemies_whenPawnMovesInvalidSpace_isInvalid() {
        Map<BoardPosition, Piece> board1 = emptyBoard;

        final Piece blackPawn = new Piece(PieceNames.PAWN, PieceTeam.BLACK, true);

        final BoardPosition start1 = new BoardPosition(4, 2);
        final BoardPosition invalidb1 = new BoardPosition(1, 5);
        final BoardPosition invalidb2 = new BoardPosition(3,1);
        final BoardPosition invalidb3 = new BoardPosition(4, 4);
        final BoardPosition invalidb4 = new BoardPosition(8, 4);

        board1.put(start1, blackPawn);

        GameState gameState1 = GameStateFactory.createNewGameState(7_777_777, board1, new HashMap<>(), playerStates);

        final boolean resultb1 = pawnMoveValidator.validate(gameState1, start1, invalidb1);
        final boolean resultb2 = pawnMoveValidator.validate(gameState1, start1, invalidb2);
        final boolean resultb3 = pawnMoveValidator.validate(gameState1, start1, invalidb3);
        final boolean resultb4 = pawnMoveValidator.validate(gameState1, start1, invalidb4);

        Assertions.assertThat(resultb1).isFalse();
        Assertions.assertThat(resultb2).isFalse();
        Assertions.assertThat(resultb3).isFalse();
        Assertions.assertThat(resultb4).isFalse();

        Map<BoardPosition, Piece> board2 = emptyBoard;

        final Piece whitePawn = new Piece(PieceNames.PAWN, PieceTeam.WHITE, true);

        final BoardPosition start2 = new BoardPosition(3, 6);
        final BoardPosition invalidw1 = new BoardPosition(3, 8);
        final BoardPosition invalidw2 = new BoardPosition(4, 6);
        final BoardPosition invalidw3 = new BoardPosition(3, 5);
        final BoardPosition invalidw4 = new BoardPosition(1, 8);

        board1.put(start2, whitePawn);

        GameState gameState2 = GameStateFactory.createNewGameState(12, board2, new HashMap<>(), playerStates);

        final boolean resultw1 = pawnMoveValidator.validate(gameState2, start2, invalidw1);
        final boolean resultw2 = pawnMoveValidator.validate(gameState2, start2, invalidw2);
        final boolean resultw3 = pawnMoveValidator.validate(gameState2, start2, invalidw3);
        final boolean resultw4 = pawnMoveValidator.validate(gameState2, start2, invalidw4);

        Assertions.assertThat(resultw1).isFalse();
        Assertions.assertThat(resultw2).isFalse();
        Assertions.assertThat(resultw3).isFalse();
        Assertions.assertThat(resultw4).isFalse();
    }

    @Test
    public void testGivenUntouchedAndNoEnemies_thenWhitePawnMoves1Space() {
        Map<BoardPosition, Piece> board1 = emptyBoard;

        final Piece blackPawn = new Piece(PieceNames.PAWN, PieceTeam.BLACK, false);

        final BoardPosition start1 = new BoardPosition(4, 5);
        final BoardPosition invalid1 = new BoardPosition(4, 4);

        board1.put(start1, blackPawn);

        GameState gameState1 = GameStateFactory.createNewGameState(720, board1, new HashMap<>(), playerStates);

        final boolean result1 = pawnMoveValidator.validate(gameState1, start1, invalid1);

        Assertions.assertThat(result1).isTrue();

        Map<BoardPosition, Piece> board2 = emptyBoard;

        final Piece whitePawn = new Piece(PieceNames.PAWN, PieceTeam.WHITE, false);

        final BoardPosition start2 = new BoardPosition(3, 6);
        final BoardPosition invalid2 = new BoardPosition(3, 7);

        board1.put(start2, whitePawn);

        GameState gameState2 = GameStateFactory.createNewGameState(1080, board2, new HashMap<>(), playerStates);

        final boolean result2 = pawnMoveValidator.validate(gameState2, start2, invalid2);

        Assertions.assertThat(result2).isTrue();
    }

    @Test
    public void testUntouchedNoEnemies_thenWhitePawnMoves2Space_isValid() {
        Map<BoardPosition, Piece> board1 = emptyBoard;

        final Piece blackPawn = new Piece(PieceNames.PAWN, PieceTeam.BLACK);

        final BoardPosition start1 = new BoardPosition(4, 5);
        final BoardPosition invalid1 = new BoardPosition(4, 3);

        board1.put(start1, blackPawn);

        GameState gameState1 = GameStateFactory.createNewGameState(720, board1, new HashMap<>(), playerStates);

        final boolean result1 = pawnMoveValidator.validate(gameState1, start1, invalid1);

        Assertions.assertThat(result1).isTrue();

        Map<BoardPosition, Piece> board2 = emptyBoard;

        final Piece whitePawn = new Piece(PieceNames.PAWN, PieceTeam.WHITE, false);

        final BoardPosition start2 = new BoardPosition(3, 6);
        final BoardPosition invalid2 = new BoardPosition(3, 8);

        board1.put(start2, whitePawn);

        GameState gameState2 = GameStateFactory.createNewGameState(1080, board2, new HashMap<>(), playerStates);

        final boolean result2 = pawnMoveValidator.validate(gameState2, start2, invalid2);

        Assertions.assertThat(result2).isTrue();
    }

    @Test
    public void givenUntouchedAndEnemy_WhenEnemyInPath_PawnCannotAdvancePastIt() {
        Map<BoardPosition, Piece> board = emptyBoard;

        final Piece blackPawn = new Piece(PieceNames.PAWN, PieceTeam.BLACK);
        final Piece whitePawn = new Piece(PieceNames.PAWN, PieceTeam.BLACK);

        final BoardPosition start = new BoardPosition(7, 4);
        final BoardPosition inTheWay = new BoardPosition(7, 5);
        final BoardPosition desired = new BoardPosition(7, 6);

        board.put(start, whitePawn);
        board.put(inTheWay, blackPawn);

        GameState gameState = GameStateFactory.createNewGameState(-99_999_999, board, new HashMap<>(), playerStates);

        final boolean result = pawnMoveValidator.validate(gameState, start, desired);

        Assertions.assertThat(result).isFalse();
    }

    @Test
    public void givenTouchedAndEnemy_WhenPawnAttacksFromInvalidPosition_isNotValid() {
        Map<BoardPosition, Piece> board1 = emptyBoard;

        final Piece blackPawn = new Piece(PieceNames.PAWN, PieceTeam.BLACK, true);
        final Piece whitePawn = new Piece(PieceNames.PAWN, PieceTeam.WHITE, true);

        final BoardPosition start1 = new BoardPosition(4, 5);
        final BoardPosition invalid1 = new BoardPosition(4, 4);
        final BoardPosition invalid2 = new BoardPosition(3, 5);
        final BoardPosition invalid3 = new BoardPosition(5, 5);
        final BoardPosition invalid4 = new BoardPosition(4, 6);
        final BoardPosition invalid5 = new BoardPosition(5, 6);
        final BoardPosition invalid6 = new BoardPosition(3, 6);

        board1.put(start1, blackPawn);
        board1.put(invalid1, whitePawn);

        GameState gameState1 = GameStateFactory.createNewGameState(720, board1, new HashMap<>(), playerStates);

        final boolean result1 = pawnMoveValidator.validate(gameState1, start1, invalid1);
        final boolean result2 = pawnMoveValidator.validate(gameState1, start1, invalid2);
        final boolean result3 = pawnMoveValidator.validate(gameState1, start1, invalid3);
        final boolean result4 = pawnMoveValidator.validate(gameState1, start1, invalid4);
        final boolean result5 = pawnMoveValidator.validate(gameState1, start1, invalid5);
        final boolean result6 = pawnMoveValidator.validate(gameState1, start1, invalid6);

        Assertions.assertThat(result1).isFalse();
        Assertions.assertThat(result2).isFalse();
        Assertions.assertThat(result3).isFalse();
        Assertions.assertThat(result4).isFalse();
        Assertions.assertThat(result5).isFalse();
        Assertions.assertThat(result6).isFalse();
    }

    @Test
    public void givenTouchedAndEnemy_WhenPawnAttacksFromValidPosition_isValid() {
        Map<BoardPosition, Piece> board1 = emptyBoard;

        final Piece blackPawn = new Piece(PieceNames.PAWN, PieceTeam.BLACK, true);
        final Piece whitePawn = new Piece(PieceNames.PAWN, PieceTeam.WHITE, true);

        final BoardPosition start1 = new BoardPosition(4, 5);
        final BoardPosition invalid1 = new BoardPosition(4, 4);
        final BoardPosition invalid2 = new BoardPosition(3, 5);
        final BoardPosition invalid3 = new BoardPosition(5, 5);
        final BoardPosition invalid4 = new BoardPosition(4, 6);
        final BoardPosition invalid5 = new BoardPosition(5, 6);
        final BoardPosition invalid6 = new BoardPosition(3, 6);

        board1.put(start1, blackPawn);
        board1.put(invalid1, whitePawn);


        GameState gameState1 = GameStateFactory.createNewGameState(720, board1, new HashMap<>(), playerStates);

        final boolean result1 = pawnMoveValidator.validate(gameState1, start1, invalid1);
        final boolean result2 = pawnMoveValidator.validate(gameState1, start1, invalid2);
        final boolean result3 = pawnMoveValidator.validate(gameState1, start1, invalid3);
        final boolean result4 = pawnMoveValidator.validate(gameState1, start1, invalid4);
        final boolean result5 = pawnMoveValidator.validate(gameState1, start1, invalid5);
        final boolean result6 = pawnMoveValidator.validate(gameState1, start1, invalid6);

        Assertions.assertThat(result1).isFalse();
        Assertions.assertThat(result2).isFalse();
        Assertions.assertThat(result3).isFalse();
        Assertions.assertThat(result4).isFalse();
        Assertions.assertThat(result5).isFalse();
        Assertions.assertThat(result6).isFalse();
    }

    @Test
    public void givenPreviousTurnOpponentMovedTwoSpaces_ThenCanCaptureViaEnPassant() {
        Map<BoardPosition, Piece> current1 = emptyBoard;
        final int currentTurn = 56;
        final Integer turnToGrab = currentTurn - 1;

        final Piece blackPawn = new Piece(PieceNames.PAWN, PieceTeam.BLACK, true);
        final Piece whitePawn = new Piece(PieceNames.PAWN, PieceTeam.WHITE, true);

        // turn one
        final BoardPosition w1 = new BoardPosition(1, 1);
        final BoardPosition b1 = new BoardPosition(2, 3);

        // turn two black advances two spaces
        final BoardPosition w2 = new BoardPosition(1, 1);
        final BoardPosition b2 = new BoardPosition(2, 1);

        // white wants to capture en passant
        final BoardPosition w3 = new BoardPosition(2, 2);

        current1.put(b2, blackPawn);
        current1.put(w2, whitePawn);

        // set up board for previous turn
        Map<BoardPosition, Piece> prev1 = emptyBoard;
        prev1.put(b1, blackPawn);
        prev1.put(w1, whitePawn);

        GameState gameState1 = GameStateFactory.createNewGameState(currentTurn, current1, Map.of(turnToGrab, prev1), playerStates);

        final boolean result1 = pawnMoveValidator.validate(gameState1, w2, w3);

        Assertions.assertThat(result1).isTrue();

        // black
        Map<BoardPosition, Piece> current2 = emptyBoard;

        // turn one
        final BoardPosition ww1 = new BoardPosition(2, 1);
        final BoardPosition bb1 = new BoardPosition(1, 3);

        // turn two white advances two spaces
        final BoardPosition ww2 = new BoardPosition(2, 3);
        final BoardPosition bb2 = new BoardPosition(1, 3);

        // white wants to capture en passant
        final BoardPosition bb3 = new BoardPosition(2, 2);

        current2.put(bb2, blackPawn);
        current2.put(ww2, whitePawn);

        // set up board for previous turn
        Map<BoardPosition, Piece> prev2 = emptyBoard;
        prev2.put(bb1, blackPawn);
        prev2.put(ww1, whitePawn);

        GameState gameState2 = GameStateFactory.createNewGameState(currentTurn, current2, Map.of(turnToGrab, prev2), playerStates);

        final boolean result2 = pawnMoveValidator.validate(gameState2, bb2, bb3);

        Assertions.assertThat(result2).isTrue();
    }
}
