package com.example.chessbot.game.board.validator.checks;

import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.piece.PieceTeam;

public final class EnemyPieceChecker {
    public static boolean isPieceEnemy(Piece self, Piece target) {
        return target.getPieceTeam() != self.getPieceTeam() && target.getPieceTeam() != PieceTeam.NONE;
    }
}
