package ng.clarence.collections;

public interface Heap<T> {
    void insert(T value);

    T pop();

    boolean validHeap();
}
