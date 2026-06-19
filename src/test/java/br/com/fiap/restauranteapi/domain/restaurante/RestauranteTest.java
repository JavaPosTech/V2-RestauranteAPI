package br.com.fiap.restauranteapi.domain.restaurante;

import br.com.fiap.restauranteapi.config.AbstractTest;
import br.com.fiap.restauranteapi.core.domain.restaurante.Restaurante;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestauranteTest extends AbstractTest {

    @Test
    void domainTest() {
        Restaurante restaurante = new Restaurante(
                1,
                1,
                "TESTE",
                "Rua de Teste, 1234",
                1, "12:00",
                "22:00",
                "2024-06-01");

        Assertions.assertEquals(1, restaurante.id());
        Assertions.assertEquals(1, restaurante.tipoCozinhaId());
    }
}