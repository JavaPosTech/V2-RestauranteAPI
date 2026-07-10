package br.com.fiap.restauranteapi.usecase.usuario;

import br.com.fiap.restauranteapi.config.AbstractTest;
import br.com.fiap.restauranteapi.core.domain.usuario.Usuario;
import br.com.fiap.restauranteapi.core.exceptions.RegistroNaoEncontradoException;
import br.com.fiap.restauranteapi.core.exceptions.RegraDeNegocioException;
import br.com.fiap.restauranteapi.core.usecase.usuario.criar.CriarUsuarioUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CriarUsuarioUseCaseTest extends AbstractTest {

    @Autowired
    private CriarUsuarioUseCase criarUsuarioUseCase;

    @Test
    void executarTest() {
        Usuario usuario = Usuario.criar(
                "Eduardo",
                "Germano",
                1
        );

        Assertions.assertDoesNotThrow(() -> criarUsuarioUseCase.executar(usuario));
    }

    @Test
    void executarComTipoUsuarioInexistenteTest() {
        Usuario usuario = Usuario.criar(
                "Eduardo",
                "Germano",
                999
        );

        Assertions.assertThrows(RegistroNaoEncontradoException.class, () -> criarUsuarioUseCase.executar(usuario));
    }

    @Test
    void executarComTipoUsuarioNullTest() {
        Usuario usuario = Mockito.mock(Usuario.class);

        Mockito.when(usuario.getTipoUsuarioId()).thenReturn(null);

        Assertions.assertThrows(RegraDeNegocioException.class, () -> criarUsuarioUseCase.executar(usuario));
    }
}