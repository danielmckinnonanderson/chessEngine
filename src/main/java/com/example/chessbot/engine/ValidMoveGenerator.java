package com.example.chessbot.engine;

import com.example.chessbot.game.state.GameState;
import com.example.chessbot.game.utility.CaptureUtility;
import com.example.chessbot.game.validation.movement.MoveValidator;
import com.example.chessbot.model.board.BoardPosition;
import com.example.chessbot.model.piece.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ValidMoveGenerator {
    private ValidMoveGenerator() {}

    public static List<BoardPosition> generateListOfValidMoves(Piece piece,
                                                               BoardPosition position,
                                                               GameState gameState,
                                                               MoveValidator validator) {
        return listOfPotentialMovesFromPieceName(piece, position)
                .stream()
                .filter(potential -> validator.validate(gameState, position, potential))
                .collect(Collectors.toList());
                // TODO filter again for invalid check state, then return
    }

    public static List<BoardPosition> listOfPotentialMovesFromPieceName(Piece p, BoardPosition b) {
        return switch (p.getPieceName()) {
            case PAWN -> PathGenerator.generatePossiblePawnPaths(p.getPieceTeam(), b);
            case ROOK -> PathGenerator.generatePossibleRookPaths(b);
            case KNIGHT -> PathGenerator.generatePossibleKnightPaths(b);
            case BISHOP -> PathGenerator.generatePossibleBishopPaths(b);
            case QUEEN -> PathGenerator.generatePossibleQueenPaths(b);
            case KING -> PathGenerator.generatePossibleKingPaths(b);
            default -> List.of();
        };
    }

    public static List<BoardPosition> removeIllegalCaptures(Piece toMove,
                                                            List<BoardPosition> potentialMoves,
                                                            Map<BoardPosition, Piece> board) {
        final List<BoardPosition> result = new ArrayList<>();

        for (BoardPosition p : potentialMoves) {
            if (CaptureUtility.canCapture(toMove, board.get(p))) {
                result.add(p);
            }
        }

        return result;
    }

    // TODO check check
    public static List<BoardPosition> removeIllegalCheckStates(BoardPosition currentPosition,
                                                               List<BoardPosition> potentialMoves) {
        final List<BoardPosition> result = new ArrayList<>();

        for (BoardPosition p : potentialMoves) {
            // if CheckValidator.validate(whatever) { result.add(p); }
        }

        return potentialMoves;
    }
}
