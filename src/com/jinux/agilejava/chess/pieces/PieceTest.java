package com.jinux.agilejava.chess.pieces;

import org.junit.jupiter.api.Test;

import static com.jinux.agilejava.chess.pieces.Piece.COLOR_BLACK;
import static com.jinux.agilejava.chess.pieces.Piece.COLOR_WHITE;
import static org.junit.jupiter.api.Assertions.*;

class PieceTest {
    @Test
    void testCreate() {
        Piece piece4 = new Piece(COLOR_WHITE, 'p');
        assertEquals(COLOR_WHITE, piece4.getColor());
        assertEquals('p', piece4.getPrintChar());

        Piece piece5 = new Piece(COLOR_BLACK, 'P');
        assertEquals(COLOR_BLACK, piece5.getColor());
        assertEquals('P', piece5.getPrintChar());
    }

}