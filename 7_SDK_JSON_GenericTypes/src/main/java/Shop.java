import com.alibaba.fastjson.JSON;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Shop {
    private final static long MILLISECOND_CONVERSION_FACTOR = 86_400_000L;

    private Storage storage = new Storage();

    public Shop() throws IOException {
        load("files/data.json");
        show();
//        addFruits("files/delivery1.json");
//        show();
//        addFruits("files/delivery2.json");
//        show();
        save("files/data.json");
    }

    public void addFruits(String pathToJsonFile) throws FileNotFoundException {
        String json = new Scanner(new File(pathToJsonFile)).useDelimiter("\\Z").next();
        Storage tmp = JSON.parseObject(json, Storage.class);
        for (Fruit fruit : tmp.fruits) {
            storage.fruits.add(fruit);
        }
    }

    public void save(String pathToJsonFile) throws IOException {
        FileWriter writer = new FileWriter(pathToJsonFile);
        writer.write(JSON.toJSONString(storage));
        writer.flush();
    }

    public void load(String pathToJsonFile) throws FileNotFoundException {
        String json = new Scanner(new File(pathToJsonFile)).useDelimiter("\\Z").next();
        storage = JSON.parseObject(json, Storage.class);
    }

    public List<Fruit> getSpoiledFruits(Date date) {
        LinkedList<Fruit> spoiledFruit = new LinkedList<>();
        for (Fruit fruit : storage.fruits) {
            if (fruit.getDeliveryDate().getTime() + MILLISECOND_CONVERSION_FACTOR * fruit.getShelfTime() < date.getTime()) {
                spoiledFruit.add(fruit);
            }
        }
        return spoiledFruit;
    }

    public List<Fruit> getAvailableFruits(Date date) {
        LinkedList<Fruit> availableFruits = new LinkedList<>();
        for (Fruit fruit : storage.fruits) {
            if (fruit.getDeliveryDate().getTime() + MILLISECOND_CONVERSION_FACTOR * fruit.getShelfTime() >= date.getTime()) {
                availableFruits.add(fruit);
            }
        }
        return availableFruits;
    }

    public List<Fruit> getSpoiledFruits(Date date, TypeOfFruit type) {
        LinkedList<Fruit> spoiledFruit = new LinkedList<>();
        for (Fruit fruit : storage.fruits) {
            if (fruit.getDeliveryDate().getTime() + MILLISECOND_CONVERSION_FACTOR * fruit.getShelfTime() < date.getTime()
                    && fruit.getTypeOfFruit() == type) {
                spoiledFruit.add(fruit);
            }
        }
        return spoiledFruit;
    }

    public List<Fruit> getAvailableFruits(Date date, TypeOfFruit type) {
        LinkedList<Fruit> availableFruits = new LinkedList<>();
        for (Fruit fruit : storage.fruits) {
            if (fruit.getDeliveryDate().getTime() + MILLISECOND_CONVERSION_FACTOR * fruit.getShelfTime() >= date.getTime()
                    && fruit.getTypeOfFruit() == type) {
                availableFruits.add(fruit);
            }
        }
        return availableFruits;
    }

    public List<Fruit> getAddedFruits(Date date) {
        LinkedList<Fruit> addedFruits = new LinkedList<>();
        for (Fruit fruit : storage.fruits) {
            if (fruit.getDeliveryDate().equals(date)) {
                addedFruits.add(fruit);
            }
        }
        return addedFruits;
    }

    public List<Fruit> getAddedFruits(Date date, TypeOfFruit type) {
        LinkedList<Fruit> addedFruits = new LinkedList<>();
        for (Fruit fruit : storage.fruits) {
            if (fruit.getDeliveryDate().equals(date) && fruit.getTypeOfFruit() == type) {
                addedFruits.add(fruit);
            }
        }
        return addedFruits;
    }

    public void show() {
        System.out.println(storage);
    }

    public static void main(String[] args) {
        try {
            Shop shop = new Shop();
            Date date = new Date(2017, 11, 8);
            System.out.println("========== SPOILED FRUITS ===========");
            LinkedList<Fruit> spoiledFruits = (LinkedList<Fruit>) shop.getSpoiledFruits(date, TypeOfFruit.MELON);
            for (Fruit fruit : spoiledFruits) {
                System.out.println(fruit);
            }
            System.out.println("========= AVAILABLE FRUITS ==========");
            LinkedList<Fruit> availableFruits = (LinkedList<Fruit>) shop.getAvailableFruits(date, TypeOfFruit.LEMON);
            for (Fruit fruit : availableFruits) {
                System.out.println(fruit);
            }
            System.out.println("=========== ADDED FRUITS ============");
            LinkedList<Fruit> addedFruits = (LinkedList<Fruit>) shop.getAddedFruits(
                    new Date(2017, 11, 1), TypeOfFruit.WATERMELON);
            for (Fruit fruit : addedFruits) {
                System.out.println(fruit);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
