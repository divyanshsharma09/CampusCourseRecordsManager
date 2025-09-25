package edu.ccrm.util;

import edu.ccrm.domain.Course;
import edu.ccrm.domain.Student;

import java.util.Comparator;

public class Comparators {

    public static final Comparator<Student> STUDENT_BY_NAME = Comparator.comparing(s -> s.getFullName().toLowerCase());

    public static final Comparator<Course> COURSE_BY_CODE = Comparator.comparing(c -> c.getCode().toLowerCase());

    public static final Comparator<Course> COURSE_BY_TITLE = Comparator.comparing(c -> c.getTitle().toLowerCase());
    
}
