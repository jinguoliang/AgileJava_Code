package com.jinux.agilejava.studensystem.studentinfo;

import java.util.Arrays;

public class Performance {
    private int[] tests;

    public void setNumberOfTests(int num) {
        tests = new int[num];
    }

    public void set(int testNumber, int score) {
        tests[testNumber] = score;
    }

    public int get(int testNumber) {
        return tests[testNumber];
    }

    public double average() {
        return Arrays.stream(tests).average().getAsDouble();
    }

    public void setScores(int score1, int score2, int score3, int score4) {
        tests = new int[]{score1, score2, score3, score4};
    }
}
