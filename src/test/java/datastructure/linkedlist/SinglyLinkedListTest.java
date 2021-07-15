package datastructure.linkedlist;

import org.junit.*;
import static org.junit.Assert.*;

public class SinglyLinkedListTest {
    SinglyLinkedList singlyLinkedList;
    public static int score = 0;
    public static int max_score = 11;

    @Before
    public void setup() {
        singlyLinkedList = new SinglyLinkedList();
    }
    @Test(timeout=100)
    public void testAdd() {
        singlyLinkedList.add('a',0);
        singlyLinkedList.add('b',1);
        singlyLinkedList.add('c',0);
        assertEquals("cab", singlyLinkedList.toString());
        score++;
    }
    @Test(timeout=100)
    public void testDelete() {
        singlyLinkedList.add('a',0);
        singlyLinkedList.add('b',1);
        singlyLinkedList.add('c',0);
        singlyLinkedList.delete(2);
        assertEquals("ca", singlyLinkedList.toString());
        score++;
    }

    @Test(timeout=100)
    public void testUtility() {
        singlyLinkedList.add('a',0);
        singlyLinkedList.add('b',1);
        singlyLinkedList.add('c',0);
        assertEquals('c', singlyLinkedList.getHead().getData());
        assertEquals(3, singlyLinkedList.getSize());
        singlyLinkedList.clear();
        assertEquals(0, singlyLinkedList.getSize());
        assertEquals(true, singlyLinkedList.isEmpty());
        score++;
    }

    @Test(timeout=100)
    public void testContains() {
        singlyLinkedList.add('a',0);
        singlyLinkedList.add('b',1);
        singlyLinkedList.add('c',2);
        singlyLinkedList.add('d',3);
        singlyLinkedList.add('e',4);
        singlyLinkedList.add('f',5);
        assertEquals(true, singlyLinkedList.contains('f'));
        assertEquals(true, singlyLinkedList.contains('a'));
        assertEquals(true, singlyLinkedList.contains('c'));
        assertEquals(false, singlyLinkedList.contains('z'));
        score++;
    }

    @Test(timeout=100)
    public void testGetIndex() {
        singlyLinkedList.add('a',0);
        singlyLinkedList.add('b',1);
        singlyLinkedList.add('c',2);
        singlyLinkedList.add('d',3);
        singlyLinkedList.add('e',4);
        singlyLinkedList.add('f',5);
        assertEquals(0, singlyLinkedList.getIndex('a'));
        assertEquals(5, singlyLinkedList.getIndex('f'));
        assertEquals(3, singlyLinkedList.getIndex('d'));
        assertEquals(-1, singlyLinkedList.getIndex('z'));
        score++;
    }

    @Test(timeout=100)
    public void testItemDeletion() {
        singlyLinkedList.add('a',0);
        singlyLinkedList.add('b',1);
        singlyLinkedList.add('c',2);
        singlyLinkedList.add('d',3);
        assertEquals(null, singlyLinkedList.deleteItem('z'));
        assertEquals("abcd", singlyLinkedList.toString());
        singlyLinkedList.deleteItem('c');
        assertEquals("abd", singlyLinkedList.toString());
        singlyLinkedList.deleteItem('a');
        assertEquals("bd", singlyLinkedList.toString());
        singlyLinkedList.deleteItem('d');
        assertEquals("b", singlyLinkedList.toString());
        score++;
    }

    @Test(timeout=100)
    public void testAddOutOfBounds() {
        assertEquals(singlyLinkedList.add('a',10), null);
        assertEquals(singlyLinkedList.add('a',-1), null);
        singlyLinkedList.add('a',0);
        singlyLinkedList.add('b',1);
        assertEquals(singlyLinkedList.add('c',3), null);
        score++;
    }

    @Test(timeout=100)
    public void testDeleteOutOfBounds() {
        assertEquals(singlyLinkedList.delete(-1), null);
        assertEquals(singlyLinkedList.delete(10), null);
        singlyLinkedList.add('a',0);
        singlyLinkedList.add('b',1);
        singlyLinkedList.add('c',2);
        assertEquals(singlyLinkedList.delete(10), null);
        score++;
    }

    @Test(timeout=100)
    public void testHeadEdgeCases() {

        assertEquals(null, singlyLinkedList.getHead());
        singlyLinkedList.add('a',0);
        assertEquals('a', singlyLinkedList.getHead().getData());
        singlyLinkedList.add('b',1);
        singlyLinkedList.delete(0);
        assertEquals('b', singlyLinkedList.getHead().getData());
        singlyLinkedList.delete(0);
        assertEquals(null, singlyLinkedList.getHead());
        score++;
    }

    @Test(timeout=100)
    public void testNullPointers() {
        singlyLinkedList.add('a',0);
        singlyLinkedList.add('b',1);
        singlyLinkedList.add('c',2);
        singlyLinkedList.add('d',3);
        singlyLinkedList.add('e',4);
        singlyLinkedList.add('f',5);
        singlyLinkedList.delete(5);
        assertEquals(null, singlyLinkedList.getNode(4).getNext());
        singlyLinkedList.deleteItem('e');
        assertEquals(null, singlyLinkedList.getNode(3).getNext());
        score++;
    }

    @Test(timeout=100)
    public void testSizing() {
        assertEquals(0, singlyLinkedList.getSize());
        singlyLinkedList.add('a',0);
        assertEquals(1, singlyLinkedList.getSize());
        singlyLinkedList.add('b',15);
        assertEquals(1, singlyLinkedList.getSize());
        singlyLinkedList.add('b',1);
        assertEquals(2, singlyLinkedList.getSize());
        singlyLinkedList.add('c',2);
        singlyLinkedList.add('d',3);
        singlyLinkedList.add('e',4);
        singlyLinkedList.add('f',5);
        singlyLinkedList.add('g',6);
        singlyLinkedList.delete(3);
        assertEquals(6, singlyLinkedList.getSize());
        singlyLinkedList.delete(5);
        assertEquals(5, singlyLinkedList.getSize());
        singlyLinkedList.deleteItem('z');
        assertEquals(5, singlyLinkedList.getSize());
        singlyLinkedList.deleteItem('b');
        assertEquals(4, singlyLinkedList.getSize());
        singlyLinkedList.deleteItem('f');
        assertEquals(3, singlyLinkedList.getSize());
        singlyLinkedList.deleteItem('a');
        assertEquals(2, singlyLinkedList.getSize());
        score++;
    }

    @AfterClass
    public static void printScore() {
        System.out.printf("SinglyLinkedList Score: %d/%d\n", score, max_score);
        System.out.printf("SinglyLinkedList Percent: %.2f\n", 100.00*score/max_score);
    }

}