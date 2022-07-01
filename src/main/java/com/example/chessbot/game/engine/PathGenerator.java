package com.example.chessbot.game.engine;

import com.example.chessbot.game.validators.movement.PawnMoveValidator;
import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.piece.Piece;

import java.util.ArrayList;
import java.util.List;

public final class PathGenerator {

    public static List<BoardPosition> generate(BoardPosition origin, Piece piece) {
        return switch (piece.getPieceName()) {
            case PAWN -> generatePawnPaths(origin, piece);
            case ROOK -> generateRookPaths(origin, piece);
            case KNIGHT -> generateKnightPaths(origin, piece);
            case BISHOP -> generateBishopPaths(origin, piece);
            case QUEEN -> generateQueenPaths(origin, piece);
            case KING -> generateKingPaths(origin, piece);
            case EMPTY -> List.of();
        };
    }

    private static List<BoardPosition> generatePawnPaths(BoardPosition origin, Piece piece) {
        int x = origin.getX();
        int y = origin.getY();

        List<BoardPosition> validPaths = new ArrayList<>();

        List<BoardPosition> allPaths = BoardPosition.getPointsAroundOrigin(origin, 2);

        return allPaths;
    }

    private static List<BoardPosition> generateRookPaths(BoardPosition origin, Piece piece) {
        return List.of();
    }

    private static List<BoardPosition> generateKnightPaths(BoardPosition origin, Piece piece) {
        return List.of();
    }

    private static List<BoardPosition> generateBishopPaths(BoardPosition origin, Piece piece) {
        return List.of();
    }

    private static List<BoardPosition> generateQueenPaths(BoardPosition origin, Piece piece) {
        return List.of();
    }

    private static List<BoardPosition> generateKingPaths(BoardPosition origin, Piece piece) {
        return List.of();
    }
}
