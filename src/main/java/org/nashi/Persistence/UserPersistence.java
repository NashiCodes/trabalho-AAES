package org.nashi.Persistence;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.nashi.User.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserPersistence implements Persistence<User> {
    private static UserPersistence instance = new UserPersistence();
    private String FILENAME = "user.json";

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
    public void save(Map<String, User> itens) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(itens);

        FileManager.Save(FILENAME, json);
    }

    @Override
    public Map<String, User> findAll() throws IOException {
        Gson gson = new Gson();
        String json = FileManager.Read(FILENAME);

        var usuarios = new HashMap<String, User>();
        if (!json.trim().isEmpty()) {
            var MapType = new TypeToken<Map<String, Object>>() {
            }.getType();
            usuarios = gson.fromJson(json, new TypeToken<HashMap<String, User>>() {
            }.getType());
            if (usuarios == null) usuarios = new HashMap<>();
        }

        return usuarios;
    }


}
