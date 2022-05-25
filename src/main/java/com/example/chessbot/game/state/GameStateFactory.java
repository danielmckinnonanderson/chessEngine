package com.example.chessbot.game.state;

import com.example.chessbot.game.state.player.PlayerState;
import com.example.chessbot.game.state.player.PlayerStateFactory;
import com.example.chessbot.model.board.BoardFactory;
import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.board.position.Pair;
import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.piece.PieceTeam;

import java.util.List;
import java.util.Map;

public final class GameStateFactory {

    public static GameState createInitialGameState() {
        return new ConcreteGameState(1, BoardFactory.createInitialBoard(), List.of(), new Pair<>(PlayerStateFactory.createInitialPlayerState(PieceTeam.WHITE), PlayerStateFactory.createInitialPlayerState(PieceTeam.BLACK)));
    }

    public static GameState createNewGameState(int moveNumber, Map<BoardPosition, Piece> board, List<Map<BoardPosition, Piece>> lastFiftyMoves, Pair<PlayerState, PlayerState> playerStates) {
        return new ConcreteGameState(moveNumber, board, lastFiftyMoves, playerStates);
    }
}

record ConcreteGameState(int moveNumber, Map<BoardPosition, Piece> board,
                         List<Map<BoardPosition, Piece>> lastFiftyMoves,
                         Pair<PlayerState, PlayerState> playerStates) implements GameState {

    @Override
    public Map<BoardPosition, Piece> getBoard() {
        return this.board;
    }

    @Override
    public List<Map<BoardPosition, Piece>> getLastFiftyMoves() {
        return null;
    }

    @Override
    public Pair<PlayerState, PlayerState> getPlayerStates() {
        return null;
    }

    @Override
    public int getMoveNumber() {
        return this.moveNumber;
    }
}
