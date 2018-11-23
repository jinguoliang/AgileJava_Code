package com.jinux.agilejava.playground;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTrimEndTest {
    @Test
    void testEndTrim() {
        assertEquals("", endTrim(""));
        assertEquals(" x", endTrim(" x "));
        assertEquals("x", endTrim("x"));
        assertEquals("xaxa", endTrim("xaxa"));
        assertEquals("", endTrim(" "));
        assertEquals("xxxx", endTrim("xxxx     "));
    }

    private String endTrim(String source) {
        int i = source.length() - 1;
        while (i >= 0) {
            if (source.charAt(i) != ' ') {
                break;
            }
            i--;
        }
        return source.substring(0, i + 1);
    }
}
