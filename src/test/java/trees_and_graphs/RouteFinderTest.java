package trees_and_graphs;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RouteFinderTest {

    private RouteFinder.Node graph;
    private RouteFinder.Node seven;
    private RouteFinder.Node six;
    private RouteFinder.Node five;
    private RouteFinder.Node four;
    private RouteFinder.Node three;
    private RouteFinder.Node two;
    private RouteFinder.Node one;

    @Before
    public void setUp() {
        graph = new RouteFinder.Node(8);
        seven = new RouteFinder.Node(7);
        six = new RouteFinder.Node(7);
        five = new RouteFinder.Node(7);
        four = new RouteFinder.Node(7);
        three = new RouteFinder.Node(7);
        two = new RouteFinder.Node(7);
        one = new RouteFinder.Node(7);

        graph.addEdge(seven);
        graph.addEdge(six);
        six.addEdge(three);
        five.addEdge(one);
        three.addEdge(four);
        three.addEdge(one);
    }

    @Test
    public void shouldReturnTrueIfARouteExists() {
        RouteFinder finder = new RouteFinder();
        assertTrue(finder.containsRoute(graph, four));
    }

    @Test
    public void shouldReturnFalseIfNoRouteExists() {
        RouteFinder finder = new RouteFinder();
        assertFalse(finder.containsRoute(graph, two));
    }
}