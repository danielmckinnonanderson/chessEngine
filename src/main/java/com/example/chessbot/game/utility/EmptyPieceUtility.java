package com.example.chessbot.game.utility;

import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.piece.PieceNames;
import com.example.chessbot.model.piece.PieceTeam;

public final class EmptyPieceUtility {
    public static boolean isPieceEmpty(Piece inPosition) {
        return inPosition.getPieceName() == PieceNames.EMPTY
                || inPosition.getPieceTeam() == PieceTeam.NONE;
    }
}