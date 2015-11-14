package ng.clarence.collections;

import java.util.Comparator;

public class Heaps {

    public static ArrayHeap<Integer> integerMinHeap() {
        return new ArrayHeap<Integer>(new Integer[100], new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
    }

    public static ArrayHeap<Integer> integerMaxHeap() {
        return new ArrayHeap<Integer>(new Integer[100], new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }
}
