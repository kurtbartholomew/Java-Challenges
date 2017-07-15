package arrays_and_strings;

public class Urlifier {
    public static String toURL(String string, int trueSize) {
        char[] newURL = new char[trueSize];
        for(int i = string.length()-1; i >= 0; i--) {
            newURL[i] = string.charAt(i) == ' ' ? '%' : string.charAt(i);
        }
        return new String(newURL);
    }
}
