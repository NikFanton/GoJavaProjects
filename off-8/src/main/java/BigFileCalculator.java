import com.alibaba.fastjson.JSON;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class BigFileCalculator {
    private final static String FILE = "10 000 000 Numbers.txt";
    private final static String PATH = "src\\main\\resources\\" + FILE;
    private ArrayList<Integer> bigArray;
    private Semaphore semaphore = new Semaphore(1);

    public BigFileCalculator() {
        try {
            System.out.println("--- File loading ---");
            load();
            System.out.println("--- File loaded---");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            System.out.println("Summary try to start");
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Summary has started calculating");
            System.out.println("Summary: " + summary());
            System.out.println("Summary has finished calculating");
            semaphore.release();
        }).start();

        new Thread(() -> {
            System.out.println("Summary of divided try to start");
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Summary of divided has started calculating");
            System.out.println("Summary of divided: " + sumOfDivided());
            System.out.println("Summary of divided has finished calculating");
            semaphore.release();
        }).start();

        new Thread(() -> {
            System.out.println("Subtraction try to start");
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Subtraction has started calculating");
            System.out.println("Subtraction: " + subtraction());
            System.out.println("Subtraction has finished calculating");
            semaphore.release();
        }).start();

    }

    void load() throws FileNotFoundException {
        String json = new Scanner(new File(PATH)).useDelimiter("\\Z").next();
        bigArray = JSON.parseObject(json, ArrayList.class);
    }

    public long summary() {
        long sum = 0;
        for (int i = 0; i < bigArray.size(); i++) {
            sum += bigArray.get(i);
        }
        return sum;
    }

    public BigInteger multiply() {
        BigInteger multiply = new BigInteger("1");
        for (int i = 0; i < bigArray.size(); i++) {
            multiply = multiply.multiply(BigInteger.valueOf(bigArray.get(i)));
        }
        return multiply;
    }

    public double sumOfDivided() {
        double sum = 0;
        for (int i = 0; i < bigArray.size(); i++) {
            sum += bigArray.get(i)/(i + 1);
        }
        return sum;
    }

    public long subtraction() {
        long sum = bigArray.get(0);
        for (int i = 1; i < bigArray.size(); i++) {
            sum -= bigArray.get(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        new BigFileCalculator();
    }
}
