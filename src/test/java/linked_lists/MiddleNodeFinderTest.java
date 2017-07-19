package linked_lists;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MiddleNodeFinderTest {

    private MiddleNodeFinder.Node oddList;
    private MiddleNodeFinder.Node evenList;
    private MiddleNodeFinder.Node shortList;

    @Before
    public void setUp() {
        oddList = new MiddleNodeFinder.Node(1, null);
        MiddleNodeFinder.Node second = new MiddleNodeFinder.Node(2, null);
        MiddleNodeFinder.Node third = new MiddleNodeFinder.Node(3, null);
        MiddleNodeFinder.Node fourth = new MiddleNodeFinder.Node(4, null);
        MiddleNodeFinder.Node fifth = new MiddleNodeFinder.Node(5, null);

        oddList.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        evenList = new MiddleNodeFinder.Node(5, null);
        MiddleNodeFinder.Node sixth = new MiddleNodeFinder.Node(6, null);
        MiddleNodeFinder.Node seventh = new MiddleNodeFinder.Node(7, null);
        MiddleNodeFinder.Node eighth = new MiddleNodeFinder.Node(8, null);

        evenList.next = sixth;
        sixth.next = seventh;
        seventh.next = eighth;

        shortList = new MiddleNodeFinder.Node(1,null);
    }

    @Test
    public void shouldReturnMiddleNodeForOddNumberedList() {
        assertEquals(MiddleNodeFinder.findMiddleNode(oddList),oddList.next.next);
    }

    @Test
    public void shouldReturnMiddleNodeForEvenNumberedList() {
        assertEquals(MiddleNodeFinder.findMiddleNode(evenList),evenList.next);
    }

    @Test
    public void shouldReturnMiddleNodeForShortList() {
        assertEquals(MiddleNodeFinder.findMiddleNode(shortList),shortList);
    }
}
