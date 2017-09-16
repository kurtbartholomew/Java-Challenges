package trees_and_graphs;

import java.util.*;

public class DependencyResolver {

    public static class GraphNode {

        public int data;
        public List<GraphNode> edges;

        public GraphNode(int data) {
            this.data = data;
            this.edges = new ArrayList<>();
        }

        public void addEdge(GraphNode node) {
            edges.add(node);
        }
    }

    public static List<GraphNode> resolveDependencyChain(GraphNode node) {
        return new LinkedList<GraphNode>();
    }
}
