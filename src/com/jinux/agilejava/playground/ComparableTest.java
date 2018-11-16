package com.jinux.agilejava.playground;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ComparableTest {
    @Test
    void testStringCompareTo() {
        assertTrue("A".compareTo("B") < 0);
    }
}
