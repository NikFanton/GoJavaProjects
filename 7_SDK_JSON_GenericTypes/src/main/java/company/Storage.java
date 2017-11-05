package company;

import company.dataformat.Fruit;
import company.dataformat.TypeOfFruit;

import java.util.ArrayList;
import java.util.Date;

public class Storage {
    public ArrayList<Fruit> fruits = new ArrayList<>();
    public double moneyBalance = 0;

    public Storage() {
//        init();
    }

    private void init() {
        fruits.add(new Fruit(TypeOfFruit.STRAWBERRY, 10, new Date(2017, 11, 12), 9.1f, 20));
        fruits.add(new Fruit(TypeOfFruit.LEMON,      20, new Date(2017, 11, 1),  5.1f, 1000));
        fruits.add(new Fruit(TypeOfFruit.BANANA,      1, new Date(2017, 10, 28), 7.2f, 30));
        fruits.add(new Fruit(TypeOfFruit.KIWI,        5, new Date(2017, 11, 3),  8.0f, 20));
        fruits.add(new Fruit(TypeOfFruit.MELON,       5, new Date(2017, 11, 1),  9.2f, 500));
        fruits.add(new Fruit(TypeOfFruit.PINEAPPLE,  10, new Date(2017, 10, 29), 9.3f, 120));
        fruits.add(new Fruit(TypeOfFruit.WATERMELON,  5, new Date(2017, 11, 1),  2.2f, 600));
        fruits.add(new Fruit(TypeOfFruit.BLUEBERRY,   7, new Date(2017, 11, 2),  4.0f, 100));
        fruits.add(new Fruit(TypeOfFruit.RASPBERRY,   8, new Date(2017, 11, 3),  3.0f, 950));
        fruits.add(new Fruit(TypeOfFruit.APPLE,       8, new Date(2017, 11, 3),  3.2f, 500));
    }

    public void getFruitsSize() {
        fruits.size();
    }

    @Override
    public String toString() {
        return "\t\tFruits{" + fruits + "}\n "
                + "\t\tMoney Balance: " + moneyBalance;
    }
}
