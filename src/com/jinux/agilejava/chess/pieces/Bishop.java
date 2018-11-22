package com.jinux.agilejava.chess.pieces;

public class Bishop extends Piece {
    private Bishop(Color color) {
        super(color);
    }

    @Override
    protected char getRawRepresentation() {
        return BISHOP_REPRESENTATION;
    }

    @Override
    public float getScore() {
        return SCORE_BISHOP;
    }

    public static Bishop create(Color color) {
        return new Bishop(color);
    }
}
