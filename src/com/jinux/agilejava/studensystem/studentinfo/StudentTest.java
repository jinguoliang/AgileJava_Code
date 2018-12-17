package com.jinux.agilejava.studensystem.studentinfo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    private static final double GRADE_TOLERANCE = 0.05;

    private Student mStudentA;

    @BeforeEach
    void setUp() {
        mStudentA = new Student("a");

    }

    @Test
    public void testCreate() {
        final String firstStudentName = "John Jin";
        Student student = new Student(firstStudentName);
        assertEquals(firstStudentName, student.getName());
        assertEquals("John", student.getFirstName());
        assertEquals("Jin", student.getLastName());
        assertEquals("", student.getMiddleName());

        final String secondStudentName = "Joe";
        Student secondStudent = new Student(secondStudentName);
        assertEquals(secondStudentName, secondStudent.getName());
        assertEquals("", secondStudent.getFirstName());
        assertEquals("Joe", secondStudent.getLastName());
        assertEquals("", secondStudent.getMiddleName());

        final String thirdStudentName = "Joe Stan Jin";
        Student thirdStudent = new Student(thirdStudentName);
        assertEquals(thirdStudentName, thirdStudent.getName());
        assertEquals("Joe", thirdStudent.getFirstName());
        assertEquals("Jin", thirdStudent.getLastName());
        assertEquals("Stan", thirdStudent.getMiddleName());

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

    @Test
    void testCalculateGpa() {
        assertGpa(0.0);
        mStudentA.addGrade(Student.Grade.A);
        assertGpa(4.0);
        mStudentA.addGrade(Student.Grade.B);
        assertGpa(3.5);
        mStudentA.addGrade(Student.Grade.C);
        assertGpa(3.0);
        mStudentA.addGrade(Student.Grade.D);
        assertGpa(2.5);
        mStudentA.addGrade(Student.Grade.F);
        assertGpa(2.0);
    }

    @Test
    void testCalculateHonorsStudentGpa() {
        assertGpa(createHonorsStudent(), 0f);
        assertGpa(createHonorsStudent(Student.Grade.A), 5f);
        assertGpa(createHonorsStudent(Student.Grade.B), 4f);
        assertGpa(createHonorsStudent(Student.Grade.C), 3f);
        assertGpa(createHonorsStudent(Student.Grade.D), 2f);
        assertGpa(createHonorsStudent(Student.Grade.F), 0f);
    }

    private Student createHonorsStudent(Student.Grade grade) {
        Student student = createHonorsStudent();
        student.addGrade(grade);
        return student;
    }

    private Student createHonorsStudent() {
        Student student = new Student("a");
        student.setGradingStrategy(new HonorsGradingStrategy());
        return student;
    }

    private void assertGpa(double expect) {
        assertGpa(mStudentA, expect);
    }

    private void assertGpa(Student student, double expect) {
        assertEquals(expect, student.getGpa(), GRADE_TOLERANCE);
    }

    @Test
    void testCharge() {
        Student student = new Student("a");
        student.addCharge(500);
        student.addCharge(200);
        student.addCharge(399);
        assertEquals(1099, student.totalCharges());
    }

    @Test
    void testBadlyFormattedName() {
        try {
            new Student("a b c d");
            fail("expected exception from 4-part name");
        } catch (StudentNameFormatException success) {
            assertEquals("Student name 'a b c d' contains more than 3 parts",
                    success.getMessage());
        }
    }
}