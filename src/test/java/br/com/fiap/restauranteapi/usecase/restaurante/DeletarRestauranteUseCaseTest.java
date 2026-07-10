package br.com.fiap.restauranteapi.usecase.restaurante;

import br.com.fiap.restauranteapi.config.AbstractTest;
import br.com.fiap.restauranteapi.core.exceptions.RegistroNaoEncontradoException;
import br.com.fiap.restauranteapi.core.exceptions.RegraDeNegocioException;
import br.com.fiap.restauranteapi.core.usecase.restaurante.deletar.RestauranteDeletarUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DeletarRestauranteUseCaseTest extends AbstractTest {

    @Autowired
    private RestauranteDeletarUseCase restauranteDeletarUseCase;

    @Test
    void executarTest() {
        Assertions.assertDoesNotThrow(() -> restauranteDeletarUseCase.executar(1, 1));
    }

    @Test
    void executarTestComRestauranteInexistente() {
        Assertions.assertThrows(RegistroNaoEncontradoException.class,
                () -> restauranteDeletarUseCase.executar(999, 1));
    }

    @Test
    void executarTestComUsuarioInexistente() {
        Assertions.assertThrows(RegistroNaoEncontradoException.class,
                () -> restauranteDeletarUseCase.executar(1, 999));
    }

    @Test
    void executarTestComUsuarioNaoDono() {
        Assertions.assertThrows(RegraDeNegocioException.class,
                () -> restauranteDeletarUseCase.executar(2, 1));
    }
}