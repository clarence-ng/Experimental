package ng.clarence.collections;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ArrayMaxHeapTest {

    @Test
    public void insert() {
        ArrayHeap<Integer> heap = Heaps.integerMaxHeap();
        heap.insert(1);
        assertTrue(heap.validHeap());
        heap.insert(3);
        assertTrue(heap.validHeap());
        heap.insert(10);
        assertTrue(heap.validHeap());
        heap.insert(3);
        assertTrue(heap.validHeap());
        heap.insert(5);
        assertTrue(heap.validHeap());
        heap.insert(4);
        assertTrue(heap.validHeap());
        heap.insert(8);
        assertTrue(heap.validHeap());
        heap.insert(9);
        assertTrue(heap.validHeap());
        heap.insert(2);
        assertTrue(heap.validHeap());
        heap.insert(6);
        assertTrue(heap.validHeap());
        heap.insert(7);
        assertTrue(heap.validHeap());
        heap.insert(7);
        assertTrue(heap.validHeap());
    }

    @Test
    public void pop() {
        ArrayHeap<Integer> heap = Heaps.integerMaxHeap();
        heap.insert(1);
        heap.insert(3);
        heap.insert(3);
        heap.insert(9);
        heap.insert(8);
        heap.insert(7);
        heap.insert(6);

        assertTrue(heap.validHeap());
        assertTrue(9 == heap.pop());
        assertTrue(heap.validHeap());
        assertTrue(8 == heap.pop());
        assertTrue(heap.validHeap());
        assertTrue(7 == heap.pop());
        assertTrue(heap.validHeap());
        assertTrue(6 == heap.pop());
        assertTrue(heap.validHeap());
        assertTrue(3 == heap.pop());
        assertTrue(heap.validHeap());
        assertTrue(3 == heap.pop());
        assertTrue(heap.validHeap());
        assertTrue(1 == heap.pop());
        assertTrue(heap.validHeap());
    }

    @Test
    public void popDifferentInsertOrder() {
        ArrayHeap<Integer> heap = Heaps.integerMaxHeap();
        heap.insert(9);
        heap.insert(3);
        heap.insert(3);
        heap.insert(6);
        heap.insert(1);
        heap.insert(7);
        heap.insert(8);

        assertTrue(heap.validHeap());
        assertTrue(9 == heap.pop());
        assertTrue(heap.validHeap());
        assertTrue(8 == heap.pop());
        assertTrue(heap.validHeap());
        assertTrue(7 == heap.pop());
        assertTrue(heap.validHeap());
        assertTrue(6 == heap.pop());
        assertTrue(heap.validHeap());
        assertTrue(3 == heap.pop());
        assertTrue(heap.validHeap());
        assertTrue(3 == heap.pop());
        assertTrue(heap.validHeap());
        assertTrue(1 == heap.pop());
        assertTrue(heap.validHeap());
    }

    @Test
    public void popSame() {
        ArrayHeap<Integer> heap = Heaps.integerMaxHeap();
        heap.insert(1);
        heap.insert(1);
        heap.insert(1);
        heap.insert(1);
        heap.insert(1);
        heap.insert(1);
        heap.insert(1);

        assertTrue(heap.validHeap());
        assertTrue(1 == heap.pop());
        assertTrue(heap.validHeap());
        assertTrue(1 == heap.pop());
        assertTrue(heap.validHeap());
        assertTrue(1 == heap.pop());
        assertTrue(heap.validHeap());
        assertTrue(1 == heap.pop());
        assertTrue(heap.validHeap());
        assertTrue(1 == heap.pop());
        assertTrue(heap.validHeap());
        assertTrue(1 == heap.pop());
        assertTrue(heap.validHeap());
        assertTrue(1 == heap.pop());
        assertTrue(heap.validHeap());
    }

}
