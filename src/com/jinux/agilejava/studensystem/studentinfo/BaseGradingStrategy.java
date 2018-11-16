package com.jinux.agilejava.studensystem.studentinfo;

public class BaseGradingStrategy implements GradingStrategy {
    @Override
    public float gradePointsFor(Student.Grade grade) {
        switch (grade) {
            case A:
                return 4f;
            case B:
                return 3f;
            case C:
                return 2f;
            case D:
                return 1f;
            case E:
                return 0f;
            default:
                return 0f;
        }
    }
}
