package com.jinux.agilejava.studensystem.studentinfo;

import java.util.*;

public class CourseSession {
    private Date mStartDate;
    private String mDepartment;
    private int mNumber;
    private List<Student> mAllStudents = new ArrayList<>();

    private CourseSession(String department, int number, Date startDate) {
        mDepartment = department;
        mNumber = number;
        mStartDate = startDate;
    }

    public static CourseSession create(String department, int number, Date startDate) {
        return new CourseSession(department, number, startDate);
    }

    public String getDepartment() {
        return mDepartment;
    }

    public int getNumber() {
        return mNumber;
    }

    public int getNumberOfStudents() {
        return mAllStudents.size();
    }

    public void enroll(Student student) {
        mAllStudents.add(student);
    }

    public Student get(int i) {
        return mAllStudents.get(i);
    }

    public Date getEndDate() {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(mStartDate);
        int numberOfDays = 7 * 16 - 3;
        calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
        return calendar.getTime();
    }

    public Date getStartDate() {
        return mStartDate;
    }
}
