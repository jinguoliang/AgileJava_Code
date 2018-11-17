package com.jinux.agilejava.chess;

import com.jinux.agilejava.chess.pieces.Piece;
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
        mBoard.initialize();
        assertEquals("pppp" + "pppp", mBoard.getRowToPrint(2));
        assertEquals("PPPP" + "PPPP", mBoard.getRowToPrint(7));

        assertEquals(""
                + StringUtil.appendNewLine("RNBQ" + "KBNR")
                + StringUtil.appendNewLine("PPPP" + "PPPP")
                + StringUtil.appendNewLine("...." + "....")
                + StringUtil.appendNewLine("...." + "....")
                + StringUtil.appendNewLine("...." + "....")
                + StringUtil.appendNewLine("...." + "....")
                + StringUtil.appendNewLine("pppp" + "pppp")
                + StringUtil.appendNewLine("rnbq" + "kbnr"), mBoard.getPrintFormat());
    }

    @Test
    void testCount() {
        mBoard.initialize();

        assertEquals(8, mBoard.getPieceCount(Piece.Color.WHITE, Piece.PAWN_REPRESENTATION));
        assertEquals(8, mBoard.getPieceCount(Piece.Color.BLACK, Piece.PAWN_REPRESENTATION));
    }
}
