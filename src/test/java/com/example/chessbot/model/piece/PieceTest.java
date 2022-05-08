package com.example.chessbot.model.piece;

import com.example.chessbot.model.board.exceptions.IllegalTeamException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PieceTest {
    @Test
    public void testPiece_isValidTeam() throws IllegalTeamException {
        final int VALID_TEAM = 1;
        final boolean RESULT = Piece.isTeamValid(VALID_TEAM);

        Assertions.assertThat(RESULT).isTrue();
    }

    @Test
    public void testPiece_invalidTeam() {
        final int INVALID_TEAM = 99;
        Assertions.assertThatExceptionOfType(IllegalTeamException.class).isThrownBy(() -> Piece.isTeamValid(INVALID_TEAM));
    }
}
