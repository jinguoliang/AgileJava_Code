package com.jinux.agilejava.playground;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CharacterTest {
    @Test
    void testWhiteSpace() {
        assertTrue(Character.isWhitespace('\n'));
        assertTrue(Character.isWhitespace('\t'));
        assertTrue(Character.isWhitespace(' '));
    }

    @Test
    void testIdentifier() {
        assertFalse(Character.isJavaIdentifierPart(' '));
        assertTrue(Character.isJavaIdentifierPart('$'));
        assertFalse(Character.isJavaIdentifierPart('-'));  // minus sign can't be part
        assertFalse(Character.isJavaIdentifierPart(')'));
        assertFalse(Character.isJavaIdentifierPart('+'));
        assertTrue(Character.isJavaIdentifierPart('2'));
        assertFalse(Character.isJavaIdentifierPart('\t'));
        assertFalse(Character.isJavaIdentifierPart('#'));

        assertFalse(Character.isJavaIdentifierStart('2'));
        assertTrue(Character.isJavaIdentifierStart('$'));
        assertFalse(Character.isJavaIdentifierStart('#'));  // # can't start
    }
}
