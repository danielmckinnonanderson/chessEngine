package com.example.chessbot.engine;

import com.example.chessbot.model.board.BoardPosition;
import com.example.chessbot.model.piece.PieceTeam;

import java.util.ArrayList;
import java.util.List;

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


    public static List<BoardPosition> generateUpPath(BoardPosition origin) {
        List<BoardPosition> result = new ArrayList<>();

        int originY = origin.getY();
        int originX = origin.getX();
        int spacesToEdge = 8 - originY;

        for(int i = originY; i <= spacesToEdge; i++) {
            result.add(new BoardPosition(originX, i));
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


}
