//rental manager

import java.util.ArrayList;
import java.util.Scanner;


interface Rentable {
    void rent();
    void returnVehicle();
    double calculateRentalCost(int days);
}

class Car implements Rentable {
    private String make;
    private String model;
    private boolean isRented;
    private double dailyRate;

    public Car(String make, String model, double dailyRate) {
        this.make = make;
        this.model = model;
        this.isRented = false;
        this.dailyRate = dailyRate;
    }

    @Override
    public void rent() {
        if (!isRented) {
            isRented = true;
            System.out.println("Car rented successfully.");
        } else {
            System.out.println("Car is already rented.");
        }
    }

    @Override
    public void returnVehicle() {
        if (isRented) {
            isRented = false;
            System.out.println("Car returned successfully.");
        } else {
            System.out.println("Car was not rented.");
        }
    }

    @Override
    public double calculateRentalCost(int days) {
        return dailyRate * days;
    }

    @Override
    public String toString() {
        return "Car [make=" + make + ", model=" + model + ", dailyRate=" + dailyRate + ", isRented=" + isRented + "]";
    }
}

class Motorcycle implements Rentable {
    private String make;
    private String model;
    private boolean isRented;
    private double dailyRate;

    public Motorcycle(String make, String model, double dailyRate) {
        this.make = make;
        this.model = model;
        this.isRented = false;
        this.dailyRate = dailyRate;
    }

    @Override
    public void rent() {
        if (!isRented) {
            isRented = true;
            System.out.println("Motorcycle rented successfully.");
        } else {
            System.out.println("Motorcycle is already rented.");
        }
    }

    @Override
    public void returnVehicle() {
        if (isRented) {
            isRented = false;
            System.out.println("Motorcycle returned successfully.");
        } else {
            System.out.println("Motorcycle was not rented.");
        }
    }

    @Override
    public double calculateRentalCost(int days) {
        return dailyRate * days;
    }

    @Override
    public String toString() {
        return "Motorcycle [make=" + make + ", model=" + model + ", dailyRate=" + dailyRate + ", isRented=" + isRented + "]";
    }
}

class Bicycle implements Rentable {
    private String make;
    private String model;
    private boolean isRented;
    private double dailyRate;

    public Bicycle(String make, String model, double dailyRate) {
        this.make = make;
        this.model = model;
        this.isRented = false;
        this.dailyRate = dailyRate;
    }

    @Override
    public void rent() {
        if (!isRented) {
            isRented = true;
            System.out.println("Bicycle rented successfully.");
        } else {
            System.out.println("Bicycle is already rented.");
        }
    }

    @Override
    public void returnVehicle() {
        if (isRented) {
            isRented = false;
            System.out.println("Bicycle returned successfully.");
        } else {
            System.out.println("Bicycle was not rented.");
        }
    }

    @Override
    public double calculateRentalCost(int days) {
        return dailyRate * days;
    }

    @Override
    public String toString() {
        return "Bicycle [make=" + make + ", model=" + model + ", dailyRate=" + dailyRate + ", isRented=" + isRented + "]";
    }
}


public class RentalManager {
    private ArrayList<Rentable> vehicles;
    private Scanner scanner;

    public RentalManager() {
        vehicles = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addVehicle(Rentable vehicle) {
        vehicles.add(vehicle);
    }

    public void rentVehicle(int index) {
        if (index >= 0 && index < vehicles.size()) {
            vehicles.get(index).rent();
        } else {
            System.out.println("Invalid vehicle index.");
        }
    }

    public void returnVehicle(int index) {
        if (index >= 0 && index < vehicles.size()) {
            vehicles.get(index).returnVehicle();
        } else {
            System.out.println("Invalid vehicle index.");
        }
    }

    public void displayVehicles() {
        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println((i + 1) + ". " + vehicles.get(i));
        }
    }

    public void calculateRentalCost(int index, int days) {
        if (index >= 0 && index < vehicles.size()) {
            double cost = vehicles.get(index).calculateRentalCost(days);
            System.out.println("Total rental cost for " + days + " days: $" + cost);
        } else {
            System.out.println("Invalid vehicle index.");
        }
    }

    public static void main(String[] args) {
        RentalManager manager = new RentalManager();

        Car car = new Car("Toyota", "Camry", 50);
        Motorcycle motorcycle = new Motorcycle("Honda", "CBR", 30);
        Bicycle bicycle = new Bicycle("Giant", "Escape", 10);

        manager.addVehicle(car);
        manager.addVehicle(motorcycle);
        manager.addVehicle(bicycle);

        boolean exit = false;
        Scanner scanner = new Scanner(System.in);

        while (!exit) {
            System.out.println("\nVehicle Rental System Menu:");
            System.out.println("1. Display all vehicles");
            System.out.println("2. Rent a vehicle");
            System.out.println("3. Return a vehicle");
            System.out.println("4. Calculate rental cost");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    manager.displayVehicles();
                    break;
                case 2:
                    System.out.print("Enter the vehicle number to rent: ");
                    int rentIndex = scanner.nextInt() - 1;
                    manager.rentVehicle(rentIndex);
                    break;
                case 3:
                    System.out.print("Enter the vehicle number to return: ");
                    int returnIndex = scanner.nextInt() - 1;
                    manager.returnVehicle(returnIndex);
                    break;
                case 4:
                    System.out.print("Enter the vehicle number: ");
                    int costIndex = scanner.nextInt() - 1;
                    System.out.print("Enter the number of days: ");
                    int days = scanner.nextInt();
                    manager.calculateRentalCost(costIndex, days);
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
