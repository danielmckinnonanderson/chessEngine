package com.example.chessbot.game.board.validator;

import com.example.chessbot.game.state.GameState;
import com.example.chessbot.game.state.GameStateFactory;
import com.example.chessbot.game.state.player.PlayerState;
import com.example.chessbot.game.state.player.PlayerStateFactory;
import com.example.chessbot.game.validation.movement.*;
import com.example.chessbot.game.validators.movement.*;
import com.example.chessbot.model.board.BoardFactory;
import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.Pair;
import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.piece.PieceNames;
import com.example.chessbot.model.piece.PieceTeam;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

public class BoardMoveValidatorTest {

    private Pair<PlayerState, PlayerState> playerStates;
    private MoveValidator mockPawnMoveValidator;
    private MoveValidator mockRookMoveValidator;
    private MoveValidator mockKnightMoveValidator;
    private MoveValidator mockBishopMoveValidator;
    private MoveValidator mockQueenMoveValidator;
    private MoveValidator mockKingMoveValidator;
    private BoardMoveValidator boardPositionValidator;

    @BeforeEach
    public void setup_mockMoveValidators() {
        this.mockPawnMoveValidator = Mockito.mock(PawnMoveValidator.class);
        this.mockRookMoveValidator = Mockito.mock(RookMoveValidator.class);
        this.mockKnightMoveValidator = Mockito.mock(KnightMoveValidator.class);
        this.mockBishopMoveValidator = Mockito.mock(BishopMoveValidator.class);
        this.mockQueenMoveValidator = Mockito.mock(QueenMoveValidator.class);
        this.mockKingMoveValidator = Mockito.mock(KingMoveValidator.class);
        this.boardPositionValidator = new BoardMoveValidator(
                mockPawnMoveValidator,
                mockRookMoveValidator,
                mockKnightMoveValidator,
                mockBishopMoveValidator,
                mockQueenMoveValidator,
                mockKingMoveValidator);
    }

    @BeforeEach
    public void setup_playerStates() {
        this.playerStates = new Pair<>(PlayerStateFactory.createInitialPlayerState(PieceTeam.WHITE), PlayerStateFactory.createInitialPlayerState(PieceTeam.BLACK));
    }

    @Test
    public void testGivenPieceIsPawn_whenBoardPositionValidatorReads_shouldSendToPawn() {
        Map<BoardPosition, Piece> board = BoardFactory.createInitialBoard();

        final Piece whitePawn = new Piece(PieceNames.PAWN, PieceTeam.WHITE);

        final BoardPosition currentPosition = new BoardPosition(1, 1);
        final BoardPosition desiredPosition = new BoardPosition(1, 2);

        board.put(currentPosition, whitePawn);

        GameState gameState = GameStateFactory.createNewGameState(1, board, new HashMap<>(), this.playerStates);

        Mockito.when(mockPawnMoveValidator.validate(any(), any(), any())).thenReturn(true);

        boardPositionValidator.validate(gameState, currentPosition, desiredPosition);

        verify(mockPawnMoveValidator, Mockito.times(1)).validate(any(), any(), any());
    }

    @Test
    public void testGivenPieceIsRook_whenBoardPositionValidatorReads_shouldSendToRook() {
        Map<BoardPosition, Piece> board = BoardFactory.createInitialBoard();

        final Piece whiteRook = new Piece(PieceNames.ROOK, PieceTeam.WHITE);

        final BoardPosition currentPosition = new BoardPosition(1, 1);
        final BoardPosition desiredPosition = new BoardPosition(1, 2);

        board.put(currentPosition, whiteRook);

        GameState gameState = GameStateFactory.createNewGameState(1, board, new HashMap<>(), this.playerStates);

        Mockito.when(mockRookMoveValidator.validate(any(), any(), any())).thenReturn(true);

        boardPositionValidator.validate(gameState, currentPosition, desiredPosition);

        verify(mockRookMoveValidator, Mockito.times(1)).validate(any(), any(), any());
    }

    @Test
    public void testGivenPieceIsKnight_whenBoardPositionValidatorReads_shouldSendToKnight() {
        Map<BoardPosition, Piece> board = BoardFactory.createInitialBoard();

        final Piece whiteRook = new Piece(PieceNames.KNIGHT, PieceTeam.WHITE);

        final BoardPosition currentPosition = new BoardPosition(1, 1);
        final BoardPosition desiredPosition = new BoardPosition(1, 2);

        board.put(currentPosition, whiteRook);

        GameState gameState = GameStateFactory.createNewGameState(1, board, new HashMap<>(), this.playerStates);

        Mockito.when(mockKnightMoveValidator.validate(any(), any(), any())).thenReturn(true);

        boardPositionValidator.validate(gameState, currentPosition, desiredPosition);

        verify(mockKnightMoveValidator, Mockito.times(1)).validate(any(), any(), any());
    }

    @Test
    public void testGivenPieceIsBishop_whenBoardPositionValidatorReads_shouldSendToBishop() {
        Map<BoardPosition, Piece> board = BoardFactory.createInitialBoard();

        final Piece whiteBishop = new Piece(PieceNames.BISHOP, PieceTeam.WHITE);

        final BoardPosition currentPosition = new BoardPosition(1, 1);
        final BoardPosition desiredPosition = new BoardPosition(1, 2);

        board.put(currentPosition, whiteBishop);

        GameState gameState = GameStateFactory.createNewGameState(1, board, new HashMap<>(), this.playerStates);

        Mockito.when(mockBishopMoveValidator.validate(any(), any(), any())).thenReturn(true);

        boardPositionValidator.validate(gameState, currentPosition, desiredPosition);

        verify(mockBishopMoveValidator, Mockito.times(1)).validate(any(), any(), any());
    }

    @Test
    public void testGivenPieceIsQueen_whenBoardPositionValidatorReads_shouldSendToQueen() {
        Map<BoardPosition, Piece> board = BoardFactory.createInitialBoard();

        final Piece whiteQueen = new Piece(PieceNames.QUEEN, PieceTeam.WHITE);

        final BoardPosition currentPosition = new BoardPosition(1, 1);
        final BoardPosition desiredPosition = new BoardPosition(1, 2);

        board.put(currentPosition, whiteQueen);

        GameState gameState = GameStateFactory.createNewGameState(1, board, new HashMap<>(), this.playerStates);

        Mockito.when(mockQueenMoveValidator.validate(any(), any(), any())).thenReturn(true);

        boardPositionValidator.validate(gameState, currentPosition, desiredPosition);

        verify(mockQueenMoveValidator, Mockito.times(1)).validate(any(), any(), any());
    }

    @Test
    public void testGivenPieceIsKing_whenBoardPositionValidatorReads_shouldSendToKing() {
        Map<BoardPosition, Piece> board = BoardFactory.createInitialBoard();

        final Piece whiteKing = new Piece(PieceNames.KING, PieceTeam.WHITE);

        final BoardPosition currentPosition = new BoardPosition(1, 1);
        final BoardPosition desiredPosition = new BoardPosition(1, 2);

        board.put(currentPosition, whiteKing);

        GameState gameState = GameStateFactory.createNewGameState(1, board, new HashMap<>(), this.playerStates);

        Mockito.when(mockKingMoveValidator.validate(any(), any(), any())).thenReturn(true);

        boardPositionValidator.validate(gameState, currentPosition, desiredPosition);

        verify(mockKingMoveValidator, Mockito.times(1)).validate(any(), any(), any());
    }
}
