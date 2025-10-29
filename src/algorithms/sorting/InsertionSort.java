package algorithms.sorting;

import static algorithms.ArrayUtils.printArray;

public class InsertionSort {

    // Time complexity: O(n²)
    // Space complexity: O(1)
    public static int[] insertionSort(int[] array) {
        if (array == null || array.length < 2) {
            return array;
        }
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        printArray(insertionSort(new int[]{8, 3, 1, 2, 11, 19, 4, 6}));
    }
}
