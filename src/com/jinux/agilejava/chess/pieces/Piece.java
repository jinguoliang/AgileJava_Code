package com.jinux.agilejava.chess.pieces;

import com.jinux.agilejava.chess.Board;

import java.util.List;

public abstract class Piece {

    public static final char PAWN_REPRESENTATION = 'p';
    public static final char ROOK_REPRESENTATION = 'r';
    public static final char KNIGHT_REPRESENTATION = 'n';
    public static final char BISHOP_REPRESENTATION = 'b';
    public static final char QUEEN_REPRESENTATION = 'q';
    public static final char KING_REPRESENTATION = 'k';
    public static final char BLANK_REPRESENTATION = '.';

    public static final float SCORE_ROOK = 5;
    public static final float SCORE_QUEEN = 9;
    public static final float SCORE_BISHOP = 3;
    public static final float SCORE_KNIGHT = 2.5f;
    public static final float SCORE_ZERO = 0;

    private Color color;

    Piece(Color color) {
        this.color = color;
    }

    public boolean isWhite() {
        return color == Color.WHITE;
    }

    public boolean isBlack() {
        return color == Color.BLACK;
    }

    public Color getColor() {
        return color;
    }

    public char getRepresentation() {
        if (color == Color.WHITE) {
            return getRawRepresentation();
        } else {
            return Character.toUpperCase(getRawRepresentation());
        }
    }

    protected abstract char getRawRepresentation();

    public abstract float getScore();

    public abstract List<String> getPossibleMoves(String pos, Board board);

    public enum Color {WHITE, BLACK}
}
