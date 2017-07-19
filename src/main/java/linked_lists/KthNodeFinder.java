package linked_lists;

public class KthNodeFinder {
    public static class Node {
        public Integer data;
        public Node next;

        public Node(Integer data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    public static Node findKthLastNode(Node head, int k){
        Node sentinel = new Node(null,null);
        sentinel.next = head;
        Node slow = sentinel.next;
        Node fast = slow;
        while(k >= 0 && fast != null) {
            fast = fast.next;
            --k;
        }
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return (k > 0) ? null : slow;
    }
}
