package com.jinux.agilejava.studensystem.report;

import com.jinux.agilejava.studensystem.studentinfo.CourseSession;
import com.jinux.agilejava.utils.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CourseReport {

    private List<CourseSession> mSessions = new ArrayList<>();

    public void add(CourseSession session) {
        mSessions.add(session);
    }

    public String text() {
        mSessions.sort(Comparator.comparing(CourseSession::getDepartment));
        StringBuilder builder = new StringBuilder();
        for (CourseSession session: mSessions) {
            builder.append(StringUtil.appendNewLine(session.getDepartment() + " " + session.getNumber()));
        }
        return builder.toString();
    }
}
