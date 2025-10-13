package data_structures.arrays;

// Sample interview problem - create a function that reverses a string:
// 'Hi, my name is Shona' should be:
// 'anohS si eman ym, iH'
public class ReverseString {

    public static String reverseString(String stringToReverse) {
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

    public static String reverseStringRecursive(String stringToReverse) {
        // Base case
        if (stringToReverse == null || stringToReverse.length() <= 1) {
            return stringToReverse;
        }
        // Recursive case
        return reverseString(stringToReverse.substring(1)) + stringToReverse.charAt(0);
    }

    public static void main(String[] args) {
        System.out.println(reverseString("'Hi, my name is Shona'"));
        System.out.println(reverseStringRecursive("'Hi, my name is Shona'"));
    }
}
