package com.example.chessbot.game.board.validator;

import com.example.chessbot.model.board.position.BoardPosition;

public class PawnMoveValidator {

    public boolean isMoveValid(int pieceTeam, boolean isFirstTurn, boolean opponentIsPresentInDesiredPosition, BoardPosition currentPosition, BoardPosition desiredPosition) {
        int deltaX = desiredPosition.getPositionX().getValue() - currentPosition.getPositionX().getValue();
        int deltaY = desiredPosition.getPositionY().getValue() - currentPosition.getPositionY().getValue();
        int absValueDeltaX = Math.abs(deltaX);
        int absValueDeltaY = Math.abs(deltaY);

        boolean onlyMovesForward = onlyMovesForward(pieceTeam, deltaY);

        if (onlyMovesForward) {
            if (isFirstTurn) {
                return isDesiredPositionOneOrTwoSpacesForward(absValueDeltaX, absValueDeltaY);
            }
            if (opponentIsPresentInDesiredPosition) {
                return isDesiredPositionInCaptureRange(absValueDeltaX, absValueDeltaY);
            }
            return isDesiredPositionOneSpaceForward(absValueDeltaX, absValueDeltaY);
        }
        return false;
    }

    private boolean onlyMovesForward(int pieceTeam, int deltaY) {
        return pieceTeam == 0 ?  deltaY > 0 : deltaY < 0;
    }

    private boolean isDesiredPositionInCaptureRange(int deltaX, int deltaY) {
        return deltaX == 1 && deltaY == 1;
    }

    private boolean isDesiredPositionOneSpaceForward(int deltaX, int deltaY) {
        return deltaX == 0 && deltaY == 1;
    }

    private boolean isDesiredPositionOneOrTwoSpacesForward(int deltaX, int deltaY) {
        return deltaX == 0 && (deltaY == 1 || deltaY == 2);
    }
}
