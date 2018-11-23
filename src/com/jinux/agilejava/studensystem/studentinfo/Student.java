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

    private GradingStrategy mGradingStrategy = new BasicGradingStrategy();

    private List<Grade> mGrades = new ArrayList<>();
    private String lastName;
    private String firstName = "";
    private String middleName = "";

    public Student(String fullName) {
        this.mName = fullName;
        List<String> nameParts = split(fullName);
        setName(nameParts);
    }

    private List<String> split(String fullName) {
        List<String> result = new ArrayList<>(3);
        StringBuilder builder = new StringBuilder();
        int index = 0;
        while (index < fullName.length()) {
            char c = fullName.charAt(index);
            if (c != ' ') {
                builder.append(c);
            } else {
                if (builder.length() > 0) {
                    result.add(builder.toString());
                }
                builder = new StringBuilder();
            }
            index++;
        }
        if (builder.length() > 0) {
            result.add(builder.toString());
        }
        return result;
    }

    public void setGradingStrategy(GradingStrategy mGradingStrategy) {
        this.mGradingStrategy = mGradingStrategy;
    }

    public String getName() {
        return mName;
    }

    private void setName(List<String> nameParts) {

        this.lastName = removeLast(nameParts);
        String name = removeLast(nameParts);
        if (nameParts.isEmpty()) {
            this.firstName = name;
        } else {
            this.middleName = name;
            this.firstName = removeLast(nameParts);
        }

    }

    private String removeLast(List<String> nameParts) {
        if (nameParts.isEmpty()) {
            return "";
        }
        return nameParts.remove(nameParts.size() - 1);
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

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    enum Grade {
        A(4), B(3), C(2), D(1), F(0);

        private final float points;

        Grade(float points) {
            this.points = points;
        }

        public float getPoints() {
            return points;
        }
    }
}
