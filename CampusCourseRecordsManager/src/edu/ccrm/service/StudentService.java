package edu.ccrm.service;

import edu.ccrm.domain.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class StudentService {

    private final List<Student> students = new ArrayList<>();

    public void addStudent(Scanner scanner) {
        System.out.print("Enter student ID: ");
        String id = scanner.next();
        System.out.print("Enter registration number: ");
        String regNo = scanner.next();
        System.out.print("Enter full name: ");
        scanner.nextLine(); // consume leftover line
        String fullName = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.next();
        System.out.print("Enter date of birth (YYYY-MM-DD): ");
        String dobStr = scanner.next();
        LocalDate dob = LocalDate.parse(dobStr);

        Student student = new Student(id, regNo, fullName, email, dob);
        students.add(student);
        System.out.println("Student added: " + student);
    }

    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        students.forEach(System.out::println);
    }

    public void updateStudent(Scanner scanner) {
        System.out.print("Enter student ID to update: ");
        String id = scanner.next();
        Optional<Student> studentOpt = findStudentById(id);
        if (studentOpt.isEmpty()) {
            System.out.println("Student not found.");
            return;
        }
        Student student = studentOpt.get();

        System.out.print("Enter new full name: ");
        scanner.nextLine(); // consume leftover
        String newName = scanner.nextLine();
        student.setFullName(newName);
        System.out.println("Student updated: " + student);
    }

    public void deactivateStudent(Scanner scanner) {
        System.out.print("Enter student ID to deactivate: ");
        String id = scanner.next();
        Optional<Student> studentOpt = findStudentById(id);
        studentOpt.ifPresent(student -> {
            student.deactivate();
            System.out.println("Student deactivated: " + student);
        });
    }

    public void printStudentProfile(Scanner scanner) {
        System.out.print("Enter student ID: ");
        String id = scanner.next();
        Optional<Student> studentOpt = findStudentById(id);
        studentOpt.ifPresentOrElse(
                student -> System.out.println("Profile: " + student),
                () -> System.out.println("Student not found.")
        );
    }

    public Optional<Student> findStudentById(String id) {
        return students.stream()
                .filter(s -> s.getId().equalsIgnoreCase(id))
                .findFirst();
    }
}
