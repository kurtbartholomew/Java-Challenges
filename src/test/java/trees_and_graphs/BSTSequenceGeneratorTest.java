package trees_and_graphs;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class BSTSequenceGeneratorTest {

    private BSTSequenceGenerator.TreeNode root;
    private ArrayList<int[]> permutations;

    @Before
    public void setUp() {
        root = new BSTSequenceGenerator.TreeNode(10);

        BSTSequenceGenerator.TreeNode nodeOne = new BSTSequenceGenerator.TreeNode(1);
        BSTSequenceGenerator.TreeNode nodeTwo = new BSTSequenceGenerator.TreeNode(5);
        BSTSequenceGenerator.TreeNode nodeThree = new BSTSequenceGenerator.TreeNode(4);
        BSTSequenceGenerator.TreeNode nodeFour = new BSTSequenceGenerator.TreeNode(19);
        BSTSequenceGenerator.TreeNode nodeFive = new BSTSequenceGenerator.TreeNode(15);
        BSTSequenceGenerator.TreeNode nodeSix = new BSTSequenceGenerator.TreeNode(25);

        root.left = nodeThree;
        root.right = nodeFour;
//        nodeThree.left = nodeOne;
//        nodeThree.right = nodeTwo;
//        nodeFour.left = nodeFive;
//        nodeFour.right = nodeSix;

        permutations = new ArrayList<>();
        permutations.add(new int[]{10,4,19});
        permutations.add(new int[]{10,19,4});
    }

    @Test
    public void shouldReturnCorrectNumberOfArrays() {
        assertEquals(2, BSTSequenceGenerator.generateSequences(root).size());
    }

    @Test
    public void shouldReturnCorrectPermutationsOfInput() {
        ArrayList<LinkedList<Integer>> sequences = BSTSequenceGenerator.generateSequences(root);
        int counter = 0;
        for(LinkedList<Integer> seq : sequences) {
            int[] intSeq = convertToIntArr(seq);
            assertArrayEquals(permutations.get(counter++), intSeq);
        }
    }

    private static int[] convertToIntArr(LinkedList<Integer> seq) {
        int[] arr = new int[seq.size()];
        int count = 0;
        for(Integer num: seq) {
            arr[count++] = num;
        }
        return arr;
    }
}