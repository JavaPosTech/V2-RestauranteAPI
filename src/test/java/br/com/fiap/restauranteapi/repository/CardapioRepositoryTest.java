package br.com.fiap.restauranteapi.repository;

import br.com.fiap.restauranteapi.config.AbstractTest;
import br.com.fiap.restauranteapi.infra.adapter.database.repository.cardapio.CardapioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CardapioRepositoryTest extends AbstractTest {

    @Autowired
    private CardapioRepository cardapioRepository;

    @Test
    void findByRestauranteIdTest() {
        var cardapios = Assertions.assertDoesNotThrow(() -> cardapioRepository.findByRestauranteId(1));

        Assertions.assertNotNull(cardapios);
        Assertions.assertFalse(cardapios.isEmpty());
        Assertions.assertTrue(cardapios.stream().allMatch(cardapio -> cardapio.getRestauranteId().equals(1)));
    }

    @Test
    void findByRestauranteIdSemResultadoTest() {
        var cardapios = Assertions.assertDoesNotThrow(() -> cardapioRepository.findByRestauranteId(999));

        Assertions.assertNotNull(cardapios);
        Assertions.assertTrue(cardapios.isEmpty());
    }
}