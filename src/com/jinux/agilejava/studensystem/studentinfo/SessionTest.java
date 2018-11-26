package com.jinux.agilejava.studensystem.studentinfo;

import com.jinux.agilejava.utils.DateUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public abstract class SessionTest {

    private static final int CREDITS = 3;

    private Session session;
    private Date startDate;

    @BeforeEach
    public void setUp() {
        startDate = DateUtil.createDate(2003, 1, 6);
        session = createSession("ENGL", 101, startDate);
        session.setNumberOfCredits(SessionTest.CREDITS);
    }

    protected abstract Session createSession(String department, int number, Date startDate);

    @Test
    void testCreate() {
        assertEquals("ENGL", session.getDepartment());
        assertEquals(101, session.getNumber());
        assertEquals(0, session.getNumberOfStudents());
        assertEquals(startDate, session.getStartDate());
    }

    @Test
    void testEnrollStudents() {
        Student student1 = new Student("John");
        session.enroll(student1);
        assertEquals(SessionTest.CREDITS, student1.getCredits());
        assertEquals(1, session.getNumberOfStudents());
        assertEquals(student1, session.get(0));

        Student student2 = new Student("Joe");
        session.enroll(student2);
        assertEquals(SessionTest.CREDITS, student2.getCredits());
        assertEquals(2, session.getNumberOfStudents());
        assertEquals(student2, session.get(1));
    }

    @Test
    void testCourseDate() {
        CourseSession session = CourseSession.create("ABCD", 200, startDate);
        Date sixteenWeeksOut = DateUtil.createDate(2003, 4, 25);
        assertEquals(sixteenWeeksOut, session.getEndDate());
    }

    @Test
    void testComparable() {
        final Date date = new Date();
        CourseSession sessionA = CourseSession.create("CMSC", 101, date);
        CourseSession sessionB = CourseSession.create("ENGL", 101, date);

        assertTrue(sessionA.compareTo(sessionB) < 0);
        assertTrue(sessionB.compareTo(sessionA) > 0);

        CourseSession sessionC = CourseSession.create("ENGL", 101, date);
        assertEquals(0, sessionC.compareTo(sessionB));

        CourseSession sessionD = CourseSession.create("ENGL", 210, date);
        assertTrue(sessionC.compareTo(sessionD) < 0);
    }

    @Test
    void testSessionLength() {
        assertTrue(session.getSessionLength() > 0);
    }

    @Test
    void testAverageGpaForPartTimeStudents() {
        session.enroll(createFullTimeStudent());

        Student partTime1 = new Student("1");
        partTime1.addGrade(Student.Grade.A);
        session.enroll(partTime1);

        session.enroll(createFullTimeStudent());

        Student partTime2 = new Student("2");
        partTime2.addGrade(Student.Grade.B);
        session.enroll(partTime2);

        assertEquals(3.5, session.averageGpaForPartTimeStudents(), 0.05);

    }

    private Student createFullTimeStudent() {
        Student student = new Student("a");
        student.addCredits(Student.CREDITS_REQUIRED_FOR_FULL_TIME);
        return student;
    }
}