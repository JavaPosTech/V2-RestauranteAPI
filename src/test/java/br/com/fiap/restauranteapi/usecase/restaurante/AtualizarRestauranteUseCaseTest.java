package br.com.fiap.restauranteapi.usecase.restaurante;

import br.com.fiap.restauranteapi.config.AbstractTest;
import br.com.fiap.restauranteapi.core.domain.restaurante.Restaurante;
import br.com.fiap.restauranteapi.core.domain.usuario.Usuario;
import br.com.fiap.restauranteapi.core.exceptions.RegistroNaoEncontradoException;
import br.com.fiap.restauranteapi.core.exceptions.RegraDeNegocioException;
import br.com.fiap.restauranteapi.core.usecase.restaurante.atualizar.RestauranteAtualizarUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AtualizarRestauranteUseCaseTest extends AbstractTest {

    @Autowired
    private RestauranteAtualizarUseCase restauranteAtualizarUseCase;

    private Restaurante restauranteValido(Integer usuarioId) {
        return new Restaurante(null, new Usuario(usuarioId), "SABOR ATUALIZADO", "RUA NOVA, 10", "FRANCESA", "10:00", "23:00", null);
    }

    @Test
    void executarTest() {
        Assertions.assertDoesNotThrow(() -> restauranteAtualizarUseCase.executar(1, restauranteValido(1)));
    }

    @Test
    void executarTestComRestauranteInexistente() {
        Assertions.assertThrows(RegistroNaoEncontradoException.class, () -> restauranteAtualizarUseCase.executar(999, restauranteValido(1)));
    }

    @Test
    void executarTestComUsuarioInexistente() {
        Assertions.assertThrows(RegistroNaoEncontradoException.class, () -> restauranteAtualizarUseCase.executar(1, restauranteValido(999)));
    }

    @Test
    void executarTestComUsuarioNaoDono() {
        Assertions.assertThrows(RegraDeNegocioException.class, () -> restauranteAtualizarUseCase.executar(1, restauranteValido(2)));
    }
}