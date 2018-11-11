package com.jinux.agilejava.chess;

import com.jinux.agilejava.utils.StringUtil;
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
                + StringUtil.line("...." + "....")
                + StringUtil.line("PPPP" + "PPPP")
                + StringUtil.line("...." + "....")
                + StringUtil.line("...." + "....")
                + StringUtil.line("...." + "....")
                + StringUtil.line("...." + "....")
                + StringUtil.line("pppp" + "pppp")
                + StringUtil.line("...." + "...."), mBoard.getPrintFormat());
    }
}