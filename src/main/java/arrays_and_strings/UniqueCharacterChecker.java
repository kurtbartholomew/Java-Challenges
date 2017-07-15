package arrays_and_strings;

public class UniqueCharacterChecker {
    public static boolean isUnique(String stringToCheck) {
        int bitVector = 0;
        for(int i = 0; i < stringToCheck.length(); i++) {
            char c = stringToCheck.charAt(i);
            int charCode = c - 'a';
            if((bitVector & (1 << charCode)) > 0) {
                return false;
            }
            bitVector |= (1 << charCode);
        }
        return true;
    }
}
