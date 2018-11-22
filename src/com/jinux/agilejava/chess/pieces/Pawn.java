package com.jinux.agilejava.chess.pieces;

public class Pawn extends Piece {
    Pawn(Color color) {
        super(color);
    }

    public static Piece create(Color color) {
        return new Pawn(color);
    }

    @Override
    protected char getRawRepresentation() {
        return PAWN_REPRESENTATION;
    }

    @Override
    public float getScore() {
        return SCORE_ZERO;
    }
}
