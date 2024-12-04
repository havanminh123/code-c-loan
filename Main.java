package democodep4;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Sample data
        manager.addStudent(new Student("S001", "Nguyen Van A", 8.5));
        manager.addStudent(new Student("S002", "Tran Thi B", 6.0));
        manager.addStudent(new Student("S003", "Le Van C", 7.8));
        manager.addStudent(new Student("S004", "Pham Thi D", 5.5));
        manager.addStudent(new Student("S005", "Dinh Van E", 9.2));

        do {
            // Display menu options
            System.out.println("\n----- Student Management -----");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student Info");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student");
            System.out.println("5. Sort Students by Marks");
            System.out.println("6. Display Student List");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        // Add a new student
                        addStudent(scanner, manager);
                        break;

                    case 2:
                        // Edit existing student info
                        editStudent(scanner, manager);
                        break;

                    case 3:
                        // Delete a student
                        System.out.print("Enter the ID of the student to delete: ");
                        String deleteId = scanner.nextLine();
                        manager.deleteStudent(deleteId);
                        break;

                    case 4:
                        // Search for a student
                        System.out.print("Enter the ID of the student to search: ");
                        String searchId = scanner.nextLine();
                        Student foundStudent = manager.searchStudent(searchId);
                        if (foundStudent != null) {
                            System.out.println(foundStudent);
                        } else {
                            System.out.println("Error: Student not found.");
                        }
                        break;

                    case 5:
                        // Sort and display students
                        manager.sortStudents(); // Sort using Bubble Sort
                        System.out.println("Students sorted by marks:");
                        displayStudents(manager);
                        break;

                    case 6:
                        // Display current student list
                        System.out.println("Current student list:");
                        displayStudents(manager);
                        break;

                    case 0:
                        System.out.println("Exiting the program.");
                        break;

                    default:
                        System.out.println("Error: Invalid choice. Please select between 0 and 6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number between 0 and 6.");
                choice = -1; // Reset choice to continue the loop
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void addStudent(Scanner scanner, StudentManager manager) {
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();

        // Validate name input
        String name;
        while (true) {
            System.out.print("Enter name: ");
            name = scanner.nextLine();
            if (Pattern.matches("[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯăẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾỄỆỈỊỌỎỐỒỔÔÕÙÚĂĐỀỆƠƠƯãùúăãđễụƯạảấầẩẫậắằẳẵặẹẻẽềềểếễệỉịọỏốồổộũ]+(?:\\s[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯăẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾỄỆỈỊỌỎỐỒỔÔÕÙÚĂĐỀỆƠƠƯãùúăãđễụƯạảấầẩẫậắằẳẵặẹẻẽềềểếễệỉịọỏốồổộũ]*)*", name)) {
                break; // Valid name
            } else {
                System.out.println("Error: Invalid name. Please enter letters and spaces only.");
            }
        }

        // Validate marks input
        double marks;
        while (true) {
            System.out.print("Enter marks: ");
            if (scanner.hasNextDouble()) {
                marks = scanner.nextDouble();
                scanner.nextLine(); // Clear the newline
                if (marks >= 0 && marks <= 10) {
                    break; // Valid marks
                } else {
                    System.out.println("Error: Marks must be between 0 and 10.");
                }
            } else {
                System.out.println("Error: Please enter valid marks.");
                scanner.next(); // Clear invalid input
            }
        }
        manager.addStudent(new Student(id, name, marks));
    }

    private static void editStudent(Scanner scanner, StudentManager manager) {
        System.out.print("Enter the ID of the student to edit: ");
        String editId = scanner.nextLine();

        // Validate new name input
        String newName;
        while (true) {
            System.out.print("Enter new name: ");
            newName = scanner.nextLine();
            if (Pattern.matches("[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯăẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾỄỆỈỊỌỎỐỒỔÔÕÙÚĂĐỀỆƠƠƯãùúăãđễụƯạảấầẩẫậắằẳẵặẹẻẽềềểếễệỉịọỏốồổộũ]+(?:\\s[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯăẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾỄỆỈỊỌỎỐỒỔÔÕÙÚĂĐỀỆƠƠƯãùúăãđễụƯạảấầẩẫậắằẳẵặẹẻẽềềểếễệỉịọỏốồổộũ]*)*", newName)) {
                break; // Valid new name
            } else {
                System.out.println("Error: Invalid name. Please enter letters and spaces only.");
            }
        }

        // Validate new marks input
        double newMarks;
        while (true) {
            System.out.print("Enter new marks: ");
            if (scanner.hasNextDouble()) {
                newMarks = scanner.nextDouble();
                scanner.nextLine(); // Clear the newline
                if (newMarks >= 0 && newMarks <= 10) {
                    break; // Valid new marks
                } else {
                    System.out.println("Error: Marks must be between 0 and 10.");
                }
            } else {
                System.out.println("Error: Please enter valid marks.");
                scanner.next(); // Clear invalid input
            }
        }
        manager.editStudent(editId, newName, newMarks);
    }

    private static void displayStudents(StudentManager manager) {
        for (Student student : manager.getStudents()) {
            System.out.println(student);
        }
    }
}