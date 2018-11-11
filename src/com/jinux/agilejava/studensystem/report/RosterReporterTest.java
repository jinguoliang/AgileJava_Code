package com.jinux.agilejava.studensystem.report;

import com.jinux.agilejava.studensystem.studentinfo.CourseSession;
import com.jinux.agilejava.studensystem.studentinfo.DateUtil;
import com.jinux.agilejava.studensystem.studentinfo.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RosterReporterTest {

    @Test
    void testRosterReport() {
        DateUtil dateUtil = new DateUtil();
        CourseSession session = new CourseSession("ENGL", 101, dateUtil.createDate(2003, 1, 6));
        session.enroll(new Student("A"));
        session.enroll(new Student("B"));

        String rosterReport = new RosterReporter(session).getReport();
        System.out.printf(rosterReport);
        assertEquals(RosterReporter.ROSTER_REPORT_HEADER
                        + "A" + RosterReporter.NEWLINE + "B" + RosterReporter.NEWLINE
                        + RosterReporter.ROSTER_REPORT_FOOTER
                        + "2" + RosterReporter.NEWLINE,
                rosterReport);
    }

}