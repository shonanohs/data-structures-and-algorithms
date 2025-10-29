package algorithms.sorting;

import static algorithms.ArrayUtils.printArray;

public class BubbleSort {

    // Time complexity: O(n²)
    // Space complexity: O(1)
    public static int[] bubbleSort(int[] array) {
        if (array == null) return new int[0];
        int length = array.length;
        boolean swapped; // Flag to track if any swaps occurred in the inner loop

        // In each pass, the largest unsorted element "bubbles up" to its correct position
        for (int i = 0; i < length - 1; i++) {
            swapped = false;
            for (int j = 0; j < length - 1 - i; j++) { // Performs the adjacent comparisons and swaps
                // across the unsorted portion of the array
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped by inner loop, the array is already sorted and we can stop early
            if (!swapped) {
                break;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 21, 4, 5, 2, 8, 10, 3, 19};
        printArray(array); // [1, 21, 4, 5, 2, 8, 10, 3, 19]
        bubbleSort(array);
        printArray(array); // [1, 2, 3, 4, 5, 8, 10, 19, 21]
    }
}
