package com.jinux.agilejava.chess;

import com.jinux.agilejava.chess.pieces.Piece;
import com.jinux.agilejava.utils.StringUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void testComputeScore() {
        assertWhiteScore(0);
        board.setPieceAtPosition("a5", Piece.Color.WHITE, Piece.Type.QUEEN);
        assertWhiteScore(9);
        board.setPieceAtPosition("a6", Piece.Color.WHITE, Piece.Type.KNIGHT);
        assertWhiteScore(7.5f);
        board.setPieceAtPosition("a7", Piece.Color.WHITE, Piece.Type.BISHOP);
        assertWhiteScore(10.5f);
        board.setPieceAtPosition("a8", Piece.Color.WHITE, Piece.Type.ROOK);
        assertWhiteScore(15.5f);
        board.setPieceAtPosition("a1", Piece.Color.WHITE, Piece.Type.PAWN);
        assertWhiteScore(16.5f);
        board.setPieceAtPosition("a2", Piece.Color.WHITE, Piece.Type.PAWN);
        assertWhiteScore(16.5f);

    }

    private void assertWhiteScore(float expect) {
        assertEquals(expect, board.getAllScore(Piece.Color.WHITE), 0.05f);
    }

    private void assertBlackScore(float expect) {
        assertEquals(expect, board.getAllScore(Piece.Color.BLACK), 0.05f);
    }

    @Test
    void testComputeOneColumnCount() {
        board.setPieceAtPosition("a1", Piece.Color.WHITE, Piece.Type.PAWN);
        assertEquals(1, board.computeOneColumnPawnCount(Piece.Color.WHITE, 0));
        board.setPieceAtPosition("a2", Piece.Color.WHITE, Piece.Type.PAWN);
        assertEquals(2, board.computeOneColumnPawnCount(Piece.Color.WHITE, 0));
    }

    @Test
    void testComputeOneColumnScore() {
        board.setPieceAtPosition("a1", Piece.Color.WHITE, Piece.Type.PAWN);
        assertEquals(1, board.computeOneColumnPawnScore(Piece.Color.WHITE, 0), 0.05f);
        board.setPieceAtPosition("a2", Piece.Color.WHITE, Piece.Type.PAWN);
        assertEquals(1, board.computeOneColumnPawnScore(Piece.Color.WHITE, 0), 0.05f);
        board.setPieceAtPosition("a3", Piece.Color.WHITE, Piece.Type.PAWN);
        assertEquals(1.5f, board.computeOneColumnPawnScore(Piece.Color.WHITE, 0), 0.05f);
        board.setPieceAtPosition("b3", Piece.Color.WHITE, Piece.Type.PAWN);
        assertEquals(1.5f, board.computeOneColumnPawnScore(Piece.Color.WHITE, 0), 0.05f);
    }

    @Test
    void testComputeAllColumnScore() {
        board.setPieceAtPosition("a1", Piece.Color.WHITE, Piece.Type.PAWN);
        assertEquals(1, board.computePawnScore(Piece.Color.WHITE), 0.05f);
        board.setPieceAtPosition("a2", Piece.Color.WHITE, Piece.Type.PAWN);
        assertEquals(1, board.computePawnScore(Piece.Color.WHITE), 0.05f);
        board.setPieceAtPosition("a3", Piece.Color.WHITE, Piece.Type.PAWN);
        assertEquals(1.5f, board.computePawnScore(Piece.Color.WHITE), 0.05f);
        board.setPieceAtPosition("b3", Piece.Color.WHITE, Piece.Type.PAWN);
        assertEquals(2.5f, board.computePawnScore(Piece.Color.WHITE), 0.05f);
    }

    @Test
    void testComputeAllScore() {
        board.setPieceAtPosition("a7", Piece.Color.BLACK, Piece.Type.PAWN);
        assertBlackScore(1);
        board.setPieceAtPosition("b6", Piece.Color.BLACK, Piece.Type.PAWN);
        assertBlackScore(2);
        board.setPieceAtPosition("b8", Piece.Color.BLACK, Piece.Type.KING);
        assertBlackScore(2);
        board.setPieceAtPosition("c7", Piece.Color.BLACK, Piece.Type.PAWN);
        assertBlackScore(3);
        board.setPieceAtPosition("c8", Piece.Color.BLACK, Piece.Type.ROOK);
        assertBlackScore(8);
        board.setPieceAtPosition("d7", Piece.Color.BLACK, Piece.Type.BISHOP);
        assertBlackScore(11);
        board.setPieceAtPosition("e6", Piece.Color.BLACK, Piece.Type.QUEEN);
        assertBlackScore(20);

        board.setPieceAtPosition("e1", Piece.Color.WHITE, Piece.Type.ROOK);
        assertBlackScore(20);
        assertWhiteScore(5);
        board.setPieceAtPosition("f1", Piece.Color.WHITE, Piece.Type.KING);
        assertWhiteScore(5);
        board.setPieceAtPosition("f2", Piece.Color.WHITE, Piece.Type.PAWN);
        board.setPieceAtPosition("f3", Piece.Color.WHITE, Piece.Type.PAWN);
        board.setPieceAtPosition("f4", Piece.Color.WHITE, Piece.Type.KNIGHT);
        board.setPieceAtPosition("g2", Piece.Color.WHITE, Piece.Type.PAWN);
        board.setPieceAtPosition("g4", Piece.Color.WHITE, Piece.Type.QUEEN);
        board.setPieceAtPosition("h3", Piece.Color.WHITE, Piece.Type.PAWN);

        assertWhiteScore(19.5f);
    }

    void createSampleBoardLayout(Board board) {
        board.setPieceAtPosition("a7", Piece.Color.BLACK, Piece.Type.PAWN);
        board.setPieceAtPosition("b6", Piece.Color.BLACK, Piece.Type.PAWN);
        board.setPieceAtPosition("b8", Piece.Color.BLACK, Piece.Type.KING);
        board.setPieceAtPosition("c7", Piece.Color.BLACK, Piece.Type.PAWN);
        board.setPieceAtPosition("c8", Piece.Color.BLACK, Piece.Type.PAWN);
        board.setPieceAtPosition("a7", Piece.Color.BLACK, Piece.Type.ROOK);
        board.setPieceAtPosition("e1", Piece.Color.WHITE, Piece.Type.ROOK);

        board.setPieceAtPosition("d7", Piece.Color.BLACK, Piece.Type.BISHOP);
        board.setPieceAtPosition("e6", Piece.Color.BLACK, Piece.Type.QUEEN);
        board.setPieceAtPosition("f1", Piece.Color.WHITE, Piece.Type.KING);
        board.setPieceAtPosition("f2", Piece.Color.WHITE, Piece.Type.PAWN);
        board.setPieceAtPosition("f3", Piece.Color.WHITE, Piece.Type.PAWN);
        board.setPieceAtPosition("f4", Piece.Color.WHITE, Piece.Type.KNIGHT);
        board.setPieceAtPosition("g2", Piece.Color.WHITE, Piece.Type.PAWN);
        board.setPieceAtPosition("g4", Piece.Color.WHITE, Piece.Type.QUEEN);
        board.setPieceAtPosition("h3", Piece.Color.WHITE, Piece.Type.PAWN);
    }
}
