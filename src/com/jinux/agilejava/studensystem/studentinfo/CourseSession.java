package com.jinux.agilejava.studensystem.studentinfo;

import java.util.*;

public class CourseSession implements Comparable<CourseSession> {
    public static final int ONE_WEEK = 7;
    private static final int DAYS_FROM_FRIDAY_TO_MONDAY = 3;
    private Date mStartDate;
    private String mDepartment;
    private int mNumber;
    private List<Student> mAllStudents = new ArrayList<>();
    private int mNumberOfCredits;

    protected CourseSession(String department, int number, Date startDate) {
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
        student.addCredits(mNumberOfCredits);
        mAllStudents.add(student);
    }

    public Student get(int i) {
        return mAllStudents.get(i);
    }

    public Date getEndDate() {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(mStartDate);
        int numberOfDays = ONE_WEEK * getSessionLength() - DAYS_FROM_FRIDAY_TO_MONDAY;
        calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
        return calendar.getTime();
    }

    protected int getSessionLength() {
        return 16;
    }

    public Date getStartDate() {
        return mStartDate;
    }

    public void setNumberOfCredits(int credits) {
        mNumberOfCredits = credits;
    }

    @Override
    public int compareTo(CourseSession o) {
        int compareDepart = getDepartment().compareTo(o.getDepartment());
        if (compareDepart == 0) {
            return getNumber() - o.getNumber();
        } else {
            return compareDepart;
        }
    }
}
