package com.example.chessbot.game.board;

import com.example.chessbot.model.board.Board;
import com.example.chessbot.model.board.exceptions.IllegalTeamException;
import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.piece.PieceNames;
import com.example.chessbot.model.board.position.BoardPosition;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class BoardFactoryTest {

    private Map<BoardPosition, Piece> constructMockPiecesInPlay_inInitialBoardPosition() {
        Map<BoardPosition, Piece> mockPiecesInPlay = new HashMap<>();
        try {
            mockPiecesInPlay.put(new BoardPosition(0, 1), new Piece(PieceNames.PAWN, 0));
            mockPiecesInPlay.put(new BoardPosition(1, 1), new Piece(PieceNames.PAWN, 0));
            mockPiecesInPlay.put(new BoardPosition(2, 1), new Piece(PieceNames.PAWN, 0));
            mockPiecesInPlay.put(new BoardPosition(3, 1), new Piece(PieceNames.PAWN, 0));
            mockPiecesInPlay.put(new BoardPosition(4, 1), new Piece(PieceNames.PAWN, 0));
            mockPiecesInPlay.put(new BoardPosition(5, 1), new Piece(PieceNames.PAWN, 0));
            mockPiecesInPlay.put(new BoardPosition(6, 1), new Piece(PieceNames.PAWN, 0));
            mockPiecesInPlay.put(new BoardPosition(7, 1), new Piece(PieceNames.PAWN, 0));
            mockPiecesInPlay.put(new BoardPosition(0, 1), new Piece(PieceNames.ROOK, 0));
            mockPiecesInPlay.put(new BoardPosition(7, 1), new Piece(PieceNames.ROOK, 0));
            mockPiecesInPlay.put(new BoardPosition(2, 1), new Piece(PieceNames.BISHOP, 0));
            mockPiecesInPlay.put(new BoardPosition(5, 1), new Piece(PieceNames.BISHOP, 0));
            mockPiecesInPlay.put(new BoardPosition(1, 1), new Piece(PieceNames.KNIGHT, 0));
            mockPiecesInPlay.put(new BoardPosition(6, 1), new Piece(PieceNames.KNIGHT, 0));
            mockPiecesInPlay.put( new BoardPosition(3, 1),new Piece(PieceNames.QUEEN, 0));
            mockPiecesInPlay.put(new BoardPosition(4, 1), new Piece(PieceNames.KING, 0));

            mockPiecesInPlay.put(new BoardPosition(0, 6), new Piece(PieceNames.PAWN, 1));
            mockPiecesInPlay.put(new BoardPosition(1, 6), new Piece(PieceNames.PAWN, 1));
            mockPiecesInPlay.put(new BoardPosition(2, 6), new Piece(PieceNames.PAWN, 1));
            mockPiecesInPlay.put(new BoardPosition(3, 6), new Piece(PieceNames.PAWN, 1));
            mockPiecesInPlay.put(new BoardPosition(4, 6), new Piece(PieceNames.PAWN, 1));
            mockPiecesInPlay.put(new BoardPosition(5, 6), new Piece(PieceNames.PAWN, 1));
            mockPiecesInPlay.put(new BoardPosition(6, 6), new Piece(PieceNames.PAWN, 1));
            mockPiecesInPlay.put(new BoardPosition(7, 6), new Piece(PieceNames.PAWN, 1));
            mockPiecesInPlay.put(new BoardPosition(0, 7), new Piece(PieceNames.ROOK, 1));
            mockPiecesInPlay.put(new BoardPosition(7, 7), new Piece(PieceNames.ROOK, 1));
            mockPiecesInPlay.put(new BoardPosition(2, 7), new Piece(PieceNames.BISHOP, 1));
            mockPiecesInPlay.put(new BoardPosition(5, 7), new Piece(PieceNames.BISHOP, 1));
            mockPiecesInPlay.put(new BoardPosition(1, 7), new Piece(PieceNames.KNIGHT, 1));
            mockPiecesInPlay.put(new BoardPosition(6, 7), new Piece(PieceNames.KNIGHT, 1));
            mockPiecesInPlay.put(new BoardPosition(3, 7), new Piece(PieceNames.QUEEN, 1));
            mockPiecesInPlay.put(new BoardPosition(4, 7), new Piece(PieceNames.KING, 1));
        } catch(IllegalTeamException exception) {
            System.out.println(exception.getMessage());
        }
        return mockPiecesInPlay;
    }


    @Test
    public void testBoardFactory_newBoard() {
        final Board RESULT = BoardFactory.createInitialBoard();
        final Map<BoardPosition, Piece> MOCK_PIECES_IN_PLAY = constructMockPiecesInPlay_inInitialBoardPosition();
        Assertions.assertThat(RESULT.getPiecesInPlay()).isNotNull();

        for(BoardPosition key : RESULT.getPiecesInPlay().keySet()) {
            Assertions.assertThat(RESULT.getPiecesInPlay().get(key).getPieceName())
                    .isEqualTo(MOCK_PIECES_IN_PLAY.get(key).getPieceName());
            Assertions.assertThat(RESULT.getPiecesInPlay().get(key).getPieceTeam())
                    .isEqualTo(MOCK_PIECES_IN_PLAY.get(key).getPieceTeam());
        }
    }

    @Test
    public void testBoardFactory_updateBoard() {
        final Map<BoardPosition, Piece> MOCK_PIECES_IN_PLAY = constructMockPiecesInPlay_inInitialBoardPosition();
        final Board RESULT = BoardFactory.updateBoard(MOCK_PIECES_IN_PLAY);

        for(BoardPosition key : RESULT.getPiecesInPlay().keySet()) {
            Assertions.assertThat(RESULT.getPiecesInPlay().get(key).getPieceName())
                    .isEqualTo(MOCK_PIECES_IN_PLAY.get(key).getPieceName());
            Assertions.assertThat(RESULT.getPiecesInPlay().get(key).getPieceTeam())
                    .isEqualTo(MOCK_PIECES_IN_PLAY.get(key).getPieceTeam());
        }
    }
}
