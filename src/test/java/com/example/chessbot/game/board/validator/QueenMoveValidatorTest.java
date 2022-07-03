package com.example.chessbot.game.board.validator;

import com.example.chessbot.game.state.GameState;
import com.example.chessbot.game.state.GameStateFactory;
import com.example.chessbot.game.state.player.PlayerState;
import com.example.chessbot.game.state.player.PlayerStateFactory;
import com.example.chessbot.game.validation.movement.QueenMoveValidator;
import com.example.chessbot.model.board.BoardFactory;
import com.example.chessbot.model.board.BoardPosition;
import com.example.chessbot.model.Pair;
import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.piece.PieceNames;
import com.example.chessbot.model.piece.PieceTeam;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class QueenMoveValidatorTest {
    private final QueenMoveValidator queenMoveValidator = new QueenMoveValidator();

    private Map<BoardPosition, Piece> emptyBoard;
    private Pair<PlayerState, PlayerState> playerStates;

    @BeforeEach
    public void setupBoard() {
        this.playerStates = new Pair<>(PlayerStateFactory.createInitialPlayerState(PieceTeam.WHITE), PlayerStateFactory.createInitialPlayerState(PieceTeam.BLACK));
        this.emptyBoard = BoardFactory.createEmptyBoard();
    }

    @Test
    public void givenNoPiecesInWay_QueenCanMoveOmniDirectionally() {
        Map<BoardPosition, Piece> boardOne = emptyBoard;

        final BoardPosition starting = new BoardPosition(5, 5);
        final BoardPosition up = new BoardPosition(5, 8);
        final BoardPosition right = new BoardPosition(8, 5);
        final BoardPosition down = new BoardPosition(5, 2);
        final BoardPosition left = new BoardPosition(1, 5);
        final BoardPosition upRight = new BoardPosition(8, 8);
        final BoardPosition downRight = new BoardPosition(8, 2);
        final BoardPosition downLeft = new BoardPosition(2, 2);
        final BoardPosition upLeft = new BoardPosition(2, 8);


        final Piece whiteQueen = new Piece(PieceNames.QUEEN, PieceTeam.WHITE);

        boardOne.put(starting, whiteQueen);
        GameState gameStateOne = GameStateFactory.createNewGameState(1, boardOne, new HashMap<>(), this.playerStates);

        final boolean result1 = queenMoveValidator.validate(gameStateOne, starting, up);
        final boolean result2 = queenMoveValidator.validate(gameStateOne, starting, right);
        final boolean result3 = queenMoveValidator.validate(gameStateOne, starting, down);
        final boolean result4 = queenMoveValidator.validate(gameStateOne, starting, left);
        final boolean result5 = queenMoveValidator.validate(gameStateOne, starting, upRight);
        final boolean result6 = queenMoveValidator.validate(gameStateOne, starting, downRight);
        final boolean result7 = queenMoveValidator.validate(gameStateOne, starting, downLeft);
        final boolean result8 = queenMoveValidator.validate(gameStateOne, starting, upLeft);

        Assertions.assertThat(result1).isTrue();
        Assertions.assertThat(result2).isTrue();
        Assertions.assertThat(result3).isTrue();
        Assertions.assertThat(result4).isTrue();
        Assertions.assertThat(result5).isTrue();
        Assertions.assertThat(result6).isTrue();
        Assertions.assertThat(result7).isTrue();
        Assertions.assertThat(result8).isTrue();
    }

    @Test
    public void givenNoPiecesInWay_QueenCannotMakeInvalidMove() {
        Map<BoardPosition, Piece> boardOne = emptyBoard;

        final BoardPosition starting = new BoardPosition(5, 5);
        final BoardPosition up = new BoardPosition(4, 1);
        final BoardPosition right = new BoardPosition(4, 7);
        final BoardPosition down = new BoardPosition(6, 2);
        final BoardPosition left = new BoardPosition(7, 8);
        final BoardPosition upRight = new BoardPosition(2, 3);
        final BoardPosition downRight = new BoardPosition(1, 6);
        final BoardPosition downLeft = new BoardPosition(3, 4);
        final BoardPosition upLeft = new BoardPosition(2, 4);


        final Piece whiteQueen = new Piece(PieceNames.QUEEN, PieceTeam.WHITE);

        boardOne.put(starting, whiteQueen);
        GameState gameStateOne = GameStateFactory.createNewGameState(1, boardOne,new HashMap<>(), this.playerStates);

        final boolean result1 = queenMoveValidator.validate(gameStateOne, starting, up);
        final boolean result2 = queenMoveValidator.validate(gameStateOne, starting, right);
        final boolean result3 = queenMoveValidator.validate(gameStateOne, starting, down);
        final boolean result4 = queenMoveValidator.validate(gameStateOne, starting, left);
        final boolean result5 = queenMoveValidator.validate(gameStateOne, starting, upRight);
        final boolean result6 = queenMoveValidator.validate(gameStateOne, starting, downRight);
        final boolean result7 = queenMoveValidator.validate(gameStateOne, starting, downLeft);
        final boolean result8 = queenMoveValidator.validate(gameStateOne, starting, upLeft);

        Assertions.assertThat(result1).isFalse();
        Assertions.assertThat(result2).isFalse();
        Assertions.assertThat(result3).isFalse();
        Assertions.assertThat(result4).isFalse();
        Assertions.assertThat(result5).isFalse();
        Assertions.assertThat(result6).isFalse();
        Assertions.assertThat(result7).isFalse();
        Assertions.assertThat(result8).isFalse();
    }

    @Test
    public void givenPiecesInWay_QueenCannotMovePast() {
        Map<BoardPosition, Piece> boardOne = emptyBoard;

        final BoardPosition starting = new BoardPosition(3, 3);
        final BoardPosition endLeft = new BoardPosition(1, 3);
        final BoardPosition endTopLeft = new BoardPosition(1, 5);
        final BoardPosition endDownLeft = new BoardPosition(1, 1);
        final BoardPosition endRight = new BoardPosition(7, 3);
        final BoardPosition endTopRight = new BoardPosition(7, 7);
        final BoardPosition endDownRight = new BoardPosition(5, 1);
        final BoardPosition endUp = new BoardPosition(3, 8);
        final BoardPosition endDown = new BoardPosition(3, 1);

        final BoardPosition down = new BoardPosition(3, 2);
        final BoardPosition downRight = new BoardPosition(4, 2);
        final BoardPosition downLeft = new BoardPosition(2, 2);
        final BoardPosition up = new BoardPosition(3, 4);
        final BoardPosition upRight = new BoardPosition(4, 4);
        final BoardPosition upLeft = new BoardPosition(2, 4);
        final BoardPosition right = new BoardPosition(4, 3);
        final BoardPosition left = new BoardPosition(2, 3);

        final Piece whiteQueen = new Piece(PieceNames.QUEEN, PieceTeam.WHITE);
        final Piece whiteBishop = new Piece(PieceNames.BISHOP, PieceTeam.WHITE);
        final Piece whiteKing = new Piece(PieceNames.KING, PieceTeam.WHITE);
        final Piece whitePawn = new Piece(PieceNames.PAWN, PieceTeam.WHITE);
        final Piece whiteRook = new Piece(PieceNames.ROOK, PieceTeam.WHITE);
        final Piece blackKnight = new Piece(PieceNames.KNIGHT, PieceTeam.BLACK);
        final Piece blackPawn = new Piece(PieceNames.PAWN, PieceTeam.BLACK);
        final Piece blackKing = new Piece(PieceNames.KING, PieceTeam.BLACK);
        final Piece blackQueen = new Piece(PieceNames.QUEEN, PieceTeam.BLACK);

        boardOne.put(starting, whiteQueen);
        boardOne.put(down, whiteBishop);
        boardOne.put(downRight, blackKnight);
        boardOne.put(downLeft, blackPawn);
        boardOne.put(up, whitePawn);
        boardOne.put(upRight, blackKing);
        boardOne.put(upLeft, blackQueen);
        boardOne.put(right, whiteKing);
        boardOne.put(left, whiteRook);
        GameState gameStateOne = GameStateFactory.createNewGameState(1, boardOne, new HashMap<>(), this.playerStates);

        final boolean whiteQueenCanMovePastPieceDown = queenMoveValidator.validate(gameStateOne, starting, endDown);
        final boolean whiteQueenCanMovePastPieceUp = queenMoveValidator.validate(gameStateOne, starting, endUp);
        final boolean whiteQueenCanMovePastPieceRight = queenMoveValidator.validate(gameStateOne, starting, endRight);
        final boolean whiteQueenCanMovePastPieceLeft = queenMoveValidator.validate(gameStateOne, starting, endLeft);
        final boolean whiteQueenCanMovePastPieceUpRight = queenMoveValidator.validate(gameStateOne, starting, endTopRight);
        final boolean whiteQueenCanMovePastPieceUpLeft = queenMoveValidator.validate(gameStateOne, starting, endTopLeft);
        final boolean whiteQueenCanMovePastPieceDownRight = queenMoveValidator.validate(gameStateOne, starting, endDownRight);
        final boolean whiteQueenCanMovePastPieceDownLeft = queenMoveValidator.validate(gameStateOne, starting, endDownLeft);

        Assertions.assertThat(whiteQueenCanMovePastPieceDown).isFalse();
        Assertions.assertThat(whiteQueenCanMovePastPieceUp).isFalse();
        Assertions.assertThat(whiteQueenCanMovePastPieceRight).isFalse();
        Assertions.assertThat(whiteQueenCanMovePastPieceLeft).isFalse();
        Assertions.assertThat(whiteQueenCanMovePastPieceUpRight).isFalse();
        Assertions.assertThat(whiteQueenCanMovePastPieceUpLeft).isFalse();
        Assertions.assertThat(whiteQueenCanMovePastPieceDownRight).isFalse();
        Assertions.assertThat(whiteQueenCanMovePastPieceDownLeft).isFalse();
    }

    @Test
    public void givenNoPiecesInWay_AndEnemyInDesiredPosition_QueenCanCapture() {
        Map<BoardPosition, Piece> boardOne = emptyBoard;

        final BoardPosition starting = new BoardPosition(3, 3);
        final BoardPosition endLeft = new BoardPosition(1, 3);
        final BoardPosition endTopLeft = new BoardPosition(1, 5);
        final BoardPosition endDownLeft = new BoardPosition(1, 1);
        final BoardPosition endRight = new BoardPosition(7, 3);
        final BoardPosition endTopRight = new BoardPosition(7, 7);
        final BoardPosition endDownRight = new BoardPosition(5, 1);
        final BoardPosition endUp = new BoardPosition(3, 8);
        final BoardPosition endDown = new BoardPosition(3, 1);


        final Piece whiteQueen = new Piece(PieceNames.QUEEN, PieceTeam.WHITE);

        final Piece blackKnight = new Piece(PieceNames.KNIGHT, PieceTeam.BLACK);

        boardOne.put(starting, whiteQueen);

        boardOne.put(endLeft, blackKnight);
        boardOne.put(endTopLeft, blackKnight);
        boardOne.put(endUp, blackKnight);
        boardOne.put(endTopRight, blackKnight);
        boardOne.put(endRight, blackKnight);
        boardOne.put(endDownRight, blackKnight);
        boardOne.put(endDown, blackKnight);
        boardOne.put(endDownLeft, blackKnight);

        GameState gameStateOne = GameStateFactory.createNewGameState(1, boardOne, new HashMap<>(), this.playerStates);

        final boolean whiteQueenCanMovePastWhitePieceDown = queenMoveValidator.validate(gameStateOne, starting, endDown);
        final boolean whiteQueenCanMovePastWhitePieceUp = queenMoveValidator.validate(gameStateOne, starting, endUp);
        final boolean whiteQueenCanMovePastWhitePieceRight = queenMoveValidator.validate(gameStateOne, starting, endRight);
        final boolean whiteQueenCanMovePastWhitePieceLeft = queenMoveValidator.validate(gameStateOne, starting, endLeft);
        final boolean whiteQueenCanMovePastWhitePieceUpRight = queenMoveValidator.validate(gameStateOne, starting, endTopRight);
        final boolean whiteQueenCanMovePastWhitePieceUpLeft = queenMoveValidator.validate(gameStateOne, starting, endTopLeft);
        final boolean whiteQueenCanMovePastWhitePieceDownRight = queenMoveValidator.validate(gameStateOne, starting, endDownRight);
        final boolean whiteQueenCanMovePastWhitePieceDownLeft = queenMoveValidator.validate(gameStateOne, starting, endDownLeft);

        Assertions.assertThat(whiteQueenCanMovePastWhitePieceDown).isTrue();
        Assertions.assertThat(whiteQueenCanMovePastWhitePieceUp).isTrue();
        Assertions.assertThat(whiteQueenCanMovePastWhitePieceRight).isTrue();
        Assertions.assertThat(whiteQueenCanMovePastWhitePieceLeft).isTrue();
        Assertions.assertThat(whiteQueenCanMovePastWhitePieceUpRight).isTrue();
        Assertions.assertThat(whiteQueenCanMovePastWhitePieceUpLeft).isTrue();
        Assertions.assertThat(whiteQueenCanMovePastWhitePieceDownRight).isTrue();
        Assertions.assertThat(whiteQueenCanMovePastWhitePieceDownLeft).isTrue();
    }

    @Test
    public void givenNoPiecesInWay_AndEnemyInDesiredPositionIsKing_QueenCannotCapture() {
        Map<BoardPosition, Piece> boardOne = emptyBoard;

        final BoardPosition starting = new BoardPosition(3, 3);
        final BoardPosition endLeft = new BoardPosition(1, 3);
        final BoardPosition endTopLeft = new BoardPosition(1, 5);
        final BoardPosition endDownLeft = new BoardPosition(1, 1);
        final BoardPosition endRight = new BoardPosition(7, 3);
        final BoardPosition endTopRight = new BoardPosition(7, 7);
        final BoardPosition endDownRight = new BoardPosition(5, 1);
        final BoardPosition endUp = new BoardPosition(3, 8);
        final BoardPosition endDown = new BoardPosition(3, 1);


        final Piece whiteQueen = new Piece(PieceNames.QUEEN, PieceTeam.WHITE);

        final Piece blackKing = new Piece(PieceNames.KING, PieceTeam.BLACK);

        boardOne.put(starting, whiteQueen);

        boardOne.put(endLeft, blackKing);
        boardOne.put(endTopLeft, blackKing);
        boardOne.put(endUp, blackKing);
        boardOne.put(endTopRight, blackKing);
        boardOne.put(endRight, blackKing);
        boardOne.put(endDownRight, blackKing);
        boardOne.put(endDown, blackKing);
        boardOne.put(endDownLeft, blackKing);

        GameState gameStateOne = GameStateFactory.createNewGameState(1, boardOne, new HashMap<>(), this.playerStates);

        final boolean whiteQueenCanMovePastWhitePieceDown = queenMoveValidator.validate(gameStateOne, starting, endDown);
        final boolean whiteQueenCanMovePastWhitePieceUp = queenMoveValidator.validate(gameStateOne, starting, endUp);
        final boolean whiteQueenCanMovePastWhitePieceRight = queenMoveValidator.validate(gameStateOne, starting, endRight);
        final boolean whiteQueenCanMovePastWhitePieceLeft = queenMoveValidator.validate(gameStateOne, starting, endLeft);
        final boolean whiteQueenCanMovePastWhitePieceUpRight = queenMoveValidator.validate(gameStateOne, starting, endTopRight);
        final boolean whiteQueenCanMovePastWhitePieceUpLeft = queenMoveValidator.validate(gameStateOne, starting, endTopLeft);
        final boolean whiteQueenCanMovePastWhitePieceDownRight = queenMoveValidator.validate(gameStateOne, starting, endDownRight);
        final boolean whiteQueenCanMovePastWhitePieceDownLeft = queenMoveValidator.validate(gameStateOne, starting, endDownLeft);

        Assertions.assertThat(whiteQueenCanMovePastWhitePieceDown).isFalse();
        Assertions.assertThat(whiteQueenCanMovePastWhitePieceUp).isFalse();
        Assertions.assertThat(whiteQueenCanMovePastWhitePieceRight).isFalse();
        Assertions.assertThat(whiteQueenCanMovePastWhitePieceLeft).isFalse();
        Assertions.assertThat(whiteQueenCanMovePastWhitePieceUpRight).isFalse();
        Assertions.assertThat(whiteQueenCanMovePastWhitePieceUpLeft).isFalse();
        Assertions.assertThat(whiteQueenCanMovePastWhitePieceDownRight).isFalse();
        Assertions.assertThat(whiteQueenCanMovePastWhitePieceDownLeft).isFalse();
    }

    @Test
    public void givenFriendlyPiecesInWay_QueenCannotMovePastToCapture() {
        Map<BoardPosition, Piece> boardOne = emptyBoard;

        final BoardPosition starting = new BoardPosition(3, 3);
        final BoardPosition endLeft = new BoardPosition(1, 3);
        final BoardPosition endTopLeft = new BoardPosition(1, 5);
        final BoardPosition endDownLeft = new BoardPosition(1, 1);
        final BoardPosition endRight = new BoardPosition(7, 3);
        final BoardPosition endTopRight = new BoardPosition(7, 7);
        final BoardPosition endDownRight = new BoardPosition(5, 1);
        final BoardPosition endUp = new BoardPosition(3, 8);
        final BoardPosition endDown = new BoardPosition(3, 1);

        final BoardPosition down = new BoardPosition(3, 2);
        final BoardPosition downRight = new BoardPosition(4, 2);
        final BoardPosition downLeft = new BoardPosition(2, 2);
        final BoardPosition up = new BoardPosition(3, 4);
        final BoardPosition upRight = new BoardPosition(4, 4);
        final BoardPosition upLeft = new BoardPosition(2, 4);
        final BoardPosition right = new BoardPosition(4, 3);
        final BoardPosition left = new BoardPosition(2, 3);

        final Piece whiteQueen = new Piece(PieceNames.QUEEN, PieceTeam.WHITE);
        final Piece whiteBishop = new Piece(PieceNames.BISHOP, PieceTeam.WHITE);
        final Piece whiteKing = new Piece(PieceNames.KING, PieceTeam.WHITE);
        final Piece whitePawn = new Piece(PieceNames.PAWN, PieceTeam.WHITE);
        final Piece whiteRook = new Piece(PieceNames.ROOK, PieceTeam.WHITE);
        final Piece whiteKnight = new Piece(PieceNames.KNIGHT, PieceTeam.WHITE);
        final Piece whitePawn2 = new Piece(PieceNames.PAWN, PieceTeam.WHITE);
        final Piece whitePawn3 = new Piece(PieceNames.PAWN, PieceTeam.WHITE);
        final Piece whitePawn4 = new Piece(PieceNames.PAWN, PieceTeam.WHITE);

        final Piece blackKnight = new Piece(PieceNames.KNIGHT, PieceTeam.BLACK);


        boardOne.put(starting, whiteQueen);
        boardOne.put(down, whiteBishop);
        boardOne.put(downRight, whiteKnight);
        boardOne.put(downLeft, whitePawn2);
        boardOne.put(up, whitePawn);
        boardOne.put(upRight, whitePawn3);
        boardOne.put(upLeft, whitePawn4);
        boardOne.put(right, whiteKing);
        boardOne.put(left, whiteRook);

        boardOne.put(endLeft, blackKnight);
        boardOne.put(endTopLeft, blackKnight);
        boardOne.put(endUp, blackKnight);
        boardOne.put(endTopRight, blackKnight);
        boardOne.put(endRight, blackKnight);
        boardOne.put(endDownRight, blackKnight);
        boardOne.put(endDown, blackKnight);
        boardOne.put(endDownLeft, blackKnight);

        GameState gameStateOne = GameStateFactory.createNewGameState(1, boardOne, new HashMap<>(), this.playerStates);

        final boolean whiteQueenCanMovePastWhitePieceDown = queenMoveValidator.validate(gameStateOne, starting, endDown);
        final boolean whiteQueenCanMovePastWhitePieceUp = queenMoveValidator.validate(gameStateOne, starting, endUp);
        final boolean whiteQueenCanMovePastWhitePieceRight = queenMoveValidator.validate(gameStateOne, starting, endRight);
        final boolean whiteQueenCanMovePastWhitePieceLeft = queenMoveValidator.validate(gameStateOne, starting, endLeft);
        final boolean whiteQueenCanMovePastWhitePieceUpRight = queenMoveValidator.validate(gameStateOne, starting, endTopRight);
        final boolean whiteQueenCanMovePastWhitePieceUpLeft = queenMoveValidator.validate(gameStateOne, starting, endTopLeft);
        final boolean whiteQueenCanMovePastWhitePieceDownRight = queenMoveValidator.validate(gameStateOne, starting, endDownRight);
        final boolean whiteQueenCanMovePastWhitePieceDownLeft = queenMoveValidator.validate(gameStateOne, starting, endDownLeft);

        Assertions.assertThat(whiteQueenCanMovePastWhitePieceDown).isFalse();
        Assertions.assertThat(whiteQueenCanMovePastWhitePieceUp).isFalse();
        Assertions.assertThat(whiteQueenCanMovePastWhitePieceRight).isFalse();
        Assertions.assertThat(whiteQueenCanMovePastWhitePieceLeft).isFalse();
        Assertions.assertThat(whiteQueenCanMovePastWhitePieceUpRight).isFalse();
        Assertions.assertThat(whiteQueenCanMovePastWhitePieceUpLeft).isFalse();
        Assertions.assertThat(whiteQueenCanMovePastWhitePieceDownRight).isFalse();
        Assertions.assertThat(whiteQueenCanMovePastWhitePieceDownLeft).isFalse();
    }

    @Test
    public void testGivenDesiredPositionIsSameAsStartingPosition_thenQueenCannotSitStill() {
        Map<BoardPosition, Piece> boardOne = emptyBoard;

        final BoardPosition starting = new BoardPosition(4, 7);

        final Piece blackQueen = new Piece(PieceNames.QUEEN, PieceTeam.BLACK);

        boardOne.put(starting, blackQueen);

        GameState gameState = GameStateFactory.createNewGameState(420, boardOne, new HashMap<>(), this.playerStates);

        final boolean whiteQueenCanSitStill = queenMoveValidator.validate(gameState, starting, starting);

        Assertions.assertThat(whiteQueenCanSitStill).isFalse();
    }
}
