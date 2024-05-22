//word counter

import java.util.HashSet;
import java.util.Scanner;

public class WordCounter {
    // Method to count the number of unique words in the given text
    public int countUniqueWords(String text) {
        // Use a HashSet to store unique words
        HashSet<String> uniqueWords = new HashSet<>();
        
        // Split the text into words based on whitespace
        String[] words = text.split("\\s+");

        // Add each word to the HashSet
        for (String word : words) {
            uniqueWords.add(word.toLowerCase());
        }

        // Return the number of unique words
        return uniqueWords.size();
    }

    public static void main(String[] args) {
        // Create an instance of WordCounter
        WordCounter wordCounter = new WordCounter();
        
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a text string
        System.out.print("Enter a text string: ");
        String text = scanner.nextLine();

        // Count the number of unique words in the input text
        int uniqueWordCount = wordCounter.countUniqueWords(text);

        // Display the number of unique words
        System.out.println("Number of unique words: " + uniqueWordCount);

        // Close the scanner
        scanner.close();
    }
}
