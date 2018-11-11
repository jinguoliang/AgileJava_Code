package com.jinux.agilejava.chess;

import com.jinux.agilejava.chess.pieces.Pawn;
import com.jinux.agilejava.utils.StringUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * a chess board we can play on it
 */
public class Board {
    private List<List<Pawn>> mPawns = new ArrayList<>();


    public void initialize() {
        for (int i = 0; i < 8; i++) {
            mPawns.add(new ArrayList<>());
        }

        List<Pawn> mRow2 = mPawns.get(1);
        List<Pawn> mRow7 = mPawns.get(7 - 1);

        for (int i = 0; i < 8; i++) {
            mRow2.add(new Pawn(Pawn.COLOR_WHITE, 'p'));
            mRow7.add(new Pawn(Pawn.COLOR_BLACK, 'P'));
        }

    }


    public int getPawnCount() {
        return 16;
    }


    public String getRowToPrint(int i) {
        List<Pawn> list = mPawns.get(i - 1);

        StringBuilder builder = new StringBuilder();

        if (list.isEmpty()) {
            builder.append("...." + "....");
        } else {
            for (Pawn pawn : list) {
                builder.append(pawn.getPrintChar());
            }
        }
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
