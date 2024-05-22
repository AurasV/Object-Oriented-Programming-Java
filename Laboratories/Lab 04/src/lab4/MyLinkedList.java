package lab4;

import java.util.NoSuchElementException;

public class MyLinkedList<T> {
    private Node<T> first;
    private int size;

    public void add(T val) {
        if (first == null) {
            first = new Node<>(val);
        } else {
            Node<T> curr = first;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new Node<>(val);
        }
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node<T> curr = first;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.value;
    }

    public T remove() {
        if (size == 0) {
            throw new NoSuchElementException("List is empty");
        }
        if (size == 1) {
            T val = first.value;
            first = null;
            size--;
            return val;
        } else {
            Node<T> curr = first;
            while (curr.next.next != null) {
                curr = curr.next;
            }
            T val = curr.next.value;
            curr.next = null;
            size--;
            return val;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private static class Node<T> {
        Node<T> next;
        T value;

        public Node(T value) {
            this.value = value;
        }
    }
}
