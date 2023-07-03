package ru.job4j.oop;

public class Jukebox {
    public void music(int position) {
        String lyrics = switch (position) {
            case 1 -> "Пусть бегут неклюже";
            case 2 -> "Спокойной ночи";
            default -> "Песня не найдена";
        };
        System.out.println(lyrics);
    }

    public static void main(String[] args) {
        Jukebox sony = new Jukebox();
        sony.music(1);
        sony.music(2);
        sony.music(3);
    }
}
