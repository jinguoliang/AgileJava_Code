package com.jinux.agilejava.studensystem.studentinfo;

import java.util.EnumMap;
import java.util.Map;

public class ReportCard {
    public static final String A_MESSAGE = "Excellent";
    public static final String B_MESSAGE = "Very good";
    public static final String C_MESSAGE = "Hmmm...";
    public static final String D_MESSAGE = "You're not trying";
    public static final String F_MESSAGE = "Loser";
    private Map<Student.Grade, String> message;

    public String getMessage(Student.Grade grade) {
        if (message == null) {
            loadMessages();
        }
        return message.get(grade);
    }

    private void loadMessages() {
        message = new EnumMap<>(Student.Grade.class);
        message.put(Student.Grade.A, A_MESSAGE);
        message.put(Student.Grade.B, B_MESSAGE);
        message.put(Student.Grade.C, C_MESSAGE);
        message.put(Student.Grade.D, D_MESSAGE);
        message.put(Student.Grade.F, F_MESSAGE);
    }
}
