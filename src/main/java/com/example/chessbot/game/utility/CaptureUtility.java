package com.example.chessbot.game.utility;

import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.piece.PieceNames;

public final class CaptureUtility {
    private CaptureUtility() {}

    public static boolean canCapture(Piece self, Piece target) {
        return EnemyPieceUtility.isPieceEnemy(self, target)
                && target.getPieceName() != PieceNames.KING;
    }
}
