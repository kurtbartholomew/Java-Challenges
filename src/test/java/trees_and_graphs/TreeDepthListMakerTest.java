package trees_and_graphs;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TreeDepthListMakerTest {

    private TreeDepthListMaker.TreeNode head;

    @Before
    public void setUp() {
        head = new TreeDepthListMaker.TreeNode(1);
        TreeDepthListMaker.TreeNode second = new TreeDepthListMaker.TreeNode(2);
        TreeDepthListMaker.TreeNode third = new TreeDepthListMaker.TreeNode(3);
        TreeDepthListMaker.TreeNode fourth = new TreeDepthListMaker.TreeNode(4);
        TreeDepthListMaker.TreeNode fifth = new TreeDepthListMaker.TreeNode(5);
        TreeDepthListMaker.TreeNode sixth = new TreeDepthListMaker.TreeNode(6);
        TreeDepthListMaker.TreeNode seventh = new TreeDepthListMaker.TreeNode(7);
        TreeDepthListMaker.TreeNode eighth = new TreeDepthListMaker.TreeNode(8);

        head.left = second;
        head.right = third;
        second.left = fourth;
        second.right = fifth;
        third.left = sixth;
        third.right = seventh;
        fourth.left = eighth;
    }

    @Test
    public void shouldReturnTheCorrectNumberOfLinkedLists() {
        assertEquals(TreeDepthListMaker.buildLists(head).size(), 4);
    }

    @Test
    public void shouldReturnLinkedListWithContentsInTheCorrectOrder() {

        List<Integer[]> correctContents = new ArrayList<>();
        correctContents.add(new Integer[]{1});
        correctContents.add(new Integer[]{2, 3});
        correctContents.add(new Integer[]{4, 5, 6, 7});
        correctContents.add(new Integer[]{8});


        List<TreeDepthListMaker.ListNode> list = TreeDepthListMaker.buildLists(head);
        int level = 0;
        for(TreeDepthListMaker.ListNode start : list) {
            int counter = 0;
            while(start != null) {
                assertEquals((int) correctContents.get(level)[counter++], start.data);
                start = start.next;
            }
            ++level;
        }
        assertNotEquals(level, 0);
    }
}