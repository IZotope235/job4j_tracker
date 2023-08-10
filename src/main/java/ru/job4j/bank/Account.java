package ru.job4j.bank;

import java.util.Objects;
/**
 * Класс Account это модель данных счета клиента.
 * @author Marat Mikhaylov
 * @version 1.0
 */
public class Account {
    /**
     * Поле requisite содержит идентификационный номер счета.
     */
    private String requisite;
    /**
     * Поле balance содержит остаток средств на данном счете.
     */
    private double balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    public String getRequisite() {
        return requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
