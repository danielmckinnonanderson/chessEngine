package com.example.chessbot.game.utility;

import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.piece.PieceNames;

public final class CaptureUtil {
    public static boolean canCapture(Piece self, Piece target) {
        return EnemyPieceUtil.isPieceEnemy(self, target)
                && target.getPieceName() != PieceNames.KING;
    }
}
