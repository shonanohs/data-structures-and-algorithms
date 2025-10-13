package data_structures.arrays;

// Create a function that reverses a string:
// 'Hi, my name is Shona' should be:
// 'anohS si eman ym, iH'
public class ReverseString {

    // Time complexity: O(n)
    // Space complexity: O(n)
    public static String reverseString(String stringToReverse) {
        // Check input
        if (stringToReverse.isBlank() || stringToReverse.length() < 2) {
            return stringToReverse;
        }

        // Convert input string to array of characters
        char[] stringAsArray = new char[stringToReverse.length()];
        for (int i = 0; i < stringToReverse.length(); i++) {
            stringAsArray[i] = stringToReverse.charAt(i);
        }

        // Reverse order of each character in array by swapping value at current index
        // with corresponding value
        for(int j = 0; j < stringAsArray.length / 2; j++) {
            char temp = stringAsArray[j];
            stringAsArray[j] = stringAsArray[stringAsArray.length - 1 - j];
            stringAsArray[stringAsArray.length - 1 - j] = temp;
        }

        // Convert back to string & return
        StringBuilder reversedString = new StringBuilder();
        for (Character character : stringAsArray) {
            reversedString.append(character);
        }
        return String.valueOf(reversedString);
    }

    // Time complexity: O(n²)
    // Space complexity: O(n)
    public static String reverseStringRecursive(String stringToReverse) {
        // Base case
        if (stringToReverse == null || stringToReverse.length() <= 1) {
            return stringToReverse;
        }
        // Recursive case
        return reverseString(stringToReverse.substring(1)) + stringToReverse.charAt(0);
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    public static String reverseStringSimple(String stringToReverse) {
        // 'Real world' implementation
        return new StringBuilder(stringToReverse).reverse().toString();
    }

    public static void main(String[] args) {
        final String STRING_TO_REVERSE = "'Hi, my name is Shona'";

        System.out.println(reverseString(STRING_TO_REVERSE));
        System.out.println(reverseStringRecursive(STRING_TO_REVERSE));
        System.out.println(reverseStringSimple(STRING_TO_REVERSE));
    }
}
