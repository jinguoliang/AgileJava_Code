package com.jinux.agilejava.studensystem.studentinfo;

import java.util.*;

public class CourseSession extends Session {
    protected CourseSession(Course course, Date startDate) {
        super(course, startDate);
    }

    @Override
    protected int getSessionLength()  {
        return 16;
    }

    public static CourseSession create(String department, int number, Date startDate) {
        return new CourseSession(new Course(department, number), startDate);
    }
}
