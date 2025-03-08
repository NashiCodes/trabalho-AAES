package org.nashi.persistence;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.nashi.user.User;

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
        Gson gson;
        String json;
        try {
            gson = new Gson();
            json = FileManager.Read(FILENAME);
        } catch (IOException e) {
            throw new IOException("File not found");
        }

        var usuarios = new HashMap<String, User>();
        if (!json.trim().isEmpty()) {
            var MapType = new TypeToken<HashMap<String, User>>() {
            }.getType();
            usuarios = gson.fromJson(json, MapType);
            if (usuarios == null) usuarios = new HashMap<>();
        }

        return usuarios;
    }


}
