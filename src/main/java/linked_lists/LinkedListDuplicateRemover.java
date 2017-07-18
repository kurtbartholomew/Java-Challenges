package linked_lists;

import java.util.HashMap;
import java.util.Map;

public class LinkedListDuplicateRemover {
    public static class Node {
        public Integer data;
        public Node next;

        public Node(Integer data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    public static Node removeDuplicates(Node head) {
        Map<Integer,Node> nodeMap = new HashMap<>();
        Node sentinel = new Node(null, null);
        sentinel.next = head;
        Node current = sentinel.next;
        nodeMap.put(current.data, current);
        Node previous = sentinel;
        while(current != null) {
            current = current.next;
            previous = previous.next;
            if(current != null && nodeMap.containsKey(current.data)) {
                previous.next = current.next;
            }
            if(current != null) { nodeMap.put(current.data,current); }
        }
        return sentinel.next;
    }
}
