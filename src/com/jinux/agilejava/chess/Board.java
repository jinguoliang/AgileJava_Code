package com.jinux.agilejava.chess;

import com.jinux.agilejava.chess.pieces.Piece;
import com.jinux.agilejava.utils.StringUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * a chess board we can play on it
 */
public class Board {
    private List<List<Piece>> mPieces = new ArrayList<>();
    private boolean isInvert = false;

    Board() {
        for (int i = 0; i < 8; i++) {
            mPieces.add(createSpaceRow());
        }
    }

    public void initialize() {
        List<Piece> mRow1 = mPieces.get(0);
        mRow1.clear();
        mRow1.add(Piece.createWhiteRook());
        mRow1.add(Piece.createWhiteKnight());
        mRow1.add(Piece.createWhiteBishop());
        mRow1.add(Piece.createWhiteQueen());
        mRow1.add(Piece.createWhiteKing());
        mRow1.add(Piece.createWhiteBishop());
        mRow1.add(Piece.createWhiteKnight());
        mRow1.add(Piece.createWhiteRook());

        List<Piece> mRow8 = mPieces.get(7);
        mRow8.clear();
        mRow8.add(Piece.createBlackRook());
        mRow8.add(Piece.createBlackKnight());
        mRow8.add(Piece.createBlackBishop());
        mRow8.add(Piece.createBlackQueen());
        mRow8.add(Piece.createBlackKing());
        mRow8.add(Piece.createBlackBishop());
        mRow8.add(Piece.createBlackKnight());
        mRow8.add(Piece.createBlackRook());

        List<Piece> mRow2 = mPieces.get(1);
        mRow2.clear();
        List<Piece> mRow7 = mPieces.get(7 - 1);
        mRow7.clear();
        for (int i = 0; i < 8; i++) {
            mRow2.add(Piece.createWhitePawn());
            mRow7.add(Piece.createBlackPawn());
        }
    }

    private List<Piece> createSpaceRow() {
        List<Piece> row = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            row.add(Piece.noPiece());
        }
        return row;
    }


    public int getPieceCount(Piece.Color color, char representation) {
        return (int) mPieces.stream().flatMap(pieces -> pieces.stream())
                .filter(piece -> piece.getColor() == color
                        && Character.toLowerCase(piece.getRepresentation()) == representation)
                .count();
    }


    public String getRowToPrint(int i) {
        List<Piece> list = mPieces.get(i - 1);

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
        return mPieces.get(row).get(column);
    }

    private int getColumnIndexFrom(int pos) {
        return isInvert ? getInvertIndex(pos) : pos;
    }

    private int getRowIndexFrom(int pos) {
        return isInvert ? getInvertIndex(pos) : pos;
    }

    private int getInvertIndex(int index) {
        return 7 - index;
    }

    public boolean getInvert() {
        return isInvert;
    }

    public void setInvert(boolean isInversion) {
        this.isInvert = isInversion;
    }

    public int getTotalCount() {
        return (int) mPieces.stream().flatMap(Collection::stream)
                .filter(piece -> piece.getType() != Piece.Type.NO_PIECE)
                .count();
    }

    public void setPieceAtPosition(String posStr, Piece.Color color, Piece.Type type) {
        Position position = Position.by(posStr);
        mPieces.get(position.getRow()).set(position.getColumn(), Piece.create(color, type));
    }
}
