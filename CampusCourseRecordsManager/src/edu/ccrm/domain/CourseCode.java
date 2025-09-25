package edu.ccrm.domain;

import java.util.Objects;

public final class CourseCode {

    private final String code;

    public CourseCode(String code) {
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException("Course code cannot be null or blank");
        }
        this.code = code.trim().toUpperCase();
    }

    public String getCode() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CourseCode)) return false;
        CourseCode that = (CourseCode) o;
        return code.equals(that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return code;
    }
}
