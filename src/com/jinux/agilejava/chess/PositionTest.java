package com.jinux.agilejava.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionTest {
    private Position position;

    @BeforeEach
    void setup() {
        position = Position.by("a3");
    }

    @Test
    void testCreate() {

        assertEquals(2, position.getRow());
        assertEquals(0, position.getColumn());
    }

    @Test
    void testToString() {
        assertEquals("a3", position.toString());
    }
}