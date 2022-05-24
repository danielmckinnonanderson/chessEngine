package com.example.chessbot.game.state;

import com.example.chessbot.model.board.BoardFactory;
import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.piece.PieceNames;
import com.example.chessbot.model.piece.PieceTeam;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class GameStateTest {

    @Test
    public void whenGameStateFactoryCreatesNewGameState_shouldMatchInitialValues() {
        final GameState RESULT = GameStateFactory.createInitialGameState();

        Assertions.assertThat(RESULT.getMoveNumber()).isEqualTo(1);
        Assertions.assertThat(BoardFactory.createInitialBoard()).isNotNull();

    }
}
