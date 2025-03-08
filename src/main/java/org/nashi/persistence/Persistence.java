package org.nashi.persistence;

import java.io.IOException;
import java.util.Map;

public interface Persistence<T> {
    void save(Map<String, T> itens) throws IOException;

    Map<String, T> findAll() throws IOException;
}
