package trees_and_graphs;

import java.util.*;

public class TreeDepthListMaker {

    public static class TreeNode {

        public int data;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static class ListNode {

        public int data;
        public ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static List<ListNode> buildLists(TreeNode head) {
        List<ListNode> depthLists = new ArrayList<>();
        buildListsHelper(head, depthLists);
        return depthLists;
    }

    public static void buildListsHelper(TreeNode head, List<ListNode> depthLists) {
        Deque<TreeNode> parents = new LinkedList<>();
        Deque<TreeNode> children = new LinkedList<>();
        ListNode sentinel = new ListNode(0);
        ListNode currList = sentinel;
        TreeNode current = head;
        parents.offer(head);
        while(parents.size() > 0) {
            TreeNode parent = parents.poll();
            currList.next = new ListNode(parent.data);
            currList = currList.next;

            if(parent.left != null) { children.add(parent.left); }
            if(parent.right != null) { children.add(parent.right); }

            if(parents.size() == 0) {
                parents = children;
                children = new LinkedList<>();
                depthLists.add(sentinel.next);
                sentinel = new ListNode(0);
                currList = sentinel;
            }
        }
    }
}
