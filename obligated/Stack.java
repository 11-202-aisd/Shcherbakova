public class Stack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] data;
    private int size;

    public Stack() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public Stack(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public void push(T element) {
        if (size == data.length) {
            resize(2 * data.length);
        }
        data[size] = element;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T element = data[size - 1];
        data[size - 1] = null;
        size--;
        if (size > 0 && size == data.length / 4) {
            resize(data.length / 2);
        }
        return element;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return data[size - 1];
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
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }
}
