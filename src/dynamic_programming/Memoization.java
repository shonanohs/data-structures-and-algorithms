package dynamic_programming;

import java.util.HashMap;

public class Memoization {

    private static HashMap<Integer, Integer> cache = new HashMap<>();

    private Memoization() {}

    public static int addTo80(int n) {
        return n + 80;
    }

    public static int memoizedAddTo80(int n) {
        // If n present, return its value
        // Else, compute value & add to map
        return cache.computeIfAbsent(n, key -> key + 80);
    }

    public static void main(String[] args) {
        // Standard method
        System.out.println(addTo80(5)); // Computes 5 + 80, 85, both times
        System.out.println(addTo80(5));
        // Memoized method
        System.out.println(memoizedAddTo80(5)); // Computes 5+80, stores 85
        System.out.println(memoizedAddTo80(5)); // Returns 85 from cache, no recompute
    }
}
