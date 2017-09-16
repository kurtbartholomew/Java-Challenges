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
    private List<DependencyResolver.GraphNode> dependencies;
    private List<DependencyResolver.GraphNode> cyclicalDependencies;

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

        dependencies = new ArrayList<>();
        dependencies.add(nodeOne);
        dependencies.add(nodeTwo);
        dependencies.add(nodeThree);
        dependencies.add(nodeFour);
        dependencies.add(nodeFive);
        dependencies.add(nodeSix);

        resolvedDependencies = new int[]{6,1,2,4,3,5};

        DependencyResolver.GraphNode nodeSeven = new DependencyResolver.GraphNode(7);
        DependencyResolver.GraphNode nodeEight = new DependencyResolver.GraphNode(8);
        DependencyResolver.GraphNode nodeNine = new DependencyResolver.GraphNode(9);

        nodeSeven.addEdge(nodeEight);
        nodeEight.addEdge(nodeNine);
        nodeNine.addEdge(nodeSeven);

        cyclicalDependencies = new ArrayList<>();
        cyclicalDependencies.add(nodeSeven);
        cyclicalDependencies.add(nodeEight);
        cyclicalDependencies.add(nodeNine);
    }

    @Test
    public void shouldResolveDependenciesInCorrectOrder() {
        List<DependencyResolver.GraphNode> dependencyChain = DependencyResolver.resolveDependencyChain(dependencies);
        int[] answer = new int[dependencyChain.size()];
        int counter = 0;
        for(DependencyResolver.GraphNode node: dependencyChain) {
            answer[counter++] = node.data;
        }
        assertArrayEquals(resolvedDependencies, answer);
    }

    @Test
    public void shouldReturnNullIfContainsDependencyCycles() {
        assertNull(DependencyResolver.resolveDependencyChain(cyclicalDependencies));
    }
}