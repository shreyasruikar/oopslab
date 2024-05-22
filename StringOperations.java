//string operations

import java.util.Scanner;

public class StringOperations {
    
     public static String concatenate(String str1, String str2) {
        return str1 + str2;
    }

    // Method to find the length of a string
    public static int findLength(String str) {
        return str.length();
    }

    // Method to convert a string to uppercase
    public static String toUpperCase(String str) {
        return str.toUpperCase();
    }

    // Method to convert a string to lowercase
    public static String toLowerCase(String str) {
        return str.toLowerCase();
    }

    // Method to check if a string contains a specific substring
    public static boolean containsSubstring(String str, String substring) {
        return str.contains(substring);
    }

    // Method to replace a substring with another substring in a string
    public static String replaceSubstring(String str, String oldSubstring, String newSubstring) {
        return str.replace(oldSubstring, newSubstring);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first string: ");
        String str1 = scanner.nextLine();

        System.out.print("Enter the second string: ");
        String str2 = scanner.nextLine();

        // Demonstrating concatenation
        String concatenated = concatenate(str1, str2);
        System.out.println("Concatenated string: " + concatenated);

        // Demonstrating length
        int length = findLength(str1);
        System.out.println("Length of the first string: " + length);

        // Demonstrating toUpperCase
        String upperCase = toUpperCase(str1);
        System.out.println("First string in uppercase: " + upperCase);

        // Demonstrating toLowerCase
        String lowerCase = toLowerCase(str1);
        System.out.println("First string in lowercase: " + lowerCase);

        // Demonstrating containsSubstring
        System.out.print("Enter the substring to search for: ");
        String substring = scanner.nextLine();
        boolean contains = containsSubstring(str1, substring);
        System.out.println("First string contains \"" + substring + "\": " + contains);

        // Demonstrating replaceSubstring
        System.out.print("Enter the substring to be replaced: ");
        String oldSubstring = scanner.nextLine();

        System.out.print("Enter the new substring: ");
        String newSubstring = scanner.nextLine();

        String replacedString = replaceSubstring(str1, oldSubstring, newSubstring);
        System.out.println("String after replacement: " + replacedString);

        scanner.close();
    }
}
