package edu.ccrm.service;

import edu.ccrm.domain.Course;
import edu.ccrm.domain.Instructor;
import edu.ccrm.domain.Semester;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CourseService {

    private final List<Course> courses = new ArrayList<>();

    public void addCourse(Scanner scanner) {
        System.out.print("Enter course code: ");
        String code = scanner.next();
        System.out.print("Enter course title: ");
        scanner.nextLine(); // consume leftover
        String title = scanner.nextLine();
        System.out.print("Enter credits: ");
        int credits = scanner.nextInt();

        System.out.print("Enter department: ");
        scanner.nextLine(); // consume leftover
        String department = scanner.nextLine();

        Instructor instructor = null; // Placeholder for setting instructor
        Semester semester = Semester.FALL; // Placeholder default

        Course newCourse = new Course(code, title, credits, instructor, semester, department);
        courses.add(newCourse);
        System.out.println("Course added: " + newCourse);
    }

    public void listCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }
        courses.forEach(System.out::println);
    }

    public void updateCourse(Scanner scanner) {
        System.out.print("Enter course code to update: ");
        String code = scanner.next();
        Optional<Course> courseOpt = findCourseByCode(code);
        if (courseOpt.isEmpty()) {
            System.out.println("Course not found with code: " + code);
            return;
        }
        Course course = courseOpt.get();

        System.out.print("Enter new title: ");
        scanner.nextLine(); // consume leftover
        String newTitle = scanner.nextLine();
        System.out.print("Enter new credits: ");
        int newCredits = scanner.nextInt();

        course.setTitle(newTitle);
        course.setCredits(newCredits);
        System.out.println("Course updated: " + course);
    }

    public void deactivateCourse(Scanner scanner) {
        System.out.print("Enter course code to deactivate: ");
        String code = scanner.next();
        Optional<Course> courseOpt = findCourseByCode(code);
        if (courseOpt.isEmpty()) {
            System.out.println("Course not found with code: " + code);
            return;
        }
        Course course = courseOpt.get();
        course.deactivate();
        System.out.println("Course deactivated: " + course);
    }

    public Optional<Course> findCourseByCode(String code) {
        return courses.stream()
                .filter(course -> course.getCode().equalsIgnoreCase(code))
                .findFirst();
    }
}
