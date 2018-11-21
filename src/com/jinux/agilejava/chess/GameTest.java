package com.jinux.agilejava.chess;

import com.jinux.agilejava.chess.pieces.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.jinux.agilejava.chess.pieces.Piece.Color.BLACK;
import static com.jinux.agilejava.chess.pieces.Piece.Color.WHITE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {

    private Game game;

    @BeforeEach
    void setup() {
        game = new Game();
    }

    private void assertWhiteScore(float expect) {
        assertTotalScore(expect, WHITE);

    }

    private void assertBlackScore(float expect) {
        assertTotalScore(expect, BLACK);
    }

    private void assertTotalScore(float expect, Piece.Color color) {
        assertEquals(expect, game.getAllScore(color), 0.05f);
    }

    @Test
    void testComputeOneColumnWhitePawnScore() {
        Board board = game.getBoard();
        board.setPieceAtPosition("a1", WHITE, Piece.Type.PAWN);
        assertOneColumnWhitePawnScore(1);
        board.setPieceAtPosition("a2", WHITE, Piece.Type.PAWN);
        assertOneColumnWhitePawnScore(1);
        board.setPieceAtPosition("a3", WHITE, Piece.Type.PAWN);
        assertOneColumnWhitePawnScore(1.5f);
        board.setPieceAtPosition("b3", WHITE, Piece.Type.PAWN);
        assertOneColumnWhitePawnScore(1.5f);
    }

    private void assertOneColumnWhitePawnScore(float i) {
        assertEquals(i, game.computeOneColumnPawnScore(WHITE, 0), 0.05f);
    }

    @Test
    void testComputeAllColumnPawnScore() {
        Board board = game.getBoard();
        board.setPieceAtPosition("a1", WHITE, Piece.Type.PAWN);
        assertAllWhitePawnScore(1);
        board.setPieceAtPosition("a2", WHITE, Piece.Type.PAWN);
        assertAllWhitePawnScore(1);
        board.setPieceAtPosition("a3", WHITE, Piece.Type.PAWN);
        assertAllWhitePawnScore(1.5f);
        board.setPieceAtPosition("b3", WHITE, Piece.Type.PAWN);
        assertAllWhitePawnScore(2.5f);
    }

    private void assertAllWhitePawnScore(float i) {
        assertEquals(i, game.computePawnScore(WHITE), 0.05f);
    }

    @Test
    void testComputeAllScore() {
        Board board = game.getBoard();
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

        board.setPieceAtPosition("e1", WHITE, Piece.Type.ROOK);
        assertBlackScore(20);
        assertWhiteScore(5);
        board.setPieceAtPosition("f1", WHITE, Piece.Type.KING);
        assertWhiteScore(5);
        board.setPieceAtPosition("f2", WHITE, Piece.Type.PAWN);
        board.setPieceAtPosition("f3", WHITE, Piece.Type.PAWN);
        board.setPieceAtPosition("f4", WHITE, Piece.Type.KNIGHT);
        board.setPieceAtPosition("g2", WHITE, Piece.Type.PAWN);
        board.setPieceAtPosition("g4", WHITE, Piece.Type.QUEEN);
        board.setPieceAtPosition("h3", WHITE, Piece.Type.PAWN);

        assertWhiteScore(19.5f);
    }

    void createSampleBoardLayout(Board board) {
        board.setPieceAtPosition("a7", Piece.Color.BLACK, Piece.Type.PAWN);
        board.setPieceAtPosition("b6", Piece.Color.BLACK, Piece.Type.PAWN);
        board.setPieceAtPosition("b8", Piece.Color.BLACK, Piece.Type.KING);
        board.setPieceAtPosition("c7", Piece.Color.BLACK, Piece.Type.PAWN);
        board.setPieceAtPosition("c8", Piece.Color.BLACK, Piece.Type.PAWN);
        board.setPieceAtPosition("a7", Piece.Color.BLACK, Piece.Type.ROOK);
        board.setPieceAtPosition("e1", WHITE, Piece.Type.ROOK);

        board.setPieceAtPosition("d7", Piece.Color.BLACK, Piece.Type.BISHOP);
        board.setPieceAtPosition("e6", Piece.Color.BLACK, Piece.Type.QUEEN);
        board.setPieceAtPosition("f1", WHITE, Piece.Type.KING);
        board.setPieceAtPosition("f2", WHITE, Piece.Type.PAWN);
        board.setPieceAtPosition("f3", WHITE, Piece.Type.PAWN);
        board.setPieceAtPosition("f4", WHITE, Piece.Type.KNIGHT);
        board.setPieceAtPosition("g2", WHITE, Piece.Type.PAWN);
        board.setPieceAtPosition("g4", WHITE, Piece.Type.QUEEN);
        board.setPieceAtPosition("h3", WHITE, Piece.Type.PAWN);
    }
}