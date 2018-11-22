package com.jinux.agilejava.chess.pieces;

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

    public static Queen create(Color color) {
        return new Queen(color);
    }
}
