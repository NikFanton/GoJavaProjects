import flowers.Chamomile;
import flowers.Rose;
import flowers.SuperFlower;
import flowers.Tulip;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class FlowersLoader {

    public static SuperFlower[] load(String path) {
        SuperFlower[] flowers = null;
        try {
            FileReader reader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(reader);
            int length = Integer.parseInt(bufferedReader.readLine());
            flowers = new SuperFlower[length];
            for (int i = 0; i < length; i++) {
                String flower = bufferedReader.readLine();
                if (flower.equals(Rose.class.getSimpleName())) {
                    flowers[i] = new Rose();
                } else if (flower.equals(Chamomile.class.getSimpleName())) {
                    flowers[i] = new Chamomile();
                } else if (flower.equals(Tulip.class.getSimpleName())) {
                    flowers[i] = new Tulip();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flowers;
    }

    public static void main(String[] args) {
        SuperFlower[] flowers = FlowersLoader.load("D:\\Projects\\GoJavaProjects\\5_3-Polymorphism\\rsc\\file.txt");
        for (SuperFlower flower : flowers) {
            flower.show();
        }
    }
}
