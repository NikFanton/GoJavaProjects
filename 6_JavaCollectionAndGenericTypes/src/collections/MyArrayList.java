package collections;


public class MyArrayList<T> {
    private T[] data = (T []) new Object[10];
    private int size = 0;

    private void resize(int newSize) {
        T[] tmp = (T[]) new Object[newSize];
        System.arraycopy(data, 0, tmp, 0, size);
        data = tmp;
    }

    public void add(T value) {
        if (size >= data.length) {
            resize(2*data.length);
        }
        data[size++] = value;
    }

    public void remove(int index) {
        for (int i = index; i < size-1; i++) {
            data[i] = data[i+1];
        }
        size--;
    }

    public void clear() {
        data = (T[]) new Object[10];
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        return data[index];
    }

    public static void main(String[] args) {
        MyArrayList arrayList = new MyArrayList();
        for (int i = 0; i < 20; i++) {
            arrayList.add(i);
        }
        System.out.println("size: " + arrayList.size);
        System.out.println("Element " + arrayList.get(arrayList.size() - 1) + " will be removed");
        arrayList.remove(arrayList.size() - 1);
        System.out.println("size: " + arrayList.size);
        arrayList.clear();
        System.out.println("size: " + arrayList.size);
        for (int i = 0; i < 15; i++) {
            arrayList.add(i*5);
        }
        System.out.println("Element " + arrayList.get(arrayList.size() - 1) + " will be removed");
        System.out.println("Element " + arrayList.get(5) + " will be removed");
        arrayList.remove(arrayList.size() - 1);
        System.out.println("size: " + arrayList.size);
    }
}