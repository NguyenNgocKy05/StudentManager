package service;

import model.Student;
import java.util.ArrayList;

public class StudentService {
    // ❌ LỖI 1: Vi phạm Java naming convention
    private double GPA; // Codacy sẽ báo nên đặt tên theo camelCase (gpa)

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

    // ❌ LỖI 2: Phương thức quá dài và phức tạp (code smell)
    public void dummyMethod() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                System.out.println("Even");
            } else {
                System.out.println("Odd");
            }
        }

        int a = 1, b = 2, c = 3;
        if (a + b > c) System.out.println("Logic A");
        if (b + c > a) System.out.println("Logic B");
        if (a + c > b) System.out.println("Logic C");
    }

    // ❌ LỖI 3: Biến không sử dụng
    public void demo() {
        int unusedVariable = 123456;
        System.out.println("Demo method runs");
    }
}
