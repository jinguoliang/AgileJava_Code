package com.jinux.agilejava.studensystem.report;

import com.jinux.agilejava.studensystem.studentinfo.Course;
import com.jinux.agilejava.studensystem.studentinfo.CourseSession;
import com.jinux.agilejava.utils.StringUtil;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseReportTest {
    @Test
    public void testReport() {
        final Date date = new Date();
        CourseReport report = new CourseReport();
        report.add(CourseSession.create(new Course("ENGL", 101), date));
        report.add(CourseSession.create(new Course("CZEC", 200), date));
        report.add(CourseSession.create(new Course("ITAL", 410), date));
        report.add(CourseSession.create(new Course("CZEC", 220), date));
        report.add(CourseSession.create(new Course("ITAL", 330), date));
        assertEquals(
                StringUtil.appendNewLine("CZEC 200")
                +StringUtil.appendNewLine("CZEC 220")
                        + StringUtil.appendNewLine("ENGL 101")
                        + StringUtil.appendNewLine("ITAL 330")
                        + StringUtil.appendNewLine("ITAL 410"),
                report.text());
    }
}
