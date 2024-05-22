//array operations

import java.util.Arrays;
import java.util.Scanner;

public class ArrayOperations {
    public static int[] initializeArray(int size, Scanner scanner) {
        int[] array = new int[size];
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    // Method to find the sum of all elements in the array
    public static int findSum(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }

    // Method to find the maximum element in the array
    public static int findMax(int[] array) {
        int max = array[0];
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    // Method to find the minimum element in the array
    public static int findMin(int[] array) {
        int min = array[0];
        for (int value : array) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    // Method to sort the elements of the array in ascending order
    public static void sortArray(int[] array) {
        Arrays.sort(array);
    }

    // Method to reverse the elements of the array
    public static void reverseArray(int[] array) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] array = initializeArray(size, scanner);

        System.out.println("Array initialized: " + Arrays.toString(array));

        int sum = findSum(array);
        System.out.println("Sum of all elements: " + sum);

        int max = findMax(array);
        System.out.println("Maximum element: " + max);

        int min = findMin(array);
        System.out.println("Minimum element: " + min);

        sortArray(array);
        System.out.println("Array sorted in ascending order: " + Arrays.toString(array));

        reverseArray(array);
        System.out.println("Array reversed: " + Arrays.toString(array));

        scanner.close();
    }
}
