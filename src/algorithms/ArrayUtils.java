package algorithms;

public final class ArrayUtils {

    private ArrayUtils() {}

    /**
     * Prints the contents of an integer array in a readable format
     * @param array The integer array to print
     */
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
}
