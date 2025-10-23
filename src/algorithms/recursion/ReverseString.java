package algorithms.recursion;

public class ReverseString {
    public static String reverseString(String string) {
        if (string.length() <= 1) {
            return string;
        }
        return reverseString(string.substring(1, string.length())) + string.substring(0, 1);
    }
    public static void main(String[] args) {
        System.out.println(reverseString("hello")); // olleh
        System.out.println(reverseString("world")); // dlrow
    }
}
