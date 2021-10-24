package recursion.practice;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubsequence {

    private static boolean checkSubsequenceInDestString(String initial, String dest, String curResult) {
        int prevInd = -1;
        for (int i = 0; i < initial.length(); i++) {
            if (dest.indexOf("" + initial.charAt(i)) > prevInd) {
                prevInd = dest.indexOf("" + initial.charAt(i));
            } else {
                return false;
            }
        }
        return initial.length() > curResult.length();
    }

    private static void getAllSubsequences(String input, String curSubsequence, int index, List<String> result,
            String dest) {
        for (int i = index + 1; i < input.length(); i++) {
            getAllSubsequences(input, curSubsequence + input.charAt(i), i, result, dest);
            if (checkSubsequenceInDestString(curSubsequence + input.charAt(i), dest, result.get(0))) {
                result.set(0, curSubsequence + input.charAt(i));
            }
        }
    }

    public static void main(String[] args) {
        String input = "abc";
        String dest = "def";
        List<String> result = new ArrayList<>();
        result.add("");
        getAllSubsequences(input, "", -1, result, dest);
        System.out.println(result);
    }

}
