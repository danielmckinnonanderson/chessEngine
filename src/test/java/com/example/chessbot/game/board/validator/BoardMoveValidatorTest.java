package com.example.chessbot.game.board.validator;

import com.example.chessbot.model.board.Board;
import com.example.chessbot.model.board.ConcreteBoard;
import com.example.chessbot.model.board.exceptions.IllegalTeamException;
import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.piece.PieceNames;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.verify;

public class BoardMoveValidatorTest {

    private PawnMoveValidator mockPawnMoveValidator;
    private BoardMoveValidator boardPositionValidator;

    @BeforeEach
    public void setup_mockPawnMoveValidator() {
        this.mockPawnMoveValidator = Mockito.mock(PawnMoveValidator.class);
        this.boardPositionValidator = new BoardMoveValidator(mockPawnMoveValidator);
    }

    @Test
    public void testGivenPieceIsPawn_whenBoardPositionValidatorReads_shouldSendToPawn() throws IllegalTeamException {
        final Piece whitePawn = new Piece(PieceNames.PAWN, 0);

        final BoardPosition currentPosition = new BoardPosition(0, 1);
        final BoardPosition desiredPosition = new BoardPosition(0, 2);

        Board fakeBoard = new ConcreteBoard();

        fakeBoard.getPiecesInPlay().put(currentPosition, whitePawn);

        Mockito.when(mockPawnMoveValidator.isMoveValid(anyInt(), anyBoolean(), anyBoolean(), any(), any())).thenReturn(true);

        boolean result = boardPositionValidator.isPositionValid(whitePawn, true, false, currentPosition, desiredPosition);

        verify(mockPawnMoveValidator, Mockito.times(1)).isMoveValid(anyInt(), anyBoolean(), anyBoolean(), any(), any());
    }
}
