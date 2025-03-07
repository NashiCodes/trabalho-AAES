package org.nashi.User;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class UserBuilder {
    private final User user;

    public UserBuilder() {
        user = new User();
    }

    public User build() {
        if (user.getName().isEmpty())
            throw new IllegalArgumentException("Name is required");
        if (user.getEmail().isEmpty())
            throw new IllegalArgumentException("Email is required");
        if (user.getPassword().length == 0)
            throw new IllegalArgumentException("Password is required");

        return user;
    }

    public UserBuilder setName(String name) {
        user.setName(name);
        return this;
    }

    public UserBuilder setEmail(String email) {
        user.setEmail(email);
        return this;
    }

    public UserBuilder setPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        user.setPassword(password);
        return this;
    }

    public UserBuilder setAll(String name, String email, String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        return this;
    }
}
