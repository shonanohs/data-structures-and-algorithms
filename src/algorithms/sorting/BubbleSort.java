package algorithms.sorting;

public class BubbleSort {

    // Time complexity: O(n²)
    // Space complexity: O(1)
    public static int[] bubbleSort(int[] array) {
        if (array == null) return new int[0];
        int length = array.length;
        boolean swapped;

        for (int i = 0; i < length - 1; i++) {
            swapped = false;
            for (int j = 0; j < length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
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
        int[] array = new int[]{1, 21, 4, 5, 2, 8, 10, 3, 19};
        printArray(array); // [1, 21, 4, 5, 2, 8, 10, 3, 19]
        bubbleSort(array);
        printArray(array); // [1, 2, 3, 4, 5, 8, 10, 19, 21]
    }
}
