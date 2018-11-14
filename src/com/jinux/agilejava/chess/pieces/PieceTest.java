package com.jinux.agilejava.chess.pieces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.jinux.agilejava.chess.pieces.Piece.COLOR_BLACK;
import static com.jinux.agilejava.chess.pieces.Piece.COLOR_WHITE;
import static org.junit.jupiter.api.Assertions.*;

class PieceTest {

    private Piece piece1;
    private Piece piece2;

    @BeforeEach
    void setUp() {
        piece1 = new Piece(COLOR_WHITE, 'p');
        piece2 = new Piece(COLOR_BLACK, 'P');
    }
    @Test
    void testCreate() {

        assertEquals(COLOR_WHITE, piece1.getColor());
        assertEquals('p', piece1.getPrintChar());


        assertEquals(COLOR_BLACK, piece2.getColor());
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