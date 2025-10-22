package algorithms.recursion;

/*
    Write two functions that find the factorial of any number.
    One should use recursion, one should use a for loop.
*/
public class Factorial {
    public static int factorialIterative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }

        int factorial = 1;
        for (int i = number; i > 0; i--) {
                factorial = i * factorial;
        }
        return factorial;
    }

    public static int factorialRecursive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        if (number == 0) {
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
