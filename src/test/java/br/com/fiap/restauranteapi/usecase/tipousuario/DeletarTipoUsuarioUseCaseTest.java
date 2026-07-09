package br.com.fiap.restauranteapi.usecase.tipousuario;

import br.com.fiap.restauranteapi.config.AbstractTest;
import br.com.fiap.restauranteapi.core.exceptions.RegistroNaoEncontradoException;
import br.com.fiap.restauranteapi.core.exceptions.RegraDeNegocioException;
import br.com.fiap.restauranteapi.core.usecase.tipousuario.deletar.DeletarTipoUsuarioUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DeletarTipoUsuarioUseCaseTest extends AbstractTest {

    @Autowired
    private DeletarTipoUsuarioUseCase deletarTipoUsuarioUseCase;

    @Test
    void executarTest() {
        Assertions.assertDoesNotThrow(() -> deletarTipoUsuarioUseCase.executar(1));
    }

    @Test
    void executarTestComIdNull() {
        Assertions.assertThrows(RegraDeNegocioException.class, () -> deletarTipoUsuarioUseCase.executar(null));
    }

    @Test
    void executarTestComIdInexistente() {
        Assertions.assertThrows(RegistroNaoEncontradoException.class, () -> deletarTipoUsuarioUseCase.executar(999));
    }
}