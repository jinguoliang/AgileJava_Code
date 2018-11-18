package com.jinux.agilejava.chess;

import com.jinux.agilejava.chess.pieces.Piece;
import com.jinux.agilejava.utils.StringUtil;
import org.junit.jupiter.api.Assertions;
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
        assertEquals(0, mBoard.getTotalCount());
    }

    @Test
    void testInitialize() {
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

    @Test
    void testGetPieceAtPosition() {
        mBoard.initialize();

        Assertions.assertFalse(mBoard.getInvert());
        assertPieceAtPosition(Piece.Color.BLACK,Piece.Type.ROOK, "a8");
        assertPieceAtPosition(Piece.Color.WHITE,Piece.Type.KING, "e1");

        mBoard.setInvert(true);
        Assertions.assertTrue(mBoard.getInvert());
        assertPieceAtPosition(Piece.Color.WHITE,Piece.Type.ROOK, "a8");
        assertPieceAtPosition(Piece.Color.BLACK,Piece.Type.QUEEN, "e1");

    }

    private void assertPieceAtPosition(Piece.Color color, Piece.Type type, String pos) {
        Piece p  = mBoard.getPieceAtPosition(pos);
        assertEquals(color, p.getColor());
        assertEquals(type, p.getType());
    }

    @Test
    void testSetPieceAtPosition() {
        mBoard.setPieceAtPosition("b6", Piece.Color.BLACK, Piece.Type.KING);
        assertPieceAtPosition( Piece.Color.BLACK, Piece.Type.KING, "b6");
        assertEquals(1, mBoard.getTotalCount());
    }
}
