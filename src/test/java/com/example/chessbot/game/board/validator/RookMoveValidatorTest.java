package com.example.chessbot.game.board.validator;

import com.example.chessbot.game.state.ConcreteGameState;
import com.example.chessbot.game.state.GameState;
import com.example.chessbot.model.board.BoardFactory;
import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.piece.PieceNames;
import com.example.chessbot.model.piece.PieceTeam;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Hashtable;
import java.util.Map;

public class RookMoveValidatorTest {
    private final RookMoveValidator rookMoveValidator = new RookMoveValidator();

    private Map<BoardPosition, Piece> emptyBoard;

    @BeforeEach()
    public void setupBoard() {
        this.emptyBoard = BoardFactory.createEmptyBoard();
    }

    @Test
    public void givenNoPiecesInWay_RookCanMoveVertically() {
        Map<BoardPosition, Piece> piecesInPlayOne = emptyBoard;
        System.out.println(piecesInPlayOne);

        final BoardPosition startingPosition = new BoardPosition(1, 1);
        final BoardPosition endingPosition = new BoardPosition(1, 5);
        final Piece whiteRook = new Piece(PieceNames.ROOK, PieceTeam.WHITE);

        piecesInPlayOne.put(startingPosition, whiteRook);
        GameState gameStateOne = new ConcreteGameState(new Hashtable<>(piecesInPlayOne), 66_890);

        final boolean resultOne = rookMoveValidator.validate(gameStateOne, startingPosition, endingPosition);
        Assertions.assertThat(resultOne).isTrue();


        final BoardPosition startingPositionTwo = new BoardPosition(8, 7);
        final BoardPosition endingPositionTwo = new BoardPosition(8, 1);

        Map<BoardPosition, Piece> piecesInPlayTwo = emptyBoard;

        piecesInPlayTwo.put(startingPositionTwo, whiteRook);
        GameState gameStateTwo = new ConcreteGameState(new Hashtable<>(piecesInPlayOne), 33);

        final boolean resultTwo = rookMoveValidator.validate(gameStateTwo, startingPositionTwo, endingPositionTwo);
        Assertions.assertThat(resultTwo).isTrue();
    }

    @Test
    public void givenNoPiecesInWay_RookCanMoveHorizontally() {
        Map<BoardPosition, Piece> piecesInPlayOne = emptyBoard;

        final BoardPosition startingPosition = new BoardPosition(1, 1);
        final BoardPosition endingPosition = new BoardPosition(7, 1);
        final Piece whiteRook = new Piece(PieceNames.ROOK, PieceTeam.WHITE);

        piecesInPlayOne.put(startingPosition, whiteRook);
        GameState gameStateOne = new ConcreteGameState(new Hashtable<>(piecesInPlayOne), 900);

        final boolean resultOne = rookMoveValidator.validate(gameStateOne, startingPosition, endingPosition);
        Assertions.assertThat(resultOne).isTrue();


        final BoardPosition startingPositionTwo = new BoardPosition(3, 3);
        final BoardPosition endingPositionTwo = new BoardPosition(5, 3);
        final Piece blackRook = new Piece(PieceNames.ROOK, PieceTeam.BLACK);

        Map<BoardPosition, Piece> piecesInPlayTwo = emptyBoard;

        piecesInPlayTwo.put(startingPositionTwo, blackRook);
        GameState gameStateTwo = new ConcreteGameState(new Hashtable<>(piecesInPlayTwo), 1);

        final boolean resultTwo = rookMoveValidator.validate(gameStateTwo, startingPositionTwo, endingPositionTwo);
        Assertions.assertThat(resultTwo).isTrue();
    }

