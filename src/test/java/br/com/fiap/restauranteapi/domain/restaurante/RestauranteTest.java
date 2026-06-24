package br.com.fiap.restauranteapi.domain.restaurante;

import br.com.fiap.restauranteapi.config.AbstractTest;
import br.com.fiap.restauranteapi.core.domain.restaurante.Restaurante;
import br.com.fiap.restauranteapi.core.domain.tipousuario.TipoUsuario;
import br.com.fiap.restauranteapi.core.domain.usuario.Usuario;
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
                new Usuario(1, "João", "Silva", new TipoUsuario(1, "CLIENTE"), LocalDateTime.now()),
                "TESTE",
                "Rua de Teste, 1234",
                "BRASILEIRA", "12:00",
                "22:00",
                "2024-06-01");

        Assertions.assertEquals(1, restaurante.getId());
        Assertions.assertEquals("BRASILEIRA", restaurante.getTipoCozinha());
    }
}