package democodep4;

import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        // Check for existing ID
        for (Student existingStudent : students) {
            if (existingStudent.getId().equals(student.getId())) {
                System.out.println("Error: ID already exists. Please enter a different ID.");
                return;
            }
        }
        students.add(student);
        System.out.println("Student added successfully!");
    }

    public void editStudent(String id, String newName, double newMarks) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                students.set(i, new Student(id, newName, newMarks)); // Update student
                System.out.println("Student information updated successfully!");
                return;
            }
        }
        System.out.println("Error: Student with ID " + id + " not found.");
    }

    public void deleteStudent(String id) {
        boolean removed = students.removeIf(student -> student.getId().equals(id));
        if (removed) {
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Error: Student with ID " + id + " not found.");
        }
    }

    public Student searchStudent(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student; // Student found
            }
        }
        return null; // Student not found
    }

    // Sort students by marks using Bubble Sort
    public void sortStudents() {
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Compare marks of two adjacent students
                if (students.get(j).getMarks() < students.get(j + 1).getMarks()) {
                    // Swap if the current student's marks are less than the next student's
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
            }
        }
        System.out.println("Student list sorted by marks successfully!");
    }

    public ArrayList<Student> getStudents() {
        return students; // Return the list of students
    }
}