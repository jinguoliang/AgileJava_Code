package com.jinux.agilejava.studensystem.studentinfo.summer;

import com.jinux.agilejava.studensystem.studentinfo.CourseSession;

import java.util.Date;

public class SummerCourseSession extends CourseSession {
    private SummerCourseSession(String department, int number, Date startDate) {
        super(department, number, startDate);
    }

    public static SummerCourseSession create(String department, int number, Date startDate) {
        return new SummerCourseSession(department, number, startDate);
    }

    @Override
    protected int getSessionLength() {
        return 8;
    }
}
