package com.jinux.agilejava.chess.pieces;

public class BlankPiece extends Piece {
    private BlankPiece(Color color) {
        super(color);
    }

    @Override
    protected char getRawRepresentation() {
        return BLANK_REPRESENTATION;
    }

    @Override
    public float getScore() {
        return SCORE_ZERO;
    }

    public static BlankPiece create() {
        return new BlankPiece(Color.WHITE);
    }
}
