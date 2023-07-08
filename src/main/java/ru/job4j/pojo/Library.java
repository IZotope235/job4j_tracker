package ru.job4j.pojo;

public class Library {
    public static void moveCell(Book[] array, int startIndex, int finishIndex) {
        Book temp = array[startIndex];
        array[startIndex] = array[finishIndex];
        array[finishIndex] = temp;
    }

    public static void printArray(Book[] array) {
        for (Book el: array) {
            System.out.println(el.getName());
        }
    }

    public static void printArrayWithName(Book[] array, String bookName) {
        for (Book el: array) {
            if (el.getName().equals(bookName)) {
                System.out.println(el.getName());
            }
        }
    }

    public static void main(String[] args) {
        Book bookOne = new Book();
        Book bookTwo = new Book();
        Book bookThree = new Book();
        Book bookFour = new Book();
        Book[] bookShelf = new Book[4];
        bookShelf[0] = bookOne;
        bookShelf[1] = bookTwo;
        bookShelf[2] = bookThree;
        bookShelf[3] = bookFour;
        bookOne.setName("Clean code");
        bookTwo.setName("Java");
        bookThree.setName("JavaScript");
        bookFour.setName("Python");
        printArray(bookShelf);
        moveCell(bookShelf, 0, 3);
        System.out.println();
        printArray(bookShelf);
        System.out.println();
        printArrayWithName(bookShelf, "Clean code");
    }
}
