//multithreadedcalculator code

import java.util.Scanner;

public class MultithreadedCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next(); // consume the invalid input
        }
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next(); // consume the invalid input
        }
        double num2 = scanner.nextDouble();

        System.out.println("Choose an arithmetic operation: ");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.print("Enter your choice (1-4): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                new Thread(new Addition(num1, num2)).start();
                break;
            case 2:
                new Thread(new Subtraction(num1, num2)).start();
                break;
            case 3:
                new Thread(new Multiplication(num1, num2)).start();
                break;
            case 4:
                new Thread(new Division(num1, num2)).start();
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 4.");
        }

        scanner.close();
    }
}

class Addition implements Runnable {
    private double num1, num2;

    public Addition(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public void run() {
        System.out.println("Addition: " + num1 + " + " + num2 + " = " + (num1 + num2));
    }
}

class Subtraction implements Runnable {
    private double num1, num2;

    public Subtraction(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public void run() {
        System.out.println("Subtraction: " + num1 + " - " + num2 + " = " + (num1 - num2));
    }
}

class Multiplication implements Runnable {
    private double num1, num2;

    public Multiplication(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public void run() {
        System.out.println("Multiplication: " + num1 + " * " + num2 + " = " + (num1 * num2));
    }
}

class Division implements Runnable {
    private double num1, num2;

    public Division(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public void run() {
        if (num2 == 0) {
            System.out.println("Division by zero is not allowed.");
        } else {
            System.out.println("Division: " + num1 + " / " + num2 + " = " + (num1 / num2));
        }
    }
}
