import java.util.Scanner;

public class Functions {

    public static void task1(int x) {
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

    public static void task5(int x) {
        task5(1, x);
    }

    public static void task5(int i, int x) {
        if (i > x) return;
        System.out.println(i);
        task5(++i, x);
    }

    public static void task6(int height, int width) {
        task6(height, width, 0, 0);
    }

    public static void task6(int height, int width, int i, int j) {
        if (j >= width) {
            System.out.println();
            j = 0;
            i++;
        }

        if (i >= height) {
            return;
        }
        j++;
        System.out.print("+");
        task6(height, width, i, j);
    }

    public static void task7() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        int flag;
        do {
            do {
                System.out.print("Which task do you want to run (1-6): ");
                choice = scanner.nextInt();
            } while (choice < 1 || choice > 6);

            switch (choice) {
                case 1:
                    System.out.print("X = ");
                    int x = scanner.nextInt();
                    task1(x);
                    break;
                case 2:
                    System.out.print("Height = ");
                    int height = scanner.nextInt();
                    System.out.print("Width = ");
                    int width = scanner.nextInt();
                    drawRectangle(height, width);
                    break;
                case 3:
                    System.out.print("Size = ");
                    int size = scanner.nextInt();
                    drawRectangle(size);
                    break;
                case 4:
                    System.out.print("A = ");
                    float a = scanner.nextFloat();
                    System.out.print("B = ");
                    float b = scanner.nextFloat();
                    System.out.println("max: " + getMax(a, b));
                    break;
                case 5:
                    System.out.print("X = ");
                    int x_recursion = scanner.nextInt();
                    task5(x_recursion);
                    break;
                case 6:
                    System.out.print("Height = ");
                    int heightRecursion = scanner.nextInt();
                    System.out.print("Width = ");
                    int widthRecursion = scanner.nextInt();
                    task6(heightRecursion, widthRecursion);
                    break;
            }
            System.out.print("Would you like to continue(1 - yes): ");
            flag = scanner.nextInt();
        } while (flag == 1);
    }

    public static void main(String[] args) {
        task7();
    }
}
