package algorithms.sorting;

import static algorithms.ArrayUtils.printArray;

public class SelectionSort {

    // Time complexity: O(n²)
    // Space complexity: O(1)
    public static int[] selectionSort(int[] array) {
        if (array == null || array.length < 2) {
            return array;
        }
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        printArray(selectionSort(new int[]{8, 3, 1, 2, 11, 19, 4, 6}));
    }
}
