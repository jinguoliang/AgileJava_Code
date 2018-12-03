package com.jinux.agilejava.chess;

public class Position {
    private int row;
    private int column;

    public Position(String posStr) {
        this.row = getIndexFrom(posStr, 1, '1');
        this.column = getIndexFrom(posStr, 0, 'a');
    }

    public Position(int column, int row) {
        this.row = row;
        this.column = column;
    }

    public static Position by(String posStr) {
        return new Position(posStr);
    }

    public Position clone(int dColumn, int dRow) {
        return new Position(this.column + dColumn, this.row + dRow);
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

    public void setColumn(int i) {
        column = i;
    }

    @Override
    public String toString() {
        return columnToString() + rowToString();
    }

    private String rowToString() {
        return "" + (row + 1);
    }

    private char columnToString() {
        return (char)('a' + column);
    }
}
