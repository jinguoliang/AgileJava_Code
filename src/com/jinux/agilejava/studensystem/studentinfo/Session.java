package com.jinux.agilejava.studensystem.studentinfo;

import java.util.*;
import java.util.stream.Collectors;

public abstract class Session implements Comparable<CourseSession> {

    public static final int ONE_WEEK = 7;
    private static final int DAYS_FROM_FRIDAY_TO_MONDAY = 3;
    private Date mStartDate;
    private String mDepartment;
    private int mNumber;
    private List<Student> mAllStudents = new ArrayList<>();
    private int mNumberOfCredits;

    protected Session(String department, int number, Date startDate) {
        mDepartment = department;
        mNumber = number;
        mStartDate = startDate;
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

    protected abstract int getSessionLength();

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

    public float averageGpaForPartTimeStudents() {
        List<Float> collect = mAllStudents.stream()
                .filter(student -> !student.isFullTime())
                .map(Student::getGpa).collect(Collectors.toList());
        Float sum = collect.stream().reduce(0f, (integer, integer2) -> integer + integer2);
        return sum / collect.size();
    }
}
