package com.jinux.agilejava.studensystem.studentinfo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentDirectoryTest {

    private StudentDirectory dir;

    @BeforeEach
    public void setUp() {
        dir = new StudentDirectory();
    }

    @Test
    public void storeAndRetrieve() {
        final int numberOfStudents = 10;

        for (int i = 0; i< numberOfStudents; i++) {
            addStudent(dir, i);
        }

        for (int i = 0; i< numberOfStudents; i++) {
            verifyStudentLookup(dir, i);
        }
    }

    private void verifyStudentLookup(StudentDirectory dir, int i) {
        String id = "" + i;
        Student student = dir.findById(id);
        assertEquals(id, student.getLastName());
        assertEquals(id, student.getId());
        assertEquals(i, student.getCredits());
    }

    private void addStudent(StudentDirectory dir, int i) {
        String id = "" + i;
        Student student = new Student(id);
        student.setId(id);
        student.addCredits(i);
        dir.add(student);
    }

}