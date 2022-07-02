package com.example.chessbot.engine;

import com.example.chessbot.model.board.BoardPosition;
import com.example.chessbot.model.piece.PieceTeam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PathGenerator {
    public static List<BoardPosition> generatePossiblePawnPaths(PieceTeam team, BoardPosition origin) {
        int x = origin.getX();
        int y = origin.getY();

        if(team == PieceTeam.WHITE) {
            return List.of(
                    new BoardPosition(x, y+1),
                    new BoardPosition(x, y+2),
                    new BoardPosition(x+1, y+1),
                    new BoardPosition(x-1, y+1)
            );
        }
        if(team == PieceTeam.BLACK) {
            return List.of(
                    new BoardPosition(x, y-1),
                    new BoardPosition(x, y-2),
                    new BoardPosition(x+1, y-1),
                    new BoardPosition(x-1, y-1)
            );
        }
        return List.of();
    }

    // TODO probably don't need to make a bunch of streams in any of these. Refactor later
    public static List<BoardPosition> generatePossibleRookPaths(BoardPosition origin) {
        return Stream.of(
                generateUpPath(origin),
                generateRightPath(origin),
                generateDownPath(origin),
                generateLeftPath(origin))
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public static List<BoardPosition> generatePossibleKnightPaths(BoardPosition origin) {
        int x = origin.getX();
        int y = origin.getY();

        return List.of(
            new BoardPosition(x + 1, y + 2),
            new BoardPosition(x + 1, y - 2),
            new BoardPosition(x - 1, y + 2),
            new BoardPosition(x - 1, y - 2),
            new BoardPosition(x + 2, y + 1),
            new BoardPosition(x + 2, y - 1),
            new BoardPosition(x - 2, y + 1),
            new BoardPosition(x - 2, y - 1)
        );
    }

    public static List<BoardPosition> generatePossibleBishopPaths(BoardPosition origin) {
        int x = origin.getX();
        int y = origin.getY();

        return Stream.of(
                generateUpRightPath(origin),
                generateDownRightPath(origin),
                generateUpLeftPath(origin),
                generateDownLeftPath(origin))
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public static List<BoardPosition> generatePossibleQueenPaths(BoardPosition origin) {
        int x = origin.getX();
        int y = origin.getY();

        return Stream.of(
                generateUpPath(origin),
                generateUpRightPath(origin),
                generateRightPath(origin),
                generateDownRightPath(origin),
                generateDownPath(origin),
                generateDownLeftPath(origin),
                generateLeftPath(origin),
                generateUpLeftPath(origin))
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public static List<BoardPosition> generatePossibleKingPaths(BoardPosition origin) {
        int x = origin.getX();
        int y = origin.getY();

        return List.of(
                new BoardPosition(x, y + 1),
                new BoardPosition(x + 1, y + 1),
                new BoardPosition(x + 1, y),
                new BoardPosition(x + 1, y - 1),
                new BoardPosition(x, y - 1),
                new BoardPosition(x - 1, y - 1),
                new BoardPosition(x - 1, y),
                new BoardPosition(x - 1, y + 1));
    }


    public static List<BoardPosition> generateUpPath(BoardPosition origin) {
        List<BoardPosition> result = new ArrayList<>();

        int originY = origin.getY();
        int originX = origin.getX();
        int spacesToEdge = 8 - originY;

        for(int i = originY; i <= 8; i++) {
            result.add(new BoardPosition(originX, i));
        }

        return result;
    }

    public static List<BoardPosition> generateUpRightPath(BoardPosition origin) {
        List<BoardPosition> result = new ArrayList<>();

        int originY = origin.getY();
        int originX = origin.getX();
        int spacesToEdge = 8 - originX < 8 - origin.getY() ? 8 - originX : 8 - originY;

        for(int i = 0; i < spacesToEdge; i++) {
            result.add(new BoardPosition(originX + 1, originY + 1));
        }

        return result;
    }

    public static List<BoardPosition> generateRightPath(BoardPosition origin) {
        List<BoardPosition> result = new ArrayList<>();

        int originY = origin.getY();
        int originX = origin.getX();
        int spacesToEdge = 8 - originX;

        for(int i = originX; i <= spacesToEdge; i++) {
            result.add(new BoardPosition(i, originY));
        }

        return result;
    }

    public static List<BoardPosition> generateDownRightPath(BoardPosition origin) {
        List<BoardPosition> result = new ArrayList<>();

        int originY = origin.getY();
        int originX = origin.getX();
        int spacesToEdge = 8 - originX < origin.getY() - 1 ? 8 - originX : originY - 1;

        for(int i = originX; i <= spacesToEdge; i++) {
            result.add(new BoardPosition(i, originY));
        }

        return result;
    }

    public static List<BoardPosition> generateDownPath(BoardPosition origin) {
        List<BoardPosition> result = new ArrayList<>();

        int originY = origin.getY();
        int originX = origin.getX();
        int spacesToEdge = originY - 1;

        for(int i = originY; i >= spacesToEdge; i--) {
            result.add(new BoardPosition(originX, i));
        }

        return result;
    }

    public static List<BoardPosition> generateDownLeftPath(BoardPosition origin) {
        return List.of();
    }

    public static List<BoardPosition> generateLeftPath(BoardPosition origin) {
        List<BoardPosition> result = new ArrayList<>();

        int originY = origin.getY();
        int originX = origin.getX();
        int spacesToEdge = originX - 1;

        for(int i = originY; i >= spacesToEdge; i--) {
            result.add(new BoardPosition(originX, i));
        }

        return result;
    }

    public static List<BoardPosition> generateUpLeftPath(BoardPosition origin) {
        return List.of();
    }
}
