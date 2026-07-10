package br.com.fiap.restauranteapi.usecase;

import br.com.fiap.restauranteapi.config.AbstractTest;
import br.com.fiap.restauranteapi.core.usecase.usuario.listar.ListarUsuarioUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ListarUsuarioUseCaseTest extends AbstractTest {

    @Autowired
    private ListarUsuarioUseCase listarUsuarioUseCase;

    @Test
    void executarTest() {
        var usuarios = Assertions.assertDoesNotThrow(
                () -> listarUsuarioUseCase.executar()
        );

        Assertions.assertNotNull(usuarios);
    }
}