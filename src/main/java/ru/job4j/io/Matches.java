package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от 1 до 3:");
            int playersTurn = Integer.parseInt(input.nextLine());
            if (playersTurn > 3 || playersTurn <= 0 || playersTurn > count) {
                System.out.println("Ход должен быть от 1 до 3 спичек, но не больше количества оставшихся");
                System.out.println("Осталось: " + count + " спичек");
                System.out.println("Попробуйте еще раз");
            } else {
                turn = !turn;
                count -= playersTurn;
                System.out.println("Осталось: " + count + " спичек");
            }
        }
        String winner = !turn ? "Первый игрок" : "Второй игрок";
        System.out.println("Победил: " + winner);
    }
}
