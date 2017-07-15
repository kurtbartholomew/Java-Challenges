package arrays_and_strings;

public class OneEditAway {
    public static boolean isOneEditAway(String first, String second) {
        if(Math.abs(first.length() - second.length()) > 1) { return false; }

        String longer = first.length() >= second.length() ? first : second;
        String shorter = first.length() >= second.length() ? second : first;

        int longIdx = 0;
        int shortIdx = 0;
        int diffCounter = 0;

        while(longIdx > longer.length() && shortIdx > shorter.length()) {
            if(longer.charAt(longIdx) != shorter.charAt(shortIdx)) {
                ++diffCounter;
                if(diffCounter > 1) { return false; }
                ++longIdx;
            } else {
                ++longIdx;
                ++shortIdx;
            }
        }
        return true;
    }
}
