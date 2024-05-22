//simple calculator

import java.util.Scanner;

public class SimpleCalculator {
     public static final double PI;

    // Static block to initialize PI and print a welcome message
    static {
        PI = 3.14;
        System.out.println("Welcome to the Simple Calculator!");
    }

    // Instance block to print a message when a new instance is created
    {
        System.out.println("New calculator instance");
    }

    // Constructor
    public SimpleCalculator() {
        // Constructor body can be empty or can contain initialization logic if needed
    }

    // Method for addition
    public double add(double a, double b) {
        return a + b;
    }

    // Method for subtraction
    public double subtract(double a, double b) {
        return a - b;
    }

    // Method for multiplication
    public double multiply(double a, double b) {
        return a * b;
    }

    // Method for division
    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }

    public static void main(String[] args) {
        SimpleCalculator calculator = new SimpleCalculator();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSimple Calculator Menu:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            if (choice == 5) {
                System.out.println("Exiting...");
                break;
            }

            System.out.print("Enter the first number: ");
            double num1 = scanner.nextDouble();

            System.out.print("Enter the second number: ");
            double num2 = scanner.nextDouble();

            try {
                switch (choice) {
                    case 1:
                        System.out.println("Result: " + calculator.add(num1, num2));
                        break;
                    case 2:
                        System.out.println("Result: " + calculator.subtract(num1, num2));
                        break;
                    case 3:
                        System.out.println("Result: " + calculator.multiply(num1, num2));
                        break;
                    case 4:
                        System.out.println("Result: " + calculator.divide(num1, num2));
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }
}
