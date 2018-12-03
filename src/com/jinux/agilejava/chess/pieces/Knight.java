package com.jinux.agilejava.chess.pieces;

import com.jinux.agilejava.chess.Board;

import java.util.List;

public class Knight extends Piece {
    private Knight(Color color) {
        super(color);
    }

    public static Knight create(Color color) {
        return new Knight(color);
    }

    @Override
    protected char getRawRepresentation() {
        return KNIGHT_REPRESENTATION;
    }

    @Override
    public float getScore() {
        return SCORE_KNIGHT;
    }

    @Override
    public List<String> getPossibleMoves(String pos, Board board) {
        return null;
    }
}
