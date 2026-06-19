package br.com.fiap.restauranteapi.domain.cardapio;

import br.com.fiap.restauranteapi.config.AbstractTest;
import br.com.fiap.restauranteapi.core.domain.cardapio.Cardapio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class CardapioTest extends AbstractTest {

    @Test
    void domainTest() {
        Cardapio cardapio = new Cardapio(
                1,
                1,
                "TESTE",
                "TESTE",
                BigDecimal.TEN,
                true,
                "foto.png");

        Assertions.assertEquals(1, cardapio.id());
        Assertions.assertEquals("TESTE", cardapio.descricao());
    }
}