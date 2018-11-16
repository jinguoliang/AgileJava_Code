package com.jinux.agilejava.studensystem.studentinfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student {

    public static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
    public static final String IN_STATE = "CO";

    private final String mName;

    private int mCredits;

    private String mState;

    private GradingStrategy mGradingStrategy = new RegularGradingStrategy();

    private List<Grade> mGrades = new ArrayList<>();

    public Student(String name) {
        this.mName = name;
    }

    public void setGradingStrategy(GradingStrategy mGradingStrategy) {
        this.mGradingStrategy = mGradingStrategy;
    }

    public String getName() {
        return mName;
    }

    public boolean isFullTime() {
        return mCredits >= CREDITS_REQUIRED_FOR_FULL_TIME;
    }

    public int getCredits() {
        return mCredits;
    }

    public void addCredits(int i) {
        this.mCredits += i;
    }

    public boolean isInState() {
        return Objects.equals(IN_STATE, mState);
    }

    public void setState(String state) {
        mState = state;
    }

    public double getGpa() {
        if (mGrades.isEmpty()) return 0f;
        float total = 0f;
        for (Grade grade : mGrades) total += mGradingStrategy.gradePointsFor(grade);
        return total / mGrades.size();
    }

    public void addGrade(Grade grade) {
        mGrades.add(grade);
    }

    enum Grade {A, B, C, D, E}
}
