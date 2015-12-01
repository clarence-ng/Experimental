package ng.clarence.collections;

public class ArrayBackedQueue {

    private final int[] data;

    private int length;
    private int start;
    private int end;

    public ArrayBackedQueue(int size) {
        data = new int[size];
    }

    public boolean append(int value) {
        if (end == start && length == data.length) {
            return false;
        }
        data[end++] = value;
        end = end % data.length;
        length++;
        return true;
    }

    public Integer removeFirst() {
        if (length == 0) {
            return null;
        }
        int retValue = data[start++];
        start = start % data.length;
        length--;
        return retValue;
    }
}