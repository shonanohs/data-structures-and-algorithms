package dynamic_programming;

import java.util.concurrent.ConcurrentHashMap;

public class DynamicFibonacci {

    private static ConcurrentHashMap<Integer, Integer> cache = new ConcurrentHashMap<>();
    private static int operationsCount = 0;

    // Time complexity: O(n)
    // Space complexity: O(n)
    public static int fibonacciDynamic(int index) {
        validateInput(index);
        if (index < 2) return index;

        if (!cache.containsKey(index)) {
            operationsCount++;
            cache.put(index, fibonacciDynamic(index - 1) + fibonacciDynamic(index - 2));
        }
        return cache.get(index);
    }

    private static void validateInput(int index) {
        if (index < 0) throw new IllegalArgumentException("Negative index is not valid.");
    }

    public static void main(String[] args) {
        System.out.println("Fibonacci(5): " + fibonacciDynamic(5));
        System.out.println("Operations performed: " + operationsCount);
        System.out.println("Fibonacci(8): " + fibonacciDynamic(8));
        System.out.println("Operations performed: " + operationsCount);
        System.out.println("Fibonacci(30): " + fibonacciDynamic(30));
        System.out.println("Operations performed: " + operationsCount);
    }
}
