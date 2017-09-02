import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String name;
        String city;
        String hobby;
        int age;

        Scanner input = new Scanner(System.in);
        name = input.nextLine();
        city = input.nextLine();
        hobby = input.nextLine();
        age = input.nextInt();


        Printer.out1(name, city, age, hobby);
        Printer.out2(name, city, age, hobby);
        Printer.out3(name, city, age, hobby);
    }
}
