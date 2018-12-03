package com.jinux.agilejava.chess.pieces;

import com.jinux.agilejava.chess.Board;

import java.util.List;

public class Bishop extends Piece {
    private Bishop(Color color) {
        super(color);
    }

    @Override
    protected char getRawRepresentation() {
        return BISHOP_REPRESENTATION;
    }

    @Override
    public float getScore() {
        return SCORE_BISHOP;
    }

    @Override
    public List<String> getPossibleMoves(String pos, Board board) {
        return null;
    }

    public static Bishop create(Color color) {
        return new Bishop(color);
    }
}
