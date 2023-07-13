package ru.job4j.cast;

public class Plain implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " летает по воздуху.");
    }

    @Override
    public void brake() {
        System.out.println(getClass().getSimpleName() + " тормоза работают только при приземлении.");
    }
}
