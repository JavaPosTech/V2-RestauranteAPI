package br.com.fiap.restauranteapi.usecase.tipousuario;

import br.com.fiap.restauranteapi.config.AbstractTest;
import br.com.fiap.restauranteapi.core.domain.tipousuario.TipoUsuario;
import br.com.fiap.restauranteapi.core.exceptions.RegraDeNegocioException;
import br.com.fiap.restauranteapi.core.usecase.tipousuario.criar.CriarTipoUsuarioUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CriarTipoUsuarioUseCaseTest extends AbstractTest {

    @Autowired
    private CriarTipoUsuarioUseCase criarTipoUsuarioUseCase;

    @Test
    void executarTest() {
        Assertions.assertDoesNotThrow(() -> criarTipoUsuarioUseCase.executar(new TipoUsuario(null, "TESTE")));
    }

    @Test
    void executarTestComDescricaoJaCadastrada() {
        Assertions.assertThrows(RegraDeNegocioException.class, () -> criarTipoUsuarioUseCase.executar(new TipoUsuario(null, "CLIENTE")));
    }
}