package edu.ccrm.service;

import edu.ccrm.domain.Course;
import edu.ccrm.domain.Enrollment;
import edu.ccrm.domain.Grade;
import edu.ccrm.domain.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EnrollmentService {

    private final List<Enrollment> enrollments = new ArrayList<>();
    private final StudentService studentService = new StudentService();
    private final CourseService courseService = new CourseService();

    public void enrollStudent(Scanner scanner) {
        System.out.print("Enter student ID to enroll: ");
        String studentId = scanner.next();
        Optional<Student> studentOpt = studentService.findStudentById(studentId);
        if (studentOpt.isEmpty()) {
            System.out.println("Student not found.");
            return;
        }
        Student student = studentOpt.get();

        System.out.print("Enter course code to enroll in: ");
        String courseCode = scanner.next();
        Optional<Course> courseOpt = courseService.findCourseByCode(courseCode);
        if (courseOpt.isEmpty()) {
            System.out.println("Course not found.");
            return;
        }
        Course course = courseOpt.get();

        Enrollment enrollment = new Enrollment(student, course, LocalDate.now());
        enrollments.add(enrollment);
        student.enrollCourse(course);
        System.out.println("Student enrolled successfully.");
    }

    public void unenrollStudent(Scanner scanner) {
        System.out.print("Enter student ID to unenroll: ");
        String studentId = scanner.next();
        System.out.print("Enter course code to unenroll from: ");
        String courseCode = scanner.next();

        enrollments.removeIf(e -> e.getStudent().getId().equalsIgnoreCase(studentId)
                && e.getCourse().getCode().equalsIgnoreCase(courseCode));
        System.out.println("Student unenrolled successfully.");
    }

    public void recordMarksAndGrades(Scanner scanner) {
        System.out.print("Enter student ID: ");
        String studentId = scanner.next();
        System.out.print("Enter course code: ");
        String courseCode = scanner.next();
        System.out.print("Enter grade (S/A/B/C/D/E/F): ");
        String gradeStr = scanner.next().toUpperCase();

        Grade grade;
        try {
            grade = Grade.valueOf(gradeStr);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid grade entered.");
            return;
        }

        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudent().getId().equalsIgnoreCase(studentId)
                    && enrollment.getCourse().getCode().equalsIgnoreCase(courseCode)) {
                enrollment.setGrade(grade);
                System.out.println("Grade recorded successfully.");
                return;
            }
        }
        System.out.println("Enrollment not found for student and course.");
    }

    public List<Enrollment> getEnrollmentsForStudent(Student student) {
        return enrollments.stream()
                .filter(e -> e.getStudent().equals(student) && e.isActive())
                .collect(Collectors.toList());
    }
}
