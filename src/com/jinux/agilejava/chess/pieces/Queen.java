package com.jinux.agilejava.chess.pieces;

import com.jinux.agilejava.chess.Board;
import com.jinux.agilejava.chess.Position;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {
    Queen(Color color) {
        super(color);
    }

    public static Queen create(Color color) {
        return new Queen(color);
    }

    @Override
    protected char getRawRepresentation() {
        return QUEEN_REPRESENTATION;
    }

    @Override
    public float getScore() {
        return SCORE_QUEEN;
    }

    @Override
    public List<String> getPossibleMoves(String pos, Board board) {
        Position position = Position.by(pos);

        List<String> result = new ArrayList<>(14);

        for (int i = 0; i < 8; i++) {
            if (i != position.getRow()) {
                result.add(position.clone(0, i - position.getRow()).toString());
            }
        }

        for (int i = 0; i < 8; i++) {
            if (i != position.getColumn()) {
                result.add(position.clone(i - position.getColumn(), 0).toString());
            }
        }

        return result;
    }
}
