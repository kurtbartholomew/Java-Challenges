package linked_lists;

public class LinkedListPartitioner {

    public static class Node {

        public Integer data;
        public Node next;

        public Node(Integer data, Node next) {
            this.data = data;
            this.next = next;
        }

    }

    public static Node partitionListAroundValue(Node node, int partition) {
        if(node == null) { return null; }
        Node tail = node;
        Node head = node;
        while(node != null) {
            Node next = node.next;
            if(node.data < partition) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;
        return head;
    }

//    (5)->(10)->(3)->(6)->(9)->(7)->
//    Partition = 7

}
