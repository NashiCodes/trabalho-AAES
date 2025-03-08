package org.nashi.user;

import org.nashi.persistence.UserPersistence;

import java.io.IOException;
import java.util.Map;

public class UsersSingleton {
    private static UsersSingleton instance;
    private final Map<String, User> users;

    private UsersSingleton() throws IOException {
        users = UserPersistence.getInstance().findAll();
    }

    public static UsersSingleton getInstance() throws IOException {
        if (instance == null) {
            instance = new UsersSingleton();
        }
        return instance;
    }

    public Map<String, User> getAllUsers() {
        return users;
    }

    public void addUser(User user) throws IOException {
        users.put(user.getEmail(), user);
        UserPersistence.getInstance().save(users);
    }

    public void removeUser(User user) {
        users.remove(user.getEmail());
    }

    public User getUser(String email) {
        return users.get(email);
    }
}
