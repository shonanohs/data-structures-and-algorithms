package algorithms.sorting;

import static algorithms.ArrayUtils.printArray;

public class InsertionSort {

    // Time complexity: O(n²)
    // Space complexity: O(1)
    public static int[] insertionSort(int[] array) {
        if (array == null || array.length < 2) {
            return array;
        }
        for (int i = 1; i < array.length; i++) { // Marks boundary between sorted & unsorted sections
            for (int j = i; j > 0; j--) { // Takes the element at array[i] and 'slides' it
                // backwards into the correct position within the sorted subarray
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                } else {
                    break; // Check for early exit (if no swap was needed, the element is in its spot)
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        printArray(insertionSort(new int[]{8, 3, 1, 2, 11, 19, 4, 6}));
    }
}
