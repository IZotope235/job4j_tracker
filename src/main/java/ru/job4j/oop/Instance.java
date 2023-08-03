package ru.job4j.oop;

public class Instance {
    private String name;
    private static String hello = "Hello";

    public Instance(String name) {
        this.name = name;
    }

    public String getHello() {
        return hello;
    }

    public static void main(String[] args) {
        System.out.println((new Instance("name").getHello() instanceof String));
        System.out.println((hello instanceof String));
    }
}
