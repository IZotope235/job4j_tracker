package ru.job4j.cast;

public class VehicleUse {
    public static void main(String[] args) {
        Vehicle bus = new Bus();
        Vehicle plain = new Plain();
        Vehicle train = new Train();
        Vehicle[] vehicles = new Vehicle[]{bus, plain, train};
        for (Vehicle el: vehicles) {
            el.move();
            el.brake();
        }
    }
}
