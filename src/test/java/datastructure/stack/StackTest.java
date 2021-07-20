package datastructure.stack;

import org.junit.*;
import static org.junit.Assert.*;

public class StackTest {
    Stack stack;
    private static int score = 0;
    private static final int max_score = 10;

    @Before
    public void setup()
    {
        stack = new Stack(3);
    }

    @Test(timeout=100)
    public void testPush() {
        stack.push(0);
        assertEquals("0", stack.toString());
        assertEquals(1, stack.getSize());
        score++;
    }

    @Test(timeout=100)
    public void testPeek() {
        stack.push(0);
        assertEquals(0, stack.peek());
        assertEquals(1, stack.getSize());
        score++;
    }

    @Test(timeout=100)
    public void testPop() {
        stack.push(0);
        stack.push(1);
        stack.pop();
        assertEquals("0", stack.toString());
        assertEquals(1, stack.getSize());
        score++;
    }

    @Test(timeout=100)
    public void testToString() {
        stack.push(0);
        stack.push(1);
        assertEquals("1,0", stack.toString());
        score++;
    }

    @Test(timeout=100)
    public void testEmptyPop() {
        assertEquals(-1, stack.pop());
        score++;
    }

    @Test(timeout=100)
    public void testEmptyPeek() {
        assertEquals(-1, stack.peek());
        score++;
    }

    @Test(timeout=100)
    public void testFullPush() {
        stack.push(0);
        stack.push(1);
        stack.push(2);
        assertEquals(-1, stack.push(3));
        assertEquals(2, stack.peek());
        assertEquals(3, stack.getSize());
        score++;
    }

    @Test(timeout=100)
    public void testFillThenEmpty() {
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.pop();
        stack.pop();
        stack.pop();
        assertEquals(0, stack.getSize());
        assertEquals(-1, stack.peek());
        assertEquals(-1, stack.pop());
        score++;
    }

    @Test(timeout=100)
    public void testUtilities() {
        assertEquals(3, stack.getCapacity());
        assertEquals(true, stack.isEmpty());
        stack.push(0);
        stack.push(1);
        stack.push(2);
        assertEquals(true, stack.isFull());
        stack.pop();
        stack.pop();
        stack.pop();
        assertEquals(true, stack.isEmpty());
        score++;
    }

    @Test(timeout=100)
    public void testSmallCapacity() {
        stack = new Stack(1);
        assertEquals(1, stack.getCapacity());
        stack.push(0);
        assertEquals(true, stack.isFull());
        assertEquals(-1, stack.push(1));
        assertEquals(0, stack.pop());
        stack.push(0);
        assertEquals("0", stack.toString());
        score++;
    }

    @AfterClass
    public static void printScore() {
        System.out.printf("Stack Score: %d/%d\n", score, max_score);
        System.out.printf("Stack Percent: %.2f\n", 100.00*score/max_score);
    }
}