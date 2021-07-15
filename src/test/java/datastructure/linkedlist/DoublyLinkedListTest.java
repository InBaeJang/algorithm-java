package datastructure.linkedlist;

import org.junit.*;
import static org.junit.Assert.*;

public class DoublyLinkedListTest {
    DoublyLinkedList doublyLinkedList;
    public static int score = 0;
    public static int max_score = 13;

    @Before
    public void setup() {
        doublyLinkedList = new DoublyLinkedList();
    }

    @Test(timeout=100)
    public void testAdd() {
        doublyLinkedList.add('a',0);
        doublyLinkedList.add('b',1);
        doublyLinkedList.add('c',0);
        assertEquals("cab", doublyLinkedList.toString());
        score++;
    }

    @Test(timeout=100)
    public void testAddOutOfBounds() {
        assertEquals(doublyLinkedList.add('a',10), null);
        assertEquals(doublyLinkedList.add('a',-1), null);
        doublyLinkedList.add('a',0);
        doublyLinkedList.add('b',1);
        assertEquals(doublyLinkedList.add('c',3), null);
        score++;
    }

    @Test(timeout=100)
    public void testDelete() {
        doublyLinkedList.add('a',0);
        doublyLinkedList.add('b',1);
        doublyLinkedList.add('c',0);
        doublyLinkedList.delete(2);
        assertEquals("ca", doublyLinkedList.toString());
        score++;
    }
    @Test(timeout=100)
    public void testDeleteOutOfBounds() {
        assertEquals(doublyLinkedList.delete(-1), null);
        assertEquals(doublyLinkedList.delete(10), null);
        doublyLinkedList.add('a',0);
        doublyLinkedList.add('b',1);
        doublyLinkedList.add('c',2);
        assertEquals(doublyLinkedList.delete(10), null);
        score++;
    }


    @Test(timeout=100)
    public void testItemDeletion() {
        doublyLinkedList.add('a',0);
        doublyLinkedList.add('b',1);
        doublyLinkedList.add('c',2);
        doublyLinkedList.add('d',3);
        assertEquals(null, doublyLinkedList.deleteItem('z'));
        assertEquals("abcd", doublyLinkedList.toString());
        doublyLinkedList.deleteItem('c');
        assertEquals("abd", doublyLinkedList.toString());
        doublyLinkedList.deleteItem('a');
        assertEquals("bd", doublyLinkedList.toString());
        doublyLinkedList.deleteItem('d');
        assertEquals("b", doublyLinkedList.toString());
        score++;
    }

    @Test(timeout=100)
    public void testContains() {
        doublyLinkedList.add('a',0);
        doublyLinkedList.add('b',1);
        doublyLinkedList.add('c',2);
        doublyLinkedList.add('d',3);
        doublyLinkedList.add('e',4);
        doublyLinkedList.add('f',5);
        assertEquals(true, doublyLinkedList.contains('f'));
        assertEquals(true, doublyLinkedList.contains('a'));
        assertEquals(true, doublyLinkedList.contains('c'));
        assertEquals(false, doublyLinkedList.contains('z'));
        score++;
    }

    @Test(timeout=100)
    public void testGetIndex() {
        doublyLinkedList.add('a',0);
        doublyLinkedList.add('b',1);
        doublyLinkedList.add('c',2);
        doublyLinkedList.add('d',3);
        doublyLinkedList.add('e',4);
        doublyLinkedList.add('f',5);
        assertEquals(0, doublyLinkedList.getIndex('a'));
        assertEquals(5, doublyLinkedList.getIndex('f'));
        assertEquals(3, doublyLinkedList.getIndex('d'));
        assertEquals(-1, doublyLinkedList.getIndex('z'));
        score++;
    }

    @Test(timeout=100)
    public void testUtility() {
        doublyLinkedList.add('a',0);
        doublyLinkedList.add('b',1);
        doublyLinkedList.add('c',0);
        assertEquals('c', doublyLinkedList.getHead().getData());
        assertEquals(3, doublyLinkedList.getSize());
        doublyLinkedList.clear();
        assertEquals(0, doublyLinkedList.getSize());
        assertEquals(true, doublyLinkedList.isEmpty());
        score++;
    }

