//company management system

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
    private String name;
    private int employeeID;
    private double hourlyRate;

    public Employee(String name, int employeeID, double hourlyRate) {
        this.name = name;
        this.employeeID = employeeID;
        this.hourlyRate = hourlyRate;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public double calculateMonthlySalary() {
        // Default implementation for base class
        return 0;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", employeeID=" + employeeID +
                ", hourlyRate=" + hourlyRate +
                '}';
    }
}


class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double overtimeRate;

    public PartTimeEmployee(String name, int employeeID, double hourlyRate, int hoursWorked, double overtimeRate) {
        super(name, employeeID, hourlyRate);
        this.hoursWorked = hoursWorked;
        this.overtimeRate = overtimeRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public double getOvertimeRate() {
        return overtimeRate;
    }

    @Override
    public double calculateMonthlySalary() {
        // Calculate monthly salary including overtime
        // Assuming regular hours are 80 hours a month, and rest are overtime
        int regularHours = Math.min(hoursWorked, 80);
        int overtimeHours = Math.max(hoursWorked - 80, 0);
        return (regularHours * getHourlyRate()) + (overtimeHours * getHourlyRate() * getOvertimeRate());
    }

    @Override
    public String toString() {
        return "PartTimeEmployee{" +
                "name='" + getName() + '\'' +
                ", employeeID=" + getEmployeeID() +
                ", hourlyRate=" + getHourlyRate() +
                ", hoursWorked=" + hoursWorked +
                ", overtimeRate=" + overtimeRate +
                '}';
    }
}


class FullTimeEmployee extends Employee {
    private double salary;
    private double benefits;

    public FullTimeEmployee(String name, int employeeID, double hourlyRate, double salary, double benefits) {
        super(name, employeeID, hourlyRate);
        this.salary = salary;
        this.benefits = benefits;
    }

    public double getSalary() {
        return salary;
    }

    public double getBenefits() {
        return benefits;
    }

    @Override
    public double calculateMonthlySalary() {
        // Assuming a full-time employee works 160 hours a month
        return getSalary() + getBenefits();
    }

    @Override
    public String toString() {
        return "FullTimeEmployee{" +
                "name='" + getName() + '\'' +
                ", employeeID=" + getEmployeeID() +
                ", hourlyRate=" + getHourlyRate() +
                ", salary=" + salary +
                ", benefits=" + benefits +
                '}';
    }
}


public class Company {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a full-time employee");
            System.out.println("2. Add a part-time employee");
            System.out.println("3. Display all employees");
            System.out.println("4. Calculate monthly salary for all employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter employee's name: ");
                    String fullName = scanner.nextLine();
                    System.out.print("Enter employee's ID: ");
                    int fullID = scanner.nextInt();
                    System.out.print("Enter hourly rate: ");
                    double fullHourlyRate = scanner.nextDouble();
                    System.out.print("Enter salary: ");
                    double salary = scanner.nextDouble();
                    System.out.print("Enter benefits: ");
                    double benefits = scanner.nextDouble();
                    employees.add(new FullTimeEmployee(fullName, fullID, fullHourlyRate, salary, benefits));
                    System.out.println("Full-time employee added.");
                    break;

                case 2:
                    System.out.print("Enter employee's name: ");
                    String partName = scanner.nextLine();
                    System.out.print("Enter employee's ID: ");
                    int partID = scanner.nextInt();
                    System.out.print("Enter hourly rate: ");
                    double partHourlyRate = scanner.nextDouble();
                    System.out.print("Enter hours worked: ");
                    int hoursWorked = scanner.nextInt();
                    System.out.print("Enter overtime rate: ");
                    double overtimeRate = scanner.nextDouble();
                    employees.add(new PartTimeEmployee(partName, partID, partHourlyRate, hoursWorked, overtimeRate));
                    System.out.println("Part-time employee added.");
                    break;

                case 3:
                    System.out.println("All employees:");
                    for (Employee employee : employees) {
                        System.out.println(employee);
                    }
                    break;

                case 4:
                    System.out.println("Monthly salaries:");
                    for (Employee employee : employees) {
                        System.out.println(employee.getName() + ": " + employee.calculateMonthlySalary());
                    }
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
