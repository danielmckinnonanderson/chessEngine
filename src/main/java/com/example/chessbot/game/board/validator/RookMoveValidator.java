package com.example.chessbot.game.board.validator;

import com.example.chessbot.game.state.GameState;
import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.piece.PieceNames;

import java.util.Map;

public class RookMoveValidator implements MoveValidator {

    public boolean validate(GameState gameState, BoardPosition currentPosition, BoardPosition desiredPosition) {
        Map<BoardPosition, Piece> piecesInPlay = gameState.getBoard().getPiecesInPlay();
        Piece pieceToMove = piecesInPlay.get(currentPosition);
        Piece pieceInDesiredPosition = piecesInPlay.get(desiredPosition);

        if (isMoveEitherHorizontalOrVertical(currentPosition, desiredPosition)) {
            if (isMoveHorizontal(currentPosition, desiredPosition)) {

            }

            if (isTherePieceInDesiredPosition(pieceToMove, pieceInDesiredPosition)
                    && pieceInDesiredPositionIsEnemy(pieceToMove, pieceInDesiredPosition)) {

            }
        }


        return true;
    }

    private boolean isMoveEitherHorizontalOrVertical(BoardPosition current, BoardPosition desired) {
        return (current.getPositionY() != desired.getPositionY()
                && current.getPositionX()== current.getPositionX())
                ^ (current.getPositionX() != desired.getPositionX()
                && current.getPositionY() == desired.getPositionY());
    }

    private boolean isMoveHorizontal(BoardPosition current, BoardPosition desired) {
        return current.getPositionX() != desired.getPositionX();
    }

    private boolean areTherePiecesAlongPath(Map<BoardPosition, Piece> piecesInPlay, BoardPosition current, BoardPosition desired) {
        // given a static position along which pieces don't move
//        Type axis = getStaticAxis(current, desired);
//        if(axis == ) {
//            final int y = current.getPositionY();
//            int currentX = current.getPositionX();
//            int desiredX = desired.getPositionX();
//            int delta = desiredX - currentX;
//
//            for(int i = 0; i < delta; i++) {
//                Piece piece = piecesInPlay.get(new BoardPosition())
//            }
//
//        }

        // get difference between current and desired

        // iterate through board

        // for each point on board between current and desired

        // get piece in position

        // if piece in position is not empty return true

        // default return false
        return false;
    }

    private boolean isTherePieceInDesiredPosition(Piece pieceToMove, Piece pieceInSpot) {
        return pieceInSpot.getPieceName() != PieceNames.EMPTY;
    }

    private boolean pieceInDesiredPositionIsEnemy(Piece pieceToMove, Piece pieceInSpot) {
        return pieceToMove.getPieceTeam() != pieceInSpot.getPieceTeam();
    }
}
