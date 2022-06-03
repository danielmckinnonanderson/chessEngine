package com.example.chessbot.game.validators.movement;

import com.example.chessbot.model.state.GameState;
import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.piece.PieceNames;
import com.example.chessbot.model.piece.PieceTeam;

import java.util.Map;

public class KnightMoveValidator {

    public static boolean validate(GameState gameState, BoardPosition currentPosition, BoardPosition desiredPosition) {
        Map<BoardPosition, Piece> board = gameState.getBoard();
        Piece pieceToMove = board.get(currentPosition);
        Piece pieceInDesiredPosition = board.get(desiredPosition);

        if(!desiredPositionIsInValidLocation(currentPosition, desiredPosition)) {
            return false;
        } else {
            if(pieceIsInDesiredSpot(pieceInDesiredPosition)) {
                return canCapturePieceInDesiredSpot(pieceToMove, pieceInDesiredPosition);
            } else {
                return true;
            }
        }
    }

    private static boolean desiredPositionIsInValidLocation(BoardPosition currentPosition, BoardPosition desiredPosition) {
        int deltaX = Math.abs(desiredPosition.getX() - currentPosition.getX());
        int deltaY = Math.abs(desiredPosition.getY() - currentPosition.getY());

        return deltaX == 1 && deltaY == 2 || deltaX == 2 && deltaY == 1;
    }


    private static boolean pieceIsInDesiredSpot(Piece pieceInDesiredPosition) {
        return pieceInDesiredPosition.getPieceTeam() != PieceTeam.NONE
                && pieceInDesiredPosition.getPieceName() != PieceNames.EMPTY;
    }

    private static boolean canCapturePieceInDesiredSpot(Piece pieceToMove, Piece pieceInDesiredPosition) {
        return pieceInDesiredPosition.getPieceName() != PieceNames.KING
                && pieceInDesiredPosition.getPieceTeam() != pieceToMove.getPieceTeam();
    }
}
