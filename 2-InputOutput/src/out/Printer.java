package out;

public class Printer {

    public static void printInfoInTable(String name, String city, int age, String hobby) {
        System.out.println("Name: " + name + "\nCity: " + city + "\nAge: " + age + "\nHobby: " + hobby);
    }

    public static void printTextInfo(String name, String city, int age, String hobby) {
        System.out.println(name + " lives in " + city + ". He is " + age + " years old. He likes " + hobby + ".");
    }

    public static void printInfoInOtherWay(String name, String city, int age, String hobby) {
        int max = maxLength(name, city, hobby);
        printEmptySpace(max, name.length());
        System.out.printf("%s - name\n", name);
        printEmptySpace(max, city.length());
        System.out.printf("%s - city\n", city);
        printEmptySpace(max, getAgeLength(age));
        System.out.printf("%d - age \n", age);
        printEmptySpace(max, hobby.length());
        System.out.printf("%s - hobby\n", hobby);
    }

    private static int getAgeLength(int age) {
        int ageLen = 1;
        if (age / 10 != 0) {
            if (age / 100 != 0) {
                ageLen = 3;
            } else {
                ageLen = 2;
            }
        }
        return ageLen;
    }

    private static void printEmptySpace(int maxLength, int length) {
        for (int i = 0; i < maxLength-length; i++) {
            System.out.print(" ");
        }
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
