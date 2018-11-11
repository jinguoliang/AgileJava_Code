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
        assertEquals(32, mBoard.getPieceCount());

        mBoard.initialize();
        assertEquals("pppp" + "pppp", mBoard.getRowToPrint(2));
        assertEquals("PPPP" + "PPPP", mBoard.getRowToPrint(7));

        String blankRank = StringUtil.appendNewLine("...." + "....");
        assertEquals(""
                + StringUtil.appendNewLine("RNBQ" + "KBNR")
                + StringUtil.appendNewLine("PPPP" + "PPPP")
                + blankRank
                + blankRank
                + blankRank
                + blankRank
                + StringUtil.appendNewLine("pppp" + "pppp")
                + StringUtil.appendNewLine("rnbq" + "kbnr"), mBoard.getPrintFormat());
    }
}