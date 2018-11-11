package com.jinux.agilejava.studensystem.studentinfo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CourseSessionTest {

    private CourseSession mSession;
    private Date mStartDate;
    private DateUtil mDateUtil;

    @BeforeEach
    public void setUp() {
        mDateUtil = new DateUtil();
        mStartDate = mDateUtil.createDate(2003, 1, 6);
        mSession = new CourseSession("ENGL", 101, mStartDate);
    }
    @Test
    void testCreate() {
        assertEquals("ENGL", mSession.getDepartment());
        assertEquals(101, mSession.getNumber());
        assertEquals(0, mSession.getNumberOfStudents());
        assertEquals(mStartDate, mSession.getStartDate());
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
        Date sixteenWeeksOut = mDateUtil.createDate(2003, 4, 25);
        assertEquals(sixteenWeeksOut, session.getEndDate());
    }


}