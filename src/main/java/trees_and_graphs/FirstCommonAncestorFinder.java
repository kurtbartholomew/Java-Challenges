package trees_and_graphs;

public class FirstCommonAncestorFinder {

    public static class TreeNode {

        public int data;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static TreeNode firstCommonAncestor(TreeNode root, TreeNode first, TreeNode second) {
        return fcsHelper(root, first, second);
    }

    public static TreeNode fcsHelper(TreeNode current, TreeNode first, TreeNode second) {
        if(current == null) { return null; }
        if(current == first || current == second) { return current; }
        TreeNode left = fcsHelper(current.left, first, second);
        TreeNode right = fcsHelper(current.right, first, second);
        if(left != null && right != null) { return current; }
        if(left != null) { return left; }
        if(right != null) { return right; }
        return null;
    }
}