    @Test(timeout=100)
    public void testHeadEdgeCases() {
        assertEquals(null, doublyLinkedList.getHead());
        doublyLinkedList.add('a',0);
        assertEquals('a', doublyLinkedList.getHead().getData());
        doublyLinkedList.add('b',1);
        doublyLinkedList.delete(0);
        assertEquals('b', doublyLinkedList.getHead().getData());
        doublyLinkedList.delete(0);
        assertEquals(null, doublyLinkedList.getHead());
        score++;
    }

    @Test(timeout=100)
    public void testTailEdgeCases() {
        assertEquals(null, doublyLinkedList.getTail());
        doublyLinkedList.add('a',0);
        assertEquals('a', doublyLinkedList.getTail().getData());
        doublyLinkedList.add('b',1);
        doublyLinkedList.add('c',2);
        assertEquals('c', doublyLinkedList.getTail().getData());
        doublyLinkedList.delete(2);
        assertEquals('b', doublyLinkedList.getTail().getData());
        doublyLinkedList.delete(0);
        doublyLinkedList.delete(0);
        assertEquals(null, doublyLinkedList.getHead());
        score++;
    }

    @Test(timeout=100)
    public void testNullPointers() {
        doublyLinkedList.add('a',0);
        doublyLinkedList.add('b',1);
        doublyLinkedList.add('c',2);
        doublyLinkedList.add('d',3);
        doublyLinkedList.add('e',4);
        doublyLinkedList.add('f',5);
        doublyLinkedList.delete(5);
        assertEquals(null, doublyLinkedList.getTail().getNext());
        doublyLinkedList.deleteItem('e');
        assertEquals(null, doublyLinkedList.getTail().getNext());
        doublyLinkedList.deleteItem('a');
        assertEquals(null, doublyLinkedList.getHead().getPrev());
        doublyLinkedList.delete(0);
        assertEquals(null, doublyLinkedList.getHead().getPrev());
        score++;
    }

    @Test(timeout=100)
    public void testSizing() {
        assertEquals(0, doublyLinkedList.getSize());
        doublyLinkedList.add('a',0);
        assertEquals(1, doublyLinkedList.getSize());
        doublyLinkedList.add('b',15);
        assertEquals(1, doublyLinkedList.getSize());
        doublyLinkedList.add('b',1);
        assertEquals(2, doublyLinkedList.getSize());
        doublyLinkedList.add('c',2);
        doublyLinkedList.add('d',3);
        doublyLinkedList.add('e',4);
        doublyLinkedList.add('f',5);
        doublyLinkedList.add('g',6);
        doublyLinkedList.delete(3);
        assertEquals(6, doublyLinkedList.getSize());
        doublyLinkedList.delete(5);
        assertEquals(5, doublyLinkedList.getSize());
        doublyLinkedList.deleteItem('z');
        assertEquals(5, doublyLinkedList.getSize());
        doublyLinkedList.deleteItem('b');
        assertEquals(4, doublyLinkedList.getSize());
        doublyLinkedList.deleteItem('f');
        assertEquals(3, doublyLinkedList.getSize());
        doublyLinkedList.deleteItem('a');
        assertEquals(2, doublyLinkedList.getSize());
        score++;
    }

    @Test(timeout=100)
    public void testToStringReverse() {
        doublyLinkedList.add('a',0);
        doublyLinkedList.add('b',1);
        doublyLinkedList.add('c',2);
        assertEquals("abc", doublyLinkedList.toString());
        assertEquals("cba", doublyLinkedList.toStringReverse());
        score++;
    }

    @AfterClass
    public static void printScore() {
        System.out.printf("DoublyLinkedList Score: %d/%d\n", score, max_score);
        System.out.printf("DoublyLinkedList Percent: %.2f\n", 100.00*score/max_score);
    }
}