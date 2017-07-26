package linked_lists;

public class IntersectionFinder {
    public static class Node {

        public Integer data;
        public Node next;

        public Node(Integer data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    public static Node findIntersectingNode(Node first, Node second) {
        if(first == null || second == null) { throw new IllegalArgumentException("Both nodes cannot be null"); }
        Node a = first;
        Node b = second;
        while(a != b) {
            a = (a == null) ? second : a.next;
            b = (b == null) ? first : b.next;
        }
        return a;
    }
}
