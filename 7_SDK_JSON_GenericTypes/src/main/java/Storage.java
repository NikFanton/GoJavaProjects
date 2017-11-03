import com.alibaba.fastjson.JSON;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Storage {
    public ArrayList<Fruit> fruits = new ArrayList<>();

    public Storage() {
//        fruits.add(new Fruit(TypeOfFruit.STRAWBERRY, 10, new Date(2017, 11, 12),  9.1f));
//        fruits.add(new Fruit(TypeOfFruit.LEMON,      20, new Date(2017, 11, 1),  5.1f));
//        fruits.add(new Fruit(TypeOfFruit.BANANA,      1, new Date(2017, 10, 28), 7.2f));
//        fruits.add(new Fruit(TypeOfFruit.KIWI,        5, new Date(2017, 11, 3),  8.0f));
//        fruits.add(new Fruit(TypeOfFruit.MELON,       5, new Date(2017, 11, 1),  9.2f));
//        fruits.add(new Fruit(TypeOfFruit.PINEAPPLE,  10, new Date(2017, 10, 29), 9.3f));
//        fruits.add(new Fruit(TypeOfFruit.WATERMELON,  5, new Date(2017, 11, 1),  2.2f));
//        fruits.add(new Fruit(TypeOfFruit.BLUEBERRY,   7, new Date(2017, 11, 2),  4.0f));
//        fruits.add(new Fruit(TypeOfFruit.RASPBERRY,   8, new Date(2017, 11, 3),  3.0f));
//        fruits.add(new Fruit(TypeOfFruit.APPLE,       8, new Date(2017, 11, 3),  3.2f));
    }

    public void getFruitsSize() {
        fruits.size();
    }

    @Override
    public String toString() {
        return "Fruits{" + fruits + "}\n";
    }
}
