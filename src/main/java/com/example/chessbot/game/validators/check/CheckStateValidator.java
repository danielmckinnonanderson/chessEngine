package com.example.chessbot.game.validators.check;

import com.example.chessbot.game.validators.exceptions.IllegalCheckStatusException;
import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.piece.PieceTeam;
import com.example.chessbot.model.state.GameState;
import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.state.player.attributes.CheckState;
import com.example.chessbot.model.utility.Pair;

import java.util.Map;

public interface CheckStateValidator {
    Pair<CheckState, CheckState> validate(GameState gameState, Map<BoardPosition, Piece> prospectiveBoard, PieceTeam moved) throws IllegalCheckStatusException;
}
