package org.example;

public class Main {
    public static void main(String[] args) {

//        Cat cat = new Cat();
//        int age = cat.age;
//        age = 6;
//        String name2 = cat.name;
//        name2 = "Lolek";
//        System.out.println(cat.name);
//        fizzBuzzIfs();
//        fizzBuzzIfs2();
//        fizzBuzzWhile();
        fizzBuzzIfs3();

    }

    public static void fizzBuzzIfs() {

        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 15 != 0) {
                System.out.println("fizz");
            } else if (i % 5 == 0 && i % 15 != 0) {
                System.out.println("buzz");
            } else if (i % 15 == 0) {
                System.out.println("fizz buzz");
            } else {
                System.out.println(i);
            }
        }
    }

    public static void fizzBuzzIfs2() {

        for (int i = 1; i <= 100; i++) {
            if (i % 15 != 0) {
                if (i % 3 == 0) {
                    System.out.println("fizz");
                } else if (i % 5 == 0) {
                    System.out.println("buzz");
                } else {
                    System.out.println(i);
                }
            } else {
                System.out.println("fizz buzz");
            }
        }
    }

    public static void fizzBuzzIfs3() {
        for (int i = 1; i <= 100; i++) {
            if (i % 15 == 0) {
                System.out.println("fizz buzz");
            } else if (i % 3 == 0) {
                System.out.println("fizz");
            } else if (i % 5 == 0) {
                System.out.println("buzz");
            } else System.out.println(i);
        }
    }


    public static void fizzBuzzWhile() {

        int i = 1;
        while (i <= 100) {
            if (i % 15 != 0) {
                if (i % 3 == 0) {
                    System.out.println("fizz");
                } else if (i % 5 == 0) {
                    System.out.println("buzz");
                } else {
                    System.out.println(i);
                }
            } else {
                System.out.println("fizz buzz");

            }
            i++;
        }
    }
}