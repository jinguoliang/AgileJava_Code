package com.jinux.agilejava.chess.pieces;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QueenTest extends PieceTest {

    @Override
    Piece createPiece(Piece.Color color) {
        return Queen.create(color);
    }

    @Test
    void testScore() {
        assertEquals(Piece.SCORE_QUEEN, createPiece(Piece.Color.BLACK).getScore());
    }
}