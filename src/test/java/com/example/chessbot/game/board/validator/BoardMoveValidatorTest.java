package com.example.chessbot.game.board.validator;

import com.example.chessbot.game.state.ConcreteGameState;
import com.example.chessbot.game.state.GameState;
import com.example.chessbot.model.board.BoardFactory;
import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.piece.PieceNames;
import com.example.chessbot.model.piece.PieceTeam;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import java.util.Map;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;

public class BoardMoveValidatorTest {

    private PawnMoveValidator mockPawnMoveValidator;
    private RookMoveValidator mockRookMoveValidator;
    private BoardMoveValidator boardPositionValidator;

    @BeforeEach
    public void setup_mockPawnMoveValidator() {
        this.mockPawnMoveValidator = Mockito.mock(PawnMoveValidator.class);
        this.boardPositionValidator = new BoardMoveValidator(mockPawnMoveValidator, mockRookMoveValidator);
    }

    @Test
    public void testGivenPieceIsPawn_whenBoardPositionValidatorReads_shouldSendToPawn() {
        Map<BoardPosition, Piece> board = BoardFactory.createInitialBoard();

        final Piece whitePawn = new Piece(PieceNames.PAWN, PieceTeam.WHITE);

        final BoardPosition currentPosition = new BoardPosition(1, 1);
        final BoardPosition desiredPosition = new BoardPosition(1, 2);

        board.put(currentPosition, whitePawn);
        GameState gameState = new ConcreteGameState(board, -2103);

        Mockito.when(mockPawnMoveValidator.validate(any(),any(), any())).thenReturn(true);

        boolean result = boardPositionValidator.validate(gameState, currentPosition, desiredPosition);

        verify(mockPawnMoveValidator, Mockito.times(1)).validate(any(), any(), any());
    }
}
