import com.alibaba.fastjson.JSON;
import products.Company;
import products.FruitProduct;
import products.Store;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class JsonProcessor {
    Lines data;
    Company company;
    PersonData data1;
    PersonData data2;
    PersonData data3;
    PersonData data4;

    public JsonProcessor() {
//        loadT1("files/File 1_1.json");
//        loadT2("files/File 2_1.json");
        data1 = loadT3("files/File 3_1.json");
        data2 = loadT3("files/File 3_2.json");
        data3 = loadT3("files/File 3_3.json");
        data4 = loadT3("files/File 3_4.json");
        System.out.println(data1);
        System.out.println(data2);
        System.out.println(data3);
        System.out.println(data4);
    }

    public void loadT1(String pathToJsonFile) {
        try {
            String json = new Scanner(new File(pathToJsonFile)).useDelimiter("\\Z").next();
            data = JSON.parseObject(json, Lines.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveT1(String pathToJsonFile) {
        try {
            FileWriter writer = new FileWriter(pathToJsonFile);
            writer.write(JSON.toJSONString(data));
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadT2(String pathToJsonFile) {
        try {
            String json = new Scanner(new File(pathToJsonFile)).useDelimiter("\\Z").next();
            company = JSON.parseObject(json, Company.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public PersonData loadT3(String pathToJsonFile) {
        String json = "";
        try {
            json = new Scanner(new File(pathToJsonFile)).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        PersonData data = JSON.parseObject(json, PersonData.class);
        return data;
    }

    public static void main(String[] args) {
        JsonProcessor proc = new JsonProcessor();
    }
}
