public class Printer {

    public static void out1(String name, String city, int age, String hobby) {
        System.out.println("Name: " + name + "\nCity: " + city + "\nAge: " + age + "\nHobby: " + hobby);
    }

    public static void out2(String name, String city, int age, String hobby) {
        System.out.println(name + " lives in " + city + ". He is " + age + " years old. He likes " + hobby + ".");
    }

    public static void out3(String name, String city, int age, String hobby) {
        System.out.printf("%ages - name\n%10s - city\n%d - age \n%10s - hobby\n", name, city, age, hobby);
    }

    private int maxLength(String name, String city, String hobby) {
        int max = name.length();
        if (city.length() > max) {
            max = city.length();
        }
        if (hobby.length() > max) {
            max = city.length();
        }
        return max;
    }
}
