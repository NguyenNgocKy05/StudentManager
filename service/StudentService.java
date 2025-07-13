package service;

import model.Student;
import java.util.ArrayList;

public class StudentService {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student s) throws Exception {
        for (Student stu : students) {
            if (stu.getStudentId() == s.getStudentId())
                throw new Exception("Duplicate ID");
        }
        students.add(s);
    }

    public boolean deleteStudent(int id) {
        return students.removeIf(s -> s.getStudentId() == id);
    }

    public ArrayList<Student> searchStudent(String name) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getFullName().toLowerCase().contains(name.toLowerCase()))
                result.add(s);
        }
        return result;
    }

    public void displayStudents() {
        System.out.printf("%-10s %-30s %-5s\n", "ID", "Name", "GPA");
        for (Student s : students)
            System.out.println(s);
    }
}
