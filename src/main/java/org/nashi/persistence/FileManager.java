package org.nashi.persistence;

import java.io.*;

public class FileManager {
    public static final String PATH = "data" + File.separator;

    public static String Read(String fileName) throws IOException {
        StringBuilder content = new StringBuilder();

        BufferedReader reader = new BufferedReader(new FileReader(PATH + fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
        }
        reader.close();

        return content.toString();
    }

    public static void Save(String fileName, String content) throws IOException {
        File diretorio = new File(PATH);
        if (!diretorio.exists()) diretorio.mkdir();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH + fileName, false))) {
            writer.write(content);
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }

    }
}
