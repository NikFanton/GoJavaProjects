package out;

public class Printer {

    public static void out1(String name, String city, int age, String hobby) {
        System.out.println("Name: " + name + "\nCity: " + city + "\nAge: " + age + "\nHobby: " + hobby);
    }

    public static void out2(String name, String city, int age, String hobby) {
        System.out.println(name + " lives in " + city + ". He is " + age + " years old. He likes " + hobby + ".");
    }

    public static void out3(String name, String city, int age, String hobby) {
        int max = maxLength(name, city, hobby);
        for (int i = 0; i < max-name.length(); i++) {
            System.out.print(" ");
        }
        System.out.printf("%s - name\n", name);
        for (int i = 0; i < max - city.length(); i++) {
            System.out.print(" ");
        }
        System.out.printf("%s - city\n", city);
        int ageLen = 1;
        if (age / 10 != 0) {
            if (age / 100 != 0) {
                ageLen = 3;
            } else {
                ageLen = 2;
            }
        }
        for (int i = 0; i < max - ageLen; i++) {
            System.out.print(" ");
        }
        System.out.printf("%d - age \n", age);
        for (int i = 0; i < max - hobby.length(); i++) {
            System.out.print(" ");
        }
        System.out.printf("%s - hobby\n", hobby);
    }

    private static int maxLength(String name, String city, String hobby) {
        int max = name.length();
        if (city.length() > max) {
            max = city.length();
        }
        if (hobby.length() > max) {
            max = hobby.length();
        }
        return max;
    }
}