    @Test
    public void givenFriendlyPieceInWay_RookCannotMovePast() {
        Map<BoardPosition, Piece> piecesInPlayOne = emptyBoard;

        final BoardPosition whiteRookStartingPosition = new BoardPosition(3, 3);
        final BoardPosition whiteRookEndingPositionLeft = new BoardPosition(4, 3);
        final BoardPosition whiteRookEndingPositionRight = new BoardPosition(7, 3);
        final BoardPosition whiteRookEndingPositionTop = new BoardPosition(3, 8);
        final BoardPosition whiteRookEndingPositionDown = new BoardPosition(3, 1);

        final BoardPosition oneRankBehindWhiteRook = new BoardPosition(3, 2);
        final BoardPosition oneRankFrontWhiteRook = new BoardPosition(3, 4);
        final BoardPosition oneFileRightWhiteRook = new BoardPosition(4, 3);
        final BoardPosition oneFileLeftWhiteRook = new BoardPosition(2, 3);

        final Piece whiteRook = new Piece(PieceNames.ROOK, PieceTeam.WHITE);
        final Piece whiteBishop = new Piece(PieceNames.BISHOP, PieceTeam.WHITE);
        final Piece whiteKing = new Piece(PieceNames.KING, PieceTeam.WHITE);
        final Piece whitePawn = new Piece(PieceNames.PAWN, PieceTeam.WHITE);
        final Piece whiteRookTwo = new Piece(PieceNames.ROOK, PieceTeam.WHITE);

        piecesInPlayOne.put(whiteRookStartingPosition, whiteRook);
        piecesInPlayOne.put(oneRankBehindWhiteRook, whiteBishop);
        piecesInPlayOne.put(oneRankFrontWhiteRook, whitePawn);
        piecesInPlayOne.put(oneFileRightWhiteRook, whiteKing);
        piecesInPlayOne.put(oneFileLeftWhiteRook, whiteRookTwo);
        GameState gameStateOne = new ConcreteGameState(new Hashtable<>(piecesInPlayOne), 99_999);

        final boolean whiteRookCanMovePastWhitePieceBehind = rookMoveValidator.validate(gameStateOne, whiteRookStartingPosition, whiteRookEndingPositionDown);
        final boolean whiteRookCanMovePastWhitePieceInFront = rookMoveValidator.validate(gameStateOne, whiteRookStartingPosition, whiteRookEndingPositionTop);
        final boolean whiteRookCanMovePastWhitePieceToRight = rookMoveValidator.validate(gameStateOne, whiteRookStartingPosition, whiteRookEndingPositionRight);
        final boolean whiteRookCanMovePastWhitePieceToLeft = rookMoveValidator.validate(gameStateOne, whiteRookStartingPosition, whiteRookEndingPositionLeft);

        Assertions.assertThat(whiteRookCanMovePastWhitePieceBehind).isFalse();
        Assertions.assertThat(whiteRookCanMovePastWhitePieceInFront).isFalse();
        Assertions.assertThat(whiteRookCanMovePastWhitePieceToRight).isFalse();
        Assertions.assertThat(whiteRookCanMovePastWhitePieceToLeft).isFalse();

        Map<BoardPosition, Piece> piecesInPlayTwo = emptyBoard;

        final BoardPosition blackRookStartingPosition = new BoardPosition(3, 3);
        final BoardPosition blackRookEndingPositionLeft = new BoardPosition(4, 3);
        final BoardPosition blackRookEndingPositionRight = new BoardPosition(7, 3);
        final BoardPosition blackRookEndingPositionTop = new BoardPosition(3, 8);
        final BoardPosition blackRookEndingPositionDown = new BoardPosition(3, 1);

        final BoardPosition oneRankBehindBlackRook = new BoardPosition(3, 2);
        final BoardPosition oneRankFrontBlackRook = new BoardPosition(3, 4);
        final BoardPosition oneFileRightBlackRook = new BoardPosition(4, 3);
        final BoardPosition oneFileLeftBlackRook = new BoardPosition(2, 3);

        final Piece blackRook = new Piece(PieceNames.ROOK, PieceTeam.BLACK);
        final Piece blackBishop = new Piece(PieceNames.BISHOP, PieceTeam.BLACK);
        final Piece blackKing = new Piece(PieceNames.KING, PieceTeam.BLACK);
        final Piece blackPawn = new Piece(PieceNames.PAWN, PieceTeam.BLACK);
        final Piece blackRookTwo = new Piece(PieceNames.ROOK, PieceTeam.BLACK);

        piecesInPlayOne.put(blackRookStartingPosition, blackRook);
        piecesInPlayOne.put(oneRankBehindBlackRook, blackBishop);
        piecesInPlayOne.put(oneRankFrontBlackRook, blackPawn);
        piecesInPlayOne.put(oneFileRightBlackRook, blackKing);
        piecesInPlayOne.put(oneFileLeftBlackRook, blackRookTwo);
        GameState gameStateTwo = new ConcreteGameState(new Hashtable<>(piecesInPlayTwo), 3_939);

        final boolean blackRookCanMovePastBlackPieceBehind = rookMoveValidator.validate(gameStateTwo, blackRookStartingPosition, blackRookEndingPositionDown);
        final boolean blackRookCanMovePastBlackPieceInFront = rookMoveValidator.validate(gameStateTwo, blackRookStartingPosition, blackRookEndingPositionTop);
        final boolean blackRookCanMovePastBlackPieceToRight = rookMoveValidator.validate(gameStateTwo, blackRookStartingPosition, blackRookEndingPositionRight);
        final boolean blackRookCanMovePastBlackPieceToLeft = rookMoveValidator.validate(gameStateTwo, blackRookStartingPosition, blackRookEndingPositionLeft);

        Assertions.assertThat(blackRookCanMovePastBlackPieceBehind).isFalse();
        Assertions.assertThat(blackRookCanMovePastBlackPieceInFront).isFalse();
        Assertions.assertThat(blackRookCanMovePastBlackPieceToRight).isFalse();
        Assertions.assertThat(blackRookCanMovePastBlackPieceToLeft).isFalse();
    }

