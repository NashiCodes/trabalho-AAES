import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.nashi.persistence.UserPersistence;
import org.nashi.user.User;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class UserPersistenceTest {
    private static Map<String, User> TestUsers;

    @BeforeAll
    public static void deveRetornarInstancia1() throws NoSuchAlgorithmException, InvalidKeySpecException {
        UserPersistence userPersistence = UserPersistence.getInstance();
        assert userPersistence != null;

        var FILENAMETEST = "/test/" + UserPersistence.getInstance().getFILENAME();
        UserPersistence.getInstance().setFILENAME(FILENAMETEST);

        TestUsers = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            var user = new User();
            user.setEmail("test" + i + "@test.com");
            user.setPassword("test" + i);
            user.setName("test" + i);
            TestUsers.put(user.getEmail(), user);
        }
    }


    @Test
    public void Teste_DeveSalvarUsuario() {
        try {
            UserPersistence.getInstance().save(UserPersistenceTest.TestUsers);
            var filePath = "data" + File.separator + "test" + File.separator + "user.json";
            var file = new File(filePath);
            assert file.exists();
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void Teste_DeveLerUsuario() {
        try {
            UserPersistence.getInstance().save(TestUsers);
            var users = UserPersistence.getInstance().findAll();
            assert users != null;
            assert users.size() == TestUsers.size();
            for (var entry : users.entrySet()) {
                assertEquals(TestUsers.get(entry.getKey()).getEmail(), entry.getValue().getEmail());
            }
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void Teste_DeveRetornarExcecaoArquivoNaoEncontrado() {
        try {
            var filePath = "data" + File.separator + "test" + File.separator + "user.json";
            var file = new File(filePath);
            if (file.exists()) file.delete();
            UserPersistence.getInstance().findAll();
            fail();
        } catch (IOException e) {
            assert e.getMessage().equals("File not found");
        }
    }

    @Test
    public void Teste_DeveLerUsuarioVazio() {
        try {
            UserPersistence.getInstance().save(new HashMap<>());
            var users = UserPersistence.getInstance().findAll();
            assert users != null;
            assert users.isEmpty();
        } catch (IOException e) {
            fail();
        }
    }

}