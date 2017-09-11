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
        System.out.println("a equals b" + (a == b));
        System.out.println("a divided b without remainder" + (a % b == 0));
        System.out.println("a larger then b" + (a > b));
    }

    public static void findMinMaxMid(double a, double b, double c) {
        double min = a, max = a, mid = a;
        if (b > max) {
            max = b;
            if (c > max) { max = c; }
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
        System.out.println("a == max: " + (a == max));
        System.out.println("b == max: " + (b == max));
        System.out.println("c == max: " + (c == max));

        System.out.println("a == min: " + (a == min));
        System.out.println("b == min: " + (b == min));
        System.out.println("c == min: " + (c == min));

        System.out.println("a == mid: " + (a == mid));
        System.out.println("b == mid: " + (b == mid));
        System.out.println("c == mid: " + (c == mid));
    }

    public static void compareThreeNumbers(double a, double b, double c) {
        System.out.println("a larger then at least one another: " + (a == b || a == c));
        System.out.println("b larger then at least one another: " + (b == a || b == c));
        System.out.println("c larger then at least one another: " + (c == a || c == b));

        System.out.println("a equals then at least one another: " + (a > b || a > c));
        System.out.println("b larger then at least one another: " + (b > a || b > c));
        System.out.println("c larger then at least one another: " + (c > a || c > b));
    }

    public static void main(String[] args) {
        double a, b, c;
        Scanner in = new Scanner(System.in);
        a = in.nextDouble();
        b = in.nextDouble();
        c = in.nextDouble();

        showSum(a, b);
        System.out.println("---------------------");
        System.out.println("Rectangle space: " + rectangle(a, b));
        System.out.println(triangle(a, b, c));
        compareNumbers(a, b);
        findMinMaxMid(a, b, c);
        compareThreeNumbers(a, b, c);
    }
}
