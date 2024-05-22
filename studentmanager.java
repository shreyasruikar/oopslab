//studentmanager code

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;

class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNumber=" + rollNumber +
                ", grade='" + grade + '\'' +
                '}';
    }
}

public class StudentManager {
    private List<Student> studentslist;

    public StudentManager() {
        studentslist = new ArrayList<>();
    }

    public void addStudent(Student student) {
        studentslist.add(student);
    }

    public void removeStudent(int rollNumber) {
        Iterator<Student> iterator = studentslist.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getRollNumber() == rollNumber) {
                iterator.remove();
                System.out.println("Student with roll number " + rollNumber + " removed.");
                return;
            }
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }

    public void displayStudents() {
        if (studentslist.isEmpty()) {
            System.out.println("No students in the list.");
        } else {
            for (Student student : studentslist) {
                System.out.println(student);
            }
        }
    }

    public void replaceGrade(int rollNumber, String newGrade) {
        for (Student student : studentslist) {
            if (student.getRollNumber() == rollNumber) {
                student.setGrade(newGrade);
                System.out.println("Grade updated for student with roll number " + rollNumber + ".");
                return;
            }
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a student");
            System.out.println("2. Remove a student");
            System.out.println("3. Display all students");
            System.out.println("4. Replace the grade of a student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student's name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student's roll number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter student's grade: ");
                    String grade = scanner.nextLine();
                    manager.addStudent(new Student(name, rollNumber, grade));
                    System.out.println("Student added.");
                    break;

                case 2:
                    System.out.print("Enter student's roll number to remove: ");
                    int rollToRemove = scanner.nextInt();
                    manager.removeStudent(rollToRemove);
                    break;

                case 3:
                    System.out.println("All students:");
                    manager.displayStudents();
                    break;

                case 4:
                    System.out.print("Enter student's roll number to update grade: ");
                    int rollToUpdate = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new grade: ");
                    String newGrade = scanner.nextLine();
                    manager.replaceGrade(rollToUpdate, newGrade);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
