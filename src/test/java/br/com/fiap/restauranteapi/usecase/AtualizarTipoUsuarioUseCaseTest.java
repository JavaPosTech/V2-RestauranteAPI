package br.com.fiap.restauranteapi.usecase;

import br.com.fiap.restauranteapi.config.AbstractTest;
import br.com.fiap.restauranteapi.core.domain.tipousuario.TipoUsuario;
import br.com.fiap.restauranteapi.core.exceptions.RegraDeNegocioException;
import br.com.fiap.restauranteapi.core.exceptions.RegistroNaoEncontradoException;
import br.com.fiap.restauranteapi.core.usecase.tipousuario.atualizar.AtualizarTipoUsuarioUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AtualizarTipoUsuarioUseCaseTest extends AbstractTest {

    @Autowired
    private AtualizarTipoUsuarioUseCase atualizarTipoUsuarioUseCase;

    @Test
    void executarTest() {
        Assertions.assertDoesNotThrow(() -> atualizarTipoUsuarioUseCase.executar(1, new TipoUsuario(null, "ADMIN")));
    }

    @Test
    void executarTestComIdInexistente() {
        Assertions.assertThrows(RegistroNaoEncontradoException.class, () -> atualizarTipoUsuarioUseCase.executar(999, new TipoUsuario(null, "ADMIN TESTE")));
    }

    @Test
    void executarTestComDescricaoJaCadastrada() {
        Assertions.assertThrows(RegraDeNegocioException.class, () -> atualizarTipoUsuarioUseCase.executar(2, new TipoUsuario(null, "CLIENTE")));
    }
}