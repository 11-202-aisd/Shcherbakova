public class Queue<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] data;
    private int size;
    private int front;
    private int rear;

    public Queue() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public Queue(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
        front = 0;
        rear = -1;
    }

    public void enqueue(T element) {
        if (size == data.length) {
            resize(2 * data.length);
        }
        rear = (rear + 1) % data.length;
        data[rear] = element;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T element = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size > 0 && size == data.length / 4) {
            resize(data.length / 2);
        }
        return element;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return data[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void resize(int capacity) {
        @SuppressWarnings("unchecked")
        T[] newData = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        rear = size - 1;
    }
}
