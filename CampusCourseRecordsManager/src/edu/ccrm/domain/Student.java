package edu.ccrm.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Student extends Person {
    private String regNo;
    private boolean active;
    private LocalDate dateOfBirth;
    private Set<Course> enrolledCourses;

    public Student(String id, String regNo, String fullName, String email, LocalDate dateOfBirth) {
        super(id, fullName, email);
        this.regNo = regNo;
        this.dateOfBirth = dateOfBirth;
        this.active = true;
        this.enrolledCourses = new HashSet<>();
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public boolean isActive() {
        return active;
    }

    public void deactivate() {
        this.active = false;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Set<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
    }

    public void unenrollCourse(Course course) {
        enrolledCourses.remove(course);
    }

    @Override
    public String toString() {
        return String.format("Student[id=%s, regNo=%s, name=%s, email=%s, active=%s]",
                getId(), regNo, getFullName(), getEmail(), active);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(getId(), student.getId()) &&
               Objects.equals(regNo, student.regNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), regNo);
    }
}
