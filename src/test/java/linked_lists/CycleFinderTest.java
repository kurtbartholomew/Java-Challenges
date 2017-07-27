package linked_lists;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CycleFinderTest {

    public CycleFinder.Node listWithCycle;
    public CycleFinder.Node listWithoutCycle;
    public CycleFinder.Node second;

    @Before
    public void setUp() {
        listWithCycle = new CycleFinder.Node(1,null);
        second = new CycleFinder.Node(2,null);
        CycleFinder.Node third = new CycleFinder.Node(3,null);
        CycleFinder.Node fourth = new CycleFinder.Node(4,null);

        listWithCycle.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second;

        listWithoutCycle = new CycleFinder.Node(5,null);
        CycleFinder.Node sixth = new CycleFinder.Node(6,null);
        CycleFinder.Node seventh = new CycleFinder.Node(7,null);
        CycleFinder.Node eighth = new CycleFinder.Node(8,null);
        CycleFinder.Node ninth = new CycleFinder.Node(9,null);

        listWithoutCycle.next = sixth;
        sixth.next = seventh;
        seventh.next = eighth;
        eighth.next = ninth;
    }

    @Test
    public void shouldReturnNodeIfCycleExists() {
        assertEquals(second, CycleFinder.findCycle(listWithCycle));
    }

    @Test
    public void shouldReturnNullIfCycleDoesNotExist() {
        assertEquals(null, CycleFinder.findCycle(listWithoutCycle));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfNullIsPassed() {
        CycleFinder.findCycle(null);
    }
}