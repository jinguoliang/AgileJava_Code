package com.jinux.agilejava.chess;

import com.jinux.agilejava.chess.pieces.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board mBoard;

    @BeforeEach
    void setUp() {
        mBoard = new Board();

    }

    @Test
    void testCreate() {
        assertEquals(true, mBoard.isEmpty());
    }

    @Test
    void testAddPawn() {

        Pawn pawn1 = new Pawn(Pawn.COLOR_WHITE);
        mBoard.addPawn(pawn1);
        assertEquals(1, mBoard.getPawnCount());
        assertEquals(pawn1, mBoard.get(0));

        Pawn pawn2 = new Pawn(Pawn.COLOR_BLACK);
        mBoard.addPawn(pawn2);
        assertEquals(2, mBoard.getPawnCount());
        assertEquals(pawn1, mBoard.get(0));
        assertEquals(pawn2, mBoard.get(1));
    }

}