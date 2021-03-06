package library;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Library {
    private static final int MAX_AMOUNT_OF_VISITORS = 12;
    private int peopleCount = 0;
    private Semaphore semaphore = new Semaphore(MAX_AMOUNT_OF_VISITORS);
    private Semaphore door = new Semaphore(1);

    private ArrayList<Visitor> visitors = new ArrayList<>();

    public Library(ArrayList<Visitor> v) {
        Random random = new Random();
        for (Visitor visitor : v) {
            final Visitor tmpVisitor = visitor;
            new Thread(() -> {
                try {
                    enter(tmpVisitor);
                    System.out.println(tmpVisitor.getName() + "\t" + tmpVisitor.getId() + " is reading a book");
                    Thread.sleep(random.nextInt(4000) + 1000);
                    leave(tmpVisitor);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        this.visitors = v;
        this.peopleCount = visitors.size();
    }

    public void enter(Visitor visitor) throws InterruptedException {
        System.out.println(visitor.getName() + "\t" + visitor.getId() + " trying to enter the library\t\t Available slots: "
                + semaphore.availablePermits());
        semaphore.acquire();
        crossTheDoorToInside(visitor);
        visitors.add(visitor);
        System.out.println(visitor.getName() + "\t" + visitor.getId() + " has entered\t\t\t\t\t\t Available slots: "
                + semaphore.availablePermits());
    }

    public void leave(Visitor visitor) throws InterruptedException {
        System.out.println(visitor.getName() + "\t" + visitor.getId() + " trying to leave the library\t\t Available slots: "
                + semaphore.availablePermits());
        visitors.remove(visitor);
        crossTheDoorToOutside(visitor);
        semaphore.release();
        System.out.println(visitor.getName() + "\t" + visitor.getId() + " has left the library\t\t\t\t Available slots: "
                + semaphore.availablePermits());
    }

    public void crossTheDoorToInside(Visitor visitor) throws InterruptedException {
        System.out.println(visitor.getName() + "\t" + visitor.getId() + "\t\t []-> went to the door from the street \t\t\t\t Available slots: "
                + door.availablePermits() + "\ttime: " + System.currentTimeMillis());
        door.acquire();
        System.out.println(visitor.getName() + "\t" + visitor.getId() + "\t\t []-> passing through the door to inside\t\t\t Available slots: "
                + door.availablePermits() + "\ttime: " + System.currentTimeMillis());
        Thread.sleep(500);
        door.release();
        System.out.println(visitor.getName() + "\t" + visitor.getId() + "\t\t []-> went through the door to inside\t\t\t\t Available slots: "
                + door.availablePermits() + "\ttime: " + System.currentTimeMillis());
    }

    public void crossTheDoorToOutside(Visitor visitor) throws InterruptedException {
        System.out.println(visitor.getName() + "\t" + visitor.getId() + "\t\t []<- went to the door from the inside \t\t\t\t Available slots: "
                + door.availablePermits() + "\ttime: " + System.currentTimeMillis());
        door.acquire();
        System.out.println(visitor.getName() + "\t" + visitor.getId() + "\t\t []<- passing through the door the street\t\t\t Available slots: "
                + door.availablePermits() + "\ttime: " + System.currentTimeMillis());
        Thread.sleep(500);
        door.release();
        System.out.println(visitor.getName() + "\t" + visitor.getId() + "\t\t []<- went through the door to the street\t\t\t Available slots: "
                + door.availablePermits() + "\ttime: " + System.currentTimeMillis());
    }

    public static void main(String[] args) {
        new Library(VisitorGenerator.generateVisitors(20));
    }
}
