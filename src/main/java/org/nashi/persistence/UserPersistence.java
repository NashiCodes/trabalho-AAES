package org.nashi.persistence;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.nashi.user.User;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class UserPersistence implements Persistence<User> {
    private static UserPersistence instance = new UserPersistence();
    private final Gson gson;
    private final Type mapType;
    private String FILENAME = "user.json";

    public UserPersistence() {
        this.gson = new Gson();

        this.mapType = TypeToken.getParameterized(Map.class, String.class, User.class).getType();
    }

    public static UserPersistence getInstance() {
        if (instance == null) {
            instance = new UserPersistence();
        }
        return instance;
    }

    public String getFILENAME() {
        return FILENAME;
    }

    public void setFILENAME(String FILENAME) {
        this.FILENAME = FILENAME;
    }

    @Override
    public void save(Map<String, User> items) throws IOException {
        String json = gson.toJson(items, mapType);
        FileManager.Save(FILENAME, json);
    }

    @Override
    public Map<String, User> findAll() throws IOException {
        String json;
        try {
            json = FileManager.Read(FILENAME);
            if (json.isEmpty()) return new HashMap<>();
            return gson.fromJson(json, mapType);
        } catch (IOException e) {
            throw new IOException("File not found");
        }
    }


}
