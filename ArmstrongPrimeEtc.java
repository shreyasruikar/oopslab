//multi task code

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class MultiTask {
    // Task a: Armstrong Number Check
    public static boolean isArmstrong(int number) {
        int originalNumber = number;
        int sum = 0;
        int numberOfDigits = String.valueOf(number).length();
        
        while (number != 0) {
            int digit = number % 10;
            sum += Math.pow(digit, numberOfDigits);
            number /= 10;
        }
        
        return sum == originalNumber;
    }

    // Task b: Anagram Check
    public static boolean areAnagrams(String str1, String str2) {
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        
        return Arrays.equals(charArray1, charArray2);
    }

    // Task c: Date of Birth Comparison
    public static void compareDOB(String dob1, String dob2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        LocalDate date1 = LocalDate.parse(dob1, formatter);
        LocalDate date2 = LocalDate.parse(dob2, formatter);
        
        if (date1.isEqual(date2)) {
            System.out.println("Same age.");
        } else if (date1.isBefore(date2)) {
            System.out.println("Younger.");
        } else {
            System.out.println("Elder.");
        }
    }

    // Task d: Prime Number Check
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Task a: Armstrong Number Check
        System.out.print("Enter a number to check if it is an Armstrong number: ");
        int armstrongNumber = scanner.nextInt();
        System.out.println(armstrongNumber + (isArmstrong(armstrongNumber) ? " is " : " is not ") + "an Armstrong number.");

        // Task b: Anagram Check
        scanner.nextLine(); // Consume newline
        System.out.print("Enter the first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter the second string: ");
        String str2 = scanner.nextLine();
        System.out.println(str1 + " and " + str2 + (areAnagrams(str1, str2) ? " are " : " are not ") + "anagrams.");

        // Task c: Date of Birth Comparison
        System.out.print("Enter the first date of birth (yyyy-MM-dd): ");
        String dob1 = scanner.nextLine();
        System.out.print("Enter the second date of birth (yyyy-MM-dd): ");
        String dob2 = scanner.nextLine();
        compareDOB(dob1, dob2);

        // Task d: Prime Number Check
        System.out.print("Enter a number to check if it is prime: ");
        int primeNumber = scanner.nextInt();
        System.out.println(primeNumber + (isPrime(primeNumber) ? " is " : " is not ") + "a prime number.");

        scanner.close();
    }
}
