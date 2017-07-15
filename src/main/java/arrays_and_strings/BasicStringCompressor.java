package arrays_and_strings;

public class BasicStringCompressor {
    public static String compressString(String str) {
        StringBuilder strB = new StringBuilder();
        Character previous = null;
        int counter = 0;
        for(int i = 0; i <= str.length(); i++) {
            if(strB.length() >= str.length()) { return str; }
            if(previous != null && (i == str.length() || previous != str.charAt(i))) {
                strB.append(previous);
                strB.append(counter);
                counter = 0;
            }
            ++counter;
            previous = i == str.length() ? null : str.charAt(i);
        }
        return strB.length() >= str.length() ? str : strB.toString();
    }
}
