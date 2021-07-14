package datastructure.linkedlist;

import org.junit.*;

import static org.junit.Assert.*;

public class SinglyLinkedListTest {
    SinglyLinkedList ll;
    public static int score = 0;
    public static int max_score = 11;

    @Before
    public void setup() {
        ll = new SinglyLinkedList();
    }
    @Test(timeout=100)
    public void testAdd() {
        ll.add('a',0);
        ll.add('b',1);
        ll.add('c',0);
        assertEquals("cab",ll.toString());
        score++;
    }
    @Test(timeout=100)
    public void testDelete() {
        ll.add('a',0);
        ll.add('b',1);
        ll.add('c',0);
        ll.delete(2);
        assertEquals("ca",ll.toString());
        score++;
    }

    @Test(timeout=100)
    public void testUtility() {
        ll.add('a',0);
        ll.add('b',1);
        ll.add('c',0);
        assertEquals('c', ll.getHead().getData());
        assertEquals(3, ll.getSize());
        ll.clear();
        assertEquals(0, ll.getSize());
        assertEquals(true, ll.isEmpty());
        score++;
    }

    @Test(timeout=100)
    public void testContains() {
        ll.add('a',0);
        ll.add('b',1);
        ll.add('c',2);
        ll.add('d',3);
        ll.add('e',4);
        ll.add('f',5);
        assertEquals(true, ll.contains('f'));
        assertEquals(true, ll.contains('a'));
        assertEquals(true, ll.contains('c'));
        assertEquals(false, ll.contains('z'));
        score++;
    }

    @Test(timeout=100)
    public void testGetIndex() {
        ll.add('a',0);
        ll.add('b',1);
        ll.add('c',2);
        ll.add('d',3);
        ll.add('e',4);
        ll.add('f',5);
        assertEquals(0, ll.getIndex('a'));
        assertEquals(5, ll.getIndex('f'));
        assertEquals(3, ll.getIndex('d'));
        assertEquals(-1, ll.getIndex('z'));
        score++;
    }

    @Test(timeout=100)
    public void testItemDeletion() {
        ll.add('a',0);
        ll.add('b',1);
        ll.add('c',2);
        ll.add('d',3);
        assertEquals(null, ll.deleteItem('z'));
        assertEquals("abcd", ll.toString());
        ll.deleteItem('c');
        assertEquals("abd", ll.toString());
        ll.deleteItem('a');
        assertEquals("bd", ll.toString());
        ll.deleteItem('d');
        assertEquals("b", ll.toString());
        score++;
    }

    @Test(timeout=100)
    public void testAddOutOfBounds() {
        assertEquals(ll.add('a',10), null);
        assertEquals(ll.add('a',-1), null);
        ll.add('a',0);
        ll.add('b',1);
        assertEquals(ll.add('c',3), null);
        score++;
    }

    @Test(timeout=100)
    public void testDeleteOutOfBounds() {
        assertEquals(ll.delete(-1), null);
        assertEquals(ll.delete(10), null);
        ll.add('a',0);
        ll.add('b',1);
        ll.add('c',2);
        assertEquals(ll.delete(10), null);
        score++;
    }

    @Test(timeout=100)
    public void testHeadEdgeCases() {

        assertEquals(null, ll.getHead());
        ll.add('a',0);
        assertEquals('a', ll.getHead().getData());
        ll.add('b',1);
        ll.delete(0);
        assertEquals('b', ll.getHead().getData());
        ll.delete(0);
        assertEquals(null, ll.getHead());
        score++;
    }

    @Test(timeout=100)
    public void testNullPointers() {
        ll.add('a',0);
        ll.add('b',1);
        ll.add('c',2);
        ll.add('d',3);
        ll.add('e',4);
        ll.add('f',5);
        ll.delete(5);
        assertEquals(null,ll.getNode(4).getNext());
        ll.deleteItem('e');
        assertEquals(null,ll.getNode(3).getNext());
        score++;
    }

    @Test(timeout=100)
    public void testSizing() {
        assertEquals(0, ll.getSize());
        ll.add('a',0);
        assertEquals(1, ll.getSize());
        ll.add('b',15);
        assertEquals(1, ll.getSize());
        ll.add('b',1);
        assertEquals(2, ll.getSize());
        ll.add('c',2);
        ll.add('d',3);
        ll.add('e',4);
        ll.add('f',5);
        ll.add('g',6);
        ll.delete(3);
        assertEquals(6, ll.getSize());
        ll.delete(5);
        assertEquals(5, ll.getSize());
        ll.deleteItem('z');
        assertEquals(5, ll.getSize());
        ll.deleteItem('b');
        assertEquals(4, ll.getSize());
        ll.deleteItem('f');
        assertEquals(3, ll.getSize());
        ll.deleteItem('a');
        assertEquals(2, ll.getSize());
        score++;
    }

    @AfterClass
    public static void printScore() {
        System.out.printf("SinglyLinkedList Score: %d/%d\n", score, max_score);
        System.out.printf("SinglyLinkedList Percent: %.2f\n", 100.00*score/max_score);
    }

}