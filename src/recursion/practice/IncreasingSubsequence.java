package recursion.practice;

import java.util.ArrayList;
import java.util.List;

public class IncreasingSubsequence {

    // private static void findIncreasingSubsequence(int[] input, int prevVal, int
    // prevIndex, List<Integer> result) {
    // for (int i = prevIndex + 1; i < input.length; i++) {
    // if (input[i] > prevVal) {
    // result.add(input[i]);
    // findIncreasingSubsequence(input, input[i], i, result);
    // }
    // }
    // System.out.println(result);
    // result.clear();
    // }

    private static void findIncreasingSubsequenceV2(int[] input, int prevIndex, List<Integer> result) {
        if (prevIndex + 1 >= input.length)
            return;

        List<Integer> localList = new ArrayList<>();
        int currentVal = input[prevIndex + 1];
        localList.add(input[prevIndex + 1]);
        for (int i = prevIndex + 2; i < input.length; i++) {
            if (input[i] > currentVal) {
                localList.add(input[i]);
                currentVal = input[i];
            }
        }
        System.out.println(localList);
        if (localList.size() >= result.size()) {
            result.clear();
            result.addAll(localList);
            localList.clear();
        }
        findIncreasingSubsequenceV2(input, prevIndex + 1, result);
    }

    public static void main(String[] args) {
        int[] input = { 60, 100, 10, 22, 9, 33, 21, 50 };
        List<Integer> result = new ArrayList<>();
        // findIncreasingSubsequence(input, -1, -1, result);
        double currentTimeMillis = System.currentTimeMillis();
        findIncreasingSubsequenceV2(input, -1, result);
        System.out.println(System.currentTimeMillis() - currentTimeMillis);
        // System.out.println(result);
    }
}
