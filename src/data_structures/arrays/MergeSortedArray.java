package data_structures.arrays;

import java.util.Arrays;

// Given two arrays that are sorted, merge them into one sorted array
public class MergeSortedArray {

    // Time complexity: O(n + m)
    // Space complexity: O(n + m)
    public static int[] mergeSort(int[] array1, int[] array2) {
        int i = 0; // array1 index
        int j = 0; // array2 index
        int k = 0; // merged array index

        int[] mergedArray = new int[array1.length + array2.length];

        while (i < array1.length && j < array2.length) {
            if (array1[i] <= array2[j]) {
                mergedArray[k] = array1[i];
                i++;
            } else {
                mergedArray[k] = array2[j];
                j++;
            }
            k++;
        }

        // Add remaining elements, if any (when array lengths differ)
        while (i < array1.length) {
            mergedArray[k] = array1[i];
            i++;
            k++;
        }

        while (j < array2.length) {
            mergedArray[k] = array2[j];
            j++;
            k++;
        }
        return mergedArray;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSort(new int[]{0, 3, 4, 31}, new int[]{4, 6, 30}))); // [0, 3, 4, 4, 6, 30, 31]
    }
}
