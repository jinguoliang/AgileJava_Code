package com.jinux.agilejava.chess;

import com.jinux.agilejava.chess.pieces.Piece;
import com.jinux.agilejava.utils.StringUtil;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        mRow1.add(Piece.createWhiteRook());
        mRow1.add(Piece.createWhiteKnight());
        mRow1.add(Piece.createWhiteBishop());
        mRow1.add(Piece.createWhiteQueen());
        mRow1.add(Piece.createWhiteKing());
        mRow1.add(Piece.createWhiteBishop());
        mRow1.add(Piece.createWhiteKnight());
        mRow1.add(Piece.createWhiteRook());

        List<Piece> mRow8 = pieces.get(LAST_INDEX);
        mRow8.clear();
        mRow8.add(Piece.createBlackRook());
        mRow8.add(Piece.createBlackKnight());
        mRow8.add(Piece.createBlackBishop());
        mRow8.add(Piece.createBlackQueen());
        mRow8.add(Piece.createBlackKing());
        mRow8.add(Piece.createBlackBishop());
        mRow8.add(Piece.createBlackKnight());
        mRow8.add(Piece.createBlackRook());

        List<Piece> mRow2 = pieces.get(SECOND_INDEX);
        List<Piece> mRow7 = pieces.get(SECOND_LAST_INDEX);
        IntStream.range(0, COLUMN_COUNT).forEach(i -> {
            mRow2.set(i, Piece.createWhitePawn());
            mRow7.set(i, Piece.createBlackPawn());
        });
    }

    private List<Piece> createSpaceRow() {
        return IntStream.range(0, COLUMN_COUNT)
                .mapToObj(i -> Piece.noPiece())
                .collect(Collectors.toList());
    }


    public int getPieceCount(Piece.Color color, Piece.Type type) {
        return (int) pieces.stream().flatMap(Collection::stream)
                .filter(piece -> piece.getColor() == color
                        && piece.getType() == type)
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
                .filter(piece -> piece.getType() != Piece.Type.NO_PIECE)
                .count();
    }

    public void setPieceAtPosition(String posStr, Piece.Color color, Piece.Type type) {
        Position position = Position.by(posStr);
        pieces.get(position.getRow()).set(position.getColumn(), Piece.create(color, type));
    }

    int computeOneColumnPawnCount(Piece.Color color, int column) {
        int count = 0;
        for (int row = 0; row < Board.ROW_COUNT; row++) {
            Piece piece = getPieces().get(row).get(column);
            if (piece.getType() == Piece.Type.PAWN
                    && piece.getColor() == color) {
                count++;
            }
        }
        return count;
    }

    public List<List<Piece>> getPieces() {
        return pieces;
    }
}
