package ng.clarence.solutions;

import ng.clarence.collections.ArrayBackedQueue;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ArrayBackedQueueTest {

    @Test
    public void sanity() {
        ArrayBackedQueue queue = new ArrayBackedQueue(7);
        assertNull(queue.removeFirst());

        assertTrue(queue.append(1));
        assertTrue(queue.removeFirst() == 1);
        assertNull(queue.removeFirst());
        for (int i = 2; i < 9; i++) {
            assertTrue(queue.append(i));
        }

        for (int i = 2; i < 9; i++) {
            assertTrue(queue.removeFirst() == i);
        }
        assertNull(queue.removeFirst());

        for (int i = 9; i < 16; i++) {
            assertTrue(queue.append(i));
        }
        assertFalse(queue.append(16));
        assertFalse(queue.append(17));
    }
}
