package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student ivan = new Student();
        ivan.setFullName("Ivan Ivanov");
        ivan.setGroup("0512");
        ivan.setAdmission(new Date());
        System.out.println(ivan.getFullName() + System.lineSeparator() + ivan.getGroup()
                + System.lineSeparator() + ivan.getAdmission());
    }
}
