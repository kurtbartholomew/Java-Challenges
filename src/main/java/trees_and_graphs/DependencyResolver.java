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

    public static List<GraphNode> resolveDependencyChain(List<GraphNode> dependencies) {
        Set<GraphNode> visited = new HashSet<>();
        Set<GraphNode> completed = new HashSet<>();
        LinkedList<GraphNode> buildOrder = new LinkedList<>();
        for(GraphNode current : dependencies) {
            if(!visited.contains(current) && !completed.contains(current)) {
                if(!dfsHelper(current, visited, completed, buildOrder)) {
                    return null;
                }
            }
        }
        return buildOrder;
    }

    public static boolean dfsHelper(GraphNode node, Set<GraphNode> visited, Set<GraphNode> completed, LinkedList<GraphNode> buildOrder) {
        if(visited.contains(node)) {
            return false;
        }
        if(!visited.contains(node) && !completed.contains(node)) {
            visited.add(node);
            for(GraphNode child : node.edges) {
                if(!dfsHelper(child, visited, completed, buildOrder)) {
                    return false;
                }
            }
            buildOrder.add(node);
            visited.remove(node);
            completed.add(node);
        }
        return true;
    }
}
