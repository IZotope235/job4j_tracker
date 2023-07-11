package ru.job4j.poly;

public class Bus implements Transport {

    private static final int FUEL_PRICE = 11;

    @Override
    public void drive() {
        System.out.println("The bus is driving");
    }

    @Override
    public void passangers(int number) {
        System.out.println("There are " + number + " passengers on the bus");
    }

    @Override
    public int reFill(int fuelQuantity) {
        return FUEL_PRICE * fuelQuantity;
    }
}
