package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает модель банковского сервиса по работе с клиентом.
 * @author Marat Mikhaylov
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение данных осуществляется в коллекции типа HashMap.
     * Индекс - экземпляр класса User, a значение - коллекция типа List
     * в которой содержатся экземпляры класса Account;
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход клиента и добавляет его в коллекцию
     * только если такого клиента еще нет в коллекции.
     * @param user клиент, который добавляется в коллекцию.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаляет клиента по данным паспорта.
     * @param passport данные паспорта клиента.
     * @return возвращает true если такой клиент был удален,
     * и false если в коллекции не было клиента с такими данными.
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Метод добавляет новый счет клиента если такой клиент был найден по паспорту
     * и такого аккаунта у клиента еще нет.
     * @param passport данные паспорта клиента.
     * @param account данные счета клиента.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> userAccounts = users.get(user);
            if (!userAccounts.contains(account)) {
                userAccounts.add(account);
            }
        }
    }

    /**
     * Метод осуществляет поиск в коллекции клиентов по данным паспорта.
     * @param passport данные паспорта клиента.
     * @return возвращает данные клиента если найден, иначе null.
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод осуществляет поиск счета клиента по его паспорту и реквизитам счета.
     * @param passport данные паспорта клиента.
     * @param requisite реквизиты счета клиента.
     * @return возвращает счет клиента если найден такой клиент и счет, иначе null.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> userAccounts = users.get(user);
            for (Account userAccount : userAccounts) {
                if (userAccount.getRequisite().equals(requisite)) {
                    return userAccount;
                }
            }
        }
        return null;
    }

    /**
     * Метод позволяет перевести средства от одного клиента к другому.
     * @param srcPassport данные паспорта клиента источника средств.
     * @param srcRequisite данные счета клиента источника средств.
     * @param destPassport данные паспорта клиента назначения перевода.
     * @param destRequisite данные счета клиента назначения перевода.
     * @param amount количество средств к переводу.
     * @return возвращает true если перевод совершен,
     * false при недостатке средств на счету клиента или если клиенты не найдены.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account accountSrcUser = findByRequisite(srcPassport, srcRequisite);
        Account accountDestUser = findByRequisite(destPassport, destRequisite);
        if (accountSrcUser != null && accountDestUser != null
                && accountSrcUser.getBalance() >= amount) {
            accountSrcUser.setBalance(accountSrcUser.getBalance() - amount);
            accountDestUser.setBalance(accountDestUser.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}


