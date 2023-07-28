package org.example;

public class Cat {
    public final int age;
    public final String name;
    private final colour catColour;

     static enum colour {
        WHITE, RED, BLACK, GREY, SPOTTED
    }

    public Cat(String name, colour catColour, int age) {
        this.name = name;
        this.catColour = catColour;
        this.age = age;
    }

    public Cat() {
        this.age = 2;
        this.name = "Kot";
        this.catColour = colour.WHITE;
    }
}
