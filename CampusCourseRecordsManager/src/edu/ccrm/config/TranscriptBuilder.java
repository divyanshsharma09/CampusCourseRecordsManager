package edu.ccrm.config;

import edu.ccrm.domain.Transcript;
import edu.ccrm.domain.Enrollment;
import edu.ccrm.domain.Grade;

import java.util.List;

public class TranscriptBuilder {

    private String studentId;
    private List<Enrollment> enrollments;

    public TranscriptBuilder setStudentId(String studentId) {
        this.studentId = studentId;
        return this;
    }

    public TranscriptBuilder setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
        return this;
    }

    public Transcript build() {
        Transcript transcript = new Transcript(studentId);

        double totalGradePoints = 0.0;
        int totalCredits = 0;

        for (Enrollment enrollment : enrollments) {
            Grade grade = enrollment.getGrade();
            if (grade != null) {
                int credits = enrollment.getCourse().getCredits();
                totalCredits += credits;
                totalGradePoints += grade.getGradePoint() * credits;
                transcript.addCourseGrade(enrollment.getCourse(), grade);
            }
        }

        double gpa = totalCredits == 0 ? 0 : totalGradePoints / totalCredits;
        transcript.setGpa(gpa);

        return transcript;
    }
}