    @Test
    public void givenEnemyPieceInWay_RookCannotMovePast() {
        Map<BoardPosition, Piece> piecesInPlayOne = emptyBoard;

        final BoardPosition whiteRookStartingPosition = new BoardPosition(3, 3);
        final BoardPosition whiteRookEndingPositionLeft = new BoardPosition(4, 3);
        final BoardPosition whiteRookEndingPositionRight = new BoardPosition(7, 3);
        final BoardPosition whiteRookEndingPositionTop = new BoardPosition(3, 8);
        final BoardPosition whiteRookEndingPositionDown = new BoardPosition(3, 1);

        final BoardPosition oneRankBehindWhiteRook = new BoardPosition(3, 2);
        final BoardPosition oneRankFrontWhiteRook = new BoardPosition(3, 4);
        final BoardPosition oneFileRightWhiteRook = new BoardPosition(4, 3);
        final BoardPosition oneFileLeftWhiteRook = new BoardPosition(2, 3);

        final Piece blackRook = new Piece(PieceNames.ROOK, PieceTeam.BLACK);
        final Piece blackBishop = new Piece(PieceNames.BISHOP, PieceTeam.BLACK);
        final Piece blackKing = new Piece(PieceNames.KING, PieceTeam.BLACK);
        final Piece blackPawn = new Piece(PieceNames.PAWN, PieceTeam.BLACK);
        final Piece blackRookTwo = new Piece(PieceNames.ROOK, PieceTeam.BLACK);

        piecesInPlayOne.put(whiteRookStartingPosition, blackRook);
        piecesInPlayOne.put(oneRankBehindWhiteRook, blackBishop);
        piecesInPlayOne.put(oneRankFrontWhiteRook, blackPawn);
        piecesInPlayOne.put(oneFileRightWhiteRook, blackKing);
        piecesInPlayOne.put(oneFileLeftWhiteRook, blackRookTwo);
        GameState gameStateOne = new ConcreteGameState(new Hashtable<>(piecesInPlayOne), 99_999);

        final boolean whiteRookCanMovePastWhitePieceBehind = rookMoveValidator.validate(gameStateOne, whiteRookStartingPosition, whiteRookEndingPositionDown);
        final boolean whiteRookCanMovePastWhitePieceInFront = rookMoveValidator.validate(gameStateOne, whiteRookStartingPosition, whiteRookEndingPositionTop);
        final boolean whiteRookCanMovePastWhitePieceToRight = rookMoveValidator.validate(gameStateOne, whiteRookStartingPosition, whiteRookEndingPositionRight);
        final boolean whiteRookCanMovePastWhitePieceToLeft = rookMoveValidator.validate(gameStateOne, whiteRookStartingPosition, whiteRookEndingPositionLeft);

        Assertions.assertThat(whiteRookCanMovePastWhitePieceBehind).isFalse();
        Assertions.assertThat(whiteRookCanMovePastWhitePieceInFront).isFalse();
        Assertions.assertThat(whiteRookCanMovePastWhitePieceToRight).isFalse();
        Assertions.assertThat(whiteRookCanMovePastWhitePieceToLeft).isFalse();

        Map<BoardPosition, Piece> piecesInPlayTwo = emptyBoard;

        final BoardPosition blackRookStartingPosition = new BoardPosition(3, 3);
        final BoardPosition blackRookEndingPositionLeft = new BoardPosition(4, 3);
        final BoardPosition blackRookEndingPositionRight = new BoardPosition(7, 3);
        final BoardPosition blackRookEndingPositionTop = new BoardPosition(3, 8);
        final BoardPosition blackRookEndingPositionDown = new BoardPosition(3, 1);

        final BoardPosition oneRankBehindBlackRook = new BoardPosition(3, 2);
        final BoardPosition oneRankFrontBlackRook = new BoardPosition(3, 4);
        final BoardPosition oneFileRightBlackRook = new BoardPosition(4, 3);
        final BoardPosition oneFileLeftBlackRook = new BoardPosition(2, 3);

        final Piece whiteRook = new Piece(PieceNames.ROOK, PieceTeam.WHITE);
        final Piece whiteBishop = new Piece(PieceNames.BISHOP, PieceTeam.WHITE);
        final Piece whiteKing = new Piece(PieceNames.KING, PieceTeam.WHITE);
        final Piece whitePawn = new Piece(PieceNames.PAWN, PieceTeam.WHITE);
        final Piece whiteRookTwo = new Piece(PieceNames.ROOK, PieceTeam.WHITE);

        piecesInPlayOne.put(blackRookStartingPosition, whiteRook);
        piecesInPlayOne.put(oneRankBehindBlackRook, whiteBishop);
        piecesInPlayOne.put(oneRankFrontBlackRook, whiteKing);
        piecesInPlayOne.put(oneFileRightBlackRook, whitePawn);
        piecesInPlayOne.put(oneFileLeftBlackRook, whiteRookTwo);
        GameState gameStateTwo = new ConcreteGameState(new Hashtable<>(piecesInPlayTwo), 3_939);

        final boolean blackRookCanMovePastBlackPieceBehind = rookMoveValidator.validate(gameStateTwo, blackRookStartingPosition, blackRookEndingPositionDown);
        final boolean blackRookCanMovePastBlackPieceInFront = rookMoveValidator.validate(gameStateTwo, blackRookStartingPosition, blackRookEndingPositionTop);
        final boolean blackRookCanMovePastBlackPieceToRight = rookMoveValidator.validate(gameStateTwo, blackRookStartingPosition, blackRookEndingPositionRight);
        final boolean blackRookCanMovePastBlackPieceToLeft = rookMoveValidator.validate(gameStateTwo, blackRookStartingPosition, blackRookEndingPositionLeft);

        Assertions.assertThat(blackRookCanMovePastBlackPieceBehind).isFalse();
        Assertions.assertThat(blackRookCanMovePastBlackPieceInFront).isFalse();
        Assertions.assertThat(blackRookCanMovePastBlackPieceToRight).isFalse();
        Assertions.assertThat(blackRookCanMovePastBlackPieceToLeft).isFalse();
    }

