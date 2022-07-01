package com.example.chessbot.game.utility;

import com.example.chessbot.model.state.player.attributes.CheckState;
import com.example.chessbot.model.board.position.BoardPosition;
import com.example.chessbot.model.utility.Pair;
import com.example.chessbot.model.piece.Piece;
import com.example.chessbot.model.piece.PieceNames;
import com.example.chessbot.model.piece.PieceTeam;

import java.util.*;

public final class CheckUtil {

    public static Pair<CheckState, CheckState> getCheckStatesFromBoard(Map<BoardPosition, Piece> board) {
        // get location of king for specified team
        Pair<BoardPosition, BoardPosition> kingLocations = getKingLocations(board);

        // given location of king, check each opposing piece to see if it has a valid move to capture it currently
        board.forEach((position, piece) -> {

        });
        return null;
    }

    // TODO consider adding king location as property of player state tracked from beginning to prevent doing this
    public static Pair<BoardPosition, BoardPosition> getKingLocations(Map<BoardPosition, Piece> board) {
        List<Pair<BoardPosition, Piece>> kingLocations = new ArrayList<>();
        board.forEach((position, piece) -> {
            if(piece.getPieceName() == PieceNames.KING) {
                kingLocations.add(new Pair<>(position, piece));
            }
        });

        if(kingLocations.get(0).getRight().getPieceTeam() == PieceTeam.WHITE) {
            // return pair where white king is always on the left
            return new Pair<>(kingLocations.get(0).getLeft(), kingLocations.get(1).getLeft());
        } else return new Pair<>(kingLocations.get(1).getLeft(), kingLocations.get(0).getLeft());
    }


    /**
     * @param board current pieces on board
     * @return two lists of pairs, each pair contains a board position that the king is held in check from and the piece present there
     */
    public static Pair<List<Pair<BoardPosition, Piece>>, List<Pair<BoardPosition, Piece>>> getListInCheckFrom(Map<BoardPosition, Piece> board, Pair<BoardPosition, BoardPosition> kingLocations) {
        List<Pair<BoardPosition, Piece>> whiteInCheckFrom = new ArrayList<>();
        List<Pair<BoardPosition, Piece>> blackInCheckFrom = new ArrayList<>();

        board.forEach((position, piece) -> {
            if(piece.getPieceTeam() == PieceTeam.WHITE
                && CaptureUtil.canPutInCheck()) {
                blackInCheckFrom.add(new Pair(position, piece));
            } else if (piece.getPieceTeam() == PieceTeam.BLACK
                && CaptureUtil.canPutInCheck()) {
                whiteInCheckFrom.add(new Pair(position, piece));
            }
        });

        return new Pair<>(whiteInCheckFrom, blackInCheckFrom);
    }
}
