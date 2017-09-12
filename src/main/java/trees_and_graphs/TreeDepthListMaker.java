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

        public ListNode() {
            this.data = data;
            this.next = null;
        }
    }

    public static List<ListNode> buildLists(TreeNode head) {
        return new ArrayList<ListNode>();
    }
}
