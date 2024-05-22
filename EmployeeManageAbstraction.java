//employee manager using abstraction

import java.util.ArrayList;
import java.util.Scanner;

abstract class Employee {
    protected String name;
    protected int employeeID;

    public Employee(String name, int employeeID) {
        this.name = name;
        this.employeeID = employeeID;
    }

    public abstract double calculateSalary();
    public abstract void evaluatePerformance();

    @Override
    public String toString() {
        return "Employee [Name=" + name + ", Employee ID=" + employeeID + "]";
    }
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;
    private double performanceBonus;

    public FullTimeEmployee(String name, int employeeID, double monthlySalary) {
        super(name, employeeID);
        this.monthlySalary = monthlySalary;
        this.performanceBonus = 0;
    }

    public void setPerformanceBonus(double performanceBonus) {
        this.performanceBonus = performanceBonus;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary + performanceBonus;
    }

    @Override
    public void evaluatePerformance() {
        // Simple performance evaluation logic (can be expanded)
        performanceBonus = monthlySalary * 0.1;  // Example: 10% of monthly salary as bonus
        System.out.println("Performance evaluated. Bonus: $" + performanceBonus);
    }

    @Override
    public String toString() {
        return "FullTimeEmployee [Name=" + name + ", Employee ID=" + employeeID + 
               ", Monthly Salary=" + monthlySalary + ", Performance Bonus=" + performanceBonus + "]";
    }
}

class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(String name, int employeeID, double hourlyRate) {
        super(name, employeeID);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = 0;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public void evaluatePerformance() {
        System.out.println("Performance evaluation not applicable for part-time employees.");
    }

    @Override
    public String toString() {
        return "PartTimeEmployee [Name=" + name + ", Employee ID=" + employeeID + 
               ", Hourly Rate=" + hourlyRate + ", Hours Worked=" + hoursWorked + "]";
    }
}


public class EmployeeManager {
    private ArrayList<Employee> employees;
    private Scanner scanner;

    public EmployeeManager() {
        employees = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void registerEmployee() {
        System.out.println("Register Employee:");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter employee ID: ");
        int employeeID = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
        System.out.print("Enter type (1 for Full-time, 2 for Part-time): ");
        int type = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        if (type == 1) {
            System.out.print("Enter monthly salary: ");
            double monthlySalary = scanner.nextDouble();
            employees.add(new FullTimeEmployee(name, employeeID, monthlySalary));
        } else if (type == 2) {
            System.out.print("Enter hourly rate: ");
            double hourlyRate = scanner.nextDouble();
            employees.add(new PartTimeEmployee(name, employeeID, hourlyRate));
        } else {
            System.out.println("Invalid employee type.");
        }
    }

    public void calculateSalary() {
        System.out.print("Enter employee ID to calculate salary: ");
        int employeeID = scanner.nextInt();
        Employee employee = findEmployeeByID(employeeID);
        if (employee != null) {
            if (employee instanceof PartTimeEmployee) {
                System.out.print("Enter hours worked: ");
                int hoursWorked = scanner.nextInt();
                ((PartTimeEmployee) employee).setHoursWorked(hoursWorked);
            }
            double salary = employee.calculateSalary();
            System.out.println("Calculated Salary: $" + salary);
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void evaluatePerformance() {
        System.out.print("Enter employee ID to evaluate performance: ");
        int employeeID = scanner.nextInt();
        Employee employee = findEmployeeByID(employeeID);
        if (employee != null) {
            employee.evaluatePerformance();
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void displayEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private Employee findEmployeeByID(int employeeID) {
        for (Employee employee : employees) {
            if (employee.employeeID == employeeID) {
                return employee;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);

        while (!exit) {
            System.out.println("\nEmployee Management System Menu:");
            System.out.println("1. Register new employee");
            System.out.println("2. Calculate employee salary");
            System.out.println("3. Evaluate employee performance");
            System.out.println("4. Display all employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    manager.registerEmployee();
                    break;
                case 2:
                    manager.calculateSalary();
                    break;
                case 3:
                    manager.evaluatePerformance();
                    break;
                case 4:
                    manager.displayEmployees();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
