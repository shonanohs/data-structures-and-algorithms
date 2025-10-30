package algorithms.searching;

public class BinarySearch {

    // Time complexity: O(log n)
    // Space complexity: O(1)
    public static int binarySearch(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (array[mid] == value) {
                return mid;
            }
            else if (array[mid] < value) {
                low = mid + 1;
            }
            else if (array[mid] > value) {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{2, 3, 4, 10, 40}, 10)); // 3
        System.out.println(binarySearch(new int[]{2, 3, 4, 10, 40}, 5)); // -1
    }
}
