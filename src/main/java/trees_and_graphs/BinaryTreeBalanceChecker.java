package trees_and_graphs;

public class BinaryTreeBalanceChecker {

    public static class Node {

        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static boolean checkBalance(Node head) {
        return checkBalanceHelper(head) != -1;
    }

    public static int checkBalanceHelper(Node head) {
        if(head == null) { return 0; }
        int left = checkBalanceHelper(head.left);
        int right = checkBalanceHelper(head.right);
        if(left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        } else {
            return Math.max(left + 1, right + 1);
        }
    }
}
