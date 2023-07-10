package ru.job4j.record;

public class PersonMain {
    public static void main(String[] args) {
        Person person = new Person("Ivan", 30);
        System.out.println(person);
        PersonRecord record = new PersonRecord("Ivan", 30);
        System.out.println(record);
    }
}
