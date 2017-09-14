package trees_and_graphs;

public class BSTValidator {

    public static class Node {

        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static boolean validateBST(Node head) {
        return validateBSTHelper(head, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean validateBSTHelper(Node head, int min, int max) {
        if(head == null) { return true; }
        if(head.data <= min || head.data >= max) { return false; }
        return validateBSTHelper(head.left, min, head.data)
                && validateBSTHelper(head.right, head.data, max);
    }
}
