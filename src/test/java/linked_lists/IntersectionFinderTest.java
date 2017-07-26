package linked_lists;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntersectionFinderTest {

    private IntersectionFinder.Node list;
    private IntersectionFinder.Node intersectingList;
    private IntersectionFinder.Node noIntersectionList;
    private IntersectionFinder.Node second;

    @Before
    public void setUp() {
        list = new IntersectionFinder.Node(7,null);
        second = new IntersectionFinder.Node(9,null);
        IntersectionFinder.Node third = new IntersectionFinder.Node(1,null);
        IntersectionFinder.Node fourth = new IntersectionFinder.Node(2,null);
        IntersectionFinder.Node fifth = new IntersectionFinder.Node(1,null);
        IntersectionFinder.Node sixth = new IntersectionFinder.Node(6,null);

        list.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;

        intersectingList = new IntersectionFinder.Node(10,null);

        IntersectionFinder.Node tenth = new IntersectionFinder.Node(10,null);
        IntersectionFinder.Node eleventh = new IntersectionFinder.Node(11,null);
        IntersectionFinder.Node twelvth = new IntersectionFinder.Node(12,null);

        intersectingList.next = tenth;
        tenth.next = eleventh;
        eleventh.next = twelvth;
        twelvth.next = second;

        noIntersectionList = new IntersectionFinder.Node(8,null);

        IntersectionFinder.Node seventh = new IntersectionFinder.Node(9,null);
        IntersectionFinder.Node eighth = new IntersectionFinder.Node(1,null);
        IntersectionFinder.Node ninth = new IntersectionFinder.Node(2,null);

        noIntersectionList.next = seventh;
        seventh.next = eighth;
        eighth.next = ninth;
    }

    @Test
    public void shouldReturnNodeIfAnIntersectionExists() {
        assertEquals(second, IntersectionFinder.findIntersectingNode(list,intersectingList));
    }

    @Test
    public void shouldReturnNullIfNoIntersectionExists() {
        assertEquals(null, IntersectionFinder.findIntersectingNode(list,noIntersectionList));
    }

}