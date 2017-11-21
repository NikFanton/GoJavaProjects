import java.util.ArrayList;
import java.util.concurrent.*;

public class ParallelCalculation {
    private final static int SIZE = 8000000;
    private ArrayList<Integer> numbers = new ArrayList<>();
    private static double result = 0.0;    // Expected result = 0.42161372625336324
    private ExecutorService threadPool = Executors.newFixedThreadPool(2);
    private static volatile int i = 0;
    private static Object lock = new Object();

    private FutureTask<Double> calcAllSin = new FutureTask<Double>(new Callable<Double>() {
        @Override
        public Double call() throws Exception {
            double res = 0.0;
            for (int x : numbers) {
                res += Math.sin(x);
            }
            return res;
        }
    });

    private FutureTask<Double> calcAllCos = new FutureTask<Double>(new Callable<Double>() {
        @Override
        public Double call() throws Exception {
            double res = 0.0;
            for (int x : numbers) {
                res += Math.cos(x);
            }
            return res;
        }
    });

    private FutureTask<Double> calcSin = new FutureTask<Double>(new Callable<Double>() {
        @Override
        public Double call() throws Exception {
            return Math.sin(numbers.get(i));
        }
    });

    private FutureTask<Double> calcCos = new FutureTask<Double>(new Callable<Double>() {
        @Override
        public Double call() throws Exception {
            return Math.cos(numbers.get(i));
        }
    });

    public void simpleCalculation() {
        System.out.println("=== Simple Calc ===");
        for (int x : numbers) {
            result += Math.sin(x) + Math.cos(x);
        }
    }

    public void simpleMultithreadingCalcViaPool() throws ExecutionException, InterruptedException {
        System.out.println("=== Simple Multithreading Calc Via Pool ===");
        threadPool.submit(calcSin);
        threadPool.submit(calcCos);
        double resSin = 0.0, resCos = 0.0;
        for (i = 0; i < SIZE; i++) {
            synchronized (lock) {
                resSin = calcSin.get();
                resCos = calcCos.get();
//                System.out.println("sin: " + resSin + " cos: " + resCos);
            }
            result += resSin;
            result += resCos;
        }
    }

    public void multithreadingCalcViaPool() throws ExecutionException, InterruptedException {
        System.out.println("=== Multithreading CalcViaPool ===");
        threadPool.submit(calcAllSin);
        threadPool.submit(calcAllCos);
        result += (double) (calcAllSin.get());
        result += (double) (calcAllCos.get());
    }

    public void startCalculation() throws ExecutionException, InterruptedException {
        double time;

        time = System.currentTimeMillis();
        simpleCalculation();
        time = -(time - System.currentTimeMillis()) / 1000.;
        System.out.println("Time: " + time);
        System.out.println(result);

        result = 0.0;
        time = System.currentTimeMillis();
        simpleMultithreadingCalcViaPool();
        time = -(time - System.currentTimeMillis()) / 1000.;
        System.out.println("Time: " + time);
        System.out.println(result);

        result = 0.0;
        time = System.currentTimeMillis();
        multithreadingCalcViaPool();
        time = -(time - System.currentTimeMillis()) / 1000.;
        System.out.println("Time: " + time);
        System.out.println(result);

        threadPool.shutdown();
    }

    public ParallelCalculation() {
        System.out.println("=== Initialization started ===\n.\n.\n.");
        for (int i = 1; i <= SIZE; i++) {
            numbers.add(i);
        }
        System.out.println("=== Initialization complete ===");
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ParallelCalculation calculation = new ParallelCalculation();
        calculation.startCalculation();
    }
}
