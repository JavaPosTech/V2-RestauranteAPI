package br.com.fiap.restauranteapi.usecase;

import br.com.fiap.restauranteapi.config.AbstractTest;
import br.com.fiap.restauranteapi.core.exceptions.RegistroNaoEncontradoException;
import br.com.fiap.restauranteapi.core.exceptions.RegraDeNegocioException;
import br.com.fiap.restauranteapi.core.usecase.usuario.deletar.DeletarUsuarioUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DeletarUsuarioUseCaseTest extends AbstractTest {

    @Autowired
    private DeletarUsuarioUseCase deletarUsuarioUseCase;

    @Test
    void executarTest() {
        Assertions.assertDoesNotThrow(() -> deletarUsuarioUseCase.executar(1));
    }

    @Test
    void executarComUsuarioInexistenteTest() {
        Assertions.assertThrows(RegistroNaoEncontradoException.class, () -> deletarUsuarioUseCase.executar(999));
    }

    @Test
    void executarComIdNullTest() {
        Assertions.assertThrows(RegraDeNegocioException.class, () -> deletarUsuarioUseCase.executar(null));
    }
}