    @Test
    public void givenMultiplePiecesInWay_RookCannotMovePast() {
        Map<BoardPosition, Piece> piecesInPlayOne = emptyBoard;

        final BoardPosition whiteRookStartingPosition = new BoardPosition(3, 4);
        final BoardPosition whiteRookEndingPositionLeft = new BoardPosition(1, 4);
        final BoardPosition whiteRookEndingPositionRight = new BoardPosition(8, 4);
        final BoardPosition whiteRookEndingPositionTop = new BoardPosition(3, 8);
        final BoardPosition whiteRookEndingPositionDown = new BoardPosition(3, 1);

        final BoardPosition oneRankBehindWhiteRook = new BoardPosition(3, 3);
        final BoardPosition oneRankFrontWhiteRook = new BoardPosition(3, 5);
        final BoardPosition oneFileRightWhiteRook = new BoardPosition(4, 4);
        final BoardPosition oneFileLeftWhiteRook = new BoardPosition(2, 4);

        final BoardPosition twoRanksBehindWhiteRook = new BoardPosition(3, 1);
        final BoardPosition twoRanksFrontWhiteRook = new BoardPosition(3, 5);
        final BoardPosition twoFilesRightWhiteRook = new BoardPosition(5, 4);
        final BoardPosition twoFilesLeftWhiteRook = new BoardPosition(1, 4);

        final Piece whiteRook = new Piece(PieceNames.ROOK, PieceTeam.WHITE);
        final Piece whiteBishop = new Piece(PieceNames.BISHOP, PieceTeam.WHITE);
        final Piece whiteKing = new Piece(PieceNames.KING, PieceTeam.WHITE);
        final Piece whitePawn = new Piece(PieceNames.PAWN, PieceTeam.WHITE);
        final Piece whiteRookTwo = new Piece(PieceNames.ROOK, PieceTeam.WHITE);
        final Piece whiteBishopTwo = new Piece(PieceNames.BISHOP, PieceTeam.WHITE);
        final Piece whiteKingTwo = new Piece(PieceNames.KING, PieceTeam.WHITE);
        final Piece whitePawnTwo = new Piece(PieceNames.PAWN, PieceTeam.WHITE);
        final Piece whiteQueen = new Piece(PieceNames.QUEEN, PieceTeam.WHITE);

        piecesInPlayOne.put(whiteRookStartingPosition, whiteRook);
        piecesInPlayOne.put(oneRankBehindWhiteRook, whiteBishop);
        piecesInPlayOne.put(oneRankFrontWhiteRook, whiteKing);
        piecesInPlayOne.put(oneFileRightWhiteRook, whitePawn);
        piecesInPlayOne.put(oneFileLeftWhiteRook, whiteRookTwo);
        piecesInPlayOne.put(twoRanksFrontWhiteRook, whiteBishopTwo);
        piecesInPlayOne.put(twoRanksBehindWhiteRook, whiteKingTwo);
        piecesInPlayOne.put(twoFilesRightWhiteRook, whitePawnTwo);
        piecesInPlayOne.put(twoFilesLeftWhiteRook, whiteQueen);
        GameState gameStateOne = new ConcreteGameState(new Hashtable<>(piecesInPlayOne), 4_812);

        final boolean whiteRookCanMovePastWhitePieceBehind = rookMoveValidator.validate(gameStateOne, whiteRookStartingPosition, whiteRookEndingPositionDown);
        final boolean whiteRookCanMovePastWhitePieceInFront = rookMoveValidator.validate(gameStateOne, whiteRookStartingPosition, whiteRookEndingPositionTop);
        final boolean whiteRookCanMovePastWhitePieceToRight = rookMoveValidator.validate(gameStateOne, whiteRookStartingPosition, whiteRookEndingPositionRight);
        final boolean whiteRookCanMovePastWhitePieceToLeft = rookMoveValidator.validate(gameStateOne, whiteRookStartingPosition, whiteRookEndingPositionLeft);
        Assertions.assertThat(whiteRookCanMovePastWhitePieceBehind).isFalse();
        Assertions.assertThat(whiteRookCanMovePastWhitePieceInFront).isFalse();
        Assertions.assertThat(whiteRookCanMovePastWhitePieceToRight).isFalse();
        Assertions.assertThat(whiteRookCanMovePastWhitePieceToLeft).isFalse();
    }

