package com.example.chessbot.game.state;

import com.example.chessbot.model.board.BoardFactory;
import com.example.chessbot.model.board.Board;
import com.example.chessbot.model.board.ConcreteBoard;
import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.piece.PieceNames;
import com.example.chessbot.model.piece.PieceTeam;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

public class GameStateTest {

    @Test
    public void whenGameStateFactoryCreatesNewGameState_shouldMatchInitialValues() {
        Map<BoardPosition, Piece> MOCK_PIECES_IN_PLAY = new HashMap<>();
        MOCK_PIECES_IN_PLAY.put(new BoardPosition(4, 6), new Piece(PieceNames.BISHOP, PieceTeam.WHITE));

        Board MOCK_BOARD = new ConcreteBoard().setPiecesInPlay(MOCK_PIECES_IN_PLAY);

        try(MockedStatic<BoardFactory> mockedBoardFactory = Mockito.mockStatic(BoardFactory.class)) {
            mockedBoardFactory.when(BoardFactory::createInitialBoard).thenReturn(MOCK_BOARD);

            final GameState RESULT = GameStateFactory.createInitialGameState();


            Assertions.assertThat(RESULT.getMoveNumber()).isEqualTo(1);
            Assertions.assertThat(BoardFactory.createInitialBoard()).isNotNull();
        }
    }
}
