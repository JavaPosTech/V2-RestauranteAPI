package br.com.fiap.restauranteapi.repository;

import br.com.fiap.restauranteapi.config.AbstractTest;
import br.com.fiap.restauranteapi.core.enums.ESituacaoCadastro;
import br.com.fiap.restauranteapi.infra.adapter.database.repository.usuario.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UsuarioRepositoryTest extends AbstractTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    void findAllTest() {
        var usuarios = usuarioRepository.findAll();

        Assertions.assertNotNull(usuarios);
        Assertions.assertFalse(usuarios.isEmpty());

        Assertions.assertTrue(
                usuarios.stream().allMatch(usuario ->
                        usuario.getSituacaoCadastroId() != null
                )
        );
    }
    @Test
    void findByIdAndSituacaoCadastroIdTest() {
        var usuario = usuarioRepository.findByIdAndSituacaoCadastroId(
                1,
                ESituacaoCadastro.ATIVO.getCodigo()
        );

        Assertions.assertTrue(usuario.isPresent());
    }
}