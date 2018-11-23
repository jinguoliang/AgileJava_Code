package com.jinux.agilejava.playground;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoopCompareTest {
    @Test
    void testCommas() {
        String sequence = "1,2,3,4,5";
        assertEquals(sequence, sequenceUsingDo(1, 5));
        assertEquals(sequence, sequenceUsingWhile(1, 5));
        assertEquals(sequence, sequenceUsingFor(1, 5));
    }

    private String sequenceUsingFor(int start, int end) {
        StringBuilder builder = new StringBuilder();
        for (int i = start; i <= end; i++) {
            if (i > start) {
                builder.append(',');
            }
            builder.append(i);
        }
        return builder.toString();
    }

    private String sequenceUsingWhile(int start, int end) {
        StringBuilder builder = new StringBuilder();
        int i = start;
        while (i <= end) {
            if (i > start) {
                builder.append(',');
            }
            builder.append(i);
            i++;
        }
        return builder.toString();
    }

    private String sequenceUsingDo(int start, int end) {
        StringBuilder builder = new StringBuilder();
        int i = start;
        do {
            if (i > start) {
                builder.append(',');
            }
            builder.append(i);
        } while (++i <= end);
        return builder.toString();
    }
}
