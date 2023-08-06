package ru.job4j.collection;

import java.util.HashMap;
import java.util.HashSet;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> postMap = new HashMap<>();
        postMap.put("ivanivanov98@mail.ru", "Ivanov Ivan Ivanovich");
        postMap.put("petrov_23@gmail.com", "Petrov Peter Ivanovich");
        for (String string : postMap.keySet()) {
            System.out.println(string);
        }
    }
}
