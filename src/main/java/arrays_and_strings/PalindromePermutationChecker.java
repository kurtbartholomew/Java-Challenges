package arrays_and_strings;

public class PalindromePermutationChecker {
    public static boolean checkIfPalindrome(String first) {
        first = first.toLowerCase();
        int palindromeCounter = 0;
        for(int i = 0; i < first.length(); i++) {
            char c = first.charAt(i);
            if(c != ' ') {
                palindromeCounter ^= (1 << (first.charAt(i) - 'a'));
            }
        }
        return (palindromeCounter & (palindromeCounter - 1)) == 0;
    }
}
