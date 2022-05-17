package com.example.chessbot.game.board.validator;

import com.example.chessbot.game.state.ConcreteGameState;
import com.example.chessbot.game.state.GameState;
import com.example.chessbot.model.board.Board;
import com.example.chessbot.model.board.ConcreteBoard;
import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.board.position.BoardPositionX;
import com.example.chessbot.model.board.position.BoardPositionY;
import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.piece.PieceNames;
import com.example.chessbot.model.piece.PieceTeam;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

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
        Board board = new ConcreteBoard().initializeEmptyBoard();

        final Piece whitePawn = new Piece(PieceNames.PAWN, PieceTeam.WHITE);

        final BoardPosition currentPosition = new BoardPosition(BoardPositionX.A, BoardPositionY.ONE);
        final BoardPosition desiredPosition = new BoardPosition(BoardPositionX.A, BoardPositionY.TWO);

        board.getPiecesInPlay().put(currentPosition, whitePawn);
        GameState gameState = new ConcreteGameState(board, -2103);

        Mockito.when(mockPawnMoveValidator.validate(any(),any(), any())).thenReturn(true);

        boolean result = boardPositionValidator.validate(gameState, currentPosition, desiredPosition);

        verify(mockPawnMoveValidator, Mockito.times(1)).validate(any(), any(), any());
    }
}
