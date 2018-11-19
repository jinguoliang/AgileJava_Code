package com.jinux.agilejava.studensystem.studentinfo;

public class BasicGradingStrategy implements GradingStrategy {
    @Override
    public float gradePointsFor(Student.Grade grade) {
        return grade.getPoints();
    }
}

// 我明白一个超级帮的道理，好吧，也不是太大
// 映射，是 枚举，Map 该做的，而策略应该做的是选择那种映射如何映射