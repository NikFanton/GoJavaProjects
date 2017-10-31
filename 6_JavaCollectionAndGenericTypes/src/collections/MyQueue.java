package collections;

public class MyQueue<T> {
    private Node first;
    private Node last;
    private int size;

    private class Node {
        T item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size(){
        return size;
    }

    public void remove(int index) {
        if (index >= size) { return; }
        if (index == 0) {
            first = first.next;
        } else if (index == size - 1) {
                Node tmp = first;
                while (tmp.next != last) {
                    tmp = tmp.next;
                }
                last = tmp;
                tmp.next = null;
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
        size = 0;
    }

    public T peek() {
        return first.item;
    }

    public void add(T item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        }
        else {
            oldLast.next = last;
        }
        size++;
    }

    public T poll() {
        T item = first.item;
        first = first.next;
        if (isEmpty())  last = null;
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
        MyQueue queue = new MyQueue();
        queue.add(5);
        queue.add(2);
        queue.add(3);
        queue.add(10);
        queue.add(20);
        queue.show();
        queue.poll();
        queue.show();
        queue.add(30);
        queue.show();
        queue.poll();
        queue.show();
        queue.clear();
        for (int i = 0; i < 15; i++) {
            queue.add(i*5);
        }
        queue.show();
        System.out.println(queue.size());
        queue.remove(queue.size() - 1);
        queue.show();
        queue.add(6);
        queue.show();
    }
}
