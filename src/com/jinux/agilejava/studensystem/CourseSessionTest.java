package com.jinux.agilejava.studensystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class CourseSessionTest {

    private CourseSession mSession;
    private Date mStartDate;

    @BeforeEach
    public void setUp() {
        mStartDate = createDate(2003, 1, 6);
        mSession = new CourseSession("ENGL", 101, mStartDate);
    }
    @Test
    void testCreate() {
        assertEquals("ENGL", mSession.getDepartment());
        assertEquals(101, mSession.getNumber());
        assertEquals(0, mSession.getNumberOfStudents());
        assertEquals(mStartDate, mSession.getStartDate());
    }

    private Date createDate(int year, int month, int date) {
        Calendar calendar = new GregorianCalendar();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONDAY, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, date);
        return calendar.getTime();
    }

    @Test
    void testEnrollStudents() {
        Student student1 = new Student("John");
        mSession.enroll(student1);
        assertEquals(1, mSession.getNumberOfStudents());
        assertEquals(student1, mSession.get(0));

        Student student2 = new Student("Joe");
        mSession.enroll(student2);
        assertEquals(2, mSession.getNumberOfStudents());
        assertEquals(student2, mSession.get(1));
    }

    @Test
    void testCourseDate() {
        CourseSession session = new CourseSession("ABCD", 200, mStartDate);
        Date sixteenWeeksOut = createDate(2003, 4, 25);
        assertEquals(sixteenWeeksOut, session.getEndDate());
    }
}