package ru.job4j.cast;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " двигается по скоростным трассам.");
    }

    @Override
    public void brake() {
        System.out.println(getClass().getSimpleName() + " тормозная система продублированна.");
    }
}
