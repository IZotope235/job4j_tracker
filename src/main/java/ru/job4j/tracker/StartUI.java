package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        LocalDateTime currentDateTime = item.getDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String currentDateFormat = currentDateTime.format(formatter);
        System.out.println(currentDateFormat);
    }

}