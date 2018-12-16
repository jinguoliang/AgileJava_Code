package com.jinux.agilejava.studensystem.studentinfo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScorerTest {

    private Scorer scorer;

    @BeforeEach
    void setup() {
        scorer = new Scorer();
    }

    @Test
    void testCaptureScore() {
        assertEquals(75, scorer.score("75"));
    }

    @Test
    void testIsValid() {
        assertTrue(scorer.isValid("75"));
        assertFalse(scorer.isValid("abc"));
    }

    @Test
    void testBadScoreEntered() {
        try {
            scorer.score("abc");
            fail("expected NumberFormatException on bad input");
        } catch (NumberFormatException success) {
        }
    }
}