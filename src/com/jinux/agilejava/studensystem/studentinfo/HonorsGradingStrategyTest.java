package com.jinux.agilejava.studensystem.studentinfo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HonorsGradingStrategyTest {

    @Test
    void gradePointsFor() {
        GradingStrategy strategy = new HonorsGradingStrategy();
        assertEquals(5, strategy.gradePointsFor(Student.Grade.A));
        assertEquals(4, strategy.gradePointsFor(Student.Grade.B));
        assertEquals(3, strategy.gradePointsFor(Student.Grade.C));
        assertEquals(2, strategy.gradePointsFor(Student.Grade.D));
        assertEquals(0, strategy.gradePointsFor(Student.Grade.F));
    }
}