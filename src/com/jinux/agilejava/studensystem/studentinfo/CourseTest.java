package com.jinux.agilejava.studensystem.studentinfo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseTest {
    @Test
    public void testCreate() {
        Course course = new Course("CMSC", 120);
        assertEquals("CMSC", course.getDepartment());
        assertEquals(120, course.getNumber());
    }
}
