package com.example.chessbot.game.validation.movement;

import com.example.chessbot.game.utility.CaptureUtility;
import com.example.chessbot.game.utility.EmptyPieceUtility;
import com.example.chessbot.game.state.GameState;
import com.example.chessbot.model.board.BoardPosition;
import com.example.chessbot.model.piece.Piece;

import java.util.Map;

public class KingMoveValidator implements MoveValidator {
    @Override
    public boolean validate(GameState gameState, BoardPosition currentPosition, BoardPosition desiredPosition) {
        Map<BoardPosition, Piece> board = gameState.getBoard();
        int difX = desiredPosition.getX() - currentPosition.getX();
        int difY = desiredPosition.getY() - currentPosition.getY();

        if(!isMoveDeltaOne(difX, difY)) {
            return false;
        }

        Piece toMove = board.get(currentPosition);
        Piece inDesired = board.get(desiredPosition);

        if(EmptyPieceUtility.isPieceEmpty(inDesired)) {
            return true;
        } else {
            return CaptureUtility.canCapture(toMove, inDesired);
        }
    }

    private boolean isMoveDeltaOne(int difX, int difY) {
        int absX = Math.abs(difX);
        int absY = Math.abs(difY);

        if(absX == 1 && absY == 1) {
            return true;
        } else if(absX == 0 && absY == 1) {
            return true;
        } else return absX == 1 && absY == 0;
    }
}
