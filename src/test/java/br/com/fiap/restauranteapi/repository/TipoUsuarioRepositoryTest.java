package br.com.fiap.restauranteapi.repository;

import br.com.fiap.restauranteapi.config.AbstractTest;
import br.com.fiap.restauranteapi.infra.adapter.database.repository.tipousuario.TipoUsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TipoUsuarioRepositoryTest extends AbstractTest {

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    @Test
    void existsByDescricaoTest() {
        boolean existe = Assertions.assertDoesNotThrow(() -> tipoUsuarioRepository.existsByDescricao("CLIENTE"));
        boolean naoExiste = Assertions.assertDoesNotThrow(() -> tipoUsuarioRepository.existsByDescricao("TESTE"));

        Assertions.assertTrue(existe);
        Assertions.assertFalse(naoExiste);
    }

    @Test
    void existsByDescricaoAndIdNotTest() {
        boolean existe = Assertions.assertDoesNotThrow(() -> tipoUsuarioRepository.existsByDescricaoAndIdNot("CLIENTE", 2));
        boolean naoExiste = Assertions.assertDoesNotThrow(() -> tipoUsuarioRepository.existsByDescricaoAndIdNot("ADMIN", 2));

        Assertions.assertTrue(existe);
        Assertions.assertFalse(naoExiste);
    }
}