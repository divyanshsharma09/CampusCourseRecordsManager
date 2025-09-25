package edu.ccrm.domain;

public class Instructor extends Person {

    private String department;
    private String title;

    public Instructor(String id, String fullName, String email, String department, String title) {
        super(id, fullName, email);
        this.department = department;
        this.title = title;
    }

    // Getters and setters
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return String.format("Instructor[id=%s, name=%s, email=%s, dept=%s, title=%s]",
                getId(), getFullName(), getEmail(), department, title);
    }
}
