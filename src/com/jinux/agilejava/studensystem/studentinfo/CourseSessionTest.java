package com.jinux.agilejava.studensystem.studentinfo;

import java.util.Date;

class CourseSessionTest extends SessionTest {
    @Override
    protected Session createSession(String department, int number, Date startDate) {
        CourseSession session = CourseSession.create(department, number, startDate);
        return session;
    }
}