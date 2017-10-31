package collections;

import java.util.Iterator;

public class MyStack<T> {
    private Node first;
    private int size;

    private class Node {
        T item;
        Node next;
    }

    public void remove(int index) {
        if (index >= size) { return; }
        if (index == 0) {
            first = first.next;
        } else {
            remove(first, index);
        }
        size--;
    }

    private void remove(Node head, int index) {
        if (index <= 1) {
            head.next = head.next.next;
        } else {
            remove(head.next, --index);
        }
    }

    public int size() {
        return size;
    }

    public void clear() {
        first = null;
        size = 0;
    }

    public T peek() {
        return first.item;
    }

    public void push(T item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        size++;
    }

    public T pop() {
        T item = first.item;
        first = first.next;
        size--;
        return item;
    }

    public void show() {
        show(first);
        System.out.println();
    }

    private void show(Node head) {
        if (head != null) {
            System.out.print(head.item + " ");
            show(head.next);
        }
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(3);
        stack.push(2);
        stack.push(6);
        for (int i = 0; i < 15; i++) {
            stack.push(i*5);
        }
        stack.show();
        stack.pop();
        stack.show();
        System.out.println(stack.peek());
        stack.remove(stack.size()-1);
        stack.show();
        stack.clear();
        stack.show();
    }
}
