//student management system

import java.util.*;

class Stud {
    private final String id;
    private String name;
    private String gender;
    private String grade;
    private String contactInfo;
    private int age;

    public Stud(String id, String name, int age, String gender, String grade, String contactInfo) {
        this.id = id; this.name = name; this.age = age;
        this.gender = gender; this.grade = grade; this.contactInfo = contactInfo;
    }

    public String getId() { return id; }
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setGender(String gender) { this.gender = gender; }
    public void setGrade(String grade) { this.grade = grade; }
    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }

    @Override public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Gender: " + gender + ", Grade: " + grade + ", Contact Info: " + contactInfo;
    }
}

public class StudentManagementSystem {
    private static final String ADMIN_USERNAME = "admin", ADMIN_PASSWORD = "password";
    private static final List<Stud> studentDatabase = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        if (adminLogin()) {
            while (true) {
                System.out.println("\nMenu: A. Add Student B. Remove Student C. Update Student D. Display All E. Search F. Exit");
                switch (scanner.nextLine().toUpperCase()) {
                    case "A": addNewStudent(); break;
                    case "B": removeStudent(); break;
                    case "C": updateStudentInfo(); break;
                    case "D": displayAllStudents(); break;
                    case "E": searchStudent(); break;
                    case "F": System.out.println("Exiting."); return;
                    default: System.out.println("Invalid choice.");
                }
            }
        } else {
            System.out.println("Invalid login.");
        }
    }

    private static boolean adminLogin() {
        System.out.print("Username: "); String username = scanner.nextLine();
        System.out.print("Password: "); String password = scanner.nextLine();
        return ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password);
    }

    private static void addNewStudent() {
        System.out.print("ID: "); String id = scanner.nextLine();
        if (getStudentById(id) != null) { System.out.println("ID exists."); return; }
        System.out.print("Name: "); String name = scanner.nextLine();
        System.out.print("Age: "); int age = getIntInput();
        System.out.print("Gender: "); String gender = scanner.nextLine();
        System.out.print("Grade: "); String grade = scanner.nextLine();
        System.out.print("Contact Info: "); String contactInfo = scanner.nextLine();
        studentDatabase.add(new Stud(id, name, age, gender, grade, contactInfo));
        System.out.println("Student added.");
    }

    private static void removeStudent() {
        System.out.print("ID: "); Stud student = getStudentById(scanner.nextLine());
        if (student != null) {
            studentDatabase.remove(student); System.out.println("Student removed.");
        } else { System.out.println("ID not found."); }
    }

    private static void updateStudentInfo() {
        System.out.print("ID: "); Stud student = getStudentById(scanner.nextLine());
        if (student == null) { System.out.println("ID not found."); return; }
        System.out.println("Updating " + student);
        System.out.print("New Name: "); String name = scanner.nextLine(); if (!name.isBlank()) student.setName(name);
        System.out.print("New Age: "); String ageInput = scanner.nextLine(); if (!ageInput.isBlank()) student.setAge(Integer.parseInt(ageInput));
        System.out.print("New Gender: "); String gender = scanner.nextLine(); if (!gender.isBlank()) student.setGender(gender);
        System.out.print("New Grade: "); String grade = scanner.nextLine(); if (!grade.isBlank()) student.setGrade(grade);
        System.out.print("New Contact Info: "); String contactInfo = scanner.nextLine(); if (!contactInfo.isBlank()) student.setContactInfo(contactInfo);
        System.out.println("Updated.");
    }

    private static void displayAllStudents() {
        if (studentDatabase.isEmpty()) { System.out.println("No students."); return; }
        for (Stud student : studentDatabase) { System.out.println(student); }
    }

    private static void searchStudent() {
        System.out.println("Search by: 1. ID 2. Name 3. Grade");
        int choice = getIntInput();
        System.out.print("Enter search term: "); String searchTerm = scanner.nextLine();
        List<Stud> results = new ArrayList<>();
        for (Stud student : studentDatabase) {
            if ((choice == 1 && student.getId().equalsIgnoreCase(searchTerm)) ||
                    (choice == 2 && student.getId().equalsIgnoreCase(searchTerm)) ||
                    (choice == 3 && student.getId().equalsIgnoreCase(searchTerm))) {
                results.add(student);
            }
        }
        if (results.isEmpty()) { System.out.println("No results found."); }
        else { for (Stud student : results) { System.out.println(student); } }
    }

    private static Stud getStudentById(String id) {
        for (Stud student : studentDatabase) {
            if (student.getId().equals(id)) { return student; }
        }
        return null;
    }

    private static int getIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter an integer.");
            }
        }
    }
}
