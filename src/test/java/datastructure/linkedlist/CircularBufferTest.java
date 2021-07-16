package datastructure.linkedlist;

import org.junit.*;
import static org.junit.Assert.assertEquals;

public class CircularBufferTest {
    CircularBuffer circularBuffer;
    public static int score = 0;
    public static int max_score = 8;

    @Before
    public void setup() {
        circularBuffer = new CircularBuffer(3);
    }

    @Test(timeout=100)
    public void testAdd() {
        circularBuffer.add('a');
        circularBuffer.add('b');
        circularBuffer.add('c');
        assertEquals("abc", circularBuffer.toString());
        score++;
    }

    @Test(timeout=100)
    public void testDelete() {
        circularBuffer.add('a');
        circularBuffer.add('b');
        circularBuffer.add('c');
        circularBuffer.delete();
        assertEquals("ab", circularBuffer.toString());
        circularBuffer.delete();
        assertEquals("a", circularBuffer.toString());
        circularBuffer.delete();
        assertEquals("", circularBuffer.toString());
        score++;
    }

    @Test(timeout=100)
    public void testUtility() {
        circularBuffer.add('a');
        circularBuffer.add('b');
        circularBuffer.add('c');
        assertEquals('a', circularBuffer.getHead().getData());
        assertEquals(3, circularBuffer.getSize());
        circularBuffer.clear();
        assertEquals(0, circularBuffer.getSize());
        assertEquals(true, circularBuffer.isEmpty());
        score++;
    }

    @Test(timeout=100)
    public void testContains() {
        circularBuffer.add('a');
        circularBuffer.add('b');
        circularBuffer.add('c');
        assertEquals(false, circularBuffer.contains('f'));
        assertEquals(true, circularBuffer.contains('a'));
        assertEquals(true, circularBuffer.contains('b'));
        assertEquals(true, circularBuffer.contains('c'));
        score++;
    }

    @Test(timeout=100)
    public void testGetIndex() {
        circularBuffer.add('a');
        circularBuffer.add('b');
        circularBuffer.add('c');
        assertEquals(0, circularBuffer.getIndex('a'));
        assertEquals(1, circularBuffer.getIndex('b'));
        assertEquals(2, circularBuffer.getIndex('c'));
        assertEquals(-1, circularBuffer.getIndex('z'));
        score++;
    }

    @Test(timeout=100)
    public void testAddOverflow() {
        circularBuffer.add('a');
        circularBuffer.add('b');
        circularBuffer.add('c');
        circularBuffer.add('d');
        assertEquals("bcd", circularBuffer.toString());
        circularBuffer.add('e');
        assertEquals("cde", circularBuffer.toString());
        score++;
    }

    @Test(timeout=100)
    public void testAddOverflowEdgeCases() {
        circularBuffer.add('a');
        circularBuffer.add('b');
        circularBuffer.add('c');
        circularBuffer.add('d');
        circularBuffer.add('e');
        circularBuffer.add('f');
        assertEquals("def", circularBuffer.toString());
        assertEquals(3, circularBuffer.getSize());
        score++;
    }

    @Test(timeout=100)
    public void testSmallCapacity() {
        circularBuffer = new CircularBuffer(1);
        circularBuffer.add('a');
        circularBuffer.add('b');
        circularBuffer.add('c');
        circularBuffer.add('d');
        circularBuffer.add('e');
        circularBuffer.add('f');
        assertEquals("f", circularBuffer.toString());
        assertEquals(1, circularBuffer.getSize());
        score++;
    }

    @AfterClass
    public static void printScore() {
        System.out.printf("CircularBuffer Score: %d/%d\n", score, max_score);
        System.out.printf("CircularBuffer Percent: %.2f\n", 100.00*score/max_score);
    }
}