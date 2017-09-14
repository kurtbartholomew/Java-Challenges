package trees_and_graphs;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeBalanceCheckerTest {

    private BinaryTreeBalanceChecker.Node balanced;
    private BinaryTreeBalanceChecker.Node unbalanced;

    @Before
    public void setUp() {
        balanced = new BinaryTreeBalanceChecker.Node(0);
        BinaryTreeBalanceChecker.Node two = new BinaryTreeBalanceChecker.Node(2);
        BinaryTreeBalanceChecker.Node three = new BinaryTreeBalanceChecker.Node(3);
        BinaryTreeBalanceChecker.Node four = new BinaryTreeBalanceChecker.Node(4);
        BinaryTreeBalanceChecker.Node five = new BinaryTreeBalanceChecker.Node(5);
        BinaryTreeBalanceChecker.Node six = new BinaryTreeBalanceChecker.Node(6);
        BinaryTreeBalanceChecker.Node seven = new BinaryTreeBalanceChecker.Node(7);

        balanced.left = two;
        balanced.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;

        unbalanced = new BinaryTreeBalanceChecker.Node(0);
        BinaryTreeBalanceChecker.Node eight = new BinaryTreeBalanceChecker.Node(8);
        BinaryTreeBalanceChecker.Node nine = new BinaryTreeBalanceChecker.Node(9);
        BinaryTreeBalanceChecker.Node ten = new BinaryTreeBalanceChecker.Node(10);
        BinaryTreeBalanceChecker.Node eleven = new BinaryTreeBalanceChecker.Node(11);
        BinaryTreeBalanceChecker.Node twelve = new BinaryTreeBalanceChecker.Node(12);
        BinaryTreeBalanceChecker.Node thirteen = new BinaryTreeBalanceChecker.Node(13);

        unbalanced.left = eight;
        unbalanced.right = nine;
        eight.left = ten;
        ten.right = eleven;
        ten.left = twelve;
        eleven.right = thirteen;
    }

    @Test
    public void shouldReturnTrueForBalancedTrees() {
        assertTrue(BinaryTreeBalanceChecker.checkBalance(balanced));
    }

    @Test
    public void shouldReturnFalseForUnbalancedTrees() {
        assertFalse(BinaryTreeBalanceChecker.checkBalance(balanced));
    }
}