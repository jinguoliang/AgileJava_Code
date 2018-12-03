package com.jinux.agilejava.chess.pieces;

import com.jinux.agilejava.chess.Board;

import java.util.List;

public class BlankPiece extends Piece {
    private BlankPiece(Color color) {
        super(color);
    }

    @Override
    protected char getRawRepresentation() {
        return BLANK_REPRESENTATION;
    }

    @Override
    public float getScore() {
        return SCORE_ZERO;
    }

    @Override
    public List<String> getPossibleMoves(String pos, Board board) {
        return null;
    }

    public static BlankPiece create() {
        return new BlankPiece(Color.WHITE);
    }
}
