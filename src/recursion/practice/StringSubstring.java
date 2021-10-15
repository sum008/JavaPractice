package recursion.practice;

public class StringSubstring {

    private static void getAllStringSubstrings(String input, String cString) {
        if (input.length() == 0) {
            return;
        }

        for (int i = 0; i < input.length(); i++) {
            getAllStringSubstrings(input.substring(i + 1), cString + input.charAt(i));
            System.out.print(cString + input.charAt(i) + " ");
        }
    }

    public static void main(String[] a) {
        String input = "abc";
        getAllStringSubstrings(input, "");
    }
}
