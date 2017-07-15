package arrays_and_strings;

import java.util.Map;

public final class PermutationChecker {
    public static boolean isFirstPermutationOfSecond(String first, String second) {
        if(first.length() != second.length()) { return false; }
        first = first.toLowerCase();
        second = second.toLowerCase();
        int[] firstCounterArr = createFreqArray(first);
        int[] secondCounterArr = createFreqArray(second);
        for(int i = 0; i < firstCounterArr.length; i++) {
            int count = secondCounterArr[i];
            if(count > 0) { firstCounterArr[i] -= count; }
            if(firstCounterArr[i] < 0 || firstCounterArr[i] > 0) { return false; }
        }
        return true;
    }
    private static int[] createFreqArray(String str) {
        int[] counterArr = new int[26];
        for(int i = 0; i < str.length(); i++) {
            ++counterArr[str.charAt(i) - 'a'];
        }
        return counterArr;
    }
}
