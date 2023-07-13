package ru.job4j.cast;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " двигается по рельсам.");
    }

    @Override
    public void brake() {
        System.out.println(getClass().getSimpleName() + " тормозная система может сработать принудительно.");

    }
}
