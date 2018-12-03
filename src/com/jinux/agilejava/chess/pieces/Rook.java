package com.jinux.agilejava.chess.pieces;

import com.jinux.agilejava.chess.Board;

import java.util.List;

public class Rook extends Piece {
    private Rook(Color color) {
        super(color);
    }

    public static Rook create(Color color) {
        return new Rook(color);
    }

    @Override
    protected char getRawRepresentation() {
        return ROOK_REPRESENTATION;
    }

    @Override
    public float getScore() {
        return SCORE_ROOK;
    }

    @Override
    public List<String> getPossibleMoves(String pos, Board board) {
        return null;
    }
}
