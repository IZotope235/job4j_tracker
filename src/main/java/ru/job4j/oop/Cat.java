package ru.job4j.oop;

public class Cat {
    private String food;
    private String name;

    public void show() {
        System.out.print((this.name));
        System.out.print(" ");
        System.out.println((this.food));
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

    public String sound() {
        return "may-may";
    }

    public static void main(String[] args) {
        Cat peppy = new Cat();
        Cat sparky = new Cat();
        Cat gav = new Cat();
        gav.giveNick("Gav");
        gav.eat("kotleta");
        gav.show();
        Cat black = new Cat();
        black.giveNick("Black");
        black.eat("fish");
        black.show();

    }
}
