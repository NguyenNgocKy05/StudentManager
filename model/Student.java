package model;

public class Student {
    private int studentId;
    private String fullName;
    private double gpa;

    public Student(int studentId, String fullName, double gpa) {
        if (fullName.length() > 50 || gpa < 0.0 || gpa > 4.0)
            throw new IllegalArgumentException("Invalid name or GPA");
        this.studentId = studentId;
        this.fullName = fullName;
        this.gpa = gpa;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public double getGpa() {
        return gpa;
    }

    public void setFullName(String name) {
        if (name.length() <= 50) {
            this.fullName = name;
        }
    }

    public void setGpa(double gpa) {
        if (gpa >= 0.0 && gpa <= 4.0) {
            this.gpa = gpa;
        }
    }

    @Override
    public String toString() {
        return String.format("%-10d %-30s %-5.2f", studentId, fullName, gpa);
    }
}
