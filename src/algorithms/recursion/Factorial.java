package algorithms.recursion;

/*
    Write two functions that find the factorial of any number.
    One should use recursion, one should use a for loop.
*/
public class Factorial {

    // Time complexity: O(n)
    // Space complexity: O(1)
    public static int factorialIterative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }

        int factorial = 1;
        for (int i = number; i > 1; i--) { // Stop looping at 2 to avoid unnecessary additional loop to multiply by 1
                factorial = i * factorial;
        }
        return factorial;
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    public static int factorialRecursive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        if (number == 0 || number == 1) {
            return 1;
        }
        return factorialRecursive(number - 1) * number;
    }

    public static void main(String[] args) {
        // Iterative function call
        System.out.println(factorialIterative(5)); // 120
        System.out.println(factorialIterative(0)); // 1

        // Recursive function call
        System.out.println(factorialRecursive(5)); // 120
        System.out.println(factorialRecursive(0)); // 1
    }
}
