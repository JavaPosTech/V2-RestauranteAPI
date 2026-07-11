package br.com.fiap.restauranteapi.usecase.usuario;

import br.com.fiap.restauranteapi.config.AbstractTest;
import br.com.fiap.restauranteapi.core.domain.tipousuario.TipoUsuario;
import br.com.fiap.restauranteapi.core.domain.usuario.Usuario;
import br.com.fiap.restauranteapi.core.exceptions.RegistroNaoEncontradoException;
import br.com.fiap.restauranteapi.core.exceptions.RegraDeNegocioException;
import br.com.fiap.restauranteapi.core.usecase.usuario.atualizar.AtualizarUsuarioUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AtualizarUsuarioUseCaseTest extends AbstractTest {

    @Autowired
    private AtualizarUsuarioUseCase atualizarUsuarioUseCase;

    @Test
    void executarTest() {
        Usuario usuario = Usuario.atualizar(
                "Eduardo Atualizado",
                null,
                null
        );

        Assertions.assertDoesNotThrow(() -> atualizarUsuarioUseCase.executar(1, usuario));
    }

    @Test
    void executarComUsuarioInexistenteTest() {
        Usuario usuario = Usuario.atualizar(
                "Eduardo",
                null,
                null
        );

        Assertions.assertThrows(RegistroNaoEncontradoException.class, () -> atualizarUsuarioUseCase.executar(999, usuario));
    }

    @Test
    void executarComTipoUsuarioInexistenteTest() {
        Usuario usuario = Usuario.atualizar(
                null,
                null,
                new TipoUsuario(999)
        );

        Assertions.assertThrows(RegistroNaoEncontradoException.class, () -> atualizarUsuarioUseCase.executar(1, usuario));
    }
    @Test
    void executarAtualizandoSomenteSobrenomeTest() {
        Usuario usuario = Usuario.atualizar(
                null,
                "Germano Atualizado",
                null
        );

        Assertions.assertDoesNotThrow(() -> atualizarUsuarioUseCase.executar(1, usuario));
    }

    @Test
    void executarComIdNullTest() {
        Usuario usuario = Usuario.atualizar(
                "Eduardo",
                null,
                null
        );

        Assertions.assertThrows(RegraDeNegocioException.class, () -> atualizarUsuarioUseCase.executar(null, usuario));
    }
}