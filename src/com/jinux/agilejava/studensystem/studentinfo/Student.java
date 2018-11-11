package com.jinux.agilejava.studensystem.studentinfo;

import java.util.Objects;

public class Student {

    public static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
    public static final String IN_STATE = "CO";
    private final String mName;

    private int mCredits;
    private String mState;

    public Student(String name) {
        this.mName = name;
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
}
