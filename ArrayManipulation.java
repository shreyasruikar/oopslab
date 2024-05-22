//array manipulation code

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class ArrayManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for the size of the array
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        // Ask for array elements
        System.out.println("Enter the elements of the array separated by spaces:");
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("Original Array: " + Arrays.toString(array));

        // Ask for the number of positions to rotate
        System.out.print("Enter the number of positions to rotate to the right: ");
        int rotateBy = scanner.nextInt();
        int[] rotatedArray = rotateArray(array, rotateBy);
        System.out.println("Array after rotating by " + rotateBy + " positions to the right: " + Arrays.toString(rotatedArray));

        // Remove duplicates
        int[] uniqueArray = removeDuplicates(array);
        System.out.println("Array after removing duplicates: " + Arrays.toString(uniqueArray));

        // Rearrange even numbers before odd numbers
        int[] rearrangedArray = rearrangeEvenOdd(array);
        System.out.println("Array with even numbers before odd numbers: " + Arrays.toString(rearrangedArray));

        // Close the scanner
        scanner.close();
    }

    // Method to rotate the elements of the array to the right
    public static int[] rotateArray(int[] array, int rotateBy) {
        int n = array.length;
        rotateBy = rotateBy % n; // handle cases where rotateBy > n
        int[] rotatedArray = new int[n];
        for (int i = 0; i < n; i++) {
            rotatedArray[(i + rotateBy) % n] = array[i];
        }
        return rotatedArray;
    }

    // Method to remove duplicate elements while preserving the original order
    public static int[] removeDuplicates(int[] array) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int num : array) {
            set.add(num);
        }
        int[] uniqueArray = new int[set.size()];
        int index = 0;
        for (int num : set) {
            uniqueArray[index++] = num;
        }
        return uniqueArray;
    }

    // Method to rearrange the elements of the array such that even numbers appear before odd numbers
    public static int[] rearrangeEvenOdd(int[] array) {
        int[] rearrangedArray = new int[array.length];
        int evenIndex = 0;
        int oddIndex = array.length - 1;
        for (int num : array) {
            if (num % 2 == 0) {
                rearrangedArray[evenIndex++] = num;
            } else {
                rearrangedArray[oddIndex--] = num;
            }
        }
        return rearrangedArray;
    }
}
