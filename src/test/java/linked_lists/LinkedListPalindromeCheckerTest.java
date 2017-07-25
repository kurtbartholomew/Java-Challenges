package linked_lists;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListPalindromeCheckerTest {


    private LinkedListPalindromeChecker.Node palindromeList;
    private LinkedListPalindromeChecker.Node nonPalindromeList;

    @Before
    public void setUp() {
        palindromeList = new LinkedListPalindromeChecker.Node(7,null);
        LinkedListPalindromeChecker.Node second = new LinkedListPalindromeChecker.Node(5,null);
        LinkedListPalindromeChecker.Node third = new LinkedListPalindromeChecker.Node(3,null);
        LinkedListPalindromeChecker.Node fourth = new LinkedListPalindromeChecker.Node(5,null);
        LinkedListPalindromeChecker.Node fifth = new LinkedListPalindromeChecker.Node(7,null);

        palindromeList.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        nonPalindromeList = new LinkedListPalindromeChecker.Node(3,null);
        LinkedListPalindromeChecker.Node seventh = new LinkedListPalindromeChecker.Node(4,null);
        LinkedListPalindromeChecker.Node eighth = new LinkedListPalindromeChecker.Node(5,null);
        LinkedListPalindromeChecker.Node ninth = new LinkedListPalindromeChecker.Node(6,null);

        nonPalindromeList.next = seventh;
        seventh.next = eighth;
        eighth.next = ninth;
    }


    @Test
    public void shouldReturnTrueIfLinkedListIsAPalindrome() {
       assertTrue(LinkedListPalindromeChecker.isPalindrome(palindromeList));
    }

    @Test
    public void shouldReturnTrueIfLinkedListIsAPalindromeInConstantSpace() {
        assertTrue(LinkedListPalindromeChecker.constantSpaceIsPalindrome(palindromeList));
    }

    @Test
    public void shouldReturnFalseIfLinkedListIsNotAPalindrome() {
        assertFalse(LinkedListPalindromeChecker.isPalindrome(nonPalindromeList));
    }

    @Test
    public void shouldReturnFalseIfLinkedListIsNotAPalindromeInConstantSpace() {
        assertFalse(LinkedListPalindromeChecker.constantSpaceIsPalindrome(nonPalindromeList));
    }

}