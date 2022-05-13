package com.example.chessbot.game.board.validator;

import com.example.chessbot.model.board.Board;
import com.example.chessbot.model.board.ConcreteBoard;
import com.example.chessbot.model.board.exceptions.IllegalTeamException;
import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.board.position.BoardPositionX;
import com.example.chessbot.model.board.position.BoardPositionY;
import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.piece.PieceNames;
import com.example.chessbot.model.piece.PieceTeam;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PawnMoveValidatorTest {
    private final PawnMoveValidator pawnMoveValidator = new PawnMoveValidator();

    @Test
    public void noFirstTurnNoEnemy_whenWhitePawnMovesBackward_isInvalid() throws IllegalTeamException {
        final Piece whitePawn = new Piece(PieceNames.PAWN, PieceTeam.WHITE);

        final BoardPosition currentPosition = new BoardPosition(BoardPositionX.C, BoardPositionY.SIX);
        final BoardPosition desiredPosition = new BoardPosition(BoardPositionX.C, BoardPositionY.FIVE);

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
        final Piece whitePawn = new Piece(PieceNames.PAWN, PieceTeam.WHITE);

        final BoardPosition currentPosition = new BoardPosition(BoardPositionX.A, BoardPositionY.ONE);
        final BoardPosition desiredPosition = new BoardPosition(BoardPositionX.F, BoardPositionY.TWO);

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
        final Piece whitePawn = new Piece(PieceNames.PAWN, PieceTeam.WHITE);

        final BoardPosition currentPosition = new BoardPosition(BoardPositionX.A, BoardPositionY.TWO);
        final BoardPosition desiredPosition = new BoardPosition(BoardPositionX.A, BoardPositionY.THREE);

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
        final Piece whitePawn = new Piece(PieceNames.PAWN, PieceTeam.WHITE);

        final BoardPosition currentPosition = new BoardPosition(BoardPositionX.A, BoardPositionY.ONE);
        final BoardPosition desiredPosition = new BoardPosition(BoardPositionX.A, BoardPositionY.THREE);

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
        final Piece whitePawn = new Piece(PieceNames.PAWN, PieceTeam.WHITE);
        final Piece blackPawn = new Piece(PieceNames.PAWN, PieceTeam.BLACK);

        final BoardPosition currentPosition = new BoardPosition(BoardPositionX.A, BoardPositionY.ONE);
        final BoardPosition desiredPosition = new BoardPosition(BoardPositionX.A, BoardPositionY.THREE);
        final BoardPosition blackPawnPosition = new BoardPosition(BoardPositionX.A, BoardPositionY.THREE);

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
        final Piece whitePawn = new Piece(PieceNames.PAWN, PieceTeam.WHITE);

        final BoardPosition currentPosition = new BoardPosition(BoardPositionX.A, BoardPositionY.ONE);
        final BoardPosition desiredPosition = new BoardPosition(BoardPositionX.A, BoardPositionY.THREE);

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
        final Piece blackPawn = new Piece(PieceNames.PAWN, PieceTeam.BLACK);

        final BoardPosition currentPosition = new BoardPosition(BoardPositionX.C, BoardPositionY.SIX);
        final BoardPosition desiredPosition = new BoardPosition(BoardPositionX.C, BoardPositionY.SEVEN);

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
        final Piece blackPawn = new Piece(PieceNames.PAWN, PieceTeam.BLACK);

        final BoardPosition currentPosition = new BoardPosition(BoardPositionX.A, BoardPositionY.EIGHT);
        final BoardPosition desiredPosition = new BoardPosition(BoardPositionX.E, BoardPositionY.ONE);

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
        final Piece blackPawn = new Piece(PieceNames.PAWN, PieceTeam.BLACK);

        final BoardPosition currentPosition = new BoardPosition(BoardPositionX.D, BoardPositionY.SIX);
        final BoardPosition desiredPosition = new BoardPosition(BoardPositionX.D, BoardPositionY.FOUR);

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
        final Piece blackPawn = new Piece(PieceNames.PAWN, PieceTeam.BLACK);

        final BoardPosition currentPosition = new BoardPosition(BoardPositionX.H, BoardPositionY.SEVEN);
        final BoardPosition desiredPosition = new BoardPosition(BoardPositionX.H, BoardPositionY.FIVE);

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
        final Piece whitePawn = new Piece(PieceNames.PAWN, PieceTeam.BLACK);
        final Piece blackPawn = new Piece(PieceNames.PAWN, PieceTeam.BLACK);

        final BoardPosition currentPosition = new BoardPosition(BoardPositionX.A, BoardPositionY.FIVE);
        final BoardPosition desiredPosition = new BoardPosition(BoardPositionX.A, BoardPositionY.THREE);
        final BoardPosition blackPawnPosition = new BoardPosition(BoardPositionX.A, BoardPositionY.THREE);

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
        final Piece blackPawn = new Piece(PieceNames.PAWN, PieceTeam.BLACK);

        final BoardPosition currentPosition = new BoardPosition(BoardPositionX.A, BoardPositionY.THREE);
        final BoardPosition desiredPosition = new BoardPosition(BoardPositionX.A, BoardPositionY.ONE);

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
