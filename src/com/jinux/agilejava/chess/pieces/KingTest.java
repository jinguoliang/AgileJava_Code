package com.jinux.agilejava.chess.pieces;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KingTest extends PieceTest {
    @Test
    void testCreate() {
    }

    @Test
    void testMoveLeft() {
        King king = King.create(Piece.Color.WHITE);
//        king.moveLeft()
    }

    @Test
    void getRepresentation() {
        assertEquals('k', King.create(Piece.Color.BLACK).getRawRepresentation());
    }

    @Override
    Piece createPiece(Piece.Color color) {
        return King.create(color);
    }

    @Test
    void testScore() {
       assertEquals(Piece.SCORE_ZERO, createPiece(Piece.Color.BLACK).getScore());
    }
}