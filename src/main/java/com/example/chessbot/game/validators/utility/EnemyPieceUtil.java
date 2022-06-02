package com.example.chessbot.game.validators.utility;

import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.piece.PieceTeam;

public final class EnemyPieceUtil {
    public static boolean isPieceEnemy(Piece self, Piece target) {
        return target.getPieceTeam() != self.getPieceTeam() && target.getPieceTeam() != PieceTeam.NONE;
    }
}
