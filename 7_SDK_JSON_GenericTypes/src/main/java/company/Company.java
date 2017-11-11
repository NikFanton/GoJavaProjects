package company;

import com.alibaba.fastjson.JSON;
import company.dataformat.Fruit;
import company.dataformat.TypeOfFruit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Company {
    private ChainStores chainStores = new ChainStores();

    public Company() {
        load("src/main/resources/totaldata.json");
    }

    public void save(String pathToJsonFile) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(pathToJsonFile);
            writer.write(JSON.toJSONString(chainStores));
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(String pathToJsonFile) {
        try {
            String json = new Scanner(new File(pathToJsonFile)).useDelimiter("\\Z").next();
            chainStores = JSON.parseObject(json, ChainStores.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void showAllStores() {
        System.out.println(chainStores);
    }

    public int countOfShops() {
        return chainStores.shops.size();
    }

    public double getCompanyBalance() {
        return chainStores.companyBalance();
    }

    public Shop getShop(int index) {
        return chainStores.shops.get(index);
    }

    public List<Fruit> getSpoiledFruits(Date date) {
        LinkedList<Fruit> spoiledFruits = new LinkedList<>();
        for (Shop shop : chainStores.shops) {
            for (Fruit fruit : shop.getSpoiledFruits(date)) {
                spoiledFruits.add(fruit);
            }
        }
        return spoiledFruits;
    }

    public List<Fruit> getSpoiledFruits(Date date, TypeOfFruit type) {
        LinkedList<Fruit> spoiledFruits = new LinkedList<>();
        for (Shop shop : chainStores.shops) {
            for (Fruit fruit : shop.getSpoiledFruits(date, type)) {
                spoiledFruits.add(fruit);
            }
        }
        return spoiledFruits;
    }

    public List<Fruit> getAvailableFruits(Date date) {
        LinkedList<Fruit> availableFruits = new LinkedList<>();
        for (Shop shop : chainStores.shops) {
            for (Fruit fruit : shop.getAvailableFruits(date)) {
                availableFruits.add(fruit);
            }
        }
        return availableFruits;
    }

    public List<Fruit> getAvailableFruits(Date date, TypeOfFruit type) {
        LinkedList<Fruit> availableFruits = new LinkedList<>();
        for (Shop shop : chainStores.shops) {
            for (Fruit fruit : shop.getAvailableFruits(date, type)) {
                availableFruits.add(fruit);
            }
        }
        return availableFruits;
    }

    public List<Fruit> getAddedFruits(Date date) {
        LinkedList<Fruit> addedFruits = new LinkedList<>();
        for (Shop shop : chainStores.shops) {
            for (Fruit fruit : shop.getAddedFruits(date)) {
                addedFruits.add(fruit);
            }
        }
        return addedFruits;
    }

    public List<Fruit> getAddedFruits(Date date, TypeOfFruit type) {
        LinkedList<Fruit> addedFruits = new LinkedList<>();
        for (Shop shop : chainStores.shops) {
            for (Fruit fruit : shop.getAddedFruits(date, type)) {
                addedFruits.add(fruit);
            }
        }
        return addedFruits;
    }

    public static void main(String[] args) {
        Company company = new Company();
        company.showAllStores();
    }
}
