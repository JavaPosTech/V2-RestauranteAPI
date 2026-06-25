package br.com.fiap.restauranteapi.domain.tipousuario;

import br.com.fiap.restauranteapi.config.AbstractTest;
import br.com.fiap.restauranteapi.core.domain.tipousuario.TipoUsuario;
import br.com.fiap.restauranteapi.core.exceptions.RegraDeNegocioException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TipoUsuarioTest extends AbstractTest {

    @Test
    void domainTest() {
        TipoUsuario tipoUsuario = new TipoUsuario(1, "TESTE");

        Assertions.assertEquals(1, tipoUsuario.getId());
        Assertions.assertEquals("TESTE", tipoUsuario.getDescricao());
    }

    @Test
    void criarTest() {
        Assertions.assertDoesNotThrow(() -> TipoUsuario.criar("TESTE"));
    }

    @Test
    void criarComDescricaoNullTest() {
        Assertions.assertThrows(RegraDeNegocioException.class, () -> TipoUsuario.criar(null));
    }

    @Test
    void criarComDescricaoVaziaTest() {
        Assertions.assertThrows(RegraDeNegocioException.class, () -> TipoUsuario.criar(""));
    }
}