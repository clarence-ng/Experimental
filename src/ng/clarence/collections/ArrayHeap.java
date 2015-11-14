package ng.clarence.collections;

import java.util.Comparator;
import java.util.LinkedList;

public class ArrayHeap<T> implements Heap<T> {
    private final T[] values;
    private final Comparator<T> comparator;
    private int heapSize = 0;

    ArrayHeap(T[] values, Comparator<T> comparator) {
        this.values = values;
        this.comparator = comparator;
    }

    @Override
    public void insert(T value) {
        values[heapSize] = value;
        int current = heapSize;
        while (current > 0) {
            int parent = getParentIndex(current);
            if (comparator.compare(values[parent], values[current]) > 0 ) {
                swapValuesAt(parent, current);
                current = parent;
            } else {
                break;
            }
        }
        heapSize += 1;
    }

    @Override
    public T pop() {
        if (heapSize == 0) {
            return null;
        }
        T result = values[0];
        swapValuesAt(0, heapSize - 1);
        values[heapSize - 1] = null;
        heapSize -= 1;

        int current = 0;
        while(current < heapSize) {
            int leftChildIndex = getLeftChild(current);
            int rightChildIndex = getRightChild(current);
            if (leftChildIndex >= heapSize) {
                break;
            } else if (rightChildIndex >= heapSize) {
                if (comparator.compare(values[current], values[leftChildIndex]) > 0) {
                    swapValuesAt(current, leftChildIndex);
                }
                break;
            } else {
                if (comparator.compare(values[current], values[leftChildIndex]) > 0 ||
                        comparator.compare(values[current], values[rightChildIndex]) > 0) {
                    if (comparator.compare(values[leftChildIndex], values[rightChildIndex]) < 0) {
                        swapValuesAt(current, leftChildIndex);
                        current = leftChildIndex;
                    } else {
                        swapValuesAt(current, rightChildIndex);
                        current = rightChildIndex;
                    }
                } else {
                    break;
                }
            }
        }
        return result;
    }

    private int getParentIndex(int i) {
        return (i - 1) / 2;
    }

    private int getLeftChild(int index) {
        int result = index * 2 + 1;
        return result;
    }

    private int getRightChild(int index) {
        int result = index * 2 + 2;
        return result;
    }

    @Override
    public boolean validHeap() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        while (!list.isEmpty()) {
            int index = list.removeFirst();
            int left = getLeftChild(index);
            int right = getRightChild(index);
            if (left < heapSize) {
                if (comparator.compare(values[index], values[left]) > 0) {
                    return false;
                }
                list.add(left);
            }
            if (right < heapSize) {
                if (comparator.compare(values[index], values[left]) > 0) {
                    return false;
                }
                list.add(right);
            }
        }
        return true;
    }

    private void swapValuesAt(int parent, int i) {
        T temp = values[parent];
        values[parent] = values[i];
        values[i] = temp;
    }
}
