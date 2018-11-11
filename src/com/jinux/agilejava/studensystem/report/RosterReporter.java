package com.jinux.agilejava.studensystem.report;

import com.jinux.agilejava.studensystem.studentinfo.CourseSession;
import com.jinux.agilejava.utils.StringUtil;

import static com.jinux.agilejava.utils.StringUtil.NEWLINE;

public class RosterReporter {
    public static final String ROSTER_REPORT_HEADER =
            StringUtil.appendNewLine("Stutents")
            + StringUtil.appendNewLine("----" );
    public static final String ROSTER_REPORT_FOOTER = NEWLINE + "# students = ";

    private final CourseSession mCourseSession;

    public RosterReporter(CourseSession session) {
        mCourseSession = session;
    }

    public String getReport() {
        return getRosterReport();
    }

    public String getRosterReport() {
        StringBuilder builder = new StringBuilder();
        writeHeader(builder);
        writeBody(builder);
        writeFooter(builder);
        return builder.toString();
    }

    private void writeFooter(StringBuilder builder) {
        builder.append(RosterReporter.ROSTER_REPORT_FOOTER);
        builder.append(mCourseSession.getNumberOfStudents() + "\n");
    }

    private void writeBody(StringBuilder builder) {
        for (int i = 0; i < mCourseSession.getNumberOfStudents(); i++) {
            builder.append(mCourseSession.get(i).getName());
            builder.append("\n");
        }
    }

    private void writeHeader(StringBuilder builder) {
        builder.append(RosterReporter.ROSTER_REPORT_HEADER);
    }
}
