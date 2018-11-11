package com.jinux.agilejava.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardTest {

    private Board mBoard;

    @BeforeEach
    void setUp() {
        mBoard = new Board();

    }

    @Test
    void testCreate() {
        assertEquals(16, mBoard.getPawnCount());

        mBoard.initialize();
        assertEquals("pppp" + "pppp", mBoard.getRowToPrint(2));
        assertEquals("PPPP" + "PPPP", mBoard.getRowToPrint(7));

        assertEquals(""
                + "...." + "...." + "\n"
                + "PPPP" + "PPPP" + "\n"
                + "...." + "...." + "\n"
                + "...." + "...." + "\n"
                + "...." + "...." + "\n"
                + "...." + "...." + "\n"
                + "pppp" + "pppp" + "\n"
                + "...." + "...." + "\n", mBoard.getPrintFormat());
    }
}