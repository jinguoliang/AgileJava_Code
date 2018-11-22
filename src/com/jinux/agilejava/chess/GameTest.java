package com.jinux.agilejava.chess;

import com.jinux.agilejava.chess.pieces.*;
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
        board.setPieceAtPosition("a1", WHITE, Pawn.class);
        assertOneColumnWhitePawnScore(1);
        board.setPieceAtPosition("a2", WHITE, Pawn.class);
        assertOneColumnWhitePawnScore(1);
        board.setPieceAtPosition("a3", WHITE, Pawn.class);
        assertOneColumnWhitePawnScore(1.5f);
        board.setPieceAtPosition("b3", WHITE, Pawn.class);
        assertOneColumnWhitePawnScore(1.5f);
    }

    private void assertOneColumnWhitePawnScore(float i) {
        assertEquals(i, game.computeOneColumnPawnScore(WHITE, 0), 0.05f);
    }

    @Test
    void testComputeAllColumnPawnScore() {
        Board board = game.getBoard();
        board.setPieceAtPosition("a1", WHITE, Pawn.class);
        assertAllWhitePawnScore(1);
        board.setPieceAtPosition("a2", WHITE, Pawn.class);
        assertAllWhitePawnScore(1);
        board.setPieceAtPosition("a3", WHITE, Pawn.class);
        assertAllWhitePawnScore(1.5f);
        board.setPieceAtPosition("b3", WHITE, Pawn.class);
        assertAllWhitePawnScore(2.5f);
    }

    private void assertAllWhitePawnScore(float i) {
        assertEquals(i, game.computePawnScore(WHITE), 0.05f);
    }

    @Test
    void testComputeAllScore() {
        Board board = game.getBoard();
        board.setPieceAtPosition("a7", Piece.Color.BLACK, Pawn.class);
        assertBlackScore(1);
        board.setPieceAtPosition("b6", Piece.Color.BLACK, Pawn.class);
        assertBlackScore(2);
        board.setPieceAtPosition("b8", Piece.Color.BLACK, King.class);
        assertBlackScore(2);
        board.setPieceAtPosition("c7", Piece.Color.BLACK, Pawn.class);
        assertBlackScore(3);
        board.setPieceAtPosition("c8", Piece.Color.BLACK, Rook.class);
        assertBlackScore(8);
        board.setPieceAtPosition("d7", Piece.Color.BLACK, Bishop.class);
        assertBlackScore(11);
        board.setPieceAtPosition("e6", Piece.Color.BLACK, Queen.class);
        assertBlackScore(20);

        board.setPieceAtPosition("e1", WHITE, Rook.class);
        assertBlackScore(20);
        assertWhiteScore(5);
        board.setPieceAtPosition("f1", WHITE, King.class);
        assertWhiteScore(5);
        board.setPieceAtPosition("f2", WHITE, Pawn.class);
        board.setPieceAtPosition("f3", WHITE, Pawn.class);
        board.setPieceAtPosition("f4", WHITE, Knight.class);
        board.setPieceAtPosition("g2", WHITE, Pawn.class);
        board.setPieceAtPosition("g4", WHITE, Queen.class);
        board.setPieceAtPosition("h3", WHITE, Pawn.class);

        assertWhiteScore(19.5f);
    }

    @Test
    void testMoveLeft() {
        Board board = game.getBoard();
        String pos = "b2";
        board.setPieceAtPosition(pos, Piece.Color.BLACK, King.class);
        game.moveLeft(pos);
        Piece piece = board.getPieceAtPosition("a2");
        assertEquals(King.class, piece.getClass());
        assertEquals(BLACK, piece.getColor());
        assertEquals(BlankPiece.class, board.getPieceAtPosition(pos).getClass());
    }




}