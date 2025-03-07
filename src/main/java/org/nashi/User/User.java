package org.nashi.User;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

public class User {
    private final byte[] salt;
    private byte[] password;
    private String name;
    private String email;

    public User() {
        this.name = "";
        this.email = "";
        this.password = new byte[0];
        this.salt = new byte[16];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean checkPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        var spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        var f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        return Arrays.equals(this.password, f.generateSecret(spec).getEncoded());
    }

    public byte[] getPassword() {
        return password;
    }

    //Hash the password with a generated salt
    public void setPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecureRandom random = new SecureRandom();
        random.nextBytes(salt);
        var spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        var f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        this.password = f.generateSecret(spec).getEncoded();
    }
}
