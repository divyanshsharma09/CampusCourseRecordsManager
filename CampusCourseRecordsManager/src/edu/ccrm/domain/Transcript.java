package edu.ccrm.domain;

import java.util.HashMap;
import java.util.Map;

public class Transcript {
    private String studentId;
    private Map<Course, Grade> courseGrades = new HashMap<>();
    private double gpa;

    public Transcript(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void addCourseGrade(Course course, Grade grade) {
        courseGrades.put(course, grade);
    }

    public Map<Course, Grade> getCourseGrades() {
        return courseGrades;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Transcript:\n");
        courseGrades.forEach((course, grade) -> sb.append(course.getCode())
                .append(": ").append(grade).append("\n"));
        sb.append("GPA: ").append(gpa);
        return sb.toString();
    }
}
