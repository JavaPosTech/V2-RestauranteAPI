package br.com.fiap.restauranteapi.domain.usuario;

import br.com.fiap.restauranteapi.config.AbstractTest;
import br.com.fiap.restauranteapi.core.domain.tipousuario.TipoUsuario;
import br.com.fiap.restauranteapi.core.domain.usuario.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class UsuarioTest extends AbstractTest {

    @Test
    void domainTest() {
        Usuario usuario = new Usuario(
                1,
                "TESTE",
                "TESTE",
                new TipoUsuario(2, "TESTE"),
                LocalDateTime.now());

        Assertions.assertEquals(1, usuario.getId());
        Assertions.assertEquals("TESTE", usuario.getNome());
        Assertions.assertEquals("TESTE", usuario.getSobrenome());
        Assertions.assertEquals(2, usuario.getTipoUsuario().getId());
    }
}