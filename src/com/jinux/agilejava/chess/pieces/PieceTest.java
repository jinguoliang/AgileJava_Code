package com.jinux.agilejava.chess.pieces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceTest {

    private Piece piece1;
    private Piece piece2;

    @BeforeEach
    void setUp() {
        piece1 = new Piece(Piece.Color.WHITE, 'p');
        piece2 = new Piece(Piece.Color.BLACK, 'P');
    }
    @Test
    void testCreate() {

        assertEquals(Piece.Color.WHITE, piece1.getColor());
        assertEquals('p', piece1.getPrintChar());


        assertEquals(Piece.Color.BLACK, piece2.getColor());
        assertEquals('P', piece2.getPrintChar());
    }

    @Test
    void testColor() {
        assertTrue(piece1.isWhite());
        assertFalse(piece2.isWhite());
        assertFalse(piece1.isBlack());
        assertTrue(piece2.isBlack());
    }

}