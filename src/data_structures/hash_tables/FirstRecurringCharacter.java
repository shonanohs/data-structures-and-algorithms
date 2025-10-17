package data_structures.hash_tables;

import java.util.HashSet;

// Given an array, return the first recurring character
// e.g. [2,5,1,2,3,5,1,2,4] should return 2
// An array of entirely unique characters (e.g. [2,3,4,5]) should return null
public class FirstRecurringCharacter {

    // Time complexity: O(n)
    // Space complexity: O(n)
    public static Integer findFirstRecurringCharacter(Integer[] array) {
        // Check input
        if (array == null || array.length == 0) {
            return null;
        }

        HashSet<Integer> seenNumbers = new HashSet<>();

        for (Integer integer : array) {
            if (seenNumbers.contains(integer)) {
                return integer;
            }
            seenNumbers.add(integer);
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println(findFirstRecurringCharacter(new Integer[]{2,5,1,2,3,5,1,2,4})); // 2
        System.out.println(findFirstRecurringCharacter(new Integer[]{2,1,1,2,3,5,1,2,4})); // 1
        System.out.println(findFirstRecurringCharacter(new Integer[]{2,3,4,5})); // null
    }
}
