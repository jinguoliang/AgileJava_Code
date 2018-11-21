package com.jinux.agilejava.studensystem.studentinfo.summer;

import com.jinux.agilejava.studensystem.studentinfo.CourseSession;
import com.jinux.agilejava.utils.DateUtil;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class SummerCourseSessionTest {

    @Test
    void testEndDate() {
        Date startDate = DateUtil.createDate(2003, 6, 9);
        CourseSession session = SummerCourseSession.create("ENGL", 200, startDate);
        Date eightWeekOut = DateUtil.createDate(2003, 8, 1);
        assertEquals(eightWeekOut, session.getEndDate());
    }


}