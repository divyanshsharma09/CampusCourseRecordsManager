# CCRM System Usage Guide

## Configuration

### Application Properties
Create `app.properties` in the application directory:
```properties
data.directory=./data
backup.directory=./data/backup
debug.mode=false
max.backup.files=5
```

## Running the Application

1. Navigate to the project directory
2. Compile the Java files:
   ```bash
   javac -d bin src/edu/ccrm/*.java src/edu/ccrm/*/*.java
   ```
3. Run the main class:
   ```bash
   java -cp bin edu.ccrm.CCRMApp
   ```

## Main Menu Options

### 1. Student Management
- Add Student
  ```
  Enter student ID: 1001
  Enter first name: John
  Enter last name: Doe
  Enter email: john.doe@example.com
  ```
- View Student: Search by ID or list all
- Update Student: Modify existing records
- Delete Student: Remove with enrollment check

### 2. Course Management
- Add Course
  ```
  Enter course code: CS101
  Enter course name: Introduction to Programming
  Enter capacity: 30
  Enter semester: FALL_2025
  ```
- View Course: Search by code or list all
- Update Course: Modify course details
- Delete Course: Remove if no active enrollments

### 3. Enrollment Management
- Enroll Student
  ```
  Enter student ID: 1001
  Enter course code: CS101
  Enter semester: FALL_2025
  ```
- Drop Course: Remove enrollment
- View Enrollments: By student or course
- Update Grades: Record/modify grades

### 4. Data Management
- Import Data: Load from CSV files
- Export Data: Save to CSV format
- Backup Data: Create timestamped backup
- Restore Backup: Recover from backup file

## File Formats

### students.csv
```csv
id,first_name,last_name,email,enrollment_date
1001,John,Doe,john.doe@example.com,2025-09-01
1002,Jane,Smith,jane.smith@example.com,2025-09-01
```

### courses.csv
```csv
code,name,capacity,instructor,semester
CS101,Introduction to Programming,30,Dr. Brown,FALL_2025
MATH201,Advanced Calculus,25,Dr. Smith,FALL_2025
```

### enrollments.csv
```csv
student_id,course_code,semester,grade
1001,CS101,FALL_2025,A
1002,MATH201,FALL_2025,B+
```

## Error Handling

### Common Issues
1. File Permissions
   - Ensure write access to data directory
   - Check backup directory permissions

2. Data Validation
   - Student ID format: 4 digits
   - Course code format: 2-4 letters + 3 digits
   - Valid email format required
   - Grade values: A, A-, B+, B, B-, C+, C, C-, D, F

3. Enrollment Rules
   - No duplicate enrollments
   - Course capacity limits
   - Pre-requisite validation

### Debug Mode
Enable debug mode in app.properties for detailed logging:
```properties
debug.mode=true
```
