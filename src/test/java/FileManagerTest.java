import org.junit.jupiter.api.Test;
import org.nashi.Persistence.FileManager;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.fail;

public class FileManagerTest {
    private static final String FILENAME = "Test.json";

    @Test
    public void DeveSalvarArquivo() {
        try {
            FileManager.Save(FILENAME, "{\"Test\": \"Test\"}");
            File file = new File("data" + File.separator + FILENAME);
            assert file.exists();
        } catch (IOException e) {
            fail();
        }
    }

    @Test
    public void DeveLerArquivo() {
        try {
            FileManager.Save(FILENAME, "{\"Test\": \"Test\"}");
            File file = new File("data" + File.separator + FILENAME);
            assert file.exists();
            String content = FileManager.Read(FILENAME);
            assert content.equals("{\"Test\": \"Test\"}\n");
        } catch (IOException e) {
            fail();
        }
    }
}
