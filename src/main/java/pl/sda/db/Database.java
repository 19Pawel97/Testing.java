package pl.sda.db;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Database {
    private Map<String, User> users;

    public Database() {
        users = new HashMap<>();
    }

    public Database(List<User> userList) {
        users = userList.stream().collect(Collectors.toMap(User::getLogin, Function.identity()));
    }

    public void addUser(User user) {
        if (users.containsKey(user.getLogin())) {
            throw new UserExistsException("User already exists.");
        }
        users.put(user.getLogin(), user);
    }

    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    public void removeUser(String login) {
        if (!users.containsKey(login)) {
            throw new UserNotFoundException("No such user found");
        }
        users.remove(login);
    }

    public User findUser(String login) {
        if (!users.containsKey(login)) {
            throw new UserNotFoundException("No such user found");
        }
        return users.get(login);
    }

    public User findByPartOfLogin(String loginPart) {
        for (String login : users.keySet()) {
            if (login.startsWith(loginPart) || login.endsWith(loginPart) || login.contains(loginPart)) {
                return users.get(login);
            } else {
                throw new UserNotFoundException("No such user found");
            }
        }
        return null;
    }

    public void modifyUser(String login, String newLogin) {
        if (!users.containsKey(login)) {
            throw new UserNotFoundException("No such user found");
        }
        users.get(login).setLogin(newLogin);
    }
}

