package com.jinux.agilejava.studensystem.studentinfo;

public class RegularGradingStrategy extends BaseGradingStrategy {
    @Override
    public float gradePointsFor(Student.Grade grade) {
        return baseGradePointsFor(grade);
    }
}
