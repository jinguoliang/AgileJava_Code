package com.jinux.agilejava.chess;

import com.jinux.agilejava.chess.pieces.*;
import com.jinux.agilejava.utils.StringUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.jinux.agilejava.chess.pieces.Piece.Color.BLACK;
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

        assertEquals(8, board.getPieceCount(Piece.Color.WHITE, Pawn.class));
        assertEquals(8, board.getPieceCount(Piece.Color.BLACK, Pawn.class));
    }

    @Test
    void testGetPieceAtPosition() {
        board.initialize();

        Assertions.assertFalse(board.getInvert());
        assertPieceAtPosition(Piece.Color.BLACK, Rook.class, "a8");
        assertPieceAtPosition(Piece.Color.WHITE, King.class, "e1");

        board.setInvert(true);
        Assertions.assertTrue(board.getInvert());
        assertPieceAtPosition(Piece.Color.WHITE, Rook.class, "a8");
        assertPieceAtPosition(Piece.Color.BLACK, Queen.class, "e1");

    }

    private void assertPieceAtPosition(Piece.Color color, Class<? extends Piece> type, String pos) {
        Piece p = board.getPieceAtPosition(pos);
        assertEquals(color, p.getColor());
        assertEquals(type, p.getClass());
    }

    @Test
    void testSetPieceAtPosition() {
        board.setPieceAtPosition("b6", King.create(BLACK));
        assertPieceAtPosition(Piece.Color.BLACK, King.class, "b6");
        assertEquals(1, board.getTotalCount());
    }

    @Test
    void testComputeOneColumnCount() {
        board.setPieceAtPosition("a1", Pawn.create(WHITE));
        assertOneColumnPawnCount(1);
        board.setPieceAtPosition("a2", Pawn.create(WHITE));
        assertOneColumnPawnCount(2);
    }

    private void assertOneColumnPawnCount(int expect) {
        assertEquals(expect, board.computeOneColumnPawnCount(WHITE, 0));
    }

    @Test
    void testRemovePieceAtPosition() {
        String a2 = "a2";
        board.setPieceAtPosition(a2, King.create(WHITE));
        assertEquals(King.class, board.getPieceAtPosition(a2).getClass());
        board.removePieceAtPosition(a2);
        assertEquals(BlankPiece.class, board.getPieceAtPosition(a2).getClass());

    }


}
