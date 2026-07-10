package br.com.fiap.restauranteapi.usecase.restaurante;

import br.com.fiap.restauranteapi.config.AbstractTest;
import br.com.fiap.restauranteapi.core.exceptions.RegistroNaoEncontradoException;
import br.com.fiap.restauranteapi.core.usecase.restaurante.listar.RestauranteListarUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class RestauranteListarUseCaseTest extends AbstractTest {

    @Autowired
    private RestauranteListarUseCase restauranteListarUseCase;

    @Test
    void executarTest() {
        var restaurantes = Assertions.assertDoesNotThrow(() -> restauranteListarUseCase.executar(1));
        assertNotNull(restaurantes);
    }

    @Test
    void executarTestRestauranteInexistente() {
        Assertions.assertThrows(RegistroNaoEncontradoException.class, () -> restauranteListarUseCase.executar(Integer.MAX_VALUE));
    }
}