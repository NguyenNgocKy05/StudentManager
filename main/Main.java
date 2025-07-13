package main;

import model.Student;
import service.StudentService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentService service = new StudentService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Student Management Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student by ID");
            System.out.println("3. Search Student by Name");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            
            int choice = -1;

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
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
                    } catch (Exception e) {
                        System.out.println("❌ " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = Integer.parseInt(sc.nextLine());
                    boolean deleted = service.deleteStudent(deleteId);
                    if (deleted)
                        System.out.println("✅ Student deleted.");
                    else
                        System.out.println("❌ Student not found.");
                    break;

                case 3:
    System.out.print("Enter name to search: ");
    String searchName = sc.nextLine();
    ArrayList<Student> result = service.searchStudent(searchName);
    if (result.isEmpty()) {
        System.out.println("❌ No matching students found.");
    } else {
        System.out.println("🎯 Search results:");
        System.out.printf("%-10s %-30s %-5s\n", "ID", "Name", "GPA");
        for (Student s : result)
            System.out.println(s);
    }
    break;


                case 4:
                    System.out.println("📋 All students:");
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
}
