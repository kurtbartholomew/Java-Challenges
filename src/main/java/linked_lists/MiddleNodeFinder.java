package linked_lists;

public class MiddleNodeFinder {
    public static class Node {

        public Integer data;
        public Node next;

        public Node(Integer data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    public static Node findMiddleNode(Node head) {
        if(head == null) { return null; }
        Node sentinel = new Node(null,null);
        sentinel.next = head;
        Node slow = sentinel.next;
        Node fast = sentinel.next;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
