package arrays_and_strings;

public class StringRotationChecker {
    public static boolean isRotatedString(String original, String rotated) {
        if(original.length() != rotated.length()) { return false; }
        return isSubstring((rotated + rotated),original);
    }
    private static boolean isSubstring(String main, String sub) {
        return main.contains(sub);
    }
}
