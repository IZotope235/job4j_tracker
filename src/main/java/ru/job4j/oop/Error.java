package ru.job4j.oop;

public class Error {
    boolean active;
    int status;
    String massage;

    Error() {

    }

    Error(boolean active, int status, String massage) {
        this.active = active;
        this.status = status;
        this.massage = massage;
    }

    public void printInfo() {
        System.out.println("Состояние: " + active);
        System.out.println("Код ошибки: " + status);
        System.out.println("Сообщение: " + massage);
    }

    public static void main(String[] args) {
        Error critical = new Error(true, 41, "Critical error");
        Error pageNotFound = new Error(false, 404, "Page not found");
        Error defaultError = new Error();
        critical.printInfo();
        pageNotFound.printInfo();
        defaultError.printInfo();
    }
}
