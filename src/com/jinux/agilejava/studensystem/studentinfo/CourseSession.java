package com.jinux.agilejava.studensystem.studentinfo;

import java.util.*;

public class CourseSession extends Session {
    protected CourseSession(String department, int number, Date startDate) {
        super(department, number, startDate);
    }

    @Override
    protected int getSessionLength()  {
        return 16;
    }

    public static CourseSession create(String department, int number, Date startDate) {
        return new CourseSession(department, number, startDate);
    }
}
