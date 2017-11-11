package company;

import com.alibaba.fastjson.JSON;
import company.dataformat.Client;
import company.dataformat.Fruit;
import company.dataformat.TypeOfFruit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Shop {
    private final static int MILLISECOND_CONVERSION_FACTOR = 86_400_000;
    private final static String PATH = "src/main/resources";
    private final String DATA_FILE = PATH + "data.json";

    public Storage storage = new Storage();

    public Shop() {
//        try {
//            load(DATA_FILE);
//            show();
////            addFruits("files/delivery1.json");
////            addFruits("files/delivery2.json");
////            show();
////            save("files/data.json");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }

    public void addFruits(String pathToJsonFile) {
        String json = null;
        try {
            json = new Scanner(new File(pathToJsonFile)).useDelimiter("\\Z").next();
            Storage tmp = JSON.parseObject(json, Storage.class);
            for (Fruit fruit : tmp.fruits) {
                storage.fruits.add(fruit);
            }
            save(DATA_FILE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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

    public void sell(String pathToJsonFile) throws FileNotFoundException {
        String json = new Scanner(new File(pathToJsonFile)).useDelimiter("\\Z").next();
        Transactions transactions = JSON.parseObject(json, Transactions.class);
        System.out.println(transactions);
        int totalCount;
        for (Client client : transactions.clients) {
            totalCount = 0;
            for (Fruit fruit : storage.fruits) {
                if (fruit.getTypeOfFruit() == client.getType()) {
                    totalCount += fruit.getCount();
                }
            }
            if (client.getCount() <= totalCount) {
                Fruit tmpFruit = null;  // Temporary variable that storage address of element with "count" = 0, for removing
                for (Fruit fruit : storage.fruits) {
                    if (fruit.getTypeOfFruit() == client.getType()) {
                        storage.fruits.remove(tmpFruit);    // Remove saved in tmpFruit element with "count" = 0
                        if (client.getCount() > fruit.getCount()) {
                            storage.moneyBalance += fruit.getCount() * fruit.getPrice();
                            client.setCount(client.getCount() - fruit.getCount());
                            fruit.setCount(0);
                            tmpFruit = fruit;
                        } else {
                            storage.moneyBalance += client.getCount() * fruit.getPrice();
                            fruit.setCount(fruit.getCount() - client.getCount());
                            client.setCount(0);
                            break;
                        }
                    }
                }
            }
        }
        try {
            save(DATA_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showMoneyBalance() {
        System.out.printf("Money Balance: %.2f\n", storage.moneyBalance);
    }

    public void show() {
        System.out.println(storage);
    }

    @Override
    public String toString() {
        return "\n\t================================"
                + "\n\tShop: {"
                + "\n" + storage + "}"
                + "\n\t================================\n";
    }

    public static void main(String[] args) {
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
    }
}
