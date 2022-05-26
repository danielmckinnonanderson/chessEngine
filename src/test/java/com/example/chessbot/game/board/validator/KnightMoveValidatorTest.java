package com.example.chessbot.game.board.validator;

import com.example.chessbot.game.state.GameState;
import com.example.chessbot.game.state.GameStateFactory;
import com.example.chessbot.game.state.player.PlayerState;
import com.example.chessbot.game.state.player.PlayerStateFactory;
import com.example.chessbot.model.board.BoardFactory;
import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.board.position.Pair;
import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.piece.PieceNames;
import com.example.chessbot.model.piece.PieceTeam;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class KnightMoveValidatorTest {
    private Pair<PlayerState, PlayerState> playerStates;
    private Map<BoardPosition, Piece> emptyBoard;
    private final MoveValidator knightMoveValidator = new KnightMoveValidator();

    @BeforeEach
    public void setup() {
        this.playerStates = new Pair<>(PlayerStateFactory.createInitialPlayerState(PieceTeam.WHITE), PlayerStateFactory.createInitialPlayerState(PieceTeam.BLACK));
        this.emptyBoard = BoardFactory.createEmptyBoard();
    }

    @Test
    public void testGivenNoPiecesOnBoard_KnightCanMoveToValidPositions() {
        Map<BoardPosition, Piece> board = emptyBoard;
        final Piece whiteKnight = new Piece(PieceNames.KNIGHT, PieceTeam.WHITE);
        final BoardPosition startingWhtPosition = new BoardPosition(4, 4);

        final BoardPosition desiredWhtPosition1 = new BoardPosition(6, 5);
        final BoardPosition desiredWhtPosition2 = new BoardPosition(5, 6);
        final BoardPosition desiredWhtPosition3 = new BoardPosition(6, 3);
        final BoardPosition desiredWhtPosition4 = new BoardPosition(3, 6);
        final BoardPosition desiredWhtPosition5 = new BoardPosition(3, 2);
        final BoardPosition desiredWhtPosition6 = new BoardPosition(2, 3);
        final BoardPosition desiredWhtPosition7 = new BoardPosition(2, 5);
        final BoardPosition desiredWhtPosition8 = new BoardPosition(5, 2);

        board.put(startingWhtPosition, whiteKnight);
        final GameState gameState = GameStateFactory.createNewGameState(99_999_999, board, List.of(), playerStates);

        final boolean result1 = knightMoveValidator.validate(gameState, startingWhtPosition, desiredWhtPosition1);
        final boolean result2 = knightMoveValidator.validate(gameState, startingWhtPosition, desiredWhtPosition2);
        final boolean result3 = knightMoveValidator.validate(gameState, startingWhtPosition, desiredWhtPosition3);
        final boolean result4 = knightMoveValidator.validate(gameState, startingWhtPosition, desiredWhtPosition4);
        final boolean result5 = knightMoveValidator.validate(gameState, startingWhtPosition, desiredWhtPosition5);
        final boolean result6 = knightMoveValidator.validate(gameState, startingWhtPosition, desiredWhtPosition6);
        final boolean result7 = knightMoveValidator.validate(gameState, startingWhtPosition, desiredWhtPosition7);
        final boolean result8 = knightMoveValidator.validate(gameState, startingWhtPosition, desiredWhtPosition8);

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
    public void testGivenPiecesInInitialPositions_KnightCanMoveOverPieces() {
        Map<BoardPosition, Piece> board = BoardFactory.createInitialBoard();
        final BoardPosition blackKnightStartingPosition = new BoardPosition(7, 8);
        final Piece blackKnight = new Piece(PieceNames.KNIGHT, PieceTeam.BLACK);

        final BoardPosition desiredBlkPosition1 = new BoardPosition(6, 6);
        final BoardPosition desiredBlkPosition2 = new BoardPosition(8, 6);
        final BoardPosition desiredBlkPosition3 = new BoardPosition(5, 7);

        Assertions.assertThat(board.get(blackKnightStartingPosition)).isEqualTo(blackKnight);

        final GameState gameState = GameStateFactory.createNewGameState(1337, board, List.of(), playerStates);

        final boolean result1 = knightMoveValidator.validate(gameState, blackKnightStartingPosition, desiredBlkPosition1);
        final boolean result2 = knightMoveValidator.validate(gameState, blackKnightStartingPosition, desiredBlkPosition2);
        final boolean result3 = knightMoveValidator.validate(gameState, blackKnightStartingPosition, desiredBlkPosition3);

        Assertions.assertThat(result1).isTrue();
        Assertions.assertThat(result2).isTrue();
        Assertions.assertThat(result3).isFalse();
    }

    @Test
    public void testGivenOpponentInDesiredSpace_KnightCanCapture() {
        Map<BoardPosition, Piece> board = BoardFactory.createEmptyBoard();
        final BoardPosition whiteKnightStartingPosition = new BoardPosition(3,3);
        final Piece whiteKnight = new Piece(PieceNames.KNIGHT, PieceTeam.WHITE);

        final BoardPosition desiredWhtPosition1 = new BoardPosition(5, 4);
        final BoardPosition desiredWhtPosition2 = new BoardPosition(5, 2);

        final Piece blackPawn = new Piece(PieceNames.PAWN, PieceTeam.BLACK);
        final Piece blackQueen = new Piece(PieceNames.QUEEN, PieceTeam.BLACK);

        board.put(whiteKnightStartingPosition, whiteKnight);
        board.put(desiredWhtPosition1, blackPawn);
        board.put(desiredWhtPosition2, blackQueen);

        final GameState gameState = GameStateFactory.createNewGameState(69_420, board, List.of(), playerStates);

        final boolean result1 = knightMoveValidator.validate(gameState, whiteKnightStartingPosition, desiredWhtPosition1);
        final boolean result2 = knightMoveValidator.validate(gameState, whiteKnightStartingPosition, desiredWhtPosition2);

        Assertions.assertThat(result1).isTrue();
        Assertions.assertThat(result2).isTrue();
    }

    @Test
    public void testGivenOpposingKingInDesiredSpace_KnightCannotCapture() {
        Map<BoardPosition, Piece> board = BoardFactory.createEmptyBoard();
        final BoardPosition blackKnightStartingPosition = new BoardPosition(3,3);
        final Piece blackKnight = new Piece(PieceNames.KNIGHT, PieceTeam.BLACK);

        final BoardPosition desiredBlkPosition1 = new BoardPosition(5, 4);

        final Piece whiteKing = new Piece(PieceNames.KING, PieceTeam.WHITE);

        board.put(blackKnightStartingPosition, blackKnight);
        board.put(desiredBlkPosition1, whiteKing);

        final GameState gameState = GameStateFactory.createNewGameState(654_321, board, List.of(), playerStates);

        final boolean result1 = knightMoveValidator.validate(gameState, blackKnightStartingPosition, desiredBlkPosition1);

        Assertions.assertThat(result1).isFalse();
    }
}
