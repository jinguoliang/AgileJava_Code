package com.jinux.agilejava.chess.pieces;

public class Pawn {

    public final static String COLOR_WHITE = "white";
    public final static String COLOR_BLACK = "black";

    private final String mColor;

    public Pawn(String color) {
        this.mColor = color;
    }

    public Pawn() {
        this.mColor = COLOR_WHITE;
    }

    public String getColor() {
        return mColor;
    }
}
