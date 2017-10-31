package collections;

public class MyLinkedList<T> {

    private Node first;
    private int size = 0;

    private class Node {
        T item;
        Node next;
    }

    public void add(T value) {
        if (first == null) {
            first = new Node();
            first.item = value;
            first.next = null;
        } else {
            add(first, value);
        }
        size++;
    }

    private void add(Node head, T value) {
        if (head.next != null) {
            add(head.next, value);
        } else {
            Node newNode = new Node();
            newNode.item = value;
            newNode.next = null;
            head.next = newNode;
        }
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

    public void clear() {
        first = null;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index == 0) {
            return first.item;
        }
        return get(first, index);
    }

    private T get(Node head, int index) {
        for (int i = 0; i < index; i++) {
            head = head.next;
        }
        return head.item;
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
        MyLinkedList linkedList = new MyLinkedList();
        for (int i = 0; i < 10; i++) {
            linkedList.add(i*5);
        }
        linkedList.show();
        System.out.println("size: " + linkedList.size);
        System.out.println("Element " + linkedList.get(2) + " will be removed");
        linkedList.remove(2);
        linkedList.show();
        System.out.println("Element " + linkedList.get(0) + " will be removed");
        linkedList.remove(0);
        linkedList.show();
        System.out.println("Element " + linkedList.get(linkedList.size()-1) + " will be removed");
        linkedList.remove(linkedList.size()-1);
        linkedList.show();
        linkedList.clear();
        for (int i = 0; i < 15; i++) {
            linkedList.add(i*5);
        }
        linkedList.show();
    }
}
