package main;

import out.Printer;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String name;
        String city;
        String hobby;
        int age;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name:  ");
        name = input.nextLine();
        System.out.print("Enter your city:  ");
        city = input.nextLine();
        System.out.print("Enter your hobby: ");
        hobby = input.nextLine();
        System.out.print("Enter your age:   ");
        age = input.nextInt();

        System.out.println("------------------");
        Printer.out1(name, city, age, hobby);
        System.out.println("------------------");
        Printer.out2(name, city, age, hobby);
        System.out.println("------------------");
        Printer.out3(name, city, age, hobby);
    }
}
