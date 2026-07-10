package br.com.fiap.restauranteapi.usecase;

import br.com.fiap.restauranteapi.config.AbstractTest;
import br.com.fiap.restauranteapi.core.usecase.cardapio.listar.ListarCardapioUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ListarCardapioUseCaseTest extends AbstractTest {

    @Autowired
    private ListarCardapioUseCase listarCardapioUseCase;

    @Test
    void executarTest() {
        var cardapios = Assertions.assertDoesNotThrow(() -> listarCardapioUseCase.executar());

        Assertions.assertNotNull(cardapios);
        Assertions.assertFalse(cardapios.isEmpty());
    }

    @Test
    void executarPorRestauranteTest() {
        var cardapios = Assertions.assertDoesNotThrow(() -> listarCardapioUseCase.executarPorRestaurante(1));

        Assertions.assertNotNull(cardapios);
        Assertions.assertFalse(cardapios.isEmpty());
        Assertions.assertTrue(cardapios.stream().allMatch(cardapio -> cardapio.restauranteId().equals(1)));
    }
}