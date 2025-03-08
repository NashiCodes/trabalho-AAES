import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.nashi.user.UserBuilder;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class UserTest {
    private UserBuilder builder;

    @BeforeEach
    public void setUp() {
        builder = new UserBuilder();
    }

    @Test
    public void DeveRetornarExcecaoQuandoNomeNaoForPreenchido() {
        try {
            builder.setEmail("teste@test.com")
                    .setPassword("123456")
                    .build();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Name is required", e.getMessage());
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            fail();
        }
    }

    @Test
    public void DeveRetornarExcecaoQuandoEmailNaoForPreenchido() {
        try {
            builder.setName("Teste")
                    .setPassword("123456")
                    .build();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Email is required", e.getMessage());
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            fail();
        }
    }

    @Test
    public void DeveRetornarExcecaoQuandoSenhaNaoForPreenchida() {
        try {
            builder.setName("Teste")
                    .setEmail("teste@test.com")
                    .build();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Password is required", e.getMessage());
        }
    }

    @Test
    public void DeveRetornarUsuarioQuandoTodosOsCamposEstiveremPreenchidos() {
        try {
            var user = builder.setName("Teste")
                    .setEmail("teste@test.com")
                    .setPassword("123456")
                    .build();
            assert user != null;
        } catch (RuntimeException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            fail();
        }
    }

    @Test
    public void DeveRetornarUsuarioQuandoTodosOsCamposEstiveremPreenchidosComSetAll() {
        try {
            var user = builder.setAll("Teste", "teste@test.com", "123456")
                    .build();
            assert user != null;
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            fail();
        }
    }

    @Test
    public void DeveRetornarVerdadeiroQuandoSenhaEstiverCorreta() {
        try {
            var user = builder.setAll("Teste", "teste@test.com", "123456")
                    .build();
            assert user != null;
            assert user.checkPassword("123456");
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            fail();
        }
    }
}
