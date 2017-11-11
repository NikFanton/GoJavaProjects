package library;


import java.util.ArrayList;
import java.util.Random;

public class VisitorGenerator {
    private static Random random = new Random();
    private final static int MIN_ID = 100;
    private final static int MAX_ID = 100000;

    public static int randomID() {
        return (random.nextInt(MAX_ID - MIN_ID) + MIN_ID);
    }

    public static String randomName() {
        return ("Visitor-" + random.nextInt(1000));
    }

    public static ArrayList<Visitor> generateVisitors(int count) {
        ArrayList<Visitor> visitors = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            visitors.add(new Visitor(VisitorGenerator.randomName(), VisitorGenerator.randomID()));
        }
        return visitors;
    }
}
