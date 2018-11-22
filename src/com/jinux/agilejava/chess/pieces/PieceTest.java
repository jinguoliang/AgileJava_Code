package com.jinux.agilejava.chess.pieces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

abstract class PieceTest {

    private Piece blackPiece;
    private Piece whitePiece;

    @BeforeEach
    void setUp() {
        blackPiece = createPiece(Piece.Color.BLACK);
        whitePiece = createPiece(Piece.Color.WHITE);
    }

    abstract Piece createPiece(Piece.Color color);

    @Test
    void testColor() {
       assertEquals(Piece.Color.WHITE, whitePiece.getColor());
       assertTrue(whitePiece.isWhite());
       assertEquals(Piece.Color.BLACK, blackPiece.getColor());
       assertTrue(blackPiece.isBlack());
    }
}