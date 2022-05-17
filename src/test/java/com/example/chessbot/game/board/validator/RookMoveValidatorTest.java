package com.example.chessbot.game.board.validator;

import com.example.chessbot.game.state.ConcreteGameState;
import com.example.chessbot.game.state.GameState;
import com.example.chessbot.model.board.Board;
import com.example.chessbot.model.board.BoardFactory;
import com.example.chessbot.model.board.ConcreteBoard;
import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.board.position.BoardPositionX;
import com.example.chessbot.model.board.position.BoardPositionY;
import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.piece.PieceNames;
import com.example.chessbot.model.piece.PieceTeam;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class RookMoveValidatorTest {
    private final RookMoveValidator rookMoveValidator = new RookMoveValidator();

    private final Board emptyBoard = BoardFactory.createEmptyBoard();

    @Test
    public void givenNoPiecesInWay_RookCanMoveVertically() {
        Map<BoardPosition, Piece> piecesInPlayOne = emptyBoard.getPiecesInPlay();

        final BoardPosition startingPosition = new BoardPosition(BoardPositionX.A, BoardPositionY.ONE);
        final BoardPosition endingPosition = new BoardPosition(BoardPositionX.A, BoardPositionY.FIVE);
        final Piece whiteRook = new Piece(PieceNames.ROOK, PieceTeam.WHITE);

        piecesInPlayOne.put(startingPosition, whiteRook);
        GameState gameStateOne = new ConcreteGameState(new ConcreteBoard().setPiecesInPlay(piecesInPlayOne), 66_890);

        final boolean resultOne = rookMoveValidator.validate(gameStateOne, startingPosition, endingPosition);
        Assertions.assertThat(resultOne).isTrue();


        final BoardPosition startingPositionTwo = new BoardPosition(BoardPositionX.H, BoardPositionY.SEVEN);
        final BoardPosition endingPositionTwo = new BoardPosition(BoardPositionX.H, BoardPositionY.ONE);

        Map<BoardPosition, Piece> piecesInPlayTwo = emptyBoard.getPiecesInPlay();

        piecesInPlayTwo.put(startingPositionTwo, whiteRook);
        GameState gameStateTwo = new ConcreteGameState(new ConcreteBoard().setPiecesInPlay(piecesInPlayOne), 33);

        final boolean resultTwo = rookMoveValidator.validate(gameStateTwo, startingPositionTwo, endingPositionTwo);
        Assertions.assertThat(resultTwo).isTrue();
    }

    @Test
    public void givenNoPiecesInWay_RookCanMoveHorizontally() {
        Map<BoardPosition, Piece> piecesInPlayOne = emptyBoard.getPiecesInPlay();

        final BoardPosition startingPosition = new BoardPosition(BoardPositionX.A, BoardPositionY.ONE);
        final BoardPosition endingPosition = new BoardPosition(BoardPositionX.G, BoardPositionY.ONE);
        final Piece whiteRook = new Piece(PieceNames.ROOK, PieceTeam.WHITE);

        piecesInPlayOne.put(startingPosition, whiteRook);
        GameState gameStateOne = new ConcreteGameState(new ConcreteBoard().setPiecesInPlay(piecesInPlayOne), 900);

        final boolean resultOne = rookMoveValidator.validate(gameStateOne, startingPosition, endingPosition);
        Assertions.assertThat(resultOne).isTrue();


        final BoardPosition startingPositionTwo = new BoardPosition(BoardPositionX.C, BoardPositionY.THREE);
        final BoardPosition endingPositionTwo = new BoardPosition(BoardPositionX.E, BoardPositionY.THREE);
        final Piece blackRook = new Piece(PieceNames.ROOK, PieceTeam.WHITE);

        Map<BoardPosition, Piece> piecesInPlayTwo = emptyBoard.getPiecesInPlay();

        piecesInPlayTwo.put(startingPositionTwo, blackRook);
        GameState gameStateTwo = new ConcreteGameState(new ConcreteBoard().setPiecesInPlay(piecesInPlayOne), 1);

        final boolean resultTwo = rookMoveValidator.validate(gameStateTwo, startingPositionTwo, endingPositionTwo);
        Assertions.assertThat(resultTwo).isTrue();
    }

    @Test
    public void givenFriendlyPieceInWay_RookCannotMovePast() {
        Map<BoardPosition, Piece> piecesInPlayOne = emptyBoard.getPiecesInPlay();

        final BoardPosition whiteRookStartingPosition = new BoardPosition(BoardPositionX.C, BoardPositionY.THREE);
        final BoardPosition whiteRookEndingPositionLeft = new BoardPosition(BoardPositionX.D, BoardPositionY.THREE);
        final BoardPosition whiteRookEndingPositionRight = new BoardPosition(BoardPositionX.G, BoardPositionY.THREE);
        final BoardPosition whiteRookEndingPositionTop = new BoardPosition(BoardPositionX.C, BoardPositionY.EIGHT);
        final BoardPosition whiteRookEndingPositionDown = new BoardPosition(BoardPositionX.C, BoardPositionY.ONE);

        final BoardPosition oneRankBehindWhiteRook = new BoardPosition(BoardPositionX.C, BoardPositionY.TWO);
        final BoardPosition oneRankFrontWhiteRook = new BoardPosition(BoardPositionX.C, BoardPositionY.FOUR);
        final BoardPosition oneFileRightWhiteRook = new BoardPosition(BoardPositionX.D, BoardPositionY.THREE);
        final BoardPosition oneFileLeftWhiteRook = new BoardPosition(BoardPositionX.B, BoardPositionY.THREE);

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
        GameState gameStateOne = new ConcreteGameState(new ConcreteBoard().setPiecesInPlay(piecesInPlayOne), 99_999);

        final boolean whiteRookCanMovePastWhitePieceBehind = rookMoveValidator.validate(gameStateOne, whiteRookStartingPosition, whiteRookEndingPositionDown);
        final boolean whiteRookCanMovePastWhitePieceInFront = rookMoveValidator.validate(gameStateOne, whiteRookStartingPosition, whiteRookEndingPositionTop);
        final boolean whiteRookCanMovePastWhitePieceToRight = rookMoveValidator.validate(gameStateOne, whiteRookStartingPosition, whiteRookEndingPositionRight);
        final boolean whiteRookCanMovePastWhitePieceToLeft = rookMoveValidator.validate(gameStateOne, whiteRookStartingPosition, whiteRookEndingPositionLeft);

        Assertions.assertThat(whiteRookCanMovePastWhitePieceBehind).isFalse();
        Assertions.assertThat(whiteRookCanMovePastWhitePieceInFront).isFalse();
        Assertions.assertThat(whiteRookCanMovePastWhitePieceToRight).isFalse();
        Assertions.assertThat(whiteRookCanMovePastWhitePieceToLeft).isFalse();

        Map<BoardPosition, Piece> piecesInPlayTwo = emptyBoard.getPiecesInPlay();

        final BoardPosition blackRookStartingPosition = new BoardPosition(BoardPositionX.C, BoardPositionY.THREE);
        final BoardPosition blackRookEndingPositionLeft = new BoardPosition(BoardPositionX.D, BoardPositionY.THREE);
        final BoardPosition blackRookEndingPositionRight = new BoardPosition(BoardPositionX.G, BoardPositionY.THREE);
        final BoardPosition blackRookEndingPositionTop = new BoardPosition(BoardPositionX.C, BoardPositionY.EIGHT);
        final BoardPosition blackRookEndingPositionDown = new BoardPosition(BoardPositionX.C, BoardPositionY.ONE);

        final BoardPosition oneRankBehindBlackRook = new BoardPosition(BoardPositionX.C, BoardPositionY.TWO);
        final BoardPosition oneRankFrontBlackRook = new BoardPosition(BoardPositionX.C, BoardPositionY.FOUR);
        final BoardPosition oneFileRightBlackRook = new BoardPosition(BoardPositionX.D, BoardPositionY.THREE);
        final BoardPosition oneFileLeftBlackRook = new BoardPosition(BoardPositionX.B, BoardPositionY.THREE);

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
        GameState gameStateTwo = new ConcreteGameState(new ConcreteBoard().setPiecesInPlay(piecesInPlayTwo), 3_939);

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
        Map<BoardPosition, Piece> piecesInPlayOne = emptyBoard.getPiecesInPlay();

        final BoardPosition whiteRookStartingPosition = new BoardPosition(BoardPositionX.C, BoardPositionY.THREE);
        final BoardPosition whiteRookEndingPositionLeft = new BoardPosition(BoardPositionX.D, BoardPositionY.THREE);
        final BoardPosition whiteRookEndingPositionRight = new BoardPosition(BoardPositionX.G, BoardPositionY.THREE);
        final BoardPosition whiteRookEndingPositionTop = new BoardPosition(BoardPositionX.C, BoardPositionY.EIGHT);
        final BoardPosition whiteRookEndingPositionDown = new BoardPosition(BoardPositionX.C, BoardPositionY.ONE);

        final BoardPosition oneRankBehindWhiteRook = new BoardPosition(BoardPositionX.C, BoardPositionY.TWO);
        final BoardPosition oneRankFrontWhiteRook = new BoardPosition(BoardPositionX.C, BoardPositionY.FOUR);
        final BoardPosition oneFileRightWhiteRook = new BoardPosition(BoardPositionX.D, BoardPositionY.THREE);
        final BoardPosition oneFileLeftWhiteRook = new BoardPosition(BoardPositionX.B, BoardPositionY.THREE);

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
        GameState gameStateOne = new ConcreteGameState(new ConcreteBoard().setPiecesInPlay(piecesInPlayOne), 99_999);

        final boolean whiteRookCanMovePastWhitePieceBehind = rookMoveValidator.validate(gameStateOne, whiteRookStartingPosition, whiteRookEndingPositionDown);
        final boolean whiteRookCanMovePastWhitePieceInFront = rookMoveValidator.validate(gameStateOne, whiteRookStartingPosition, whiteRookEndingPositionTop);
        final boolean whiteRookCanMovePastWhitePieceToRight = rookMoveValidator.validate(gameStateOne, whiteRookStartingPosition, whiteRookEndingPositionRight);
        final boolean whiteRookCanMovePastWhitePieceToLeft = rookMoveValidator.validate(gameStateOne, whiteRookStartingPosition, whiteRookEndingPositionLeft);

        Assertions.assertThat(whiteRookCanMovePastWhitePieceBehind).isFalse();
        Assertions.assertThat(whiteRookCanMovePastWhitePieceInFront).isFalse();
        Assertions.assertThat(whiteRookCanMovePastWhitePieceToRight).isFalse();
        Assertions.assertThat(whiteRookCanMovePastWhitePieceToLeft).isFalse();

        Map<BoardPosition, Piece> piecesInPlayTwo = emptyBoard.getPiecesInPlay();

        final BoardPosition blackRookStartingPosition = new BoardPosition(BoardPositionX.C, BoardPositionY.THREE);
        final BoardPosition blackRookEndingPositionLeft = new BoardPosition(BoardPositionX.D, BoardPositionY.THREE);
        final BoardPosition blackRookEndingPositionRight = new BoardPosition(BoardPositionX.G, BoardPositionY.THREE);
        final BoardPosition blackRookEndingPositionTop = new BoardPosition(BoardPositionX.C, BoardPositionY.EIGHT);
        final BoardPosition blackRookEndingPositionDown = new BoardPosition(BoardPositionX.C, BoardPositionY.ONE);

        final BoardPosition oneRankBehindBlackRook = new BoardPosition(BoardPositionX.C, BoardPositionY.TWO);
        final BoardPosition oneRankFrontBlackRook = new BoardPosition(BoardPositionX.C, BoardPositionY.FOUR);
        final BoardPosition oneFileRightBlackRook = new BoardPosition(BoardPositionX.D, BoardPositionY.THREE);
        final BoardPosition oneFileLeftBlackRook = new BoardPosition(BoardPositionX.B, BoardPositionY.THREE);

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
        GameState gameStateTwo = new ConcreteGameState(new ConcreteBoard().setPiecesInPlay(piecesInPlayTwo), 3_939);

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
        Map<BoardPosition, Piece> piecesInPlayOne = emptyBoard.getPiecesInPlay();

        final BoardPosition whiteRookStartingPosition = new BoardPosition(BoardPositionX.C, BoardPositionY.FOUR);
        final BoardPosition whiteRookEndingPositionLeft = new BoardPosition(BoardPositionX.A, BoardPositionY.FOUR);
        final BoardPosition whiteRookEndingPositionRight = new BoardPosition(BoardPositionX.H, BoardPositionY.FOUR);
        final BoardPosition whiteRookEndingPositionTop = new BoardPosition(BoardPositionX.C, BoardPositionY.EIGHT);
        final BoardPosition whiteRookEndingPositionDown = new BoardPosition(BoardPositionX.C, BoardPositionY.ONE);

        final BoardPosition oneRankBehindWhiteRook = new BoardPosition(BoardPositionX.C, BoardPositionY.THREE);
        final BoardPosition oneRankFrontWhiteRook = new BoardPosition(BoardPositionX.C, BoardPositionY.FIVE);
        final BoardPosition oneFileRightWhiteRook = new BoardPosition(BoardPositionX.D, BoardPositionY.FOUR);
        final BoardPosition oneFileLeftWhiteRook = new BoardPosition(BoardPositionX.B, BoardPositionY.FOUR);

        final BoardPosition twoRanksBehindWhiteRook = new BoardPosition(BoardPositionX.C, BoardPositionY.ONE);
        final BoardPosition twoRanksFrontWhiteRook = new BoardPosition(BoardPositionX.C, BoardPositionY.FIVE);
        final BoardPosition twoFilesRightWhiteRook = new BoardPosition(BoardPositionX.E, BoardPositionY.FOUR);
        final BoardPosition twoFilesLeftWhiteRook = new BoardPosition(BoardPositionX.A, BoardPositionY.FOUR);

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
        GameState gameStateOne = new ConcreteGameState(new ConcreteBoard().setPiecesInPlay(piecesInPlayOne), 4_812);

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
        Map<BoardPosition, Piece> piecesInPlayOne = emptyBoard.getPiecesInPlay();

        final BoardPosition startingPosition = new BoardPosition(BoardPositionX.A, BoardPositionY.ONE);
        final BoardPosition endingPosition = new BoardPosition(BoardPositionX.G, BoardPositionY.ONE);
        final Piece whiteRook = new Piece(PieceNames.ROOK, PieceTeam.WHITE);
        final Piece whiteKnight = new Piece(PieceNames.KNIGHT, PieceTeam.WHITE);

        piecesInPlayOne.put(startingPosition, whiteRook);
        piecesInPlayOne.put(endingPosition, whiteKnight);
        GameState gameStateOne = new ConcreteGameState(new ConcreteBoard().setPiecesInPlay(piecesInPlayOne), -9_999_999);

        final boolean resultOne = rookMoveValidator.validate(gameStateOne, startingPosition, endingPosition);
        Assertions.assertThat(resultOne).isFalse();


        final BoardPosition startingPositionTwo = new BoardPosition(BoardPositionX.E, BoardPositionY.SIX);
        final BoardPosition endingPositionTwo = new BoardPosition(BoardPositionX.E, BoardPositionY.TWO);
        final Piece blackRook = new Piece(PieceNames.ROOK, PieceTeam.WHITE);
        final Piece blackQueen = new Piece(PieceNames.QUEEN, PieceTeam.BLACK);

        Map<BoardPosition, Piece> piecesInPlayTwo = emptyBoard.getPiecesInPlay();

        piecesInPlayTwo.put(startingPositionTwo, blackRook);
        piecesInPlayOne.put(endingPosition, blackQueen);
        GameState gameStateTwo = new ConcreteGameState(new ConcreteBoard().setPiecesInPlay(piecesInPlayOne), 238_100);

        final boolean resultTwo = rookMoveValidator.validate(gameStateTwo, startingPositionTwo, endingPositionTwo);
        Assertions.assertThat(resultTwo).isFalse();
    }

    @Test
    public void givenEnemyPieceInSpot_RookCanCapture() {

    }

    @Test
    public void whenDesiredPositionIsSamePositionAsCurrent_ThenRookCannotStandStill() {

    }
}
