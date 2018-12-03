package com.jinux.agilejava.chess.pieces;

import com.jinux.agilejava.chess.Board;

import java.util.List;

public class Queen extends Piece {
    Queen(Color color) {
        super(color);
    }

    @Override
    protected char getRawRepresentation() {
        return QUEEN_REPRESENTATION;
    }

    @Override
    public float getScore() {
        return SCORE_QUEEN;
    }

    @Override
    public List<String> getPossibleMoves(String pos, Board board) {
        return null;
    }

    public static Queen create(Color color) {
        return new Queen(color);
    }
}
