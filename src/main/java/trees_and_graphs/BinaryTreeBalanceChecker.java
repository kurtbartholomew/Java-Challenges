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
        return 0;
    }
}
