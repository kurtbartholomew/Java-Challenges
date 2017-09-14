package trees_and_graphs;

public class SuccessorFinder {

    public static class Node {

        public int data;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node findSuccessor(Node target) {
        if(target == null) { return null; }
        Node current = null;
        if(target.right != null) {
            current = target.right;
            while(current.left != null) {
                current = current.left;
            }
        } else {
            current = target;
            Node parent = current.parent;
            while(parent != null && current != parent.left) {
                current = parent;
                parent = parent.parent;
            }
            current = parent;
        }
        return current;
    }
}
