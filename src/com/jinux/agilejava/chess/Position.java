package com.jinux.agilejava.chess;

public class Position {
    private int row;
    private int column;

    public Position(String posStr) {
        this.row = getIndexFrom(posStr, 1, '1');
        this.column = getIndexFrom(posStr, 0, 'a');
    }

    public static Position by(String posStr) {
        return new Position(posStr);
    }

    private int getIndexFrom(String posString, int i, char start) {
        return posString.charAt(i) - start;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
