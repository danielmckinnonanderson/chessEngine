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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

public class BoardMoveValidatorTest {

    private Pair<PlayerState, PlayerState> playerStates;
    private MoveValidator mockPawnMoveValidator;
    private MoveValidator mockRookMoveValidator;
    private BoardMoveValidator boardPositionValidator;

    @BeforeEach
    public void setup_mockMoveValidators() {
        this.mockPawnMoveValidator = Mockito.mock(PawnMoveValidator.class);
        this.mockRookMoveValidator = Mockito.mock(RookMoveValidator.class);
        this.boardPositionValidator = new BoardMoveValidator(mockPawnMoveValidator, mockRookMoveValidator);
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

        GameState gameState = GameStateFactory.createNewGameState(1, board, List.of(), this.playerStates);

        Mockito.when(mockPawnMoveValidator.validate(any(), any(), any())).thenReturn(true);

        boolean result = boardPositionValidator.validate(gameState, currentPosition, desiredPosition);

        verify(mockPawnMoveValidator, Mockito.times(1)).validate(any(), any(), any());
    }

    @Test
    public void testGivenPieceIsRook_whenBoardPositionValidatorReads_shouldSendToRook() {
        Map<BoardPosition, Piece> board = BoardFactory.createInitialBoard();

        final Piece whiteRook = new Piece(PieceNames.ROOK, PieceTeam.WHITE);

        final BoardPosition currentPosition = new BoardPosition(1, 1);
        final BoardPosition desiredPosition = new BoardPosition(1, 2);

        board.put(currentPosition, whiteRook);

        GameState gameState = GameStateFactory.createNewGameState(1, board, List.of(), this.playerStates);

        Mockito.when(mockRookMoveValidator.validate(any(), any(), any())).thenReturn(true);

        boolean result = boardPositionValidator.validate(gameState, currentPosition, desiredPosition);

        verify(mockRookMoveValidator, Mockito.times(1)).validate(any(), any(), any());
    }
}
