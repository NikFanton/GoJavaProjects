package array;

import java.util.Objects;
import java.util.Scanner;

public class Array<Item extends Comparable<Item>> {

    private Item arr[];
    private int size;

    Array(int size) {
        arr = (Item[]) new Comparable[size];
        this.size = size;
    }

    public void setElement(Item value, int i) {
        arr[i] = value;
    }

    public Item getElement(int i) {
        return arr[i];
    }

    public int getSize() {
        return this.size;
    }

    public void show() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public Item getMin() {
        Item min = arr[0];
        for (int i = 1; i < size; i++) {
            if (arr[i].compareTo(min) < 0) {
                min = arr[i];
            }
        }
        return min;
    }

    public Item getMax() {
        Item max = arr[0];
        for (int i = 1; i < size; i++) {
            if (arr[i].compareTo(max) > 0) {
                max = arr[i];
            }
        }
        return max;
    }

    public void sortArray() {
        int right = size;
        int left = 0;
        boolean check = true;
        while (right >= left && check) {
            check = false;
            for (int i = left; i < right-1; i++) {
                if (arr[i].compareTo(arr[i+1]) > 0) {
                    Item temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    check = true;
                }
            }
            right--;

            if (check) {
                for (int i = right-1; i > left; i--) {
                    if (arr[i-1].compareTo(arr[i]) > 0) {
                        Item temp = arr[i];
                        arr[i] = arr[i-1];
                        arr[i-1] = temp;
                        check = true;
                    }
                }
            }
            left++;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Array array = new Array(in.nextInt());
        for (int i = 0; i < array.getSize(); i++) {
            array.setElement(in.nextDouble(), i);
        }
        array.show();
        System.out.println("Min: " + array.getMin());
        System.out.println("Max: " + array.getMax());

        int cnt = 0;
        for (int i = 0; i < array.getSize(); i++) {
            if (array.getElement(i).compareTo(5.0) == 0) {
                cnt++;
            }
        }
        System.out.println("There are " + cnt + " elements with value \"5\" in array.");
        array.sortArray();
        array.show();

    }

}
