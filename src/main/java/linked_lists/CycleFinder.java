package linked_lists;

public class CycleFinder {
    public static class Node {

        public Integer data;
        public Node next;

        public Node(Integer data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    public static Node findCycle(Node head) {
        if(head == null) { throw new IllegalArgumentException("Argument head cannot be null"); }
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow.data.equals(fast.data)) {
                while(!slow.data.equals(head.data)) {
                    head = head.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
