package com.jinux.agilejava.chess;

import com.jinux.agilejava.chess.pieces.Piece;

import java.util.Collection;
import java.util.Optional;

/**
 * game logic
 */
public class Game {
    public static final int SCORE_PAWN = 1;
    public static final float SCORE_PAWN_WHEN_HAVE_OTHER_PAWN_IN_SAME_COLUMN = 0.5f;

    private final Board board;

    public Game() {
        board = new Board();
    }

    public float getAllScore(Piece.Color color) {
        Optional<Float> optionalFloat = board.getPieces().stream()
                .flatMap(Collection::stream)
                .filter(piece -> piece.getColor() == color)
                .map(this::getPieceScore).reduce((sum, n) -> sum + n);
        float excludePawn = optionalFloat.isPresent() ? optionalFloat.get() : 0;
        return excludePawn + computePawnScore(color);
    }

    private float getPieceScore(Piece piece) {
        return piece.getScore();
    }

    float computePawnScore(Piece.Color color) {
        float score = 0;
        for (int column = 0; column < Board.COLUMN_COUNT; column++) {
            score += computeOneColumnPawnScore(color, column);
        }
        return score;
    }

    float computeOneColumnPawnScore(Piece.Color color, int column) {
        int count = board.computeOneColumnPawnCount(color, column);

        if (count == 1) {
            return SCORE_PAWN;
        }
        if (count > 1) {
            return count * SCORE_PAWN_WHEN_HAVE_OTHER_PAWN_IN_SAME_COLUMN;
        }
        return 0;
    }

    public Board getBoard() {
        return board;
    }

    public void moveLeft(String pos) {
        Position position = Position.by(pos);
        position.setColumn(position.getColumn() - 1);

        Piece piece = board.getPieceAtPosition(pos);
        board.setPieceAtPosition(position.toString(), piece.getColor(), piece.getClass());
        board.removePieceAtPosition(pos);
    }
}
