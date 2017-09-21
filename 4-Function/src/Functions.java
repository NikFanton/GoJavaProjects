import java.util.Scanner;

public class Functions {

    public static void task1() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("X = ");
        int x = scanner.nextInt();
        for (int i = 1; i <= x; i++) {
            System.out.println(i);
        }

    }

    public static void drawRectangle(int height, int width) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("+");
            }
            System.out.println();
        }
    }

    public static void drawRectangle(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("+");
            }
            System.out.println();
        }
    }

    public static int getMax(int a, int b) {
        return (a > b) ? a : b;
    }

    public static float getMax(int a, float b) {
        return (a > b) ? a : b;
    }

    public static float getMax(float a, int b) {
        return (a > b) ? a : b;
    }

    public static float getMax(float a, float b) {
        return (a > b) ? a : b;
    }

    public static void task5() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("X = ");
        int x = scanner.nextInt();
        task5(1, x);
    }

    public static void task5(int i, int x) {
        if (i > x) return;
        System.out.println(i);
        task5(++i, x);
    }

    public static void main(String[] args) {
//        task1();
//        drawRectangle(3, 4);
//        drawRectangle(3);
//        System.out.println(getMax(2, (float) 2.9));
        task5();
    }
}
