package com.jinux.agilejava.chess;

import com.jinux.agilejava.chess.pieces.Piece;
import com.jinux.agilejava.utils.StringUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * a chess board we can play on it
 */
public class Board {
    private List<List<Piece>> mPieces = new ArrayList<>();


    public void initialize() {
        for (int i = 0; i < 8; i++) {
            mPieces.add(createSpaceRow());
        }


        List<Piece> mRow1 = mPieces.get(0);
        mRow1.clear();
        "rnbqkbnr".chars().forEach(i -> mRow1.add(Piece.createWhite((char) i)));

        List<Piece> mRow8 = mPieces.get(7);
        mRow8.clear();
        "RNBQKBNR".chars().forEach(i -> mRow8.add(Piece.createBlack((char) i)));

        List<Piece> mRow2 = mPieces.get(1);
        mRow2.clear();
        List<Piece> mRow7 = mPieces.get(7 - 1);
        mRow7.clear();
        for (int i = 0; i < 8; i++) {
            mRow2.add(Piece.createWhite('p'));
            mRow7.add(Piece.createBlack('P'));
        }

    }

    private List<Piece> createSpaceRow() {
        List<Piece> row = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            row.add(new Piece(Piece.Color.WHITE, '.'));
        }
        return row;
    }


    public int getPieceCount() {
        return 32;
    }


    public String getRowToPrint(int i) {
        List<Piece> list = mPieces.get(i - 1);

        StringBuilder builder = new StringBuilder();
        list.forEach(piece -> builder.append(piece.getPrintChar()));
        return builder.toString();
    }

    public String getPrintFormat() {
        StringBuilder builder = new StringBuilder();
        for (int i = 8; i >= 1; i--) {
            builder.append(StringUtil.appendNewLine(getRowToPrint(i)));
        }
        return builder.toString();
    }
}
