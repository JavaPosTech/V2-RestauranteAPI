package br.com.fiap.restauranteapi.domain.usuario;

import br.com.fiap.restauranteapi.config.AbstractTest;
import br.com.fiap.restauranteapi.core.domain.usuario.Usuario;
import br.com.fiap.restauranteapi.core.enums.ESituacaoCadastro;
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
                2,
                LocalDateTime.now(),
                ESituacaoCadastro.ATIVO);

        Assertions.assertEquals(1, usuario.getId());
        Assertions.assertEquals("TESTE", usuario.getNome());
        Assertions.assertEquals("TESTE", usuario.getSobrenome());
        Assertions.assertEquals(2, usuario.getTipoUsuarioId());
    }
}