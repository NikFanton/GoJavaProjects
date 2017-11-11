import company.Company;
import company.dataformat.Fruit;
import company.dataformat.TypeOfFruit;

import java.util.Date;
import java.util.LinkedList;

public class Runner {
    public static void main(String[] args) {
        Company company = new Company();
        company.showAllStores();
        System.out.println("Count of shops: " + company.countOfShops());
        System.out.println("Money Balance: " + company.getCompanyBalance());

        Date date = new Date(2017, 11, 8);
        System.out.println("========== SPOILED FRUITS ===========");
        LinkedList<Fruit> spoiledFruits = (LinkedList<Fruit>) company.getSpoiledFruits(date, TypeOfFruit.WATERMELON);
        for (Fruit fruit : spoiledFruits) {
            System.out.println(fruit);
        }
        System.out.println("========= AVAILABLE FRUITS ==========");
        LinkedList<Fruit> availableFruits = (LinkedList<Fruit>) company.getAvailableFruits(date, TypeOfFruit.APPLE);
        for (Fruit fruit : availableFruits) {
            System.out.println(fruit);
        }
        System.out.println("=========== ADDED FRUITS ============");
        LinkedList<Fruit> addedFruits = (LinkedList<Fruit>) company.getAddedFruits(new Date(2017, 11, 1), TypeOfFruit.LEMON);
        for (Fruit fruit : addedFruits) {
            System.out.println(fruit);
        }

//        company.getShop(1).addFruits("files/delivery1.json");
        company.showAllStores();
        company.save("src/main/resources/totaldata.json");

//        try {
//            Shop shop = new Shop();
//            Date date = new Date(2017, 11, 8);
//            System.out.println("========== SPOILED FRUITS ===========");
//            LinkedList<Fruit> spoiledFruits = (LinkedList<Fruit>) shop.getSpoiledFruits(date, TypeOfFruit.MELON);
//            for (Fruit fruit : spoiledFruits) {
//                System.out.println(fruit);
//            }
//            System.out.println("========= AVAILABLE FRUITS ==========");
//            LinkedList<Fruit> availableFruits = (LinkedList<Fruit>) shop.getAvailableFruits(date, TypeOfFruit.LEMON);
//            for (Fruit fruit : availableFruits) {
//                System.out.println(fruit);
//            }
//            System.out.println("=========== ADDED FRUITS ============");
//            LinkedList<Fruit> addedFruits = (LinkedList<Fruit>) shop.getAddedFruits(
//                    new Date(2017, 11, 1), TypeOfFruit.WATERMELON);
//            for (Fruit fruit : addedFruits) {
//                System.out.println(fruit);
//            }
//            shop.showMoneyBalance();
//            System.out.println("=========== TRANSACTIONS ============");
//            shop.sell("files/transactions.json");
//            shop.show();
//            shop.showMoneyBalance();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
