package trees_and_graphs;

import java.util.*;

public class MinimalBSTBuilder {


    public static class Node {

        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
        }

    }

    public static Node buildBST(int[] sortedArray) {
        return buildBSTHelper(sortedArray, 0, sortedArray.length - 1);
    }

    public static Node buildBSTHelper(int [] sortedArray, int start, int end) {
        if(start > end) { return null; }
        int mid = (start + end) / 2;
        Node midNode = new Node(sortedArray[mid]);
        midNode.left = buildBSTHelper(sortedArray, start, mid - 1);
        midNode.right = buildBSTHelper(sortedArray, mid + 1, end);
        return midNode;
    }
}
