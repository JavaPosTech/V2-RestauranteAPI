package br.com.fiap.restauranteapi.usecase.restaurante;

import br.com.fiap.restauranteapi.config.AbstractTest;
import br.com.fiap.restauranteapi.core.domain.restaurante.Restaurante;
import br.com.fiap.restauranteapi.core.domain.usuario.Usuario;
import br.com.fiap.restauranteapi.core.exceptions.RegistroNaoEncontradoException;
import br.com.fiap.restauranteapi.core.exceptions.RegraDeNegocioException;
import br.com.fiap.restauranteapi.core.usecase.restaurante.criar.RestauranteCriarUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class RestauranteCriarUseCaseTest extends AbstractTest {

    @Autowired
    private RestauranteCriarUseCase restauranteCriarUseCase;

    @Test
    void executarTest() {
        Assertions.assertDoesNotThrow(() -> restauranteCriarUseCase.executar(new Restaurante(
                1,
                new Usuario(1),
                "123456789",
                "RUA NOVA",
                "BRASILEIRA",
                "10:00",
                "22:00",
                LocalDate.now().toString())));
    }

    @Test
    void executarTestUsuarioInexistente() {
        Assertions.assertThrows(RegistroNaoEncontradoException.class, () -> restauranteCriarUseCase.executar(new Restaurante(
                1,
                new Usuario(Integer.MAX_VALUE),
                "123456789",
                "RUA NOVA",
                "BRASILEIRA",
                "10:00",
                "22:00",
                LocalDate.now().toString())));
    }

    @Test
    void executarTestUsuarioCliente() {
        Assertions.assertThrows(RegraDeNegocioException.class, () -> restauranteCriarUseCase.executar(new Restaurante(
                1,
                new Usuario(5),
                "123456789",
                "RUA NOVA",
                "BRASILEIRA",
                "10:00",
                "22:00",
                LocalDate.now().toString())));
    }
}