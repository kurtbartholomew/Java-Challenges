package linked_lists;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListSummerTest {

    private ListSummer.Node list;
    private ListSummer.Node listTwo;

    @Before
    public void setUp() {
        list = new ListSummer.Node(8,null);
        ListSummer.Node second = new ListSummer.Node(9,null);
        ListSummer.Node third = new ListSummer.Node(3,null);
        ListSummer.Node fourth = new ListSummer.Node(5,null);
        ListSummer.Node fifth = new ListSummer.Node(7,null);

        list.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        listTwo = new ListSummer.Node(3,null);
        ListSummer.Node seventh = new ListSummer.Node(4,null);
        ListSummer.Node eighth = new ListSummer.Node(5,null);
        ListSummer.Node ninth = new ListSummer.Node(6,null);

        listTwo.next = seventh;
        seventh.next = eighth;
        eighth.next = ninth;
    }

    @Test
    public void shouldSumALinkedList() {
        assertEquals(ListSummer.sumList(list,listTwo), 92813);
    }

    @Test
    public void shouldSumALinkedListInReverse() {
        assertEquals(ListSummer.sumListInReverse(list,listTwo),81941);
    }
}