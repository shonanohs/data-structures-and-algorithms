package algorithms.searching;

public class LinearSearch {

    // Time complexity: O(n)
    // Space complexity: O(1)
    public static int linearSearch(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (value == array[i]) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(linearSearch(new int[]{6, 1, 3, 9, 10, 21, 44}, 3)); // 2
        System.out.println(linearSearch(new int[]{6, 1, 3, 9, 10, 21, 44}, 5)); // -1
    }
}
