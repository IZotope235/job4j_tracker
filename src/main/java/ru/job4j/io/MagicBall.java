package ru.job4j.io;

import java.util.Scanner;
import java.util.Random;

public class MagicBall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Я великий Оракул. Что ты хочешь узнать?");
        String userQuestion = input.nextLine();
        int answer = new Random().nextInt(3);
        String output = switch (answer) {
            case (0) -> "Да";
            case (1) -> "Нет";
            default -> "Может быть";
        };
        System.out.println(output);
    }
}
