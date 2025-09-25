package edu.ccrm.cli;

import edu.ccrm.config.AppConfig;
import edu.ccrm.service.CourseService;
import edu.ccrm.service.EnrollmentService;
import edu.ccrm.service.StudentService;
import edu.ccrm.service.TranscriptService;

import java.util.Scanner;

public class Main {private static final Scanner scanner = new Scanner(System.in);
private static final StudentService studentService = new StudentService();
private static final CourseService courseService = new CourseService();
private static final EnrollmentService enrollmentService = new EnrollmentService();
private static final TranscriptService transcriptService = new TranscriptService();

public static void main(String[] args) {
    // Load configuration on start
    AppConfig config = AppConfig.getInstance();
    System.out.println("Welcome to Campus Course & Records Manager (CCRM)");
    System.out.println("Data folder: " + config.getDataFolder());

    boolean exit = false;
    while (!exit) {
        printMenu();
        int choice = getUserChoice();
        switch (choice) {
            case 1 -> studentManagement();
            case 2 -> courseManagement();
            case 3 -> enrollmentAndGrading();
            case 4 -> importExportData();
            case 5 -> backupOperations();
            case 6 -> reports();
            case 7 -> {
                exit = true;
                System.out.println("Exiting CCRM. Goodbye!");
            }
            default -> System.out.println("Invalid option. Please try again.");
        }
    }
    scanner.close();
}

private static void printMenu() {
    System.out.println("\nMain Menu - Select an option:");
    System.out.println("1. Manage Students");
    System.out.println("2. Manage Courses");
    System.out.println("3. Manage Enrollment & Grades");
    System.out.println("4. Import/Export Data");
    System.out.println("5. Backup & Show Backup Size");
    System.out.println("6. Reports");
    System.out.println("7. Exit");
    System.out.print("Enter choice: ");
}

private static int getUserChoice() {
    while (!scanner.hasNextInt()) {
        System.out.println("Invalid input, please enter a number:");
        scanner.next();
    }
    return scanner.nextInt();
}

private static void studentManagement() {
    boolean back = false;
    while (!back) {
        System.out.println("\nStudent Management:");
        System.out.println("1. Add Student");
        System.out.println("2. List Students");
        System.out.println("3. Update Student");
        System.out.println("4. Deactivate Student");
        System.out.println("5. Print Student Profile");
        System.out.println("6. Back to Main Menu");
        System.out.print("Enter choice: ");
        int option = getUserChoice();
        switch (option) {
            case 1 -> studentService.addStudent(scanner);
            case 2 -> studentService.listStudents();
            case 3 -> studentService.updateStudent(scanner);
            case 4 -> studentService.deactivateStudent(scanner);
            case 5 -> studentService.printStudentProfile(scanner);
            case 6 -> back = true;
            default -> System.out.println("Invalid option. Try again.");
        }
    }
}

private static void courseManagement() {
    boolean back = false;
    while (!back) {
        System.out.println("\nCourse Management:");
        System.out.println("1. Add Course");
        System.out.println("2. List Courses");
        System.out.println("3. Update Course");
        System.out.println("4. Deactivate Course");
        System.out.println("5. Back to Main Menu");
        System.out.print("Enter choice: ");
        int option = getUserChoice();
        switch (option) {
            case 1 -> courseService.addCourse(scanner);
            case 2 -> courseService.listCourses();
            case 3 -> courseService.updateCourse(scanner);
            case 4 -> courseService.deactivateCourse(scanner);
            case 5 -> back = true;
            default -> System.out.println("Invalid option. Try again.");
        }
    }
}

private static void enrollmentAndGrading() {
    boolean back = false;
    while (!back) {
        System.out.println("\nEnrollment & Grading:");
        System.out.println("1. Enroll Student in Course");
        System.out.println("2. Unenroll Student from Course");
        System.out.println("3. Record Marks & Compute Grades");
        System.out.println("4. Print Student Transcript");
        System.out.println("5. Back to Main Menu");
        System.out.print("Enter choice: ");
        int option = getUserChoice();
        switch (option) {
            case 1 -> enrollmentService.enrollStudent(scanner);
            case 2 -> enrollmentService.unenrollStudent(scanner);
            case 3 -> enrollmentService.recordMarksAndGrades(scanner);
            case 4 -> transcriptService.printTranscript(scanner);
            case 5 -> back = true;
            default -> System.out.println("Invalid option. Try again.");
        }
    }
}

private static void importExportData() {
    boolean back = false;
    while (!back) {
        System.out.println("\nImport/Export Data:");
        System.out.println("1. Import Students");
        System.out.println("2. Import Courses");
        System.out.println("3. Export Data");
        System.out.println("4. Back to Main Menu");
        System.out.print("Enter choice: ");
        int option = getUserChoice();
        switch (option) {
            case 1 -> System.out.println("Feature under development."); // Placeholder
            case 2 -> System.out.println("Feature under development."); // Placeholder
            case 3 -> System.out.println("Feature under development."); // Placeholder
            case 4 -> back = true;
            default -> System.out.println("Invalid option. Try again.");
        }
    }
}

private static void backupOperations() {
    System.out.println("\nBackup feature coming soon.");
    // Placeholders for backup and recursive size calculation  
}

private static void reports() {
    System.out.println("\nReports feature coming soon.");
    // Placeholder for reports like top students, GPA distribution
}
}