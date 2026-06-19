package br.com.fiap.restauranteapi.usecase;

import br.com.fiap.restauranteapi.config.AbstractTest;
import br.com.fiap.restauranteapi.core.exceptions.BusinessException;
import br.com.fiap.restauranteapi.core.exceptions.ResourceNotFoundException;
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
        Assertions.assertThrows(BusinessException.class, () -> deletarTipoUsuarioUseCase.executar(null));
    }

    @Test
    void executarTestComIdInexistente() {
        Assertions.assertThrows(ResourceNotFoundException.class, () -> deletarTipoUsuarioUseCase.executar(999));
    }
}