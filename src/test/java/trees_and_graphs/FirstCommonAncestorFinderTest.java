package trees_and_graphs;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FirstCommonAncestorFinderTest {

    private FirstCommonAncestorFinder.TreeNode root;
    private FirstCommonAncestorFinder.TreeNode left;
    private FirstCommonAncestorFinder.TreeNode altLeft;
    private FirstCommonAncestorFinder.TreeNode right;
    private FirstCommonAncestorFinder.TreeNode parent;


    @Before
    public void setUp() {

        root = new FirstCommonAncestorFinder.TreeNode(1);
        FirstCommonAncestorFinder.TreeNode second = new FirstCommonAncestorFinder.TreeNode(2);
        FirstCommonAncestorFinder.TreeNode third = new FirstCommonAncestorFinder.TreeNode(3);
        FirstCommonAncestorFinder.TreeNode fourth = new FirstCommonAncestorFinder.TreeNode(4);
        FirstCommonAncestorFinder.TreeNode fifth = new FirstCommonAncestorFinder.TreeNode(5);
        FirstCommonAncestorFinder.TreeNode sixth = new FirstCommonAncestorFinder.TreeNode(6);
        FirstCommonAncestorFinder.TreeNode seventh = new FirstCommonAncestorFinder.TreeNode(7);

        root.right = second;
        second.left = third;
        second.right = fourth;
        third.left = fifth;
        fourth.left = sixth;
        fourth.right = seventh;

        left = fifth;
        right = seventh;

        parent = second;
    }

    @Test
    public void shouldReturnParentIfCommonParentExists() {
        assertEquals(parent, FirstCommonAncestorFinder.firstCommonAncestor(root,left,right));
    }

    @Test
    public void shouldReturnOneOfPassedNodesIfNoCommonParentExists() {
        assertEquals(root, FirstCommonAncestorFinder.firstCommonAncestor(root,root,right));
    }

}