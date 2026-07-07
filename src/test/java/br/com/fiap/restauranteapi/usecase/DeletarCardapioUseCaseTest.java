package br.com.fiap.restauranteapi.usecase;

import br.com.fiap.restauranteapi.config.AbstractTest;
import br.com.fiap.restauranteapi.core.exceptions.RegistroNaoEncontradoException;
import br.com.fiap.restauranteapi.core.exceptions.RegraDeNegocioException;
import br.com.fiap.restauranteapi.core.usecase.cardapio.deletar.DeletarCardapioUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DeletarCardapioUseCaseTest extends AbstractTest {

    @Autowired
    private DeletarCardapioUseCase deletarCardapioUseCase;

    @Test
    void executarTest() {
        Assertions.assertDoesNotThrow(() -> deletarCardapioUseCase.executar(1, 1));
    }

    @Test
    void executarTestComCardapioInexistente() {
        Assertions.assertThrows(RegistroNaoEncontradoException.class,
                () -> deletarCardapioUseCase.executar(999, 1));
    }

    @Test
    void executarTestComUsuarioNaoDono() {
        Assertions.assertThrows(RegraDeNegocioException.class,
                () -> deletarCardapioUseCase.executar(1, 2));
    }
}