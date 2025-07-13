package service;

import model.Student;
import java.util.ArrayList;

public class StudentService {

    // ❌ LỖI 1: Vi phạm naming convention
    private double GPA; // Codacy sẽ yêu cầu đổi thành camelCase: gpa

    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student s) throws Exception {
        for (Student stu : students) {
            if (stu.getStudentId() == s.getStudentId()) {
                throw new Exception("Duplicate ID");
            }
        }
        students.add(s);
    }

    public boolean deleteStudent(int id) {
        return students.removeIf(s -> s.getStudentId() == id);
    }

    public ArrayList<Student> searchStudent(String name) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getFullName().toLowerCase().contains(name.toLowerCase())) {
                result.add(s);
            }
        }
        return result;
    }

    public void displayStudents() {
        System.out.printf("%-10s %-30s %-5s\n", "ID", "Name", "GPA");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    // ❌ LỖI 2: Phương thức quá dài (quá phức tạp)
    public void dummyComplexMethod() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) System.out.println("Even");
            else System.out.println("Odd");
        }
        int a = 1, b = 2, c = 3;
        if (a + b > c) System.out.println("A");
        if (b + c > a) System.out.println("B");
        if (a + c > b) System.out.println("C");
    }

    // ❌ LỖI 3: Biến không sử dụng
    public void unusedDemo() {
        int unused = 42;
        System.out.println("Demo function.");
    }
}
