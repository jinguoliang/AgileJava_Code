package com.jinux.agilejava.chess;

import com.jinux.agilejava.chess.pieces.*;
import com.jinux.agilejava.utils.StringUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.jinux.agilejava.chess.pieces.Piece.Color.BLACK;
import static com.jinux.agilejava.chess.pieces.Piece.Color.WHITE;

/**
 * a chess board we can play on it
 */
public class Board {
    public static final int COLUMN_COUNT = 8;
    public static final int ROW_COUNT = COLUMN_COUNT;
    public static final int LAST_INDEX = COLUMN_COUNT - 1;
    public static final int SECOND_INDEX = 1;

    public static final int FIRST_ROW_INDEX = 0;
    private static final int SECOND_LAST_INDEX = LAST_INDEX - 1;

    private List<List<Piece>> pieces = new ArrayList<>();

    private boolean isInvert = false;

    Board() {
        initWithBlankPiece();
    }

    private void initWithBlankPiece() {
        IntStream.range(0, ROW_COUNT).forEach(i -> pieces.add(createSpaceRow()));
    }

    public void initialize() {
        List<Piece> mRow1 = pieces.get(FIRST_ROW_INDEX);
        mRow1.clear();
        mRow1.add(Rook.create(WHITE));
        mRow1.add(Knight.create(WHITE));
        mRow1.add(Bishop.create(WHITE));
        mRow1.add(Queen.create(WHITE));
        mRow1.add(King.create(WHITE));
        mRow1.add(Bishop.create(WHITE));
        mRow1.add(Knight.create(WHITE));
        mRow1.add(Rook.create(WHITE));

        List<Piece> mRow8 = pieces.get(LAST_INDEX);
        mRow8.clear();
        mRow8.add(Rook.create(BLACK));
        mRow8.add(Knight.create(BLACK));
        mRow8.add(Bishop.create(BLACK));
        mRow8.add(Queen.create(BLACK));
        mRow8.add(King.create(BLACK));
        mRow8.add(Bishop.create(BLACK));
        mRow8.add(Knight.create(BLACK));
        mRow8.add(Rook.create(BLACK));

        List<Piece> mRow2 = pieces.get(SECOND_INDEX);
        List<Piece> mRow7 = pieces.get(SECOND_LAST_INDEX);
        IntStream.range(0, COLUMN_COUNT).forEach(i -> {
            mRow2.set(i, Pawn.create(WHITE));
            mRow7.set(i, Pawn.create(BLACK));
        });
    }

    private List<Piece> createSpaceRow() {
        return IntStream.range(0, COLUMN_COUNT)
                .mapToObj(i -> BlankPiece.create())
                .collect(Collectors.toList());
    }


    public int getPieceCount(Piece.Color color, Class<? extends Piece> clazz) {
        return (int) pieces.stream().flatMap(Collection::stream)
                .filter(piece -> (piece.getColor() == color)
                        && piece.getClass().equals(clazz))
                .count();
    }


    public String getRowToPrint(int i) {
        List<Piece> list = pieces.get(i - 1);

        StringBuilder builder = new StringBuilder();
        list.forEach(piece -> builder.append(piece.getRepresentation()));
        return builder.toString();
    }

    public String getPrintFormat() {
        StringBuilder builder = new StringBuilder();
        for (int i = 8; i >= 1; i--) {
            builder.append(StringUtil.appendNewLine(getRowToPrint(i)));
        }
        return builder.toString();
    }

    public Piece getPieceAtPosition(String pos) {
        Position position = Position.by(pos);
        int row = getRowIndexFrom(position.getRow());
        int column = getColumnIndexFrom(position.getColumn());
        return pieces.get(row).get(column);
    }

    private int getColumnIndexFrom(int pos) {
        return isInvert ? getInvertIndex(pos) : pos;
    }

    private int getRowIndexFrom(int pos) {
        return isInvert ? getInvertIndex(pos) : pos;
    }

    private int getInvertIndex(int index) {
        return LAST_INDEX - index;
    }

    public boolean getInvert() {
        return isInvert;
    }

    public void setInvert(boolean isInversion) {
        this.isInvert = isInversion;
    }

    public int getTotalCount() {
        return (int) pieces.stream().flatMap(Collection::stream)
                .filter(piece -> !piece.getClass().equals(BlankPiece.class))
                .count();
    }

    public void setPieceAtPosition(String posStr, Piece piece) {
        Position position = Position.by(posStr);
        pieces.get(position.getRow()).set(position.getColumn(), piece);
    }

    int computeOneColumnPawnCount(Piece.Color color, int column) {
        int count = 0;
        for (int row = 0; row < Board.ROW_COUNT; row++) {
            Piece piece = getPieces().get(row).get(column);
            if (piece.getClass().equals(Pawn.class)
                    && piece.getColor() == color) {
                count++;
            }
        }
        return count;
    }

    public List<List<Piece>> getPieces() {
        return pieces;
    }

    public void removePieceAtPosition(String posStr) {
        Position position = Position.by(posStr);
        pieces.get(position.getRow()).set(position.getColumn(), BlankPiece.create());
    }
}
