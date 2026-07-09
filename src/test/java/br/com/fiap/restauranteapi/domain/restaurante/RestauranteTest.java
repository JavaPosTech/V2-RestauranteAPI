package br.com.fiap.restauranteapi.domain.restaurante;

import br.com.fiap.restauranteapi.config.AbstractTest;
import br.com.fiap.restauranteapi.core.domain.restaurante.Restaurante;
import br.com.fiap.restauranteapi.core.domain.tipousuario.TipoUsuario;
import br.com.fiap.restauranteapi.core.domain.usuario.Usuario;
import br.com.fiap.restauranteapi.core.enums.ESituacaoCadastro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class RestauranteTest extends AbstractTest {

    @Test
    void domainTest() {
        Restaurante restaurante = new Restaurante(
                1,
                new Usuario(1, "João", "Silva", 1, LocalDateTime.now(), ESituacaoCadastro.ATIVO),
                "TESTE",
                "Rua de Teste, 1234",
                "BRASILEIRA", "12:00",
                "22:00",
                LocalDateTime.now());

        Assertions.assertEquals(1, restaurante.getId());
        Assertions.assertEquals("BRASILEIRA", restaurante.getTipoCozinha());
    }

    @Test
    void pertenceAoUsuarioTest() {
        Restaurante restaurante = new Restaurante(
                1,
                new Usuario(1, "João", "Silva", 1, LocalDateTime.now(), ESituacaoCadastro.ATIVO),
                "TESTE",
                "Rua de Teste, 1234",
                "BRASILEIRA", "12:00",
                "22:00",
                LocalDateTime.now());

        Assertions.assertFalse(restaurante.pertenceAoUsuario(1));
    }

    @Test
    void naoPertenceAoUsuarioTest() {
        Restaurante restaurante = new Restaurante(
                1,
                new Usuario(1, "João", "Silva", 1, LocalDateTime.now(), ESituacaoCadastro.ATIVO),
                "TESTE",
                "Rua de Teste, 1234",
                "BRASILEIRA", "12:00",
                "22:00",
                LocalDateTime.now());

        Assertions.assertTrue(restaurante.pertenceAoUsuario(2));
    }
}