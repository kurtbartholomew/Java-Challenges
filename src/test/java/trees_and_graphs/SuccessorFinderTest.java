package trees_and_graphs;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SuccessorFinderTest {

    private SuccessorFinder.Node successorRoot;
    private SuccessorFinder.Node targetSuccessorNode;
    private SuccessorFinder.Node successorNode;
    private SuccessorFinder.Node parentSuccessorRoot;
    private SuccessorFinder.Node targetParentSuccessorNode;
    private SuccessorFinder.Node parentSuccessorNode;
    private SuccessorFinder.Node noSuccessorRoot;
    private SuccessorFinder.Node targetNoSuccessorNode;
    private SuccessorFinder.Node noSuccessorNode;


    @Before
    public void setUp() {
        successorRoot = new SuccessorFinder.Node(5);
        SuccessorFinder.Node three = new SuccessorFinder.Node(3);
        SuccessorFinder.Node eight = new SuccessorFinder.Node(8);
        SuccessorFinder.Node twelve = new SuccessorFinder.Node(12);
        SuccessorFinder.Node eleven = new SuccessorFinder.Node(11);
        SuccessorFinder.Node ten = new SuccessorFinder.Node(10);
        SuccessorFinder.Node fourteen = new SuccessorFinder.Node(14);

        successorRoot.left = three;
        successorRoot.right = ten;
        ten.left = eight;
        ten.right = twelve;
        twelve.left = eleven;
        twelve.right = fourteen;
        targetSuccessorNode = twelve;
        successorNode = eleven;

        parentSuccessorRoot = new SuccessorFinder.Node(20);
        SuccessorFinder.Node fifteen = new SuccessorFinder.Node(15);
        SuccessorFinder.Node seventeen = new SuccessorFinder.Node(17);
        SuccessorFinder.Node nineteen = new SuccessorFinder.Node(19);
        SuccessorFinder.Node twentythree = new SuccessorFinder.Node(23);

        parentSuccessorRoot.left = fifteen;
        fifteen.parent = parentSuccessorRoot;
        parentSuccessorRoot.right = twentythree;
        twentythree.parent = parentSuccessorRoot;
        fifteen.right = seventeen;
        seventeen.parent = fifteen;
        seventeen.right = nineteen;
        nineteen.parent = seventeen;

        targetParentSuccessorNode = nineteen;
        parentSuccessorNode = parentSuccessorRoot;

        noSuccessorRoot = new SuccessorFinder.Node(50);
        SuccessorFinder.Node fiftyseven = new SuccessorFinder.Node(57);
        SuccessorFinder.Node fiftynine = new SuccessorFinder.Node(59);

        noSuccessorRoot.right = fiftyseven;
        fiftyseven.parent = noSuccessorRoot;
        fiftyseven.right = fiftynine;
        fiftynine.parent = fiftyseven;
        targetNoSuccessorNode = fiftynine;
        noSuccessorNode = null;
    }

    @Test
    public void shouldReturnDescendantSuccessorIfExists() {
        assertEquals(SuccessorFinder.findSuccessor(successorRoot, targetSuccessorNode), successorNode);
    }

    @Test
    public void shouldReturnParentSuccessorIfExists() {
        assertEquals(SuccessorFinder.findSuccessor(parentSuccessorRoot, targetParentSuccessorNode), parentSuccessorNode);
    }

    @Test
    public void shouldReturnNullIfNoSuccessorExists() {
        assertEquals(SuccessorFinder.findSuccessor(noSuccessorRoot, targetNoSuccessorNode), noSuccessorNode);
    }
}