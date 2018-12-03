package com.jinux.agilejava.chess.pieces;

import com.jinux.agilejava.chess.Board;
import com.jinux.agilejava.chess.Position;

import java.util.Arrays;
import java.util.List;

public class King extends Piece {
    private King(Color color) {
        super(color);
    }

    public static King create(Color color) {
        return new King(color);
    }

    @Override
    protected char getRawRepresentation() {
        return KING_REPRESENTATION;
    }

    @Override
    public float getScore() {
        return SCORE_ZERO;
    }

    @Override
    public List<String> getPossibleMoves(String pos, Board board) {
        Position position = Position.by(pos);
        return Arrays.asList(position.clone(1, 0).toString(),
                position.clone(-1, 0).toString(),
                position.clone(0, 1).toString(),
                position.clone(0, -1).toString());
    }
}
