package linked_lists;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class LinkedListDuplicateRemoverTest {

    private LinkedListDuplicateRemover.Node list;
    private LinkedListDuplicateRemover.Node noDupsList;

    @Before
    public void setUp() {
        list = new LinkedListDuplicateRemover.Node(7,null);
        LinkedListDuplicateRemover.Node second = new LinkedListDuplicateRemover.Node(9,null);
        LinkedListDuplicateRemover.Node third = new LinkedListDuplicateRemover.Node(1,null);
        LinkedListDuplicateRemover.Node fourth = new LinkedListDuplicateRemover.Node(2,null);
        LinkedListDuplicateRemover.Node fifth = new LinkedListDuplicateRemover.Node(1,null);
        LinkedListDuplicateRemover.Node sixth = new LinkedListDuplicateRemover.Node(6,null);
        fifth.next = sixth;
        fourth.next = fifth;
        third.next= fourth;
        second.next=  third;
        list.next = second;

        noDupsList = new LinkedListDuplicateRemover.Node(8,null);
        LinkedListDuplicateRemover.Node seventh = new LinkedListDuplicateRemover.Node(9,null);
        LinkedListDuplicateRemover.Node eighth = new LinkedListDuplicateRemover.Node(1,null);
        LinkedListDuplicateRemover.Node ninth = new LinkedListDuplicateRemover.Node(2,null);
        ninth.next = eighth;
        eighth.next = seventh;
        noDupsList.next = seventh;
    }

    public static boolean containsNoDups(LinkedListDuplicateRemover.Node head) {
        Set<Integer> counterSet = new HashSet<>();
        while(head != null) {
            if (counterSet.contains(head.data)) {
                return false;
            }
            counterSet.add(head.data);
            head = head.next;
        }
        return true;
    }

    public static int sizeOf(LinkedListDuplicateRemover.Node head) {
        int counter = 0;
        while(head != null) {
            ++counter;
            head = head.next;
        }
        return counter;
    }

    @Test
    public void shouldRemoveDuplicateNodes() {
        assertTrue(containsNoDups(LinkedListDuplicateRemover.removeDuplicates(list)));
    }

    @Test
    public void shouldRemoveNoNodesIfNoDuplicatesExist() {
        assertEquals(sizeOf(LinkedListDuplicateRemover.removeDuplicates(noDupsList)),sizeOf(noDupsList));
    }
}
