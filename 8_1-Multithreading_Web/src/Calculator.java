import java.util.Scanner;
import java.util.concurrent.*;

public class Calculator {
    public double a;
    public double b;
    public String operator;

    ExecutorService threadPool = Executors.newFixedThreadPool(1);
    Future<Double> future;

    public double calculate(double a, double b, String operator) throws ExecutionException, InterruptedException {
        this.a = a;
        this.b = b;
        this.operator = operator;

        future = threadPool.submit(new Callable<Double>() {
            @Override
            public Double call() throws Exception {
                double result = 0.0;
                if (operator.equals("+")) {
                    result = a + b;
                } else if (operator.equals("-")) {
                    result = a - b;
                } else if (operator.equals("*")) {
                    result = a * b;
                } else if (operator.equals("/")) {
                    result = a / b;
                } else if (operator.equals("%")) {
                    result = a % b;
                } else if (operator.equals("==")) {
                    result = (a == b) ? 1 : 0;
                } else if (operator.equals(">")) {
                    result = (a > b) ? 1 : 0;
                } else if (operator.equals("<")) {
                    result = (a < b) ? 1 : 0;
                } else {
                    return 0.0;
                }
                return result;
            }
        });

        double result = future.get();
        return result;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        double a, b;
        String operator;
        boolean user = false;
        do {
            System.out.print("Enter expression: ");
            a = scanner.nextDouble();
            operator = scanner.next();
            b = scanner.nextDouble();
            System.out.println(a + " " +operator + " " + b + " = " + calculator.calculate(a, b, operator));
            System.out.println("Do you want to exit (yes/no): ");
            user = scanner.next().equals("yes");
        } while (!user);
        calculator.threadPool.shutdown();
    }
}
