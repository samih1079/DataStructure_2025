package ds;

public class Queue<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * Inserts an element into the queue.
     * @param element The element to insert.
     */
    public void insert(T element) {
        Node<T> node = new Node<>(element);
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    /**
     * Removes the head element from the queue.
     * @returns The removed element, or null if the queue is empty.
     */
    public T remove() {
        if (head == null) {
            return null;
        }
        T value = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return value;
    }

    /**
     * Checks if the queue is empty.
     * @returns True if the queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the head element of the queue without removing it.
     * @returns The head element, or null if the queue is empty.
     */
    public T head() {
        return head == null ? null : head.value;
    }
}