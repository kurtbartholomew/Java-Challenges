package linked_lists;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KthNodeFinderTest {

    private KthNodeFinder.Node list;
    private KthNodeFinder.Node shortList;

    @Before
    public void setUp() {
        list = new KthNodeFinder.Node(1,null);
        KthNodeFinder.Node second = new KthNodeFinder.Node(2,null);
        KthNodeFinder.Node third = new KthNodeFinder.Node(3,null);
        KthNodeFinder.Node fourth = new KthNodeFinder.Node(4,null);
        KthNodeFinder.Node fifth = new KthNodeFinder.Node(5,null);

        list.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        shortList = new KthNodeFinder.Node(1,null);
    }

    @Test
    public void shouldReturnKthLastNode() {
        KthNodeFinder.Node node = KthNodeFinder.findKthLastNode(list, 2);
        assertEquals(node.data, list.next.next.data);
    }

    @Test
    public void shouldThrowAnErrorIfKExceedsListLength() {
        KthNodeFinder.Node node = KthNodeFinder.findKthLastNode(shortList,5);
        assertEquals(node, null);
    }
}
