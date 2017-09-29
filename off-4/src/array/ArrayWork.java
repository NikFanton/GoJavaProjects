package array;

public class ArrayWork {

    public static void show(int arr[]) {
        System.out.print("[");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[arr.length - 1] + "]");
    }

    public static int getMaxIndex(int arr[]) {
        int i_max = 0;
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                i_max = i;
            }
        }
        return i_max;
    }

    public static int getMaxValue(int arr[]) {
        return arr[getMaxIndex(arr)];
    }


    public static long power(int x, int n) {
        if (n <= 0) return 1;
        return x*power(x, n - 1);
    }

    public static void showInterval(int a, int b) {
        for (int i = a; i <= b; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {3, 2, 5, 6, 3, 7, 2, 6, 2, 6};
        show(array);
        System.out.println("a[" + getMaxIndex(array) + "] = " + getMaxValue(array));
        System.out.println(power(2, 3));
        showInterval(1, 10);
    }
}
