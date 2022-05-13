package com.example.chessbot.game.board;

import com.example.chessbot.model.board.Board;
import com.example.chessbot.model.board.position.BoardPositionX;
import com.example.chessbot.model.board.position.BoardPositionY;
import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.piece.PieceNames;
import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.piece.PieceTeam;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class BoardFactoryTest {
    private Map<BoardPosition, Piece> constructMockPiecesInPlay_inInitialBoardPosition() {
        Map<BoardPosition, Piece> mockInitialPiecesInPlay = new HashMap<>();
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.A, BoardPositionY.ONE), new Piece(PieceNames.ROOK, PieceTeam.WHITE));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.B, BoardPositionY.ONE), new Piece(PieceNames.KNIGHT, PieceTeam.WHITE));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.C, BoardPositionY.ONE), new Piece(PieceNames.BISHOP, PieceTeam.WHITE));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.D, BoardPositionY.ONE), new Piece(PieceNames.QUEEN, PieceTeam.WHITE));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.E, BoardPositionY.ONE), new Piece(PieceNames.KING, PieceTeam.WHITE));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.F, BoardPositionY.ONE), new Piece(PieceNames.BISHOP, PieceTeam.WHITE));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.G, BoardPositionY.ONE), new Piece(PieceNames.KNIGHT, PieceTeam.WHITE));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.H, BoardPositionY.ONE), new Piece(PieceNames.ROOK, PieceTeam.WHITE));

        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.A, BoardPositionY.TWO), new Piece(PieceNames.PAWN, PieceTeam.WHITE));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.B, BoardPositionY.TWO), new Piece(PieceNames.PAWN, PieceTeam.WHITE));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.C, BoardPositionY.TWO), new Piece(PieceNames.PAWN, PieceTeam.WHITE));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.D, BoardPositionY.TWO), new Piece(PieceNames.PAWN, PieceTeam.WHITE));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.E, BoardPositionY.TWO), new Piece(PieceNames.PAWN, PieceTeam.WHITE));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.F, BoardPositionY.TWO), new Piece(PieceNames.PAWN, PieceTeam.WHITE));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.G, BoardPositionY.TWO), new Piece(PieceNames.PAWN, PieceTeam.WHITE));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.H, BoardPositionY.TWO), new Piece(PieceNames.PAWN, PieceTeam.WHITE));

        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.A, BoardPositionY.THREE), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.B, BoardPositionY.THREE), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.C, BoardPositionY.THREE), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.D, BoardPositionY.THREE), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.E, BoardPositionY.THREE), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.F, BoardPositionY.THREE), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.G, BoardPositionY.THREE), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.H, BoardPositionY.THREE), new Piece(PieceNames.EMPTY, PieceTeam.NONE));

        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.A, BoardPositionY.FOUR), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.B, BoardPositionY.FOUR), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.C, BoardPositionY.FOUR), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.D, BoardPositionY.FOUR), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.E, BoardPositionY.FOUR), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.F, BoardPositionY.FOUR), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.G, BoardPositionY.FOUR), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.H, BoardPositionY.FOUR), new Piece(PieceNames.EMPTY, PieceTeam.NONE));

        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.A, BoardPositionY.FIVE), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.B, BoardPositionY.FIVE), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.C, BoardPositionY.FIVE), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.D, BoardPositionY.FIVE), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.E, BoardPositionY.FIVE), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.F, BoardPositionY.FIVE), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.G, BoardPositionY.FIVE), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.H, BoardPositionY.FIVE), new Piece(PieceNames.EMPTY, PieceTeam.NONE));

        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.A, BoardPositionY.SIX), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.B, BoardPositionY.SIX), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.C, BoardPositionY.SIX), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.D, BoardPositionY.SIX), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.E, BoardPositionY.SIX), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.F, BoardPositionY.SIX), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.G, BoardPositionY.SIX), new Piece(PieceNames.EMPTY, PieceTeam.NONE));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.H, BoardPositionY.SIX), new Piece(PieceNames.EMPTY, PieceTeam.NONE));

        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.A, BoardPositionY.SEVEN), new Piece(PieceNames.PAWN, PieceTeam.BLACK));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.B, BoardPositionY.SEVEN), new Piece(PieceNames.PAWN, PieceTeam.BLACK));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.C, BoardPositionY.SEVEN), new Piece(PieceNames.PAWN, PieceTeam.BLACK));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.D, BoardPositionY.SEVEN), new Piece(PieceNames.PAWN, PieceTeam.BLACK));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.E, BoardPositionY.SEVEN), new Piece(PieceNames.PAWN, PieceTeam.BLACK));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.F, BoardPositionY.SEVEN), new Piece(PieceNames.PAWN, PieceTeam.BLACK));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.G, BoardPositionY.SEVEN), new Piece(PieceNames.PAWN, PieceTeam.BLACK));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.H, BoardPositionY.SEVEN), new Piece(PieceNames.PAWN, PieceTeam.BLACK));

        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.A, BoardPositionY.EIGHT), new Piece(PieceNames.ROOK, PieceTeam.BLACK));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.B, BoardPositionY.EIGHT), new Piece(PieceNames.KNIGHT, PieceTeam.BLACK));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.C, BoardPositionY.EIGHT), new Piece(PieceNames.BISHOP, PieceTeam.BLACK));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.D, BoardPositionY.EIGHT), new Piece(PieceNames.QUEEN, PieceTeam.BLACK));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.E, BoardPositionY.EIGHT), new Piece(PieceNames.KING, PieceTeam.BLACK));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.F, BoardPositionY.EIGHT), new Piece(PieceNames.BISHOP, PieceTeam.BLACK));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.G, BoardPositionY.EIGHT), new Piece(PieceNames.KNIGHT, PieceTeam.BLACK));
        mockInitialPiecesInPlay.put(new BoardPosition(BoardPositionX.H, BoardPositionY.EIGHT), new Piece(PieceNames.ROOK, PieceTeam.BLACK));
        return mockInitialPiecesInPlay;
    }


    @Test
    public void testBoardFactory_newBoard() {
        final Board RESULT = BoardFactory.createInitialBoard();
        final Map<BoardPosition, Piece> PIECES_IN_PLAY = RESULT.getPiecesInPlay();

        Assertions.assertThat(PIECES_IN_PLAY).isNotNull();

        for (BoardPosition key : PIECES_IN_PLAY.keySet()) {
            Piece pieceInPlay = PIECES_IN_PLAY.get(key);
            PieceNames pieceName = pieceInPlay.getPieceName();

            switch (key.getPositionY()) {

                case THREE, FOUR, FIVE, SIX -> Assertions.assertThat(pieceName).isEqualTo(PieceNames.EMPTY);
                case TWO, SEVEN -> Assertions.assertThat(pieceName).isEqualTo(PieceNames.PAWN);
                case ONE, EIGHT -> {
                    switch (key.getPositionX()) {
                        case A, H -> Assertions.assertThat(pieceName)
                                .isEqualTo(PieceNames.ROOK);
                        case B, G -> Assertions.assertThat(pieceName)
                                .isEqualTo(PieceNames.KNIGHT);
                        case C, F -> Assertions.assertThat(pieceName)
                                .isEqualTo(PieceNames.BISHOP);
                        case D -> Assertions.assertThat(pieceName)
                                .isEqualTo(PieceNames.QUEEN);
                        case E -> Assertions.assertThat(pieceName)
                                .isEqualTo(PieceNames.KING);
                    }
                }
            }
        }
    }

    @Test
    public void testBoardFactory_updateBoard() {
        final Map<BoardPosition, Piece> MOCK_PIECES_IN_PLAY = constructMockPiecesInPlay_inInitialBoardPosition();
        final Board RESULT = BoardFactory.updateBoard(MOCK_PIECES_IN_PLAY);

        for (BoardPosition key : RESULT.getPiecesInPlay().keySet()) {
            Assertions.assertThat(RESULT.getPiecesInPlay().get(key).getPieceName())
                    .isEqualTo(MOCK_PIECES_IN_PLAY.get(key).getPieceName());
            Assertions.assertThat(RESULT.getPiecesInPlay().get(key).getPieceTeam())
                    .isEqualTo(MOCK_PIECES_IN_PLAY.get(key).getPieceTeam());
        }
    }
}
