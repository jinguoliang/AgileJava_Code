package com.jinux.agilejava.chess.pieces;

public class Piece {

    public final static String COLOR_WHITE = "white";
    public final static String COLOR_BLACK = "black";

    private final String mColor;
    private Character mPrintChar;

    public Piece(String colorWhite, Character p) {
        this.mColor = colorWhite;
        this.mPrintChar = p;
    }

    public String getColor() {
        return mColor;
    }

    public char getPrintChar() {
        return mPrintChar;
    }
}
