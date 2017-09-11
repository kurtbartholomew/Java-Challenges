package trees_and_graphs;

import java.util.*;

public class RouteFinder {

    public static class Node {

        private List<Node> outgoingEdges;
        private int data;

        public Node(int data) {
            outgoingEdges = new ArrayList<>();
            this.data = data;
        }

        public void addEdge(Node node) {
            outgoingEdges.add(node);
        }
    }

    public boolean containsRoute(Node head, Node target) {


        Set<Node> visited = new HashSet<>();


        return bfs(head, target, visited);
    }

    public boolean bfs(Node node, Node target, Set visited) {

        Deque<Node> queue = new LinkedList<>();

        queue.offer(node);
        while(!queue.isEmpty()) {
            Node current = queue.poll();

            // visit
            if(current == target) {
                return true;
            }

            for(Node edge : current.outgoingEdges) {
                if(!visited.contains(edge)) {
                    queue.offer(edge);
                }
            }
        }

        return false;
    }
}
