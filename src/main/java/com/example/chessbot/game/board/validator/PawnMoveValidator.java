package com.example.chessbot.game.board.validator;

import com.example.chessbot.game.state.GameState;
import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.piece.PieceTeam;

public class PawnMoveValidator implements MoveValidator {
    // TODO properly implement this function / correct pawn movement
    public boolean validate(GameState gameState, BoardPosition currentPosition, BoardPosition desiredPosition) {
        Piece pieceToMove = gameState.getBoard().getPiecesInPlay().get(currentPosition);
        boolean isFirstTurn = gameState.getMoveNumber() == 1;
        PieceTeam occupiedTeam = gameState.getBoard().getPiecesInPlay().get(desiredPosition).getPieceTeam();
        boolean positionIsOccupied = occupiedTeam != PieceTeam.NONE;

        return isMoveValid(pieceToMove.getPieceTeam(), isFirstTurn, positionIsOccupied, currentPosition, desiredPosition);
    }

    public boolean isMoveValid(PieceTeam pieceTeam, boolean isFirstTurn, boolean opponentIsPresentInDesiredPosition, BoardPosition currentPosition, BoardPosition desiredPosition) {
        int deltaX = desiredPosition.getPositionX() - currentPosition.getPositionX();
        int deltaY = desiredPosition.getPositionY() - currentPosition.getPositionY();
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

    private boolean onlyMovesForward(PieceTeam pieceTeam, int deltaY) {
        return pieceTeam == PieceTeam.WHITE ?  deltaY > 0 : deltaY < 0;
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
