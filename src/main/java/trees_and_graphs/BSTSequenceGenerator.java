package trees_and_graphs;

import java.util.*;

public class BSTSequenceGenerator {

    public static class TreeNode {

        public int data;
        public TreeNode left;
        public TreeNode right;


        public TreeNode(int data) {
            this.data = data;
        }
    }


    public static ArrayList<LinkedList<Integer>> generateSequences(TreeNode root) {
        if(root == null) { return null; }
        return generateHelper(root);
    }

    private static ArrayList<LinkedList<Integer>> generateHelper(TreeNode root) {
        ArrayList<LinkedList<Integer>> result = new ArrayList<>();
        if(root == null) {
            result.add(new LinkedList<>());
            return result;
        }

        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(root.data);

        ArrayList<LinkedList<Integer>> left = generateHelper(root.left);
        ArrayList<LinkedList<Integer>> right = generateHelper(root.right);

        for(LinkedList leftSeq : left) {
            for(LinkedList rightSeq : right) {
                ArrayList<LinkedList<Integer>> mixedSeqs = new ArrayList<>();
                mixSequences(leftSeq, rightSeq, prefix, mixedSeqs);
                result.addAll(mixedSeqs);
            }
        }
        return result;
    }

    private static void mixSequences(LinkedList<Integer> left, LinkedList<Integer> right, LinkedList<Integer> prefix, ArrayList<LinkedList<Integer>> mixedSeqs) {
        if(left.size() == 0 || right.size() == 0) {
            LinkedList<Integer> easyMix = new LinkedList<>(prefix);
            easyMix.addAll(left);
            easyMix.addAll(right);
            mixedSeqs.add(easyMix);
        } else {
            prefix.addLast(left.removeFirst());
            mixSequences(left, right, prefix, mixedSeqs);
            left.addFirst(prefix.removeLast());

            prefix.addLast(right.removeFirst());
            mixSequences(left, right, prefix, mixedSeqs);
            right.addFirst(prefix.removeLast());
        }
    }
}
