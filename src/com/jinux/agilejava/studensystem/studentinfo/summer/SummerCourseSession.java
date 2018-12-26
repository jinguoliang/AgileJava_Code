package com.jinux.agilejava.studensystem.studentinfo.summer;

import com.jinux.agilejava.studensystem.studentinfo.Course;
import com.jinux.agilejava.studensystem.studentinfo.CourseSession;
import com.jinux.agilejava.studensystem.studentinfo.Session;

import java.util.Date;

public class SummerCourseSession extends Session {
    private SummerCourseSession(Course course, Date startDate) {
        super(course, startDate);
    }

    public static SummerCourseSession create(String department, int number, Date startDate) {
        return new SummerCourseSession(new Course(department, number), startDate);
    }

    @Override
    protected int getSessionLength() {
        return 8;
    }
}
