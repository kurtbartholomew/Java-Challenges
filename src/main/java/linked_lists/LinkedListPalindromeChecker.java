package linked_lists;

public class LinkedListPalindromeChecker {
    public static class Node {
        public Integer data;
        public Node next;

        public Node(Integer data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    public static boolean isPalindrome(Node head) {
        if(head == null) { return false; }
        StringBuilder strb = new StringBuilder();
        while(head != null) {
            strb.append(head.data);
            head = head.next;
        }
        String str = strb.toString();
        int len = str.length();
        int mid = len / 2;
        for(int i = 0, k = len - 1; i < mid; i++, k--) {
            if(str.charAt(i) != str.charAt(k)){ return false; }
        }
        return true;
    }
    public static boolean constantSpaceIsPalindrome(Node head) {
        if(head == null) { return false; }
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast != null) { slow = slow.next; }
        Node start = head;
        Node newEnd = reverseSecondHalfOfList(slow);
        while(start != null && newEnd != null) {
            if(!start.data.equals(newEnd.data)) {
                return false;
            }
            start = start.next;
            newEnd = newEnd.next;
        }
        return true;
    }

    public static Node reverseSecondHalfOfList(Node mid) {
        Node current = mid;
        Node prev = null;
        while(current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    // 9 -> 5 -> 7 -> 5 -> 9 ->
    // 9 -> 8 -> 8 -> 9 ->
}
