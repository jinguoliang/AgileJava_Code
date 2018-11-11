package com.jinux.agilejava.studensystem.report;

import com.jinux.agilejava.studensystem.studentinfo.CourseSession;
import com.jinux.agilejava.studensystem.studentinfo.Student;
import com.jinux.agilejava.utils.DateUtil;
import com.jinux.agilejava.utils.StringUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RosterReporterTest {

    @Test
    void testRosterReport() {
        CourseSession session = CourseSession.create("ENGL", 101, DateUtil.createDate(2003, 1, 6));
        session.enroll(new Student("A"));
        session.enroll(new Student("B"));

        String rosterReport = new RosterReporter(session).getReport();
        System.out.printf(rosterReport);
        assertEquals(RosterReporter.ROSTER_REPORT_HEADER
                        + StringUtil.line("A")
                        + StringUtil.line("B")
                        + RosterReporter.ROSTER_REPORT_FOOTER
                        + StringUtil.line("2"),
                rosterReport);
    }

}