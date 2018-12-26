package com.jinux.agilejava.studensystem.studentinfo;

public class Course {
    private final String department;
    private final int number;

    public Course(String department, int number) {
        this.department = department;
        this.number = number;
    }

    public String getDepartment() {
        return department;
    }

    public int getNumber() {
        return number;
    }
}
