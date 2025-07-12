package main;

import model.Student;
import service.StudentService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentService service = new StudentService();
        Scanner sc = new Scanner(System.in);

        try {
            service.addStudent(new Student(1, "Alice Nguyen", 3.5));
            service.addStudent(new Student(2, "Bob Tran", 2.7));
            service.addStudent(new Student(3, "Charlie Le", 4.0));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        service.displayStudents();
    }
}
