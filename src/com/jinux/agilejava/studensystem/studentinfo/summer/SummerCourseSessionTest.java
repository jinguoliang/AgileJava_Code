package com.jinux.agilejava.studensystem.studentinfo.summer;

import com.jinux.agilejava.studensystem.studentinfo.Session;
import com.jinux.agilejava.studensystem.studentinfo.SessionTest;
import com.jinux.agilejava.utils.DateUtil;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SummerCourseSessionTest extends SessionTest {

    @Test
    void testEndDate() {
        Date startDate = DateUtil.createDate(2003, 6, 9);
        Session session = createSession("ENGL", 200, startDate);
        Date eightWeekOut = DateUtil.createDate(2003, 8, 1);
        assertEquals(eightWeekOut, session.getEndDate());
    }


    @Override
    protected Session createSession(String department, int number, Date startDate) {
        return SummerCourseSession.create(department, number, startDate);
    }
}