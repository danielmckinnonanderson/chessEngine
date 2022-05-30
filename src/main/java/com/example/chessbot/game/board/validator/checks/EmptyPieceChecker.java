package com.example.chessbot.game.board.validator.checks;

import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.piece.PieceNames;
import com.example.chessbot.model.piece.PieceTeam;

public final class EmptyPieceChecker {
    public static boolean isPieceEmpty(Piece inPosition) {
        return inPosition.getPieceName() == PieceNames.EMPTY
                || inPosition.getPieceTeam() == PieceTeam.NONE;
    }
}