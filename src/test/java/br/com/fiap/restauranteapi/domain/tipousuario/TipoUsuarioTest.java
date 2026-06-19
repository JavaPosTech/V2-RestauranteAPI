package br.com.fiap.restauranteapi.domain.tipousuario;

import br.com.fiap.restauranteapi.config.AbstractTest;
import br.com.fiap.restauranteapi.core.domain.tipousuario.TipoUsuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TipoUsuarioTest extends AbstractTest {

    @Test
    void domainTest() {
        TipoUsuario tipoUsuario = new TipoUsuario(1, "TESTE");

        Assertions.assertEquals(1, tipoUsuario.id());
        Assertions.assertEquals("TESTE", tipoUsuario.descricao());
    }

    @Test
    void toDomainTest() {
        Assertions.assertDoesNotThrow(() -> TipoUsuario.toDomain("TESTE"));
    }

    @Test
    void toDomainComDescricaoNullTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> TipoUsuario.toDomain(null));
    }

    @Test
    void toDomainComDescricaoVaziaTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> TipoUsuario.toDomain(""));
    }
}