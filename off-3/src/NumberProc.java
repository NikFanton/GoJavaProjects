import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberProc {

    public static void task1() {
        Scanner scanner = new Scanner(System.in);
        String strA = scanner.next();
        String strB = scanner.next();
        int a = Integer.parseInt(strA);
        int b = Integer.parseInt(strB);

        for (int i = strA.length() - 1; i >= 0; i--) {
            System.out.print(strA.charAt(i));
        }
        System.out.println();
        for (int i = strB.length() - 1; i >= 0; i--) {
            System.out.print(strB.charAt(i));
        }

        System.out.println();
        while (a % 10 != 0) {
            System.out.print(a % 10);
            a /= 10;
        }

        System.out.println();
        while (b % 10 != 0) {
            System.out.print(b % 10);
            b /= 10;
        }
    }

    public static void task2() {
        Scanner scanner = new Scanner(System.in);
        int arr[] = inputArray(scanner);
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void task3() {
        // Scanning arrays
        Scanner scanner = new Scanner(System.in);
        int arrA[] = inputArray(scanner);
        int arrB[] = inputArray(scanner);

        // Summary
        int arrC[] = arrA.length > arrB.length ? arrA : arrB;
        int min[] = arrA.length < arrB.length ? arrA : arrB;
        for (int i = 0; i < min.length; i++) {
            arrC[i] += min[i];
        }

        // Printing array
        for (int j = 0; j < arrC.length; j++) {
            System.out.print(arrC[j] + " ");
        }
    }

    public static void task4() {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int arr[] = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = scanner.nextInt();
        }
        int right = length - 1;
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
                if (arr[i-1] > (arr[i])) {
                    int temp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = temp;
                }
            }
            left++;
        }

        for (int i = length - 1; i >= 0 ; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
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

    public static void main(String[] args) {
        //inputArray();
//        task1();
//        task2();
        task3();
//        task4();
    }
}
