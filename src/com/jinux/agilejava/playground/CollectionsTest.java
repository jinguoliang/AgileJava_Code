package com.jinux.agilejava.playground;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectionsTest {
    @Test
    void testSortList() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("b");
        list.add("a");
        list.add("Ab");
        list.add("Aa");

        Collections.sort(list);
        assertEquals("A", list.get(0));
        assertEquals("Aa", list.get(1));
        assertEquals("Ab", list.get(2));
        assertEquals("a", list.get(3));
        assertEquals("b", list.get(4));
    }

    @Test
    void testSortInNewList() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("b");
        list.add("a");
        list.add("Ab");
        list.add("Aa");

        List<String> listCopy = new ArrayList<>(list);

        Collections.sort(listCopy);
        assertEquals("A", listCopy.get(0));
        assertEquals("Aa", listCopy.get(1));
        assertEquals("Ab", listCopy.get(2));
        assertEquals("a", listCopy.get(3));
        assertEquals("b", listCopy.get(4));

        assertEquals("A", list.get(0));
        assertEquals("b", list.get(1));
        assertEquals("a", list.get(2));
        assertEquals("Ab", list.get(3));
        assertEquals("Aa", list.get(4));
    }
}
