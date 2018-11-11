package com.jinux.agilejava.chess;

import com.jinux.agilejava.chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

/**
 * a chess board we can play on it
 */
public class Board {
    private List<Pawn> mPawns = new ArrayList<>();

    public boolean isEmpty() {
        return true;
    }

    public void addPawn(Pawn pawn) {
        mPawns.add(pawn);
    }

    public List<Pawn> getPawns() {
        return mPawns;
    }

    public int getPawnCount() {
        return mPawns.size();
    }

    public Pawn get(int i) {
        return mPawns.get(i);
    }
}
