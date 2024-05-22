//array intersection

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ArrayIntersection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input for nums1
        System.out.print("Enter the number of elements in nums1: ");
        int n1 = scanner.nextInt();

        // Take user input for nums2
        System.out.print("Enter the number of elements in nums2: ");
        int n2 = scanner.nextInt();


        if (n1 > n2) {
            System.out.println("Error: nums1 should not have more elements than nums2.");
            return; // Exit the program if nums1 has more elements than nums2
        }

        int[] nums1 = new int[n1];
        System.out.println("Enter elements of nums1:");
        for (int i = 0; i < n1; i++) {
            nums1[i] = scanner.nextInt();
        }

        int[] nums2 = new int[n2];
        System.out.println("Enter elements of nums2:");
        for (int i = 0; i < n2; i++) {
            nums2[i] = scanner.nextInt();
        }

        int[] result = intersection(nums1, nums2);

        System.out.println("Intersection of nums1 and nums2: " + Arrays.toString(result));

        scanner.close();
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer> intersectList = new ArrayList<>();

        // Count frequencies of elements in nums1
        for (int num : nums1) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Check intersection with nums2
        for (int num : nums2) {
            if (freqMap.containsKey(num) && freqMap.get(num) > 0) {
                intersectList.add(num);
                freqMap.put(num, freqMap.get(num) - 1);
            }
        }

        // Convert list to array
        int[] result = new int[intersectList.size()];
        for (int i = 0; i < intersectList.size(); i++) {
            result[i] = intersectList.get(i);
        }

        return result;
    }
}
