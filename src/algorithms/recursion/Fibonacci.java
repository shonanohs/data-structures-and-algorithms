package algorithms.recursion;

/*
    Given an index, return the corresponding value of the Fibonacci sequence, where the sequence is:
    0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 ...
    i.e. each value is the sum of the 2 previous values
 */
public class Fibonacci {
    public static int fibonacciIterative(int index) {
        validateInput(index);
        if (index < 2) return index;

        int a = 0;
        int b = 1;
        for (int i = 2; i <= index; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static int fibonacciRecursive(int index) {
        validateInput(index);
        if (index < 2) return index;

        return fibonacciRecursive(index - 1) + fibonacciRecursive(index - 2);
    }

    private static void validateInput(int index) {
        if (index < 0) throw new IllegalArgumentException("Negative index is not valid.");
    }

    public static void main(String[] args) {
        // Iterative function call
        System.out.println(fibonacciIterative(5)); // 5
        System.out.println(fibonacciIterative(8)); // 21

        // Recursive function call
        System.out.println(fibonacciRecursive(5)); // 5
        System.out.println(fibonacciRecursive(8)); // 21
    }
}