    @Test
    public void givenFriendlyPieceInSpot_RookCannotCapture() {
        Map<BoardPosition, Piece> piecesInPlayOne = emptyBoard;

        final BoardPosition startingPosition = new BoardPosition(1, 1);
        final BoardPosition endingPosition = new BoardPosition(7, 1);
        final Piece whiteRook = new Piece(PieceNames.ROOK, PieceTeam.WHITE);
        final Piece whiteKnight = new Piece(PieceNames.KNIGHT, PieceTeam.WHITE);

        piecesInPlayOne.put(startingPosition, whiteRook);
        piecesInPlayOne.put(endingPosition, whiteKnight);

        Assertions.assertThat(piecesInPlayOne.size()).isEqualTo(64);
        GameState gameStateOne = new ConcreteGameState(new Hashtable<>(piecesInPlayOne), -9_999_999);

        final boolean resultOne = rookMoveValidator.validate(gameStateOne, startingPosition, endingPosition);
        Assertions.assertThat(resultOne).isFalse();


        final BoardPosition startingPositionTwo = new BoardPosition(5, 6);
        final BoardPosition endingPositionTwo = new BoardPosition(5, 2);
        final Piece blackRook = new Piece(PieceNames.ROOK, PieceTeam.BLACK);
        final Piece blackQueen = new Piece(PieceNames.QUEEN, PieceTeam.BLACK);

        Map<BoardPosition, Piece> piecesInPlayTwo = emptyBoard;
        piecesInPlayTwo.put(startingPositionTwo, blackRook);
        piecesInPlayTwo.put(endingPositionTwo, blackQueen);
        GameState gameStateTwo = new ConcreteGameState(new Hashtable<>(piecesInPlayTwo), 238_100);

        final boolean resultTwo = rookMoveValidator.validate(gameStateTwo, startingPositionTwo, endingPositionTwo);
        Assertions.assertThat(resultTwo).isFalse();
    }

