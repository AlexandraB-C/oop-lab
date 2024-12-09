package lab3.Queue_1;

public interface Queue<T> {
    void enqueue(T item);
    T dequeue();
    boolean isEmpty();
    int size();
}
