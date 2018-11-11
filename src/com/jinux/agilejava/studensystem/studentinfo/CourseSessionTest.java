package com.jinux.agilejava.studensystem.studentinfo;

import com.jinux.agilejava.studensystem.utils.DateUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CourseSessionTest {

    private static final int CREDITS = 3;

    private CourseSession mSession;
    private Date mStartDate;

    @BeforeEach
    public void setUp() {
        mStartDate = DateUtil.createDate(2003, 1, 6);
        mSession = createCourseSession();
    }

    private CourseSession createCourseSession() {
        CourseSession session = CourseSession.create("ENGL", 101, mStartDate);
        session.setNumberOfCredits(CourseSessionTest.CREDITS);
        return session;
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
        assertEquals(CourseSessionTest.CREDITS, student1.getCredits());
        assertEquals(1, mSession.getNumberOfStudents());
        assertEquals(student1, mSession.get(0));

        Student student2 = new Student("Joe");
        mSession.enroll(student2);
        assertEquals(CourseSessionTest.CREDITS, student2.getCredits());
        assertEquals(2, mSession.getNumberOfStudents());
        assertEquals(student2, mSession.get(1));
    }

    @Test
    void testCourseDate() {
        CourseSession session = CourseSession.create("ABCD", 200, mStartDate);
        Date sixteenWeeksOut = DateUtil.createDate(2003, 4, 25);
        assertEquals(sixteenWeeksOut, session.getEndDate());
    }



}