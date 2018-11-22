package com.jinux.agilejava.chess.pieces;

public class King extends Piece {
    private King(Color color) {
        super(color);
    }

    @Override
    protected char getRawRepresentation() {
        return KING_REPRESENTATION;
    }

    @Override
    public float getScore() {
        return SCORE_ZERO;
    }

    public static King create(Color color) {
        return new King(color);
    }
}
