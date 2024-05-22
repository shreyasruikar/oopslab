//arraylistoperations 

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class ArrayListOperations {
    // Task a: Remove duplicates from an ArrayList
    public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> list) {
        HashSet<Integer> set = new HashSet<>(list);
        return new ArrayList<>(set);
    }

    // Task b: Various operations on ArrayList
    public static boolean checkIfExists(ArrayList<Integer> list, int element) {
        return list.contains(element);
    }

    public static void addElementAtIndex(ArrayList<Integer> list, int index, int element) {
        list.add(index, element);
    }

    public static void removeElementAtIndex(ArrayList<Integer> list, int index) {
        list.remove(index);
    }

    public static void sortArrayList(ArrayList<Integer> list) {
        Collections.sort(list);
    }

    public static void reverseArrayList(ArrayList<Integer> list) {
        Collections.reverse(list);
    }

    public static boolean compareArrayLists(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        return list1.equals(list2);
    }

    public static int findFirstOccurrence(ArrayList<Integer> list, int element) {
        return list.indexOf(element);
    }

    public static int findLastOccurrence(ArrayList<Integer> list, int element) {
        return list.lastIndexOf(element);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Task a: Remove duplicates and return a unique list
        System.out.println("Enter integers for the list (comma-separated): ");
        String input = scanner.nextLine();
        ArrayList<Integer> listWithDuplicates = new ArrayList<>();
        for (String s : input.split(",")) {
            listWithDuplicates.add(Integer.parseInt(s.trim()));
        }

        ArrayList<Integer> uniqueList = removeDuplicates(listWithDuplicates);
        System.out.println("Unique list: " + uniqueList);

        // Task b: Perform various operations
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Enter integers for another list (comma-separated): ");
        input = scanner.nextLine();
        for (String s : input.split(",")) {
            list.add(Integer.parseInt(s.trim()));
        }

        // Check if an element exists
        System.out.print("Enter an element to check if it exists in the list: ");
        int element = scanner.nextInt();
        System.out.println("Does " + element + " exist in the list? " + checkIfExists(list, element));

        // Add element at a particular index
        System.out.print("Enter an element to add: ");
        int newElement = scanner.nextInt();
        System.out.print("Enter the index to add the element at: ");
        int index = scanner.nextInt();
        addElementAtIndex(list, index, newElement);
        System.out.println("List after adding " + newElement + " at index " + index + ": " + list);

        // Remove element at a particular index
        System.out.print("Enter the index to remove the element from: ");
        int removeIndex = scanner.nextInt();
        removeElementAtIndex(list, removeIndex);
        System.out.println("List after removing element at index " + removeIndex + ": " + list);

        // Sort the ArrayList
        sortArrayList(list);
        System.out.println("Sorted list: " + list);

        // Reverse the elements in the ArrayList
        reverseArrayList(list);
        System.out.println("Reversed list: " + list);

        // Compare two ArrayLists
        ArrayList<Integer> anotherList = new ArrayList<>();
        System.out.println("Enter integers for another list to compare (comma-separated): ");
        scanner.nextLine(); // Consume newline left-over
        input = scanner.nextLine();
        for (String s : input.split(",")) {
            anotherList.add(Integer.parseInt(s.trim()));
        }
        System.out.println("Are both lists equal? " + compareArrayLists(list, anotherList));

        // Find first and last occurrence of an element
        ArrayList<Integer> listWithRepeats = new ArrayList<>();
        System.out.println("Enter integers for a list with repeats (comma-separated): ");
        input = scanner.nextLine();
        for (String s : input.split(",")) {
            listWithRepeats.add(Integer.parseInt(s.trim()));
        }
        System.out.print("Enter an element to find its first and last occurrence: ");
        int repeatElement = scanner.nextInt();
        System.out.println("First occurrence of " + repeatElement + ": " + findFirstOccurrence(listWithRepeats, repeatElement));
        System.out.println("Last occurrence of " + repeatElement + ": " + findLastOccurrence(listWithRepeats, repeatElement));

        scanner.close();
    }
}
