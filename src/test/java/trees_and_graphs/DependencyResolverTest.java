package trees_and_graphs;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class DependencyResolverTest {

    private int[] resolvedDependencies;
    private DependencyResolver.GraphNode entrant;

    @Before
    public void setUp() {
        DependencyResolver.GraphNode nodeOne = new DependencyResolver.GraphNode(1);
        DependencyResolver.GraphNode nodeTwo = new DependencyResolver.GraphNode(2);
        DependencyResolver.GraphNode nodeThree = new DependencyResolver.GraphNode(3);
        DependencyResolver.GraphNode nodeFour = new DependencyResolver.GraphNode(4);
        DependencyResolver.GraphNode nodeFive = new DependencyResolver.GraphNode(5);
        DependencyResolver.GraphNode nodeSix = new DependencyResolver.GraphNode(6);

        nodeFour.addEdge(nodeOne);
        nodeTwo.addEdge(nodeSix);
        nodeFour.addEdge(nodeTwo);
        nodeOne.addEdge(nodeSix);
        nodeThree.addEdge(nodeFour);

        entrant = nodeOne;

        resolvedDependencies = new int[]{1, 2, 3, 4, 5, 6};
    }

    @Test
    public void shouldResolveDependenciesInCorrectOrder() {
        List<DependencyResolver.GraphNode> dependencyChain = DependencyResolver.resolveDependencyChain(entrant);
        int[] answer = new int[dependencyChain.size()];
        int counter = 0;
        for(DependencyResolver.GraphNode node: dependencyChain) {
            answer[counter++] = node.data;
        }
        assertEquals(resolvedDependencies, answer);
    }
}