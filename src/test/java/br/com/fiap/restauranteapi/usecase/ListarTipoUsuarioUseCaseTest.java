package br.com.fiap.restauranteapi.usecase;

import br.com.fiap.restauranteapi.config.AbstractTest;
import br.com.fiap.restauranteapi.core.usecase.tipousuario.listar.ListarTipoUsuarioUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ListarTipoUsuarioUseCaseTest extends AbstractTest {

    @Autowired
    private ListarTipoUsuarioUseCase listarTipoUsuarioUseCase;

    @Test
    void executarTest() {
        var tipoUsuarios = Assertions.assertDoesNotThrow(() -> listarTipoUsuarioUseCase.executar());
        Assertions.assertNotNull(tipoUsuarios);
    }
}