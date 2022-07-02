package com.example.chessbot.engine;

import com.example.chessbot.game.board.validator.checks.CaptureChecker;
import com.example.chessbot.game.state.GameState;
import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.piece.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ValidMoveGenerator {
    public static List<BoardPosition> generateListOfValidMoves(Piece piece,
                                                               BoardPosition position,
                                                               GameState gameState) {
        Map<BoardPosition, Piece> board = gameState.getBoard();
        return removeIllegalCheckStates(position, removeIllegalCaptures(piece,
                removeOutOfBoundsMoves(listOfPotentialMovesFromPieceName(piece, position)),
                board));
    }

    public static List<BoardPosition> listOfPotentialMovesFromPieceName(Piece p, BoardPosition b) {
        return switch (p.getPieceName()) {
            case PAWN -> List.of();
            case ROOK -> List.of();
            default -> throw new IllegalStateException("Unexpected value: " + p.getPieceName());
        };
    }

    public static List<BoardPosition> removeOutOfBoundsMoves(List<BoardPosition> potentialMoves) {
        final List<BoardPosition> result = new ArrayList<>();

        for (BoardPosition p : potentialMoves) {
            if (p.getX() <= 8 && p.getX() >= 1) {
                result.add(p);
            }
        }

        return result;
    }

    public static List<BoardPosition> removeIllegalCaptures(Piece toMove,
                                                            List<BoardPosition> potentialMoves,
                                                            Map<BoardPosition, Piece> board) {
        final List<BoardPosition> result = new ArrayList<>();

        for (BoardPosition p : potentialMoves) {
            if (CaptureChecker.canCapture(toMove, board.get(p))) {
                result.add(p);
            }
        }

        return result;
    }

    public static List<BoardPosition> removeIllegalCheckStates(BoardPosition currentPosition,
                                                               List<BoardPosition> potentialMoves) {
        final List<BoardPosition> result = new ArrayList<>();

        for (BoardPosition p : potentialMoves) {
            // if CheckValidator.validate(whatever) { result.add(p); }
        }

        return result;
    }
}
