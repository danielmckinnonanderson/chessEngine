package com.example.chessbot.game.board.validator;

import com.example.chessbot.model.board.Board;
import com.example.chessbot.model.board.ConcreteBoard;
import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.piece.PieceNames;
import com.example.chessbot.model.piece.PieceTeam;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PawnMoveValidatorTest {
    private final PawnMoveValidator pawnMoveValidator = new PawnMoveValidator();

    @Test
    public void noFirstTurnNoEnemy_whenWhitePawnMovesBackward_isInvalid() {
        final Piece whitePawn = new Piece(PieceNames.PAWN, PieceTeam.WHITE);

        final BoardPosition currentPosition = new BoardPosition(3, 6);
        final BoardPosition desiredPosition = new BoardPosition(3, 5);

        Board fakeBoard = new ConcreteBoard();

        fakeBoard.getPiecesInPlay().put(currentPosition, whitePawn);

        Assertions.assertThat(fakeBoard.getPiecesInPlay().get(currentPosition)).isEqualTo(whitePawn);

        Assertions.assertThat(
                pawnMoveValidator.isMoveValid(
                        whitePawn.getPieceTeam(),
                        false,
                        false,
                        currentPosition,
                        desiredPosition
                )).isFalse();
    }

    @Test
    public void noFirstTurnNoEnemy_whenWhitePawnMovesInvalidSpace_isInvalid() {
        final Piece whitePawn = new Piece(PieceNames.PAWN, PieceTeam.WHITE);

        final BoardPosition currentPosition = new BoardPosition(1, 1);
        final BoardPosition desiredPosition = new BoardPosition(6, 2);

        Board fakeBoard = new ConcreteBoard();

        fakeBoard.getPiecesInPlay().put(currentPosition, whitePawn);

        Assertions.assertThat(fakeBoard.getPiecesInPlay().get(currentPosition)).isEqualTo(whitePawn);

        Assertions.assertThat(
                pawnMoveValidator.isMoveValid(
                        whitePawn.getPieceTeam(),
                        false,
                        false,
                        currentPosition,
                        desiredPosition
                )).isFalse();
    }

    @Test
    public void givenFirstTurnNoEnemy_thenWhitePawnMoves1Space() {
        final Piece whitePawn = new Piece(PieceNames.PAWN, PieceTeam.WHITE);

        final BoardPosition currentPosition = new BoardPosition(1, 2);
        final BoardPosition desiredPosition = new BoardPosition(1, 3);

        Board fakeBoard = new ConcreteBoard();

        fakeBoard.getPiecesInPlay().put(currentPosition, whitePawn);

        Assertions.assertThat(fakeBoard.getPiecesInPlay().get(currentPosition)).isEqualTo(whitePawn);

        Assertions.assertThat(
                pawnMoveValidator.isMoveValid(
                        whitePawn.getPieceTeam(),
                        false,
                        false,
                        currentPosition,
                        desiredPosition
                )).isTrue();
    }

    @Test
    public void givenFirstTurnNoEnemy_thenWhitePawnMoves2Space_isValid() {
        final Piece whitePawn = new Piece(PieceNames.PAWN, PieceTeam.WHITE);

        final BoardPosition currentPosition = new BoardPosition(1, 1);
        final BoardPosition desiredPosition = new BoardPosition(1, 3);

        Board fakeBoard = new ConcreteBoard();

        fakeBoard.getPiecesInPlay().put(currentPosition, whitePawn);

        Assertions.assertThat(fakeBoard.getPiecesInPlay().get(currentPosition)).isEqualTo(whitePawn);

        Assertions.assertThat(
                pawnMoveValidator.isMoveValid(
                        whitePawn.getPieceTeam(),
                        true,
                        false,
                        currentPosition,
                        desiredPosition
                )).isTrue();
    }

    @Test
    public void givenFirstTurnEnemy_whenWhitePawnAttacksFromInvalidPosition_isNotValid() {
        final Piece whitePawn = new Piece(PieceNames.PAWN, PieceTeam.WHITE);
        final Piece blackPawn = new Piece(PieceNames.PAWN, PieceTeam.BLACK);

        final BoardPosition currentPosition = new BoardPosition(1, 1);
        final BoardPosition desiredPosition = new BoardPosition(1, 3);
        final BoardPosition blackPawnPosition = new BoardPosition(1, 3);

        Board fakeBoard = new ConcreteBoard();

        fakeBoard.getPiecesInPlay().put(currentPosition, whitePawn);
        fakeBoard.getPiecesInPlay().put(blackPawnPosition, blackPawn);

        Assertions.assertThat(fakeBoard.getPiecesInPlay().get(currentPosition)).isEqualTo(whitePawn);

        Assertions.assertThat(
                pawnMoveValidator.isMoveValid(
                        whitePawn.getPieceTeam(),
                        false,
                        true,
                        currentPosition,
                        desiredPosition
                )).isFalse();
    }

    @Test
    public void givenFirstTurnEnemy_whenWhitePawnAttacksFromInvalidPosition_isInvalid() {
        final Piece whitePawn = new Piece(PieceNames.PAWN, PieceTeam.WHITE);

        final BoardPosition currentPosition = new BoardPosition(1, 1);
        final BoardPosition desiredPosition = new BoardPosition(1, 3);

        Board fakeBoard = new ConcreteBoard();

        fakeBoard.getPiecesInPlay().put(currentPosition, whitePawn);

        Assertions.assertThat(fakeBoard.getPiecesInPlay().get(currentPosition)).isEqualTo(whitePawn);

        Assertions.assertThat(
                pawnMoveValidator.isMoveValid(
                        whitePawn.getPieceTeam(),
                        false,
                        true,
                        currentPosition,
                        desiredPosition
                )).isFalse();
    }

    @Test
    public void noFirstTurnNoEnemy_whenBlackPawnMovesBackward_isInvalid() {
        final Piece blackPawn = new Piece(PieceNames.PAWN, PieceTeam.BLACK);

        final BoardPosition currentPosition = new BoardPosition(3, 6);
        final BoardPosition desiredPosition = new BoardPosition(3, 7);

        Board fakeBoard = new ConcreteBoard();

        fakeBoard.getPiecesInPlay().put(currentPosition, blackPawn);

        Assertions.assertThat(fakeBoard.getPiecesInPlay().get(currentPosition)).isEqualTo(blackPawn);

        Assertions.assertThat(
                pawnMoveValidator.isMoveValid(
                        blackPawn.getPieceTeam(),
                        false,
                        false,
                        currentPosition,
                        desiredPosition
                )).isFalse();
    }

    @Test
    public void noFirstTurnNoEnemy_whenBlackPawnMovesInvalidSpace_isInvalid() {
        final Piece blackPawn = new Piece(PieceNames.PAWN, PieceTeam.BLACK);

        final BoardPosition currentPosition = new BoardPosition(1, 8);
        final BoardPosition desiredPosition = new BoardPosition(5, 1);

        Board fakeBoard = new ConcreteBoard();

        fakeBoard.getPiecesInPlay().put(currentPosition, blackPawn);

        Assertions.assertThat(fakeBoard.getPiecesInPlay().get(currentPosition)).isEqualTo(blackPawn);

        Assertions.assertThat(
                pawnMoveValidator.isMoveValid(
                        blackPawn.getPieceTeam(),
                        false,
                        false,
                        currentPosition,
                        desiredPosition
                )).isFalse();
    }

    @Test
    public void givenFirstTurnNoEnemy_thenBlackPawnMoves1Space() {
        final Piece blackPawn = new Piece(PieceNames.PAWN, PieceTeam.BLACK);

        final BoardPosition currentPosition = new BoardPosition(4, 6);
        final BoardPosition desiredPosition = new BoardPosition(4, 4);

        Board fakeBoard = new ConcreteBoard();

        fakeBoard.getPiecesInPlay().put(currentPosition, blackPawn);

        Assertions.assertThat(fakeBoard.getPiecesInPlay().get(currentPosition)).isEqualTo(blackPawn);

        Assertions.assertThat(
                pawnMoveValidator.isMoveValid(
                        blackPawn.getPieceTeam(),
                        true,
                        false,
                        currentPosition,
                        desiredPosition
                )).isTrue();
    }

    @Test
    public void givenFirstTurnNoEnemy_thenBlackPawnMoves2Space_isValid() {
        final Piece blackPawn = new Piece(PieceNames.PAWN, PieceTeam.BLACK);

        final BoardPosition currentPosition = new BoardPosition(8, 7);
        final BoardPosition desiredPosition = new BoardPosition(8, 5);

        Board fakeBoard = new ConcreteBoard();

        fakeBoard.getPiecesInPlay().put(currentPosition, blackPawn);

        Assertions.assertThat(fakeBoard.getPiecesInPlay().get(currentPosition)).isEqualTo(blackPawn);

        Assertions.assertThat(
                pawnMoveValidator.isMoveValid(
                        blackPawn.getPieceTeam(),
                        true,
                        false,
                        currentPosition,
                        desiredPosition
                )).isTrue();
    }

    @Test
    public void givenFirstTurnEnemy_whenBlackPawnAttacksFromInvalidPosition_isNotValid() {
        final Piece whitePawn = new Piece(PieceNames.PAWN, PieceTeam.BLACK);
        final Piece blackPawn = new Piece(PieceNames.PAWN, PieceTeam.BLACK);

        final BoardPosition currentPosition = new BoardPosition(1, 5);
        final BoardPosition desiredPosition = new BoardPosition(1, 3);
        final BoardPosition blackPawnPosition = new BoardPosition(1, 3);

        Board fakeBoard = new ConcreteBoard();

        fakeBoard.getPiecesInPlay().put(currentPosition, whitePawn);
        fakeBoard.getPiecesInPlay().put(blackPawnPosition, blackPawn);

        Assertions.assertThat(fakeBoard.getPiecesInPlay().get(currentPosition)).isEqualTo(whitePawn);

        Assertions.assertThat(
                pawnMoveValidator.isMoveValid(
                        whitePawn.getPieceTeam(),
                        false,
                        true,
                        currentPosition,
                        desiredPosition
                )).isFalse();
    }

    @Test
    public void givenFirstTurnEnemy_whenBlackPawnAttacksFromInvalidPosition_isInvalid() {
        final Piece blackPawn = new Piece(PieceNames.PAWN, PieceTeam.BLACK);

        final BoardPosition currentPosition = new BoardPosition(1, 3);
        final BoardPosition desiredPosition = new BoardPosition(1, 1);

        Board fakeBoard = new ConcreteBoard();

        fakeBoard.getPiecesInPlay().put(currentPosition, blackPawn);

        Assertions.assertThat(fakeBoard.getPiecesInPlay().get(currentPosition)).isEqualTo(blackPawn);

        Assertions.assertThat(
                pawnMoveValidator.isMoveValid(
                        blackPawn.getPieceTeam(),
                        false,
                        true,
                        currentPosition,
                        desiredPosition
                )).isFalse();
    }
}
