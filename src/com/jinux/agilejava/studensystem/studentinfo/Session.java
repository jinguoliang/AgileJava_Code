package com.jinux.agilejava.studensystem.studentinfo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public abstract class Session implements Comparable<CourseSession> {

    public static final int ONE_WEEK = 7;
    private static final int DAYS_FROM_FRIDAY_TO_MONDAY = 3;
    private Date mStartDate;
    private String mDepartment;
    private int mNumber;
    private List<Student> mAllStudents = new ArrayList<>();
    private int mNumberOfCredits;
    private URL url;

    protected Session(Course course, Date startDate) {
        mDepartment = course.getDepartment();
        mNumber = course.getNumber();
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
        OptionalDouble average = mAllStudents.stream()
                .filter(student -> !student.isFullTime())
                .map(Student::getGpa)
                .mapToDouble(Float::doubleValue)
                .average();
        if (average.isPresent()) {
            return (float) average.getAsDouble();
        } else {
            return 0;
        }
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(String url) throws SessionException {
        try {
            this.url = new URL(url);
        } catch (MalformedURLException e) {
            throw new SessionException(e);
        }
    }
}
