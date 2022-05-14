package com.example.chessbot.game.state;

import com.example.chessbot.model.board.BoardFactory;
import com.example.chessbot.model.board.Board;

public class ConcreteGameState implements GameState {

    private final Board board;

    private final int moveNumber;

    ConcreteGameState(Board board, int moveNumber) {
        this.board = board;
        this.moveNumber = moveNumber;
    }

    public Board getBoard() {
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

    public static GameState createNewGameState(Board board, int moveNumber) {
        return new ConcreteGameState(board, moveNumber);
    }
}
