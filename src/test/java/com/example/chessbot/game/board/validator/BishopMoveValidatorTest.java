package com.example.chessbot.game.board.validator;

import com.example.chessbot.game.state.GameState;
import com.example.chessbot.game.state.GameStateFactory;
import com.example.chessbot.game.state.player.PlayerState;
import com.example.chessbot.game.state.player.PlayerStateFactory;
import com.example.chessbot.game.validation.movement.BishopMoveValidator;
import com.example.chessbot.game.validation.movement.MoveValidator;
import com.example.chessbot.model.board.BoardFactory;
import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.Pair;
import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.piece.PieceNames;
import com.example.chessbot.model.piece.PieceTeam;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class BishopMoveValidatorTest {
    private final MoveValidator bishopMoveValidator = new BishopMoveValidator();

    private Map<BoardPosition, Piece> emptyBoard;
    private Pair<PlayerState, PlayerState> playerStates;

    @BeforeEach()
    public void setupBoard() {
        this.playerStates = new Pair<>(PlayerStateFactory.createInitialPlayerState(PieceTeam.WHITE), PlayerStateFactory.createInitialPlayerState(PieceTeam.BLACK));
        this.emptyBoard = BoardFactory.createEmptyBoard();
    }

    @Test
    public void testGivenNoPiecesOnBoard_BishopCanOnlyMoveDiagonally() {
        final Piece whiteBishop = new Piece(PieceNames.BISHOP, PieceTeam.WHITE);

        Map<BoardPosition, Piece> board = emptyBoard;

        final BoardPosition starting = new BoardPosition(4, 4);
        final BoardPosition one = new BoardPosition(7, 7);
        final BoardPosition two = new BoardPosition(7, 8);
        final BoardPosition three = new BoardPosition(8, 5);
        final BoardPosition four = new BoardPosition(6, 4);
        final BoardPosition five = new BoardPosition(8, 1);
        final BoardPosition six = new BoardPosition(3, 7);
        final BoardPosition seven = new BoardPosition(1, 7);
        final BoardPosition eight = new BoardPosition(8, 8);
        final BoardPosition nine = new BoardPosition(1, 4);

        board.put(starting, whiteBishop);

        GameState gameState = GameStateFactory.createNewGameState(9_999, board, new HashMap<>(), playerStates);

        final boolean result1 = bishopMoveValidator.validate(gameState, starting, one);
        final boolean result2 = bishopMoveValidator.validate(gameState, starting, two);
        final boolean result3 = bishopMoveValidator.validate(gameState, starting, three);
        final boolean result4 = bishopMoveValidator.validate(gameState, starting, four);
        final boolean result5 = bishopMoveValidator.validate(gameState, starting, five);
        final boolean result6 = bishopMoveValidator.validate(gameState, starting, six);
        final boolean result7 = bishopMoveValidator.validate(gameState, starting, seven);
        final boolean result8 = bishopMoveValidator.validate(gameState, starting, eight);
        final boolean result9 = bishopMoveValidator.validate(gameState, starting, nine);

        Assertions.assertThat(result1).isTrue();
        Assertions.assertThat(result2).isFalse();
        Assertions.assertThat(result3).isFalse();
        Assertions.assertThat(result4).isFalse();
        Assertions.assertThat(result5).isFalse();
        Assertions.assertThat(result6).isFalse();
        Assertions.assertThat(result7).isTrue();
        Assertions.assertThat(result8).isTrue();
        Assertions.assertThat(result9).isFalse();
    }

    @Test
    public void testGivenNoPiecesInPath_BishopCanMoveDiagonally() {
        final Piece whiteBishop = new Piece(PieceNames.BISHOP, PieceTeam.WHITE);
        final Piece blackBishop = new Piece(PieceNames.BISHOP, PieceTeam.BLACK);

        Map<BoardPosition, Piece> boardOne = emptyBoard;

        final BoardPosition startingPosition = new BoardPosition(1, 1);
        final BoardPosition endingPosition = new BoardPosition(6, 6);

        boardOne.put(startingPosition, whiteBishop);
        GameState gameStateOne = GameStateFactory.createNewGameState(1, boardOne, new HashMap<>(), this.playerStates);

        final boolean resultOne = bishopMoveValidator.validate(gameStateOne, startingPosition, endingPosition);
        Assertions.assertThat(resultOne).isTrue();


        final BoardPosition startingPositionTwo = new BoardPosition(8, 4);
        final BoardPosition endingPositionTwo = new BoardPosition(5, 1);

        Map<BoardPosition, Piece> boardTwo = emptyBoard;

        boardTwo.put(startingPositionTwo, whiteBishop);
        GameState gameStateTwo = GameStateFactory.createNewGameState(1, boardTwo, new HashMap<>(), this.playerStates);

        final boolean resultTwo = bishopMoveValidator.validate(gameStateTwo, startingPositionTwo, endingPositionTwo);
        Assertions.assertThat(resultTwo).isTrue();

        Map<BoardPosition, Piece> boardThree = emptyBoard;

        final BoardPosition startingPositionThree = new BoardPosition(5, 3);
        final BoardPosition endingPositionThree = new BoardPosition(7, 1);

        boardOne.put(startingPosition, blackBishop);
        GameState gameStateThree = GameStateFactory.createNewGameState(1, boardThree, new HashMap<>(), this.playerStates);

        final boolean resultThree = bishopMoveValidator.validate(gameStateThree, startingPositionThree, endingPositionThree);
        Assertions.assertThat(resultThree).isTrue();


        final BoardPosition startingPositionFour = new BoardPosition(6, 3);
        final BoardPosition endingPositionFour = new BoardPosition(2, 7);

        Map<BoardPosition, Piece> boardFour = emptyBoard;

        boardTwo.put(startingPositionTwo, blackBishop);
        GameState gameStateFour = GameStateFactory.createNewGameState(1, boardFour, new HashMap<>(), this.playerStates);

        final boolean resultFour = bishopMoveValidator.validate(gameStateFour, startingPositionFour, endingPositionFour);
        Assertions.assertThat(resultFour).isTrue();
    }

    @Test
    public void givenFriendlyPieceInWay_BishopCannotMovePast() {
        Map<BoardPosition, Piece> boardOne = emptyBoard;

        final BoardPosition whiteBishopStartingPosition = new BoardPosition(3, 3);
        final BoardPosition whiteBishopEndingPositionUpLeft = new BoardPosition(1, 5);
        final BoardPosition whiteBishopEndingPositionDownLeft = new BoardPosition(1, 1);
        final BoardPosition whiteBishopEndingPositionUpRight = new BoardPosition(6, 6);
        final BoardPosition whiteBishopEndingPositionDownRight = new BoardPosition(5, 1);

        final BoardPosition upLeftFromStarting = new BoardPosition(2, 4);
        final BoardPosition downLeftFromStarting = new BoardPosition(2, 2);
        final BoardPosition upRightFromStarting = new BoardPosition(4, 4);
        final BoardPosition downRightFromStarting = new BoardPosition(4, 2);

        final Piece whiteBishop = new Piece(PieceNames.BISHOP, PieceTeam.WHITE);
        final Piece whiteRook = new Piece(PieceNames.ROOK, PieceTeam.WHITE);
        final Piece whiteKing = new Piece(PieceNames.KING, PieceTeam.WHITE);
        final Piece whitePawn = new Piece(PieceNames.PAWN, PieceTeam.WHITE);
        final Piece whiteQueen = new Piece(PieceNames.QUEEN, PieceTeam.WHITE);

        boardOne.put(whiteBishopStartingPosition, whiteBishop);
        boardOne.put(upLeftFromStarting, whiteRook);
        boardOne.put(downLeftFromStarting, whitePawn);
        boardOne.put(upRightFromStarting, whiteKing);
        boardOne.put(downRightFromStarting, whiteQueen);
        GameState gameStateOne = GameStateFactory.createNewGameState(1, boardOne, new HashMap<>(), this.playerStates);

        final boolean whiteBishopCanMovePastWhitePieceBehind = bishopMoveValidator.validate(gameStateOne, whiteBishopStartingPosition, whiteBishopEndingPositionDownRight);
        final boolean whiteBishopCanMovePastWhitePieceInFront = bishopMoveValidator.validate(gameStateOne, whiteBishopStartingPosition, whiteBishopEndingPositionUpRight);
        final boolean whiteBishopCanMovePastWhitePieceToRight = bishopMoveValidator.validate(gameStateOne, whiteBishopStartingPosition, whiteBishopEndingPositionDownLeft);
        final boolean whiteBishopCanMovePastWhitePieceToLeft = bishopMoveValidator.validate(gameStateOne, whiteBishopStartingPosition, whiteBishopEndingPositionUpLeft);

        Assertions.assertThat(whiteBishopCanMovePastWhitePieceBehind).isFalse();
        Assertions.assertThat(whiteBishopCanMovePastWhitePieceInFront).isFalse();
        Assertions.assertThat(whiteBishopCanMovePastWhitePieceToRight).isFalse();
        Assertions.assertThat(whiteBishopCanMovePastWhitePieceToLeft).isFalse();

        Map<BoardPosition, Piece> boardTwo = emptyBoard;

        final BoardPosition blackBishopStartingPosition = new BoardPosition(5, 5);
        final BoardPosition blackBishopEndingPositionUpLeft = new BoardPosition(2, 8);
        final BoardPosition blackBishopEndingPositionDownLeft = new BoardPosition(1, 1);
        final BoardPosition blackBishopEndingPositionUpRight = new BoardPosition(8, 8);
        final BoardPosition blackBishopEndingPositionDownRight = new BoardPosition(7, 3);

        final BoardPosition upLeftFromStartingTwo = new BoardPosition(4, 6);
        final BoardPosition downLeftFromStartingTwo = new BoardPosition(4, 4);
        final BoardPosition upRightFromStartingTwo = new BoardPosition(6, 6);
        final BoardPosition downRightFromStartingTwo = new BoardPosition(6, 4);

        final Piece blackBishop = new Piece(PieceNames.BISHOP, PieceTeam.BLACK);
        final Piece blackRook = new Piece(PieceNames.ROOK, PieceTeam.BLACK);
        final Piece blackKing = new Piece(PieceNames.KING, PieceTeam.BLACK);
        final Piece blackPawn = new Piece(PieceNames.PAWN, PieceTeam.BLACK);
        final Piece blackQueen = new Piece(PieceNames.QUEEN, PieceTeam.BLACK);

        boardTwo.put(blackBishopStartingPosition, blackBishop);
        boardTwo.put(upLeftFromStartingTwo, blackRook);
        boardTwo.put(downLeftFromStartingTwo, blackPawn);
        boardTwo.put(upRightFromStartingTwo, blackKing);
        boardTwo.put(downRightFromStartingTwo, blackQueen);
        GameState gameStateTwo = GameStateFactory.createNewGameState(1, boardTwo, new HashMap<>(), this.playerStates);

        final boolean blackRookCanMovePastBlackPieceBehind = bishopMoveValidator.validate(gameStateTwo, blackBishopStartingPosition, blackBishopEndingPositionUpLeft);
        final boolean blackRookCanMovePastBlackPieceInFront = bishopMoveValidator.validate(gameStateTwo, blackBishopStartingPosition, blackBishopEndingPositionDownLeft);
        final boolean blackRookCanMovePastBlackPieceToRight = bishopMoveValidator.validate(gameStateTwo, blackBishopStartingPosition, blackBishopEndingPositionUpRight);
        final boolean blackRookCanMovePastBlackPieceToLeft = bishopMoveValidator.validate(gameStateTwo, blackBishopStartingPosition, blackBishopEndingPositionDownRight);

        Assertions.assertThat(blackRookCanMovePastBlackPieceBehind).isFalse();
        Assertions.assertThat(blackRookCanMovePastBlackPieceInFront).isFalse();
        Assertions.assertThat(blackRookCanMovePastBlackPieceToRight).isFalse();
        Assertions.assertThat(blackRookCanMovePastBlackPieceToLeft).isFalse();
    }

    @Test
    public void testGivenPiecesInPath_AndEnemyInDesiredSpot_WhenBishopTriesCapture_ThenMoveIsInvalid() {
        Map<BoardPosition, Piece> boardOne = emptyBoard;

        final BoardPosition whiteBishopStartingPosition = new BoardPosition(3, 3);
        final BoardPosition whiteBishopEndingPositionUpLeft = new BoardPosition(1, 5);
        final BoardPosition whiteBishopEndingPositionDownLeft = new BoardPosition(1, 1);
        final BoardPosition whiteBishopEndingPositionUpRight = new BoardPosition(6, 6);
        final BoardPosition whiteBishopEndingPositionDownRight = new BoardPosition(5, 1);

        final BoardPosition upLeftFromStarting = new BoardPosition(2, 4);
        final BoardPosition downLeftFromStarting = new BoardPosition(2, 2);
        final BoardPosition upRightFromStarting = new BoardPosition(4, 4);
        final BoardPosition downRightFromStarting = new BoardPosition(4, 2);

        final Piece whiteBishop = new Piece(PieceNames.BISHOP, PieceTeam.WHITE);
        final Piece whiteRook = new Piece(PieceNames.ROOK, PieceTeam.WHITE);
        final Piece whiteKing = new Piece(PieceNames.KING, PieceTeam.WHITE);
        final Piece whitePawn = new Piece(PieceNames.PAWN, PieceTeam.WHITE);
        final Piece whiteQueen = new Piece(PieceNames.QUEEN, PieceTeam.WHITE);
        final Piece blackKnight = new Piece(PieceNames.QUEEN, PieceTeam.BLACK);

        boardOne.put(whiteBishopStartingPosition, whiteBishop);
        boardOne.put(upLeftFromStarting, whiteRook);
        boardOne.put(downLeftFromStarting, whitePawn);
        boardOne.put(upRightFromStarting, whiteKing);
        boardOne.put(downRightFromStarting, whiteQueen);
        boardOne.put(whiteBishopEndingPositionUpLeft, blackKnight);
        boardOne.put(whiteBishopEndingPositionDownLeft, blackKnight);
        boardOne.put(whiteBishopEndingPositionUpRight, blackKnight);
        boardOne.put(whiteBishopEndingPositionDownRight, blackKnight);
        GameState gameStateOne = GameStateFactory.createNewGameState(1, boardOne, new HashMap<>(), this.playerStates);

        final boolean whiteBishopCanMovePastWhitePieceBehind = bishopMoveValidator.validate(gameStateOne, whiteBishopStartingPosition, whiteBishopEndingPositionDownRight);
        final boolean whiteBishopCanMovePastWhitePieceInFront = bishopMoveValidator.validate(gameStateOne, whiteBishopStartingPosition, whiteBishopEndingPositionUpRight);
        final boolean whiteBishopCanMovePastWhitePieceToRight = bishopMoveValidator.validate(gameStateOne, whiteBishopStartingPosition, whiteBishopEndingPositionDownLeft);
        final boolean whiteBishopCanMovePastWhitePieceToLeft = bishopMoveValidator.validate(gameStateOne, whiteBishopStartingPosition, whiteBishopEndingPositionUpLeft);

        Assertions.assertThat(whiteBishopCanMovePastWhitePieceBehind).isFalse();
        Assertions.assertThat(whiteBishopCanMovePastWhitePieceInFront).isFalse();
        Assertions.assertThat(whiteBishopCanMovePastWhitePieceToRight).isFalse();
        Assertions.assertThat(whiteBishopCanMovePastWhitePieceToLeft).isFalse();

        Map<BoardPosition, Piece> boardTwo = emptyBoard;

        final BoardPosition blackBishopStartingPosition = new BoardPosition(5, 5);
        final BoardPosition blackBishopEndingPositionUpLeft = new BoardPosition(2, 8);
        final BoardPosition blackBishopEndingPositionDownLeft = new BoardPosition(1, 1);
        final BoardPosition blackBishopEndingPositionUpRight = new BoardPosition(8, 8);
        final BoardPosition blackBishopEndingPositionDownRight = new BoardPosition(7, 3);

        final BoardPosition upLeftFromStartingTwo = new BoardPosition(4, 6);
        final BoardPosition downLeftFromStartingTwo = new BoardPosition(4, 4);
        final BoardPosition upRightFromStartingTwo = new BoardPosition(6, 6);
        final BoardPosition downRightFromStartingTwo = new BoardPosition(6, 4);

        final Piece blackBishop = new Piece(PieceNames.BISHOP, PieceTeam.BLACK);
        final Piece blackRook = new Piece(PieceNames.ROOK, PieceTeam.BLACK);
        final Piece blackKing = new Piece(PieceNames.KING, PieceTeam.BLACK);
        final Piece blackPawn = new Piece(PieceNames.PAWN, PieceTeam.BLACK);
        final Piece blackQueen = new Piece(PieceNames.QUEEN, PieceTeam.BLACK);

        boardTwo.put(blackBishopStartingPosition, blackBishop);
        boardTwo.put(upLeftFromStartingTwo, blackRook);
        boardTwo.put(downLeftFromStartingTwo, blackPawn);
        boardTwo.put(upRightFromStartingTwo, blackKing);
        boardTwo.put(downRightFromStartingTwo, blackQueen);
        GameState gameStateTwo = GameStateFactory.createNewGameState(1, boardTwo, new HashMap<>(), this.playerStates);

        final boolean blackRookCanMovePastBlackPieceBehind = bishopMoveValidator.validate(gameStateTwo, blackBishopStartingPosition, blackBishopEndingPositionUpLeft);
        final boolean blackRookCanMovePastBlackPieceInFront = bishopMoveValidator.validate(gameStateTwo, blackBishopStartingPosition, blackBishopEndingPositionDownLeft);
        final boolean blackRookCanMovePastBlackPieceToRight = bishopMoveValidator.validate(gameStateTwo, blackBishopStartingPosition, blackBishopEndingPositionUpRight);
        final boolean blackRookCanMovePastBlackPieceToLeft = bishopMoveValidator.validate(gameStateTwo, blackBishopStartingPosition, blackBishopEndingPositionDownRight);

        Assertions.assertThat(blackRookCanMovePastBlackPieceBehind).isFalse();
        Assertions.assertThat(blackRookCanMovePastBlackPieceInFront).isFalse();
        Assertions.assertThat(blackRookCanMovePastBlackPieceToRight).isFalse();
        Assertions.assertThat(blackRookCanMovePastBlackPieceToLeft).isFalse();
    }

    @Test
    public void testGivenNoPiecesInWay_BishopCanCaptureEnemy() {
        final Piece whiteBishop = new Piece(PieceNames.BISHOP, PieceTeam.WHITE);
        final Piece whiteKnight = new Piece(PieceNames.KNIGHT, PieceTeam.WHITE);
        final Piece blackBishop = new Piece(PieceNames.BISHOP, PieceTeam.BLACK);
        final Piece blackKnight = new Piece(PieceNames.KNIGHT, PieceTeam.BLACK);

        Map<BoardPosition, Piece> boardOne = emptyBoard;

        final BoardPosition startingPosition = new BoardPosition(1, 1);
        final BoardPosition endingPosition = new BoardPosition(6, 6);

        boardOne.put(startingPosition, whiteBishop);
        boardOne.put(endingPosition, blackKnight);
        GameState gameStateOne = GameStateFactory.createNewGameState(1, boardOne, new HashMap<>(), this.playerStates);

        final boolean resultOne = bishopMoveValidator.validate(gameStateOne, startingPosition, endingPosition);
        Assertions.assertThat(resultOne).isTrue();


        final BoardPosition startingPositionTwo = new BoardPosition(8, 4);
        final BoardPosition endingPositionTwo = new BoardPosition(5, 1);

        Map<BoardPosition, Piece> boardTwo = emptyBoard;

        boardTwo.put(startingPositionTwo, whiteBishop);
        boardTwo.put(endingPositionTwo, blackKnight);
        GameState gameStateTwo = GameStateFactory.createNewGameState(1, boardTwo, new HashMap<>(), this.playerStates);

        final boolean resultTwo = bishopMoveValidator.validate(gameStateTwo, startingPositionTwo, endingPositionTwo);
        Assertions.assertThat(resultTwo).isTrue();

        Map<BoardPosition, Piece> boardThree = emptyBoard;

        final BoardPosition startingPositionThree = new BoardPosition(5, 3);
        final BoardPosition endingPositionThree = new BoardPosition(7, 1);

        boardThree.put(startingPositionThree, blackBishop);
        boardThree.put(endingPositionThree, whiteKnight);
        GameState gameStateThree = GameStateFactory.createNewGameState(1, boardThree, new HashMap<>(), this.playerStates);

        final boolean resultThree = bishopMoveValidator.validate(gameStateThree, startingPositionThree, endingPositionThree);
        Assertions.assertThat(resultThree).isTrue();


        final BoardPosition startingPositionFour = new BoardPosition(6, 3);
        final BoardPosition endingPositionFour = new BoardPosition(2, 7);

        Map<BoardPosition, Piece> boardFour = emptyBoard;

        boardFour.put(startingPositionFour, blackBishop);
        boardFour.put(endingPositionFour, whiteKnight);
        GameState gameStateFour = GameStateFactory.createNewGameState(1, boardFour, new HashMap<>(), this.playerStates);

        final boolean resultFour = bishopMoveValidator.validate(gameStateFour, startingPositionFour, endingPositionFour);
        Assertions.assertThat(resultFour).isTrue();
    }

    @Test
    public void testGivenNoPiecesInWay_BishopCannotCaptureKing() {
        final Piece whiteBishop = new Piece(PieceNames.BISHOP, PieceTeam.WHITE);
        final Piece whiteKing = new Piece(PieceNames.KING, PieceTeam.WHITE);
        final Piece blackBishop = new Piece(PieceNames.BISHOP, PieceTeam.BLACK);
        final Piece blackKing = new Piece(PieceNames.KING, PieceTeam.BLACK);

        Map<BoardPosition, Piece> boardOne = emptyBoard;

        final BoardPosition startingPosition = new BoardPosition(1, 1);
        final BoardPosition endingPosition = new BoardPosition(6, 6);

        boardOne.put(startingPosition, whiteBishop);
        boardOne.put(endingPosition, blackKing);
        GameState gameStateOne = GameStateFactory.createNewGameState(1, boardOne, new HashMap<>(), this.playerStates);

        final boolean resultOne = bishopMoveValidator.validate(gameStateOne, startingPosition, endingPosition);
        Assertions.assertThat(resultOne).isFalse();


        final BoardPosition startingPositionTwo = new BoardPosition(8, 4);
        final BoardPosition endingPositionTwo = new BoardPosition(5, 1);

        Map<BoardPosition, Piece> boardTwo = emptyBoard;

        boardTwo.put(startingPositionTwo, whiteBishop);
        boardTwo.put(endingPositionTwo, blackKing);
        GameState gameStateTwo = GameStateFactory.createNewGameState(1, boardTwo, new HashMap<>(), this.playerStates);

        final boolean resultTwo = bishopMoveValidator.validate(gameStateTwo, startingPositionTwo, endingPositionTwo);
        Assertions.assertThat(resultTwo).isFalse();

        Map<BoardPosition, Piece> boardThree = emptyBoard;

        final BoardPosition startingPositionThree = new BoardPosition(5, 3);
        final BoardPosition endingPositionThree = new BoardPosition(7, 1);

        boardThree.put(startingPositionThree, blackBishop);
        boardThree.put(endingPositionThree, whiteKing);
        GameState gameStateThree = GameStateFactory.createNewGameState(1, boardThree, new HashMap<>(), this.playerStates);

        final boolean resultThree = bishopMoveValidator.validate(gameStateThree, startingPositionThree, endingPositionThree);
        Assertions.assertThat(resultThree).isFalse();


        final BoardPosition startingPositionFour = new BoardPosition(6, 3);
        final BoardPosition endingPositionFour = new BoardPosition(2, 7);

        Map<BoardPosition, Piece> boardFour = emptyBoard;

        boardFour.put(startingPositionFour, blackBishop);
        boardFour.put(endingPositionFour, whiteKing);
        GameState gameStateFour = GameStateFactory.createNewGameState(1, boardFour, new HashMap<>(), this.playerStates);

        final boolean resultFour = bishopMoveValidator.validate(gameStateFour, startingPositionFour, endingPositionFour);
        Assertions.assertThat(resultFour).isFalse();
    }

    @Test
    public void testGivenNoPiecesInWay_BishopCannotCaptureAlly() {
        final Piece whiteBishop = new Piece(PieceNames.BISHOP, PieceTeam.WHITE);
        final Piece whiteKing = new Piece(PieceNames.KING, PieceTeam.WHITE);
        final Piece whitePawn = new Piece(PieceNames.PAWN, PieceTeam.WHITE);
        final Piece blackBishop = new Piece(PieceNames.BISHOP, PieceTeam.BLACK);
        final Piece blackKing = new Piece(PieceNames.KING, PieceTeam.BLACK);
        final Piece blackPawn = new Piece(PieceNames.PAWN, PieceTeam.BLACK);

        Map<BoardPosition, Piece> boardOne = emptyBoard;

        final BoardPosition startingPosition = new BoardPosition(1, 1);
        final BoardPosition endingPosition = new BoardPosition(6, 6);

        boardOne.put(startingPosition, whiteBishop);
        boardOne.put(endingPosition, whiteKing);
        GameState gameStateOne = GameStateFactory.createNewGameState(1, boardOne, new HashMap<>(), this.playerStates);

        final boolean resultOne = bishopMoveValidator.validate(gameStateOne, startingPosition, endingPosition);
        Assertions.assertThat(resultOne).isFalse();


        final BoardPosition startingPositionTwo = new BoardPosition(8, 4);
        final BoardPosition endingPositionTwo = new BoardPosition(5, 1);

        Map<BoardPosition, Piece> boardTwo = emptyBoard;

        boardTwo.put(startingPositionTwo, whiteBishop);
        boardTwo.put(endingPositionTwo, whitePawn);
        GameState gameStateTwo = GameStateFactory.createNewGameState(1, boardTwo, new HashMap<>(), this.playerStates);

        final boolean resultTwo = bishopMoveValidator.validate(gameStateTwo, startingPositionTwo, endingPositionTwo);
        Assertions.assertThat(resultTwo).isFalse();

        Map<BoardPosition, Piece> boardThree = emptyBoard;

        final BoardPosition startingPositionThree = new BoardPosition(5, 3);
        final BoardPosition endingPositionThree = new BoardPosition(7, 1);

        boardThree.put(startingPositionThree, blackBishop);
        boardThree.put(endingPositionThree, blackKing);
        GameState gameStateThree = GameStateFactory.createNewGameState(1, boardThree, new HashMap<>(), this.playerStates);

        final boolean resultThree = bishopMoveValidator.validate(gameStateThree, startingPositionThree, endingPositionThree);
        Assertions.assertThat(resultThree).isFalse();


        final BoardPosition startingPositionFour = new BoardPosition(6, 3);
        final BoardPosition endingPositionFour = new BoardPosition(2, 7);

        Map<BoardPosition, Piece> boardFour = emptyBoard;

        boardFour.put(startingPositionFour, blackBishop);
        boardFour.put(endingPositionFour, blackPawn);
        GameState gameStateFour = GameStateFactory.createNewGameState(1, boardFour, new HashMap<>(), this.playerStates);

        final boolean resultFour = bishopMoveValidator.validate(gameStateFour, startingPositionFour, endingPositionFour);
        Assertions.assertThat(resultFour).isFalse();
    }
}
