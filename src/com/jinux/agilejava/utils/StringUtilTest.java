package com.jinux.agilejava.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilTest {
    @Test
    void testLine() {
        assertEquals("hello" + StringUtil.NEWLINE, StringUtil.line("hello"));
    }

}