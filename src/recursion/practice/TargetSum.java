package recursion.practice;

import java.util.ArrayList;
import java.util.List;

public class TargetSum {
    private static void getAllValues(int[] input, int index, int currentTarget, String curResult, List<String> result) {
        if (currentTarget < 0) {
            return;
        }

        while (index < input.length) {
            String currentResult = curResult.length() == 0 ? "" + input[index]
                    : String.join("+", curResult, "" + input[index]);
            int remainingTarget = currentTarget - input[index];
            getAllValues(input, index + 1, remainingTarget, currentResult, result);
            if (remainingTarget == 0) {
                result.add(currentResult);
            }
            index += 1;
        }
    }

    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        int[] input = { 40, 10, 20, 30, 30, 70 };
        getAllValues(input, 0, 70, "", result);
        System.out.println(result);
    }
}
