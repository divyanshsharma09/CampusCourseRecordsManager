package edu.ccrm.io;

import edu.ccrm.domain.Course;
import edu.ccrm.domain.Student;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class ImportExportService {

    private final CsvParser csvParser;

    public ImportExportService() {
        this.csvParser = new CsvParser();
    }

    // Imports students from a CSV file and returns a list of Student objects
    public List<Student> importStudents(Path csvFile) throws IOException {
        List<String[]> rows = csvParser.parse(csvFile);
        // Convert each row to Student object (implementation placeholder)
        // Example: parse regNo, id, fullName, email, dob
        return StudentParser.parseStudents(rows);
    }

    // Imports courses from a CSV file and returns a list of Course objects
    public List<Course> importCourses(Path csvFile) throws IOException {
        List<String[]> rows = csvParser.parse(csvFile);
        // Convert each row to Course object (implementation placeholder)
        return CourseParser.parseCourses(rows);
    }

    // Exports provided data to CSV, implementation placeholder
    public void exportData(List<?> data, Path targetFile) throws IOException {
        // Convert data to CSV lines and write to targetFile
    }
}

class StudentParser {
    public static List<Student> parseStudents(List<String[]> rows) {
        // Placeholder: convert CSV rows to Student list
        return List.of(); // needs actual parsing logic
    }
}

class CourseParser {
    public static List<Course> parseCourses(List<String[]> rows) {
        // Placeholder: convert CSV rows to Course list
        return List.of(); // needs actual parsing logic
    }
}
