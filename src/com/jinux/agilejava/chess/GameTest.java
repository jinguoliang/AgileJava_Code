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
        board.setPieceAtPosition("a1", createWhitePawn());
        assertOneColumnWhitePawnScore(1);
        board.setPieceAtPosition("a2", createWhitePawn());
        assertOneColumnWhitePawnScore(1);
        board.setPieceAtPosition("a3", createWhitePawn());
        assertOneColumnWhitePawnScore(1.5f);
        board.setPieceAtPosition("b3", createWhitePawn());
        assertOneColumnWhitePawnScore(1.5f);
    }

    private Piece createWhitePawn() {
        return Pawn.create(WHITE);
    }

    private Piece createBlackPawn() {
        return Pawn.create(BLACK);
    }

    private void assertOneColumnWhitePawnScore(float i) {
        assertEquals(i, game.computeOneColumnPawnScore(WHITE, 0), 0.05f);
    }

    @Test
    void testComputeAllColumnPawnScore() {
        Board board = game.getBoard();
        board.setPieceAtPosition("a1", createWhitePawn());
        assertAllWhitePawnScore(1);
        board.setPieceAtPosition("a2", createWhitePawn());
        assertAllWhitePawnScore(1);
        board.setPieceAtPosition("a3", createWhitePawn());
        assertAllWhitePawnScore(1.5f);
        board.setPieceAtPosition("b3", createWhitePawn());
        assertAllWhitePawnScore(2.5f);
    }

    private void assertAllWhitePawnScore(float i) {
        assertEquals(i, game.computePawnScore(WHITE), 0.05f);
    }

    @Test
    void testComputeAllScore() {
        Board board = game.getBoard();
        board.setPieceAtPosition("a7", createBlackPawn());
        assertBlackScore(1);
        board.setPieceAtPosition("b6", createBlackPawn());
        assertBlackScore(2);
        board.setPieceAtPosition("b8", King.create(BLACK));
        assertBlackScore(2);
        board.setPieceAtPosition("c7", createBlackPawn());
        assertBlackScore(3);
        board.setPieceAtPosition("c8", Rook.create(BLACK));
        assertBlackScore(8);
        board.setPieceAtPosition("d7", Bishop.create(BLACK));
        assertBlackScore(11);
        board.setPieceAtPosition("e6", Queen.create(BLACK));
        assertBlackScore(20);

        board.setPieceAtPosition("e1", Rook.create(WHITE));
        assertBlackScore(20);
        assertWhiteScore(5);
        board.setPieceAtPosition("f1", King.create(WHITE));
        assertWhiteScore(5);
        board.setPieceAtPosition("f2", createWhitePawn());
        board.setPieceAtPosition("f3", createWhitePawn());
        board.setPieceAtPosition("f4", Knight.create(WHITE));
        board.setPieceAtPosition("g2", createWhitePawn());
        board.setPieceAtPosition("g4", Queen.create(WHITE));
        board.setPieceAtPosition("h3", createWhitePawn());

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