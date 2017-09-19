package array;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AutoSizeArray {

    public int arr[];

    AutoSizeArray() {
        Scanner scanner = new Scanner(System.in);
        arr = inputArray(scanner);
    }

    public static int[] inputArray(Scanner scanner) {
        String str = scanner.nextLine();
        Pattern pat=Pattern.compile("\\d+");
        Matcher matcher=pat.matcher(str);
        int cnt = 0;
        while (matcher.find()) { cnt++; };
        int arr[] = new int[cnt];

        int i = 0;
        matcher = pat.matcher(str);
        while (matcher.find()) {
            arr[i] = Integer.parseInt(matcher.group());
            i++;
        };
        return arr;
    }


    public void setElement(int value, int i) {
        arr[i] = value;
    }

    public int getElement(int i) {
        return arr[i];
    }

    public int getSize() {
        return arr.length;
    }

    public void show() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public int getMin() {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public int getMax() {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public void sortArray() {
        int right = arr.length - 1;
        int left = 0;
        while (right >= left) {
            for (int i = left; i < right; i++) {
                if (arr[i] > arr[i+1]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
            right--;

            for (int i = right; i > left; i--) {
                if (arr[i-1] > arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = temp;
                }
            }
            left++;
        }
    }

    public int getGreatestNumOfTheSameElements() {
        sortArray();
        int max = 0;
        int cnt = 1;
        if (arr.length <= 1) { return arr.length; }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i-1]) {
                cnt++;
            } else {
                if (cnt > max) { max = cnt; }
                cnt = 1;
            }
            if (i == arr.length - 1 && cnt > max) { max = cnt; }
        }
        return max;
    }

    public int getLeastNumOfTheSameElements() {
        sortArray();
        int min = arr.length;
        int cnt = 1;
        if (arr.length == 1) { return 1; }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i-1]) {
                cnt++;
            } else {
                if (cnt < min) { min = cnt; }
                cnt = 1;
            }
            if (i == arr.length - 1 && cnt < min) { min = cnt; }
        }
        return min;
    }

    public static void main(String[] args) {
        AutoSizeArray array = new AutoSizeArray();
        int iterator = 0;

        array.show();
        System.out.println("Min: " + array.getMin());
        System.out.println("Max: " + array.getMax());

        int cnt = 0;
        for (int i = 0; i < array.getSize(); i++) {
            if (array.getElement(i) == 5.0) {
                cnt++;
            }
        }
        System.out.println("There are " + cnt + " elements with value \"5\" in array.");
        array.sortArray();
        array.show();

        System.out.println("Max number of the same items: " + array.getGreatestNumOfTheSameElements());
        System.out.println("Min number of the same items: " + array.getLeastNumOfTheSameElements());
    }
}