    @Test
    public void givenEnemyPieceInSpot_RookCanCapture() {
        Map<BoardPosition, Piece> piecesInPlayOne = emptyBoard;

        final BoardPosition startingPosition = new BoardPosition(1, 1);
        final BoardPosition endingPosition = new BoardPosition(3, 1);
        final Piece whiteRook = new Piece(PieceNames.ROOK, PieceTeam.WHITE);
        final Piece blackKing = new Piece(PieceNames.KNIGHT, PieceTeam.BLACK);

        piecesInPlayOne.put(startingPosition, whiteRook);
        piecesInPlayOne.put(endingPosition, blackKing);
        GameState gameStateOne = new ConcreteGameState(new Hashtable<>(piecesInPlayOne), 9001);

        final boolean resultOne = rookMoveValidator.validate(gameStateOne, startingPosition, endingPosition);
        Assertions.assertThat(resultOne).isTrue();


        final BoardPosition startingPositionTwo = new BoardPosition(3, 8);
        final BoardPosition endingPositionTwo = new BoardPosition(3, 4);
        final Piece blackRook = new Piece(PieceNames.ROOK, PieceTeam.BLACK);
        final Piece whiteKing = new Piece(PieceNames.BISHOP, PieceTeam.WHITE);

        Map<BoardPosition, Piece> piecesInPlayTwo = emptyBoard;

        piecesInPlayTwo.put(startingPositionTwo, blackRook);
        piecesInPlayTwo.put(endingPositionTwo, whiteKing);
        GameState gameStateTwo = new ConcreteGameState(new Hashtable<>(piecesInPlayTwo), 1);

        final boolean resultTwo = rookMoveValidator.validate(gameStateTwo, startingPositionTwo, endingPositionTwo);
        Assertions.assertThat(resultTwo).isTrue();
    }

    @Test
    public void givenKingInSpot_RookCannotCapture() {
        Map<BoardPosition, Piece> piecesInPlayOne = emptyBoard;

        final BoardPosition startingPosition = new BoardPosition(1, 1);
        final BoardPosition endingPosition = new BoardPosition(3, 1);
        final Piece whiteRook = new Piece(PieceNames.ROOK, PieceTeam.WHITE);
        final Piece blackKing = new Piece(PieceNames.KING, PieceTeam.BLACK);

        piecesInPlayOne.put(startingPosition, whiteRook);
        piecesInPlayOne.put(endingPosition, blackKing);
        GameState gameStateOne = new ConcreteGameState(new Hashtable<>(piecesInPlayOne), 9001);

        final boolean resultOne = rookMoveValidator.validate(gameStateOne, startingPosition, endingPosition);
        Assertions.assertThat(resultOne).isFalse();


        final BoardPosition startingPositionTwo = new BoardPosition(3, 8);
        final BoardPosition endingPositionTwo = new BoardPosition(3, 4);
        final Piece blackRook = new Piece(PieceNames.ROOK, PieceTeam.BLACK);
        final Piece whiteKing = new Piece(PieceNames.KING, PieceTeam.WHITE);

        Map<BoardPosition, Piece> piecesInPlayTwo = emptyBoard;

        piecesInPlayTwo.put(startingPositionTwo, blackRook);
        piecesInPlayTwo.put(endingPositionTwo, whiteKing);
        GameState gameStateTwo = new ConcreteGameState(new Hashtable<>(piecesInPlayTwo), 1);

        final boolean resultTwo = rookMoveValidator.validate(gameStateTwo, startingPositionTwo, endingPositionTwo);
        Assertions.assertThat(resultTwo).isFalse();
    }

    @Test
    public void whenDesiredPositionIsSamePositionAsCurrent_ThenRookCannotStandStill() {
        final BoardPosition startingPosition = new BoardPosition(3, 8);
        final Piece blackRook = new Piece(PieceNames.ROOK, PieceTeam.BLACK);

        Map<BoardPosition, Piece> piecesInPlayTwo = emptyBoard;

        piecesInPlayTwo.put(startingPosition, blackRook);
        GameState gameStateTwo = new ConcreteGameState(new Hashtable<>(piecesInPlayTwo), 1);

        final boolean resultTwo = rookMoveValidator.validate(gameStateTwo, startingPosition, startingPosition);
        Assertions.assertThat(resultTwo).isFalse();
    }
}
