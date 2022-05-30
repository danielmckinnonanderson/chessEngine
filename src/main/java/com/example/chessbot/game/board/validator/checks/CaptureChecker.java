package com.example.chessbot.game.board.validator.checks;

import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.piece.PieceNames;

public final class CaptureChecker {
    public static boolean canCapture(Piece self, Piece target) {
        return EnemyPieceChecker.isPieceEnemy(self, target)
                && target.getPieceName() != PieceNames.KING;
    }
}
