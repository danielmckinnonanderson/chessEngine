package com.example.chessbot.game.board;

import com.example.chessbot.model.board.Board;
import com.example.chessbot.model.board.exceptions.IllegalTeamException;
import com.example.chessbot.model.board.position.BoardPositionX;
import com.example.chessbot.model.board.position.BoardPositionY;
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
            mockPiecesInPlay.put(new BoardPosition(BoardPositionX.A, BoardPositionY.TWO), new Piece(PieceNames.PAWN, 0));
            mockPiecesInPlay.put(new BoardPosition(BoardPositionX.B, BoardPositionY.TWO), new Piece(PieceNames.PAWN, 0));
            mockPiecesInPlay.put(new BoardPosition(BoardPositionX.C, BoardPositionY.TWO), new Piece(PieceNames.PAWN, 0));
            mockPiecesInPlay.put(new BoardPosition(BoardPositionX.D, BoardPositionY.TWO), new Piece(PieceNames.PAWN, 0));
            mockPiecesInPlay.put(new BoardPosition(BoardPositionX.E, BoardPositionY.TWO), new Piece(PieceNames.PAWN, 0));
            mockPiecesInPlay.put(new BoardPosition(BoardPositionX.F, BoardPositionY.TWO), new Piece(PieceNames.PAWN, 0));
            mockPiecesInPlay.put(new BoardPosition(BoardPositionX.G, BoardPositionY.TWO), new Piece(PieceNames.PAWN, 0));
            mockPiecesInPlay.put(new BoardPosition(BoardPositionX.H, BoardPositionY.TWO), new Piece(PieceNames.PAWN, 0));

            mockPiecesInPlay.put(new BoardPosition(BoardPositionX.A, BoardPositionY.ONE), new Piece(PieceNames.ROOK, 0));
            mockPiecesInPlay.put(new BoardPosition(BoardPositionX.B, BoardPositionY.ONE), new Piece(PieceNames.KNIGHT, 0));
            mockPiecesInPlay.put(new BoardPosition(BoardPositionX.C, BoardPositionY.ONE), new Piece(PieceNames.BISHOP, 0));
            mockPiecesInPlay.put(new BoardPosition(BoardPositionX.D, BoardPositionY.ONE), new Piece(PieceNames.QUEEN, 0));
            mockPiecesInPlay.put(new BoardPosition(BoardPositionX.E, BoardPositionY.ONE), new Piece(PieceNames.KING, 0));
            mockPiecesInPlay.put(new BoardPosition(BoardPositionX.F, BoardPositionY.ONE), new Piece(PieceNames.BISHOP, 0));
            mockPiecesInPlay.put(new BoardPosition(BoardPositionX.G, BoardPositionY.ONE), new Piece(PieceNames.KNIGHT, 0));
            mockPiecesInPlay.put(new BoardPosition(BoardPositionX.H, BoardPositionY.ONE), new Piece(PieceNames.ROOK, 0));

            mockPiecesInPlay.put(new BoardPosition(BoardPositionX.A, BoardPositionY.SEVEN), new Piece(PieceNames.PAWN, 0));
            mockPiecesInPlay.put(new BoardPosition(BoardPositionX.B, BoardPositionY.SEVEN), new Piece(PieceNames.PAWN, 0));
            mockPiecesInPlay.put(new BoardPosition(BoardPositionX.C, BoardPositionY.SEVEN), new Piece(PieceNames.PAWN, 0));
            mockPiecesInPlay.put(new BoardPosition(BoardPositionX.D, BoardPositionY.SEVEN), new Piece(PieceNames.PAWN, 0));
            mockPiecesInPlay.put(new BoardPosition(BoardPositionX.E, BoardPositionY.SEVEN), new Piece(PieceNames.PAWN, 0));
            mockPiecesInPlay.put(new BoardPosition(BoardPositionX.F, BoardPositionY.SEVEN), new Piece(PieceNames.PAWN, 0));
            mockPiecesInPlay.put(new BoardPosition(BoardPositionX.G, BoardPositionY.SEVEN), new Piece(PieceNames.PAWN, 0));
            mockPiecesInPlay.put(new BoardPosition(BoardPositionX.H, BoardPositionY.SEVEN), new Piece(PieceNames.PAWN, 0));
            
            mockPiecesInPlay.put(new BoardPosition(BoardPositionX.A, BoardPositionY.EIGHT), new Piece(PieceNames.ROOK, 0));
            mockPiecesInPlay.put(new BoardPosition(BoardPositionX.B, BoardPositionY.EIGHT), new Piece(PieceNames.KNIGHT, 0));
            mockPiecesInPlay.put(new BoardPosition(BoardPositionX.C, BoardPositionY.EIGHT), new Piece(PieceNames.BISHOP, 0));
            mockPiecesInPlay.put(new BoardPosition(BoardPositionX.D, BoardPositionY.EIGHT), new Piece(PieceNames.QUEEN, 0));
            mockPiecesInPlay.put(new BoardPosition(BoardPositionX.E, BoardPositionY.EIGHT), new Piece(PieceNames.KING, 0));
            mockPiecesInPlay.put(new BoardPosition(BoardPositionX.F, BoardPositionY.EIGHT), new Piece(PieceNames.BISHOP, 0));
            mockPiecesInPlay.put(new BoardPosition(BoardPositionX.G, BoardPositionY.EIGHT), new Piece(PieceNames.KNIGHT, 0));
            mockPiecesInPlay.put(new BoardPosition(BoardPositionX.H, BoardPositionY.EIGHT), new Piece(PieceNames.ROOK, 0));
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
