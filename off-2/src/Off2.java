import java.util.Scanner;

public class Off2 {
    public static void showSum(double a, double b) {
        System.out.println(a + " + " + b + " = " + (a + b));
    }

    public static double rectangle(double a, double b) {
        return a*b;
    }

    public static double triangle(double a, double b, double c) {
        double p = (a + b + c)/2;
        return java.lang.Math.sqrt(p*(p - a)*(p - b)*(p - c));
    }

    public static void compareNumbers(double a, double b) {
        System.out.println(a == b);
        System.out.println(a % b == 0);
        System.out.println(a > b);
    }

    public static void findMinMaxMid(double a, double b, double c) {
        double min = a, max = a, mid = a;
        if (b > max) {
            max = b;
            if (c > max) {
                max = c;
            }
        } else if (c > max) {
            max = c;
        }

        if (b < min) {
            min = b;
            if (c < min) {
                min = c;
            }
        } else if (c < min) {
            min = c;
        }

        if ((a > b && a < c) || (a < b && a > c)) {
            mid = a;
        } else if ((b > a && b < c) || (b < a && b > c)) {
            mid = b;
        } else {
            mid = c;
        }

        System.out.println("Max: " + max + "\nMin: " + min+ "\nMid: " + mid );
        System.out.println(a == max);
        System.out.println(b == max);
        System.out.println(c == max);

        System.out.println(a == min);
        System.out.println(b == min);
        System.out.println(c == min);

        System.out.println(a == mid);
        System.out.println(b == mid);
        System.out.println(c == mid);
    }

    public static void main(String[] args) {
        double a, b, c;
        Scanner in = new Scanner(System.in);
        a = in.nextDouble();
        b = in.nextDouble();
        c = in.nextDouble();

        showSum(a, b);
        System.out.println("Rectangle space: " + rectangle(a, b));
        System.out.println(triangle(a, b, c));
        compareNumbers(a, b);
        findMinMaxMid(a, b, c);
    }
}
