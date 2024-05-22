//shape drawable and resizable

import java.util.Scanner;

interface Drawable {
    void draw();
}

interface Resizable {
    void resize(double factor);
}

class Circle implements Drawable, Resizable {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Circle with radius: " + radius);
    }

    @Override
    public void resize(double factor) {
        if (factor <= 0) {
            throw new IllegalArgumentException("Resize factor must be positive.");
        }
        radius *= factor;
        System.out.println("Resized Circle to new radius: " + radius);
    }

    public double getRadius() {
        return radius;
    }
}

class Rectangle implements Drawable {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle with length: " + length + " and width: " + width);
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }
}

public class shapehierarchy{
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nShape Menu:");
            System.out.println("1. Draw Circle");
            System.out.println("2. Resize Circle");
            System.out.println("3. Draw Rectangle");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter radius of the circle: ");
                    double radius = scanner.nextDouble();
                    Circle circle = new Circle(radius);
                    circle.draw();
                    break;

                case 2:
                    System.out.print("Enter radius of the circle: ");
                    radius = scanner.nextDouble();
                    Circle resizableCircle = new Circle(radius);
                    resizableCircle.draw();
                    System.out.print("Enter resize factor: ");
                    double factor = scanner.nextDouble();
                    try {
                        resizableCircle.resize(factor);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Enter length of the rectangle: ");
                    double length = scanner.nextDouble();
                    System.out.print("Enter width of the rectangle: ");
                    double width = scanner.nextDouble();
                    Rectangle rectangle = new Rectangle(length, width);
                    rectangle.draw();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
