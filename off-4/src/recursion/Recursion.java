package recursion;

public class Recursion {

    public static void taskA(int a) {
        taskA(a, 1);
        System.out.println(a);
    }

    public static void taskA(int a, int i) {
        if (i >= a) return;
        System.out.print(i + " ");
        taskA(a, ++i);
    }

    public static void taskB(int a, int b) {
        if (a == b) {
            System.out.println(a);
            return;
        }
        if (a < b) {
            System.out.print(a + " ");
            taskB(++a, b);
        } else {
            System.out.print(a + " ");
            taskB(--a, b);
        }
    }

    public static int taskC(int m, int n) {
        if (m == 0) {
            return n + 1;
        } else if (m > 0 && n == 0) {
            return taskC(m - 1, 1);
        } else {
            return taskC(m - 1, taskC(m, n - 1));
        }
    }

    public static void main(String[] args) {
        taskA(10);
        taskB(12, 4);
        System.out.println("Result of Akkerman function: " + taskC(1, 4));
    }
}
