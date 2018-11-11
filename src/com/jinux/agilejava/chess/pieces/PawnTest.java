package com.jinux.agilejava.chess.pieces;

import org.junit.jupiter.api.Test;

import static com.jinux.agilejava.chess.pieces.Pawn.COLOR_BLACK;
import static com.jinux.agilejava.chess.pieces.Pawn.COLOR_WHITE;
import static org.junit.jupiter.api.Assertions.*;

class PawnTest {
    @Test
    void testCreate() {
        Pawn pawn1 = new Pawn(COLOR_WHITE);
        assertEquals(COLOR_WHITE, pawn1.getColor());

        Pawn pawn2 = new Pawn(COLOR_BLACK);
        assertEquals(COLOR_BLACK, pawn2.getColor());

        Pawn pawn3 = new Pawn();
        assertEquals(COLOR_WHITE, pawn3.getColor());

        Pawn pawn4 = new Pawn(COLOR_WHITE, 'p');
        assertEquals('p', pawn4.getPrintChar());

        Pawn pawn5 = new Pawn(COLOR_BLACK, 'P');
        assertEquals('P', pawn5.getPrintChar());
    }

}