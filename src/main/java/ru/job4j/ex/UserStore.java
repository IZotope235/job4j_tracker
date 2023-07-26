package ru.job4j.ex;

public class UserStore {
    static final int MIN_LENGTH_USER_NAME = 3;

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User rsl = null;
        for (User user: users) {
            if (user.getUsername().equals(login)) {
                rsl = user;
                break;
            }
        }
        if (rsl == null) {
            throw new UserNotFoundException("User not found");
        }
        return rsl;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < MIN_LENGTH_USER_NAME) {
            throw new UserInvalidException("User name is invalid");
        }
        return user.isValid();
    }

    public static void main(String[] args) {
        User[] users = {new User("Petr Arsentev", true)};
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ei) {
            ei.printStackTrace();
        } catch (UserNotFoundException en) {
            en.printStackTrace();
        }
    }
}
