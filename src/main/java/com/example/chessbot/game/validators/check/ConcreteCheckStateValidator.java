package com.example.chessbot.game.validators.check;

import com.example.chessbot.game.utility.CheckUtil;
import com.example.chessbot.game.validators.exceptions.IllegalCheckStatusException;
import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.piece.PieceTeam;
import com.example.chessbot.model.state.GameState;
import com.example.chessbot.model.state.player.attributes.CheckState;
import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.state.player.attributes.CheckStatus;
import com.example.chessbot.model.utility.Pair;

import java.util.Map;

public class ConcreteCheckStateValidator implements CheckStateValidator {

    /**
     * Determines whether or not a given move would put the moving player into check or checkmate, and thus be invalid
     * @param gameState current state of the game, including board and previous turns
     * @param prospectiveBoard reflects state of board with player's desired move already carried out
     * @return whether or not the move puts the moving player in an illegal check state
     */
    public Pair<CheckState, CheckState> validate(GameState gameState, Map<BoardPosition, Piece> prospectiveBoard, PieceTeam moved) throws IllegalCheckStatusException {
        // get current check states for both players
        CheckState whiteChk = gameState.getPlayerStates().getLeft().getCheckState();
        CheckState blackChk = gameState.getPlayerStates().getRight().getCheckState();

        // run CheckUtil on pieces of opposite team on prospective board
        Pair<CheckState, CheckState> prospectiveStates = CheckUtil.getCheckStatesFromBoard(prospectiveBoard);

        switch(moved) {
            case WHITE -> {
                if(prospectiveStates.getLeft().getStatus() != CheckStatus.NONE) {
                    throw new IllegalCheckStatusException(moved, prospectiveStates.getLeft().getStatus(), CheckStatus.NONE);
                }
                return prospectiveStates;
            }
            case BLACK -> {
                if(prospectiveStates.getRight().getStatus() != CheckStatus.NONE) {
                    throw new IllegalCheckStatusException(moved, prospectiveStates.getRight().getStatus(), CheckStatus.NONE);
                }
                return prospectiveStates;
            }
            default -> throw new IllegalStateException("How did you do this?");
        }
    }
}
