package algorithms.sorting;

public class MergeSort {

    // Time complexity: O(n log n)
    // Space complexity: O(n)
    public static int[] mergeSort(int[] array) {
        if (array.length == 1) {
            return array;
        }

        double mid = (double) array.length / 2;

        int[] left = new int[(int) Math.floor(mid)];
        int[] right = new int[(int) Math.ceil(mid)];

        for (int i = 0; i < array.length / 2; i++) {
            left[i] = array[i];
        }

        int j = 0;
        for (int i = array.length / 2; i < array.length; i++) {
            right[j] = array[i];
            j++;
        }

        return merge(mergeSort(left), mergeSort(right));
    }

    public static int[] merge(int[] array1, int[] array2) {
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

    public static void printArray(int[] array) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        printArray(mergeSort(new int[] {4, 5, 1, 12, 23, 7, 19}));
    }
}
