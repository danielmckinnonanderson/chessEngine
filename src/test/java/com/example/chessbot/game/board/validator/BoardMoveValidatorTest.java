package com.example.chessbot.game.board.validator;

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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
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
    public void testGivenPieceIsPawn_whenBoardPositionValidatorReads_shouldSendToPawn() {
        final Piece whitePawn = new Piece(PieceNames.PAWN, PieceTeam.WHITE);

        final BoardPosition currentPosition = new BoardPosition(BoardPositionX.A, BoardPositionY.ONE);
        final BoardPosition desiredPosition = new BoardPosition(BoardPositionX.A, BoardPositionY.TWO);

        Board fakeBoard = new ConcreteBoard();

        fakeBoard.getPiecesInPlay().put(currentPosition, whitePawn);

        Mockito.when(mockPawnMoveValidator.isMoveValid(any(), anyBoolean(), anyBoolean(), any(), any())).thenReturn(true);

        boolean result = boardPositionValidator.isPositionValid(whitePawn, true, false, currentPosition, desiredPosition);

        verify(mockPawnMoveValidator, Mockito.times(1)).isMoveValid(any(), anyBoolean(), anyBoolean(), any(), any());
    }
}
