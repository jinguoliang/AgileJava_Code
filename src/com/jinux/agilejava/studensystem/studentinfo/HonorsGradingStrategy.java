package com.jinux.agilejava.studensystem.studentinfo;

public class HonorsGradingStrategy extends BaseGradingStrategy {
    @Override
    public float gradePointsFor(Student.Grade grade) {
        float points = baseGradePointsFor(grade);
        if (points > 0) {
            points++;
        }
        return points;
    }
}
