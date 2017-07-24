package linked_lists;

public class ListSummer {
    public static class Node {
        public Integer data;
        public Node next;

        public Node(Integer data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    public static int sumListInReverse(Node first, Node second) {
        return buildIntegerReverse(first) + buildIntegerReverse(second);
    }

    public static int buildIntegerReverse(Node current) {
        if(current.next == null) {
            return current.data;
        }
        return buildIntegerReverse(current.next) * 10 + current.data;
    }

    public static int sumList(Node first, Node second) {
        return buildInteger(first) + buildInteger(second);
    }

    public static int buildInteger(Node current) {
        int total = current.data;
        while(current.next != null) {
            current = current.next;
            total = (total * 10) + current.data;
        }
        return total;
    }
}
