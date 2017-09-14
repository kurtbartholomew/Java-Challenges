package trees_and_graphs;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BSTValidatorTest {

    private BSTValidator.Node validBST;
    private BSTValidator.Node invalidBST;

    @Before
    public void setUp() {
        validBST = new BSTValidator.Node(7);
        BSTValidator.Node two = new BSTValidator.Node(2);
        BSTValidator.Node three = new BSTValidator.Node(3);
        BSTValidator.Node five = new BSTValidator.Node(5);
        BSTValidator.Node ten = new BSTValidator.Node(10);
        BSTValidator.Node fourteen = new BSTValidator.Node(14);
        BSTValidator.Node seventeen = new BSTValidator.Node(17);

        validBST.left = three;
        validBST.right = fourteen;
        three.left = two;
        three.right = five;
        fourteen.left = ten;
        fourteen.right = seventeen;

        invalidBST = new BSTValidator.Node(10);
        BSTValidator.Node six = new BSTValidator.Node(6);
        BSTValidator.Node eight = new BSTValidator.Node(8);
        BSTValidator.Node nine = new BSTValidator.Node(9);
        BSTValidator.Node eleven = new BSTValidator.Node(11);
        BSTValidator.Node twelve = new BSTValidator.Node(12);
        BSTValidator.Node thirteen = new BSTValidator.Node(13);

        invalidBST.left = six;
        invalidBST.right = eleven;
        six.left = twelve;
        six.right = thirteen;
        eleven.left = eight;
    }

    @Test
    public void shouldReturnTrueForValidBST() {
        assertTrue(BSTValidator.validateBST(validBST));
    }

    @Test
    public void shouldReturnFalseForInvalidBST() {
        assertFalse(BSTValidator.validateBST(invalidBST));
    }
}