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
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class RookMoveValidatorTest {
    private final RookMoveValidator rookMoveValidator = new RookMoveValidator();

    private Map<BoardPosition, Piece> emptyBoard;
    private Pair<PlayerState, PlayerState> playerStates;

    @BeforeEach()
    public void setupBoard() {
        this.playerStates = new Pair<>(PlayerStateFactory.createInitialPlayerState(PieceTeam.WHITE), PlayerStateFactory.createInitialPlayerState(PieceTeam.BLACK));
        this.emptyBoard = BoardFactory.createEmptyBoard();
    }

    @Test
    public void givenNoPiecesInWay_RookCanMoveVertically() {
        Map<BoardPosition, Piece> boardOne = emptyBoard;

        final BoardPosition startingPosition = new BoardPosition(1, 1);
        final BoardPosition endingPosition = new BoardPosition(1, 5);
        final Piece whiteRook = new Piece(PieceNames.ROOK, PieceTeam.WHITE);

        boardOne.put(startingPosition, whiteRook);
        GameState gameStateOne = GameStateFactory.createNewGameState(1, boardOne, List.of(), this.playerStates);

        final boolean resultOne = rookMoveValidator.validate(gameStateOne, startingPosition, endingPosition);
        Assertions.assertThat(resultOne).isTrue();


        final BoardPosition startingPositionTwo = new BoardPosition(8, 7);
        final BoardPosition endingPositionTwo = new BoardPosition(8, 1);

        Map<BoardPosition, Piece> boardTwo = emptyBoard;

        boardTwo.put(startingPositionTwo, whiteRook);
        GameState gameStateTwo = GameStateFactory.createNewGameState(1, boardTwo, List.of(), this.playerStates);

        final boolean resultTwo = rookMoveValidator.validate(gameStateTwo, startingPositionTwo, endingPositionTwo);
        Assertions.assertThat(resultTwo).isTrue();
    }

    @Test
    public void givenNoPiecesInWay_RookCanMoveHorizontally() {
        Map<BoardPosition, Piece> boardOne = emptyBoard;

        final BoardPosition startingPosition = new BoardPosition(1, 1);
        final BoardPosition endingPosition = new BoardPosition(7, 1);
        final Piece whiteRook = new Piece(PieceNames.ROOK, PieceTeam.WHITE);

        boardOne.put(startingPosition, whiteRook);
        GameState gameStateOne = GameStateFactory.createNewGameState(1, boardOne, List.of(), this.playerStates);

        final boolean resultOne = rookMoveValidator.validate(gameStateOne, startingPosition, endingPosition);
        Assertions.assertThat(resultOne).isTrue();


        final BoardPosition startingPositionTwo = new BoardPosition(3, 3);
        final BoardPosition endingPositionTwo = new BoardPosition(5, 3);
        final Piece blackRook = new Piece(PieceNames.ROOK, PieceTeam.BLACK);

        Map<BoardPosition, Piece> boardTwo = emptyBoard;

        boardTwo.put(startingPositionTwo, blackRook);
        GameState gameStateTwo = GameStateFactory.createNewGameState(1, boardTwo, List.of(), this.playerStates);

        final boolean resultTwo = rookMoveValidator.validate(gameStateTwo, startingPositionTwo, endingPositionTwo);
        Assertions.assertThat(resultTwo).isTrue();
    }

    @Test
    public void givenFriendlyPieceInWay_RookCannotMovePast() {
        Map<BoardPosition, Piece> boardOne = emptyBoard;

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

        boardOne.put(whiteRookStartingPosition, whiteRook);
        boardOne.put(oneRankBehindWhiteRook, whiteBishop);
        boardOne.put(oneRankFrontWhiteRook, whitePawn);
        boardOne.put(oneFileRightWhiteRook, whiteKing);
        boardOne.put(oneFileLeftWhiteRook, whiteRookTwo);
        GameState gameStateOne = GameStateFactory.createNewGameState(1, boardOne, List.of(), this.playerStates);

        final boolean whiteRookCanMovePastWhitePieceBehind = rookMoveValidator.validate(gameStateOne, whiteRookStartingPosition, whiteRookEndingPositionDown);
        final boolean whiteRookCanMovePastWhitePieceInFront = rookMoveValidator.validate(gameStateOne, whiteRookStartingPosition, whiteRookEndingPositionTop);
        final boolean whiteRookCanMovePastWhitePieceToRight = rookMoveValidator.validate(gameStateOne, whiteRookStartingPosition, whiteRookEndingPositionRight);
        final boolean whiteRookCanMovePastWhitePieceToLeft = rookMoveValidator.validate(gameStateOne, whiteRookStartingPosition, whiteRookEndingPositionLeft);

        Assertions.assertThat(whiteRookCanMovePastWhitePieceBehind).isFalse();
        Assertions.assertThat(whiteRookCanMovePastWhitePieceInFront).isFalse();
        Assertions.assertThat(whiteRookCanMovePastWhitePieceToRight).isFalse();
        Assertions.assertThat(whiteRookCanMovePastWhitePieceToLeft).isFalse();

        Map<BoardPosition, Piece> boardTwo = emptyBoard;

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

        boardTwo.put(blackRookStartingPosition, blackRook);
        boardTwo.put(oneRankBehindBlackRook, blackBishop);
        boardTwo.put(oneRankFrontBlackRook, blackPawn);
        boardTwo.put(oneFileRightBlackRook, blackKing);
        boardTwo.put(oneFileLeftBlackRook, blackRookTwo);
        GameState gameStateTwo = GameStateFactory.createNewGameState(1, boardTwo, List.of(), this.playerStates);

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
        Map<BoardPosition, Piece> boardOne = emptyBoard;

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

        boardOne.put(whiteRookStartingPosition, blackRook);
        boardOne.put(oneRankBehindWhiteRook, blackBishop);
        boardOne.put(oneRankFrontWhiteRook, blackPawn);
        boardOne.put(oneFileRightWhiteRook, blackKing);
        boardOne.put(oneFileLeftWhiteRook, blackRookTwo);
        GameState gameStateOne = GameStateFactory.createNewGameState(1, boardOne, List.of(), this.playerStates);

        final boolean whiteRookCanMovePastWhitePieceBehind = rookMoveValidator.validate(gameStateOne, whiteRookStartingPosition, whiteRookEndingPositionDown);
        final boolean whiteRookCanMovePastWhitePieceInFront = rookMoveValidator.validate(gameStateOne, whiteRookStartingPosition, whiteRookEndingPositionTop);
        final boolean whiteRookCanMovePastWhitePieceToRight = rookMoveValidator.validate(gameStateOne, whiteRookStartingPosition, whiteRookEndingPositionRight);
        final boolean whiteRookCanMovePastWhitePieceToLeft = rookMoveValidator.validate(gameStateOne, whiteRookStartingPosition, whiteRookEndingPositionLeft);

        Assertions.assertThat(whiteRookCanMovePastWhitePieceBehind).isFalse();
        Assertions.assertThat(whiteRookCanMovePastWhitePieceInFront).isFalse();
        Assertions.assertThat(whiteRookCanMovePastWhitePieceToRight).isFalse();
        Assertions.assertThat(whiteRookCanMovePastWhitePieceToLeft).isFalse();

        Map<BoardPosition, Piece> boardTwo = emptyBoard;

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

        boardTwo.put(blackRookStartingPosition, whiteRook);
        boardTwo.put(oneRankBehindBlackRook, whiteBishop);
        boardTwo.put(oneRankFrontBlackRook, whiteKing);
        boardTwo.put(oneFileRightBlackRook, whitePawn);
        boardTwo.put(oneFileLeftBlackRook, whiteRookTwo);
        GameState gameStateTwo = GameStateFactory.createNewGameState(1, boardTwo, List.of(), this.playerStates);

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
        Map<BoardPosition, Piece> boardOne = emptyBoard;

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

        boardOne.put(whiteRookStartingPosition, whiteRook);
        boardOne.put(oneRankBehindWhiteRook, whiteBishop);
        boardOne.put(oneRankFrontWhiteRook, whiteKing);
        boardOne.put(oneFileRightWhiteRook, whitePawn);
        boardOne.put(oneFileLeftWhiteRook, whiteRookTwo);
        boardOne.put(twoRanksFrontWhiteRook, whiteBishopTwo);
        boardOne.put(twoRanksBehindWhiteRook, whiteKingTwo);
        boardOne.put(twoFilesRightWhiteRook, whitePawnTwo);
        boardOne.put(twoFilesLeftWhiteRook, whiteQueen);


        GameState gameStateOne = GameStateFactory.createNewGameState(1, boardOne, List.of(), this.playerStates);

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
        Map<BoardPosition, Piece> boardOne = emptyBoard;

        final BoardPosition startingPosition = new BoardPosition(1, 1);
        final BoardPosition endingPosition = new BoardPosition(7, 1);
        final Piece whiteRook = new Piece(PieceNames.ROOK, PieceTeam.WHITE);
        final Piece whiteKnight = new Piece(PieceNames.KNIGHT, PieceTeam.WHITE);

        boardOne.put(startingPosition, whiteRook);
        boardOne.put(endingPosition, whiteKnight);

        Assertions.assertThat(boardOne.size()).isEqualTo(64);
        GameState gameStateOne = GameStateFactory.createNewGameState(1, boardOne, List.of(), this.playerStates);

        final boolean resultOne = rookMoveValidator.validate(gameStateOne, startingPosition, endingPosition);
        Assertions.assertThat(resultOne).isFalse();


        final BoardPosition startingPositionTwo = new BoardPosition(5, 6);
        final BoardPosition endingPositionTwo = new BoardPosition(5, 2);
        final Piece blackRook = new Piece(PieceNames.ROOK, PieceTeam.BLACK);
        final Piece blackQueen = new Piece(PieceNames.QUEEN, PieceTeam.BLACK);

        Map<BoardPosition, Piece> boardTwo = emptyBoard;
        boardTwo.put(startingPositionTwo, blackRook);
        boardTwo.put(endingPositionTwo, blackQueen);
        GameState gameStateTwo = GameStateFactory.createNewGameState(1, boardTwo, List.of(), this.playerStates);

        final boolean resultTwo = rookMoveValidator.validate(gameStateTwo, startingPositionTwo, endingPositionTwo);
        Assertions.assertThat(resultTwo).isFalse();
    }

    @Test
    public void givenEnemyPieceInSpot_RookCanCapture() {
        Map<BoardPosition, Piece> boardOne = emptyBoard;

        final BoardPosition startingPosition = new BoardPosition(1, 1);
        final BoardPosition endingPosition = new BoardPosition(3, 1);
        final Piece whiteRook = new Piece(PieceNames.ROOK, PieceTeam.WHITE);
        final Piece blackKing = new Piece(PieceNames.KNIGHT, PieceTeam.BLACK);

        boardOne.put(startingPosition, whiteRook);
        boardOne.put(endingPosition, blackKing);
        GameState gameStateOne = GameStateFactory.createNewGameState(1, boardOne, List.of(), this.playerStates);

        final boolean resultOne = rookMoveValidator.validate(gameStateOne, startingPosition, endingPosition);
        Assertions.assertThat(resultOne).isTrue();


        final BoardPosition startingPositionTwo = new BoardPosition(3, 8);
        final BoardPosition endingPositionTwo = new BoardPosition(3, 4);
        final Piece blackRook = new Piece(PieceNames.ROOK, PieceTeam.BLACK);
        final Piece whiteKing = new Piece(PieceNames.BISHOP, PieceTeam.WHITE);

        Map<BoardPosition, Piece> boardTwo = emptyBoard;

        boardTwo.put(startingPositionTwo, blackRook);
        boardTwo.put(endingPositionTwo, whiteKing);
        GameState gameStateTwo = GameStateFactory.createNewGameState(1, boardTwo, List.of(), this.playerStates);

        final boolean resultTwo = rookMoveValidator.validate(gameStateTwo, startingPositionTwo, endingPositionTwo);
        Assertions.assertThat(resultTwo).isTrue();
    }

    @Test
    public void givenKingInSpot_RookCannotCapture() {
        Map<BoardPosition, Piece> boardOne = emptyBoard;

        final BoardPosition startingPosition = new BoardPosition(1, 1);
        final BoardPosition endingPosition = new BoardPosition(3, 1);
        final Piece whiteRook = new Piece(PieceNames.ROOK, PieceTeam.WHITE);
        final Piece blackKing = new Piece(PieceNames.KING, PieceTeam.BLACK);

        boardOne.put(startingPosition, whiteRook);
        boardOne.put(endingPosition, blackKing);
        GameState gameStateOne = GameStateFactory.createNewGameState(1, boardOne, List.of(), this.playerStates);

        final boolean resultOne = rookMoveValidator.validate(gameStateOne, startingPosition, endingPosition);
        Assertions.assertThat(resultOne).isFalse();


        final BoardPosition startingPositionTwo = new BoardPosition(3, 8);
        final BoardPosition endingPositionTwo = new BoardPosition(3, 4);
        final Piece blackRook = new Piece(PieceNames.ROOK, PieceTeam.BLACK);
        final Piece whiteKing = new Piece(PieceNames.KING, PieceTeam.WHITE);

        Map<BoardPosition, Piece> boardTwo = emptyBoard;

        boardTwo.put(startingPositionTwo, blackRook);
        boardTwo.put(endingPositionTwo, whiteKing);
        GameState gameStateTwo = GameStateFactory.createNewGameState(1, boardTwo, List.of(), this.playerStates);

        final boolean resultTwo = rookMoveValidator.validate(gameStateTwo, startingPositionTwo, endingPositionTwo);
        Assertions.assertThat(resultTwo).isFalse();
    }

    @Test
    public void testGivenPiecesInPath_AndEnemyInDesiredSpot_WhenRookTriesCapture_ThenMoveIsInvalid() {
        Map<BoardPosition, Piece> boardOne = emptyBoard;

        final BoardPosition whiteRookStartingPosition = new BoardPosition(5, 3);
        final BoardPosition whiteRookEndingLeft = new BoardPosition(2, 3);
        final BoardPosition whiteRookEndingDown = new BoardPosition(5, 1);
        final BoardPosition whiteRookEndingRight = new BoardPosition(7, 3);
        final BoardPosition whiteRookEndingUp = new BoardPosition(5, 8);

        final BoardPosition left = new BoardPosition(3, 3);
        final BoardPosition down = new BoardPosition(5, 2);
        final BoardPosition right = new BoardPosition(6, 3);
        final BoardPosition up = new BoardPosition(5, 7);

        final Piece whiteRook = new Piece(PieceNames.ROOK, PieceTeam.WHITE);     
        final Piece whiteBishop = new Piece(PieceNames.BISHOP, PieceTeam.WHITE);
        final Piece whiteKing = new Piece(PieceNames.KING, PieceTeam.WHITE);
        final Piece whitePawn = new Piece(PieceNames.PAWN, PieceTeam.WHITE);
        final Piece whiteQueen = new Piece(PieceNames.QUEEN, PieceTeam.WHITE);
        final Piece blackKnight = new Piece(PieceNames.QUEEN, PieceTeam.BLACK);

        boardOne.put(whiteRookStartingPosition, whiteRook);
        boardOne.put(left, whiteBishop);
        boardOne.put(down, whitePawn);
        boardOne.put(right, whiteKing);
        boardOne.put(up, whiteQueen);
        boardOne.put(whiteRookEndingLeft, blackKnight);
        boardOne.put(whiteRookEndingDown, blackKnight);
        boardOne.put(whiteRookEndingRight, blackKnight);
        boardOne.put(whiteRookEndingUp, blackKnight);
        GameState gameStateOne = GameStateFactory.createNewGameState(1, boardOne, List.of(), this.playerStates);

        final boolean whiteRookCanMovePastWhitePieceLeft = rookMoveValidator.validate(gameStateOne, whiteRookStartingPosition, whiteRookEndingLeft);
        final boolean whiteRookCanMovePastWhitePieceDown = rookMoveValidator.validate(gameStateOne, whiteRookStartingPosition, whiteRookEndingDown);
        final boolean whiteRookCanMovePastWhitePieceRight = rookMoveValidator.validate(gameStateOne, whiteRookStartingPosition, whiteRookEndingRight);
        final boolean whiteRookCanMovePastWhitePieceUp = rookMoveValidator.validate(gameStateOne, whiteRookStartingPosition, whiteRookEndingUp);

        Assertions.assertThat(whiteRookCanMovePastWhitePieceLeft).isFalse();
        Assertions.assertThat(whiteRookCanMovePastWhitePieceDown).isFalse();
        Assertions.assertThat(whiteRookCanMovePastWhitePieceRight).isFalse();
        Assertions.assertThat(whiteRookCanMovePastWhitePieceUp).isFalse();
    }

    @Test
    public void whenDesiredPositionIsSamePositionAsCurrent_ThenRookCannotStandStill() {
        final BoardPosition startingPosition = new BoardPosition(3, 8);
        final Piece blackRook = new Piece(PieceNames.ROOK, PieceTeam.BLACK);

        Map<BoardPosition, Piece> boardOne = emptyBoard;

        boardOne.put(startingPosition, blackRook);
        GameState gameStateOne = GameStateFactory.createNewGameState(1, boardOne, List.of(), this.playerStates);

        final boolean resultOne = rookMoveValidator.validate(gameStateOne, startingPosition, startingPosition);
        Assertions.assertThat(resultOne).isFalse();
    }
}
