package ng.clarence.utils;

import org.junit.Test;

import java.util.LinkedList;

public class MaxRectangleSumUnderHistogramTest {
    int sol = 0;

    @Test
    public void testit() {
        int[] h = new int[5];
        h[0] = 6;
        h[1] = 3;
        h[2] = 5;
        h[3] = 3;
        h[4] = 1;
        LinkedList<Element> ll = new LinkedList();
        for (int i = 0; i < h.length; i++) {
            drain(ll, h[i], i);
            ll.addFirst(new Element(i, h[i]));
        }
        drain(ll, -1, h.length);

        System.out.println(sol);
    }

    private void drain(LinkedList<Element> ll, int v, int i) {
        while (!ll.isEmpty() && ll.peekFirst().value > v) {
            Element e = ll.pollFirst();
            int area = e.value * (i - (ll.isEmpty() ? 0 : ll.peekFirst().index + 1));
            if (sol < area) {
                sol = area;
            }
        }
    }

    public class Element {
        public final int index;
        public final int value;

        public Element(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
