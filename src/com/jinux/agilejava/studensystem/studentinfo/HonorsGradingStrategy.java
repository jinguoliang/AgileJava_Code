package com.jinux.agilejava.studensystem.studentinfo;

public class HonorsGradingStrategy extends BaseGradingStrategy {
    @Override
    public float gradePointsFor(Student.Grade grade) {
        float points = super.gradePointsFor(grade);
        if (points > 0) {
            points++;
        }
        return points;
    }
}
