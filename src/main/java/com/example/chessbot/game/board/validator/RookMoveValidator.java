package com.example.chessbot.game.board.validator;

import com.example.chessbot.game.state.GameState;
import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.board.position.BoardPositionPoint;
import com.example.chessbot.model.board.position.BoardPositionX;
import com.example.chessbot.model.board.position.BoardPositionY;
import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.piece.PieceNames;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.stream.Stream;

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
        return (current.getPositionY().getValue() != desired.getPositionY().getValue()
                && current.getPositionX().getValue() == current.getPositionX().getValue())
                ^ (current.getPositionX().getValue() != desired.getPositionX().getValue()
                && current.getPositionY().getValue() == desired.getPositionY().getValue());
    }

    private boolean isMoveHorizontal(BoardPosition current, BoardPosition desired) {
        return current.getPositionX() != desired.getPositionX();
    }

    private boolean areTherePiecesAlongPath(Map<BoardPosition, Piece> piecesInPlay, BoardPosition current, BoardPosition desired) {
        // given a static position along which pieces don't move
        Type axis = getStaticAxis(current, desired);
        if(axis == BoardPositionY.class) {
            final BoardPositionY y = current.getPositionY();
            int currentX = current.getPositionX().getValue();
            int desiredX = desired.getPositionX().getValue();
            int delta = desiredX - currentX;

            for(int i = 0; i < delta; i++) {
                Piece piece = piecesInPlay.get(new BoardPosition(BoardPositionX))
            }

        }

        // get difference between current and desired

        // iterate through board

        // for each point on board between current and desired

        // get piece in position

        // if piece in position is not empty return true

        // default return false

    }

    private Type getStaticAxis(BoardPosition one, BoardPosition two) {
        return one.getPositionY() == two.getPositionY() ?
            one.getPositionX().getClass() : one.getPositionY().getClass();

    }

    private boolean isTherePieceInDesiredPosition(Piece pieceToMove, Piece pieceInSpot) {
        return pieceInSpot.getPieceName() != PieceNames.EMPTY;
    }

    private boolean pieceInDesiredPositionIsEnemy(Piece pieceToMove, Piece pieceInSpot) {
        return pieceToMove.getPieceTeam() != pieceInSpot.getPieceTeam();
    }
}
