package com.example.chessbot.game.state;

import com.example.chessbot.game.state.player.PlayerState;
import com.example.chessbot.game.state.player.PlayerStateFactory;
import com.example.chessbot.model.board.BoardFactory;
import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.Pair;
import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.piece.PieceTeam;

import java.util.Map;

public final class GameStateFactory {

    public static GameState createInitialGameState() {
        return new ConcreteGameState(1, BoardFactory.createInitialBoard(), Map.of(), new Pair<>(PlayerStateFactory.createInitialPlayerState(PieceTeam.WHITE), PlayerStateFactory.createInitialPlayerState(PieceTeam.BLACK)));
    }

    public static GameState createNewGameState(int moveNumber, Map<BoardPosition, Piece> board, Map<Integer, Map<BoardPosition, Piece>> lastSeventyFiveMoves, Pair<PlayerState, PlayerState> playerStates) {
        return new ConcreteGameState(moveNumber, board, lastSeventyFiveMoves, playerStates);
    }
}

record ConcreteGameState(int moveNumber, Map<BoardPosition, Piece> board,
                         Map<Integer, Map<BoardPosition, Piece>> previousBoardStates,
                         Pair<PlayerState, PlayerState> playerStates) implements GameState {

    @Override
    public Map<BoardPosition, Piece> getBoard() {
        return this.board;
    }

    @Override
    public Map<Integer, Map<BoardPosition, Piece>> getPreviousBoardStates() {
        return this.previousBoardStates;
    }

    @Override
    public Pair<PlayerState, PlayerState> getPlayerStates() {
        return this.playerStates;
    }

    @Override
    public int getMoveNumber() {
        return this.moveNumber;
    }
}
