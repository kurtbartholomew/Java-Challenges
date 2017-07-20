package linked_lists;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListPartitionerTest {

    private LinkedListPartitioner.Node list = null;

    @Before
    public void setUp(){
        list = new LinkedListPartitioner.Node(5,null);
        LinkedListPartitioner.Node second = new LinkedListPartitioner.Node(10,null);
        LinkedListPartitioner.Node third = new LinkedListPartitioner.Node(3,null);
        LinkedListPartitioner.Node fourth = new LinkedListPartitioner.Node(6,null);
        LinkedListPartitioner.Node fifth = new LinkedListPartitioner.Node(9,null);
        LinkedListPartitioner.Node sixth = new LinkedListPartitioner.Node(7,null);

        list.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
    }

    @Test
    public void shouldReturnAProperlyPartitionedList(){
        int chosenPartition = 7;
        LinkedListPartitioner.Node partitionedList = LinkedListPartitioner.partitionListAroundValue(list,7);
        int underCounter = 0;
        boolean overOrEqualEncountered = false;
        LinkedListPartitioner.Node current = partitionedList;
        while(current != null && !overOrEqualEncountered) {
            if(current.data < chosenPartition) { ++underCounter; }
            if(current.data >= chosenPartition) { overOrEqualEncountered = true; }
            current = current.next;
        }
        assertEquals(underCounter,3);
    }
}