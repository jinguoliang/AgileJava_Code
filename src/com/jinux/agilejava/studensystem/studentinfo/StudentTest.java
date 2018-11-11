package com.jinux.agilejava.studensystem.studentinfo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    private Student mStudentA;

    @BeforeEach
    void setUp() {
        mStudentA = new Student("a");

    }

    @Test
    public void testCreate() {
        final String firstStudentName = "John";
        Student student = new Student(firstStudentName);
        assertEquals(firstStudentName, student.getName());

        final String secondStudentName = "Joe";
        Student secondStudent = new Student(secondStudentName);
        assertEquals(secondStudentName, secondStudent.getName());

        assertEquals(firstStudentName, student.getName());
    }


    @Test
    void testFullTime() {
        assertFalse(mStudentA.isFullTime());
    }

    @Test
    void testCredits() {
        assertEquals(0, mStudentA.getCredits());
        mStudentA.addCredits(3);
        assertEquals(3, mStudentA.getCredits());
        mStudentA.addCredits(4);
        assertEquals(7, mStudentA.getCredits());
        assertFalse(mStudentA.isFullTime());
        mStudentA.addCredits(5);
        assertEquals(Student.CREDITS_REQUIRED_FOR_FULL_TIME, mStudentA.getCredits());
        assertTrue(mStudentA.isFullTime());
    }

    @Test
    void testInState() {
        assertFalse(mStudentA.isInState());
        mStudentA.setState(Student.IN_STATE);
        assertTrue(mStudentA.isInState());
        mStudentA.setState("MD");
        mStudentA.setState(Student.IN_STATE);
    }
}