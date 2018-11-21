package com.jinux.agilejava.chess;

import com.jinux.agilejava.chess.pieces.Piece;
import com.jinux.agilejava.utils.StringUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.jinux.agilejava.chess.pieces.Piece.Color.WHITE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    void testCreate() {
        assertEquals(0, board.getTotalCount());
    }

    @Test
    void testInitialize() {
        board.initialize();

        assertEquals("pppp" + "pppp", board.getRowToPrint(2));
        assertEquals("PPPP" + "PPPP", board.getRowToPrint(7));

        assertEquals(""
                + StringUtil.appendNewLine("RNBQ" + "KBNR")
                + StringUtil.appendNewLine("PPPP" + "PPPP")
                + StringUtil.appendNewLine("...." + "....")
                + StringUtil.appendNewLine("...." + "....")
                + StringUtil.appendNewLine("...." + "....")
                + StringUtil.appendNewLine("...." + "....")
                + StringUtil.appendNewLine("pppp" + "pppp")
                + StringUtil.appendNewLine("rnbq" + "kbnr"), board.getPrintFormat());
    }

    @Test
    void testCount() {
        board.initialize();

        assertEquals(8, board.getPieceCount(Piece.Color.WHITE, Piece.Type.PAWN));
        assertEquals(8, board.getPieceCount(Piece.Color.BLACK, Piece.Type.PAWN));
    }

    @Test
    void testGetPieceAtPosition() {
        board.initialize();

        Assertions.assertFalse(board.getInvert());
        assertPieceAtPosition(Piece.Color.BLACK, Piece.Type.ROOK, "a8");
        assertPieceAtPosition(Piece.Color.WHITE, Piece.Type.KING, "e1");

        board.setInvert(true);
        Assertions.assertTrue(board.getInvert());
        assertPieceAtPosition(Piece.Color.WHITE, Piece.Type.ROOK, "a8");
        assertPieceAtPosition(Piece.Color.BLACK, Piece.Type.QUEEN, "e1");

    }

    private void assertPieceAtPosition(Piece.Color color, Piece.Type type, String pos) {
        Piece p = board.getPieceAtPosition(pos);
        assertEquals(color, p.getColor());
        assertEquals(type, p.getType());
    }

    @Test
    void testSetPieceAtPosition() {
        board.setPieceAtPosition("b6", Piece.Color.BLACK, Piece.Type.KING);
        assertPieceAtPosition(Piece.Color.BLACK, Piece.Type.KING, "b6");
        assertEquals(1, board.getTotalCount());
    }

    @Test
    void testComputeOneColumnCount() {
        board.setPieceAtPosition("a1", WHITE, Piece.Type.PAWN);
        assertOneColumnPawnCount(1);
        board.setPieceAtPosition("a2", WHITE, Piece.Type.PAWN);
        assertOneColumnPawnCount(2);
    }

    private void assertOneColumnPawnCount(int expect) {
        assertEquals(expect, board.computeOneColumnPawnCount(WHITE, 0));
    }


}
