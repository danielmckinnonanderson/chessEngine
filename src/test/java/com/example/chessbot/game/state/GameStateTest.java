package com.example.chessbot.game.state;

import com.example.chessbot.model.board.BoardFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameStateTest {

    @Test
    public void whenGameStateFactoryCreatesNewGameState_shouldMatchInitialValues() {
        final GameState RESULT = GameStateFactory.createInitialGameState();

        Assertions.assertThat(RESULT.getMoveNumber()).isEqualTo(1);
        Assertions.assertThat(BoardFactory.createInitialBoard()).isNotNull();

    }
}
