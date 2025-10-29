package algorithms.sorting;

public class QuickSort {

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) { // Base case: stop recursion if array has 0 or 1 element(s)
            // 1. Divide: partition array & get pivot index
            int pivot = partition(array, low, high);

            // 2. Conquer: recursively sort the two subarrays on either side of pivot
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1; // Index of the last element found to be smaller than the pivot -
        // marks the boundary of the 'small' section

        for (int j = low; j <= high - 1; j++) { // Iterate through all elements before the pivot
            if (array[j] <= pivot) { // All elements smaller than the pivot move to the left
                i++; // Boundary moves one position to the right
                swap(array, i, j);
            }
        }
        // Swap the pivot into its correct final position which is immediately after the 'small' section (i + 1)
        swap(array, i + 1, high);
        return i + 1;
    }

    /*
      Utility function to swap two elements in an array.
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
        int[] array = {7, 2, 3, 9, 10, 24, 3, 9};
        quickSort(array, 0, array.length - 1);
        printArray(array); // [2, 3, 3, 7, 9, 9, 10, 24]
    }
}
