package com.jinux.agilejava.studensystem.studentinfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public class Student {

    public static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
    public static final String IN_STATE = "CO";
    public static final String TOO_MANY_NAME_PARTS_MSG = "Student name '%s' contains more than %d parts";
    public static final int MAXIMUM_NUMBER_OF_NAME_PARTS = 3;
    static Logger logger = Logger.getLogger(Student.class.getName());
    private final String mName;
    private int mCredits;
    private String mState;
    private GradingStrategy mGradingStrategy = new BasicGradingStrategy();
    private List<Grade> mGrades = new ArrayList<>();
    private String lastName;
    private String firstName = "";
    private String middleName = "";
    private List<Integer> charges = new ArrayList<>();
    private String id;

    public Student(String fullName) {
        this.mName = fullName;
        List<String> nameParts = split(fullName);
        if (nameParts.size() > MAXIMUM_NUMBER_OF_NAME_PARTS) {

            String message = String.format(TOO_MANY_NAME_PARTS_MSG,
                    fullName, MAXIMUM_NUMBER_OF_NAME_PARTS);
            Student.logger.info(message);
            throw new StudentNameFormatException(message);
        }
        setName(nameParts);
    }

    private List<String> split(String fullName) {
        List<String> result = new ArrayList<>(3);
        result.addAll(Arrays.asList(fullName.split(" ")));
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

    public float getGpa() {
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

    public void addCharge(int charge) {
        charges.add(charge);
    }

    public int totalCharges() {
        return charges.stream().reduce(0, (integer, integer2) -> integer + integer2);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
