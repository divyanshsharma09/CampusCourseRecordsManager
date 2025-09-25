package edu.ccrm.domain;

public enum Grade {
    S(10),
    A(9),
    B(8),
    C(7),
    D(6),
    E(5),
    F(0); // Fail

    private final int gradePoint;

    Grade(int gradePoint) {
        this.gradePoint = gradePoint;
    }

    public int getGradePoint() {
        return gradePoint;
    }

    @Override
    public String toString() {
        return name() + " (" + gradePoint + ")";
    }
}
