package com.jinux.agilejava.chess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {
    @Test
    void testCreate() {
        Position position = Position.by("a3");
        assertEquals(2, position.getRow());
        assertEquals(0, position.getColumn());
    }
}