package com.jinux.agilejava.chess.pieces;

public class Piece {

    private final Color mColor;
    private Character mPrintChar;
    public Piece(Color color, Character p) {
        this.mColor = color;
        this.mPrintChar = p;
    }

    public Color getColor() {
        return mColor;
    }

    public char getPrintChar() {
        return mPrintChar;
    }

    public boolean isWhite() {
        return mColor == Color.WHITE;
    }

    public boolean isBlack() {
        return mColor == Color.BLACK;
    }

    public enum Color {WHITE, BLACK}
}