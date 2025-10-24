package algorithms.sorting;

public class InsertionSort {

    // Time complexity: O(n²)
    // Space complexity: O(1)
    public static int[] insertionSort(int[] array) {
        for (int i = 1; i <= array.length; i++) {
            for (int j = i - 1; j > 0; j--) {
                int val1 = array[j];
                int val2 = array[j - 1];

                if (val1 < val2) {
                    array[j] = array[j - 1];
                    array[j - 1] = val1;
                }
            }
        }
        return array;
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
        printArray(insertionSort(new int[]{8, 3, 1, 2, 11, 19, 4, 6}));
    }
}
