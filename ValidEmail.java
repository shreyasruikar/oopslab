//valid email code

import java.util.Scanner;

class InvalidEmailException extends Exception {
    public InvalidEmailException(String message) {
        super(message);
    }
}


public class ValidEmail {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your email address: ");
        String email = scanner.nextLine();

        try {
            validateEmail(email);
            System.out.println("The email address is valid.");
        } catch (InvalidEmailException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static void validateEmail(String email) throws InvalidEmailException {
        if (email == null || !email.contains("@") || !email.contains(".") || email.indexOf('@') > email.lastIndexOf('.')) {
            throw new InvalidEmailException("Invalid email address. Please make sure it contains '@' and '.', and '@' comes before '.'.");
        }
    }
}
