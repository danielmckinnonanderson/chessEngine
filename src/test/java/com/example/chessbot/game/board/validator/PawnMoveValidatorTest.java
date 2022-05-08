package com.example.chessbot.game.board.validator;

import com.example.chessbot.model.board.Board;
import com.example.chessbot.model.board.ConcreteBoard;
import com.example.chessbot.model.board.exceptions.IllegalTeamException;
import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.piece.PieceNames;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PawnMoveValidatorTest {
    private final PawnMoveValidator pawnMoveValidator = new PawnMoveValidator();

    @Test
    public void noFirstTurnNoEnemy_whenWhitePawnMovesBackward_isInvalid() throws IllegalTeamException {
        final Piece whitePawn = new Piece(PieceNames.PAWN, 0);

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
    public void noFirstTurnNoEnemy_whenWhitePawnMovesInvalidSpace_isInvalid() throws IllegalTeamException {
        final Piece whitePawn = new Piece(PieceNames.PAWN, 0);

        final BoardPosition currentPosition = new BoardPosition(0, 1);
        final BoardPosition desiredPosition = new BoardPosition(6, 3);

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
    public void givenFirstTurnNoEnemy_thenWhitePawnMoves1Space() throws IllegalTeamException {
        final Piece whitePawn = new Piece(PieceNames.PAWN, 0);

        final BoardPosition currentPosition = new BoardPosition(0, 1);
        final BoardPosition desiredPosition = new BoardPosition(0, 2);

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
    public void givenFirstTurnNoEnemy_thenWhitePawnMoves2Space_isValid() throws IllegalTeamException {
        final Piece whitePawn = new Piece(PieceNames.PAWN, 0);

        final BoardPosition currentPosition = new BoardPosition(0, 1);
        final BoardPosition desiredPosition = new BoardPosition(0, 3);

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
    public void givenFirstTurnEnemy_whenWhitePawnAttacksFromInvalidPosition_isNotValid() throws IllegalTeamException {
        final Piece whitePawn = new Piece(PieceNames.PAWN, 0);
        final Piece blackPawn = new Piece(PieceNames.PAWN, 1);

        final BoardPosition currentPosition = new BoardPosition(0, 1);
        final BoardPosition desiredPosition = new BoardPosition(0, 3);
        final BoardPosition blackPawnPosition = new BoardPosition(0, 3);

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
    public void givenFirstTurnEnemy_whenWhitePawnAttacksFromInvalidPosition_isInvalid() throws IllegalTeamException {
        final Piece whitePawn = new Piece(PieceNames.PAWN, 0);

        final BoardPosition currentPosition = new BoardPosition(0, 1);
        final BoardPosition desiredPosition = new BoardPosition(0, 3);

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
    public void noFirstTurnNoEnemy_whenBlackPawnMovesBackward_isInvalid() throws IllegalTeamException {
        final Piece blackPawn = new Piece(PieceNames.PAWN, 1);

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
    public void noFirstTurnNoEnemy_whenBlackPawnMovesInvalidSpace_isInvalid() throws IllegalTeamException {
        final Piece blackPawn = new Piece(PieceNames.PAWN, 1);

        final BoardPosition currentPosition = new BoardPosition(0, 1);
        final BoardPosition desiredPosition = new BoardPosition(6, 3);

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
    public void givenFirstTurnNoEnemy_thenBlackPawnMoves1Space() throws IllegalTeamException {
        final Piece blackPawn = new Piece(PieceNames.PAWN, 1);

        final BoardPosition currentPosition = new BoardPosition(7, 7);
        final BoardPosition desiredPosition = new BoardPosition(7, 6);

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
    public void givenFirstTurnNoEnemy_thenBlackPawnMoves2Space_isValid() throws IllegalTeamException {
        final Piece blackPawn = new Piece(PieceNames.PAWN, 1);

        final BoardPosition currentPosition = new BoardPosition(7, 7);
        final BoardPosition desiredPosition = new BoardPosition(7, 5);

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
    public void givenFirstTurnEnemy_whenBlackPawnAttacksFromInvalidPosition_isNotValid() throws IllegalTeamException {
        final Piece whitePawn = new Piece(PieceNames.PAWN, 0);
        final Piece blackPawn = new Piece(PieceNames.PAWN, 1);

        final BoardPosition currentPosition = new BoardPosition(0, 1);
        final BoardPosition desiredPosition = new BoardPosition(0, 3);
        final BoardPosition blackPawnPosition = new BoardPosition(0, 3);

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
    public void givenFirstTurnEnemy_whenBlackPawnAttacksFromInvalidPosition_isInvalid() throws IllegalTeamException {
        final Piece blackPawn = new Piece(PieceNames.PAWN, 1);

        final BoardPosition currentPosition = new BoardPosition(0, 1);
        final BoardPosition desiredPosition = new BoardPosition(0, 3);

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
