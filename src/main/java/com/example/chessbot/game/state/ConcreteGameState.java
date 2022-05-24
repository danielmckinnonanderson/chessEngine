package com.example.chessbot.game.state;

import com.example.chessbot.model.board.BoardFactory;
import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.piece.Piece;

import java.util.Hashtable;
import java.util.Map;

public record ConcreteGameState(Map<BoardPosition, Piece> board, int moveNumber) implements GameState {

    public Map<BoardPosition, Piece> getBoard() {
        return this.board;
    }

    public int getMoveNumber() {
        return this.moveNumber;
    }
}

class GameStateFactory {

    public static GameState createInitialGameState() {
        return new ConcreteGameState(BoardFactory.createInitialBoard(), 1);
    }

    public static GameState createNewGameState(Hashtable<BoardPosition, Piece> board, int moveNumber) {
        return new ConcreteGameState(board, moveNumber);
    }
}
