package main;

import model.Student;
import service.StudentService;
import service.DuplicateStudentException;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentService service = new StudentService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            showMenu();
            int choice = readChoice(sc);

            switch (choice) {
                case 1:
                    addStudentFlow(sc, service);
                    break;
                case 2:
                    deleteStudentFlow(sc, service);
                    break;
                case 3:
                    searchStudentFlow(sc, service);
                    break;
                case 4:
                    service.displayStudents();
                    break;
                case 5:
                    System.out.println("👋 Goodbye!");
                    return;
                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n===== Student Management Menu =====");
        System.out.println("1. Add Student");
        System.out.println("2. Delete Student by ID");
        System.out.println("3. Search Student by Name");
        System.out.println("4. Display All Students");
        System.out.println("5. Exit");
        System.out.print("Enter your choice (1-5): ");
    }

    private static int readChoice(Scanner sc) {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid input. Please enter a number.");
            return -1;
        }
    }

    private static void addStudentFlow(Scanner sc, StudentService service) {
        try {
            System.out.print("Enter Student ID: ");
            int id = Integer.parseInt(sc.nextLine());

            System.out.print("Enter Full Name: ");
            String name = sc.nextLine();

            System.out.print("Enter GPA (0.0 - 4.0): ");
            double gpa = Double.parseDouble(sc.nextLine());

            Student s = new Student(id, name, gpa);
            service.addStudent(s);
            System.out.println("✅ Student added successfully.");
        } catch (DuplicateStudentException e) {
            System.out.println("❌ " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Invalid input: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Unexpected error: " + e.getMessage());
        }
    }

    private static void deleteStudentFlow(Scanner sc, StudentService service) {
        System.out.print("Enter Student ID to delete: ");
        int deleteId = Integer.parseInt(sc.nextLine());
        boolean deleted = service.deleteStudent(deleteId);
        if (deleted) {
            System.out.println("✅ Student deleted.");
        } else {
            System.out.println("❌ Student not found.");
        }
    }

    private static void searchStudentFlow(Scanner sc, StudentService service) {
        System.out.print("Enter name to search: ");
        String searchName = sc.nextLine();
        ArrayList<Student> result = service.searchStudent(searchName);
        if (result.isEmpty()) {
            System.out.println("❌ No matching students found.");
        } else {
            System.out.println("🎯 Search results:");
            System.out.printf("%-10s %-30s %-5s\n", "ID", "Name", "GPA");
            for (Student s : result) {
                System.out.println(s);
            }
        }
    }
}
