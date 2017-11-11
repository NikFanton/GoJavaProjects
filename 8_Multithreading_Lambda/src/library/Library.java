package library;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Library {
    private static final int MAX_AMOUNT_OF_VISITORS = 12;
    private int peopleCount = 0;
    private Semaphore semaphore = new Semaphore(MAX_AMOUNT_OF_VISITORS);

    private ArrayList<Visitor> visitors = new ArrayList<>();

    public Library(ArrayList<Visitor> v) {
        this.visitors = v;
        this.peopleCount = visitors.size();

        Random random = new Random();
        for (Visitor visitor : v) {
            Visitor tmpVisitor = visitor;
            new Thread(() -> {
                try {
                    enter(tmpVisitor);
                    System.out.println(visitor.getName() + "\t" + visitor.getId() + " is reading a book");
                    Thread.sleep(random.nextInt(4000) + 1000);
                    leave(tmpVisitor);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public void enter(Visitor visitor) throws InterruptedException {
        System.out.println(visitor.getName() + "\t" + visitor.getId() + " trying to enter the library\t\t Available slots: "
                + semaphore.availablePermits());
        semaphore.acquire();
        visitors.add(visitor);
        System.out.println(visitor.getName() + "\t" + visitor.getId() + " has entered\t\t\t\t\t\t Available slots: "
                + semaphore.availablePermits());
    }

    public void leave(Visitor visitor) throws InterruptedException {
        System.out.println(visitor.getName() + "\t" + visitor.getId() + " trying to leave the library\t\t Available slots: "
                + semaphore.availablePermits());
        visitors.remove(visitor);
        semaphore.release();
        System.out.println(visitor.getName() + "\t" + visitor.getId() + " has left the library\t\t\t\t Available slots: "
                + semaphore.availablePermits());
    }

    public static void main(String[] args) {
        new Library(VisitorGenerator.generateVisitors(20));
    }
}
