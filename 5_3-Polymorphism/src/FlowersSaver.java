import flowers.SuperFlower;

import java.io.FileWriter;
import java.io.IOException;

public abstract class FlowersSaver {
    public static void save(SuperFlower[] flowers, String path) {
        try {
            FileWriter writer = new FileWriter(path);
            writer.write(flowers.length + "\n");
            for (SuperFlower flower: flowers) {
                writer.write(flower.getClass().getSimpleName() + "\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FlowerStore store = new FlowerStore();
        FlowersSaver.save(store.sellSequence(5, 6, 3), "D:\\Projects\\GoJavaProjects\\5_3-Polymorphism\\rsc\\file.txt");
    }
}
