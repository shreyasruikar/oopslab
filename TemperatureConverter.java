import java.util.Scanner;

class InvalidTemperatureException extends Exception {
    public InvalidTemperatureException(String message) {
        super(message);
    }
}

class TemperatureConverter {
    private static final double MIN_CELSIUS = -273.15; // global constant
    private static final double MAX_CELSIUS = 1000.0; // global constant

    public static double celsiusToFahrenheit(double celsius) throws InvalidTemperatureException {
        if (celsius < MIN_CELSIUS || celsius > MAX_CELSIUS) {
            throw new InvalidTemperatureException("Temperature out of valid range: " + celsius + "\u00B0C");
        }
        return (celsius * 9/5) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) throws InvalidTemperatureException {
        double celsius = (fahrenheit - 32) * 5/9;
        if (celsius < MIN_CELSIUS || celsius > MAX_CELSIUS) {
            throw new InvalidTemperatureException("Temperature out of valid range: " + fahrenheit + "\u00B0F");
        }
        return celsius;
    }
}


public class Temperature {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTemperature Converter Menu:");
            System.out.println("1. Convert Celsius to Fahrenheit");
            System.out.println("2. Convert Fahrenheit to Celsius");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter temperature in Celsius: ");
                    double celsius = scanner.nextDouble();
                    try {
                        double fahrenheit = TemperatureConverter.celsiusToFahrenheit(celsius);
                        System.out.println(celsius + "\u00B0C is " + fahrenheit + "\u00B0F");
                    } catch (InvalidTemperatureException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter temperature in Fahrenheit: ");
                    double fahrenheit = scanner.nextDouble();
                    try {
                        double celsiusResult = TemperatureConverter.fahrenheitToCelsius(fahrenheit);
                        System.out.println(fahrenheit + "\u00B0F is " + celsiusResult + "\u00B0C");
                    } catch (InvalidTemperatureException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
