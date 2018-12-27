package com.jinux.agilejava.studensystem.studentinfo;

import java.util.Date;

class CourseSessionTest extends SessionTest {
    @Override
    protected Session createSession(Course course, Date startDate) {
        CourseSession session = CourseSession.create(course, startDate);
        return session;
    }
}