package recursion.practice;

import java.util.HashMap;
import java.util.Map;

public class StringEncoding {

    private static final Map<String, String> charMap = new HashMap<>() {
        {
            put("1", "a");
            put("2", "b");
            put("3", "c");
            put("4", "d");
            put("5", "e");
            put("6", "f");
            put("7", "g");
            put("8", "h");
            put("9", "i");
            put("10", "j");
            put("11", "k");
            put("12", "l");
            put("13", "m");
            put("14", "n");
            put("15", "o");
            put("16", "p");
            put("17", "q");
            put("18", "r");
            put("19", "s");
            put("20", "t");
            put("21", "u");
            put("22", "v");
            put("23", "w");
            put("24", "x");
            put("25", "y");
            put("26", "z");
        }
    };

    private static void getAllPossibleStringEncodings(String validEncodings, String remainingString) {

        for (int i = 0; i < remainingString.length(); i++) {
            String preStr = remainingString.substring(0, i + 1);
            String postStr = remainingString.substring(i + 1);
            if (charMap.get(preStr) == null) {
                return;
            }
            if (charMap.get(postStr) != null) {
                String localValidEncoding = validEncodings;
                localValidEncoding += charMap.get(preStr) + charMap.get(postStr);
                System.out.println(localValidEncoding);
            }
            getAllPossibleStringEncodings(validEncodings + charMap.get(preStr), postStr);
        }
    }

    public static void main(String[] args) {
        getAllPossibleStringEncodings("", "123");
        // ip -> 123
        // op -> aw(1,23), lc(12,3), abc(1,2,3)

        // ip -> 12
        // op should be -> ab(1,2), l(12)
        // but current op(bug) -> ab(1,2)
    }
}
