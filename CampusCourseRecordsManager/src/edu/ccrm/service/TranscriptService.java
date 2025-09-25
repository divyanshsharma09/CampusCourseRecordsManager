package edu.ccrm.service;

import edu.ccrm.domain.Enrollment;
import edu.ccrm.domain.Student;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class TranscriptService {

    private EnrollmentService enrollmentService = new EnrollmentService();
    private StudentService studentService = new StudentService();

    public void printTranscript(Scanner scanner) {
        System.out.print("Enter student ID to print transcript: ");
        String studentId = scanner.next();

        Optional<Student> studentOpt = studentService.findStudentById(studentId);
        if (studentOpt.isEmpty()) {
            System.out.println("Student not found.");
            return;
        }
        Student student = studentOpt.get();

        List<Enrollment> enrollments = enrollmentService.getEnrollmentsForStudent(student);

        // Example output, replace with actual transcript logic
        System.out.println("Transcript for " + student.getFullName());
        enrollments.forEach(enrollment -> 
            System.out.println(enrollment.getCourse().getCode() + ": " + enrollment.getGrade())
        );
    }
}

