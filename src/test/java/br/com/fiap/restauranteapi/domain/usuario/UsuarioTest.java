package br.com.fiap.restauranteapi.domain.usuario;

import br.com.fiap.restauranteapi.config.AbstractTest;
import br.com.fiap.restauranteapi.core.domain.tipousuario.TipoUsuario;
import br.com.fiap.restauranteapi.core.domain.usuario.Usuario;
import br.com.fiap.restauranteapi.core.enums.ESituacaoCadastro;
import br.com.fiap.restauranteapi.core.exceptions.RegraDeNegocioException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class UsuarioTest extends AbstractTest {

    @Test
    void domainTest() {
        Usuario usuario = new Usuario(1, "Eduardo", "Germano", new TipoUsuario(1), LocalDateTime.now(), ESituacaoCadastro.ATIVO);

        Assertions.assertEquals(1, usuario.getId());
        Assertions.assertEquals("Eduardo", usuario.getNome());
        Assertions.assertEquals("Germano", usuario.getSobrenome());
        Assertions.assertEquals(1, usuario.getTipoUsuario().getId());
        Assertions.assertEquals(ESituacaoCadastro.ATIVO, usuario.getSituacaoCadastro());
    }

    @Test
    void construtorComSituacaoNullDeveDefinirAtivoTest() {
        Usuario usuario = new Usuario(1, "Eduardo", "Germano", new TipoUsuario(1), LocalDateTime.now(), null);
        Assertions.assertEquals(ESituacaoCadastro.ATIVO, usuario.getSituacaoCadastro());
    }

    @Test
    void criarTest() {
        Assertions.assertDoesNotThrow(() -> Usuario.criar("Eduardo", "Germano", new TipoUsuario(1)));
    }

    @Test
    void criarComNomeNullTest() {
        Assertions.assertThrows(RegraDeNegocioException.class, () -> Usuario.criar(null, "Germano", new TipoUsuario(1)));
    }

    @Test
    void criarComNomeVazioTest() {
        Assertions.assertThrows(RegraDeNegocioException.class, () -> Usuario.criar("   ", "Germano", new TipoUsuario(1)));
    }

    @Test
    void criarComSobrenomeNullTest() {
        Assertions.assertThrows(RegraDeNegocioException.class, () -> Usuario.criar("Eduardo", null, new TipoUsuario(1)));
    }

    @Test
    void criarComSobrenomeVazioTest() {
        Assertions.assertThrows(RegraDeNegocioException.class, () -> Usuario.criar("Eduardo", "   ", new TipoUsuario(1)));
    }

    @Test
    void criarComTipoUsuarioNullTest() {
        Assertions.assertThrows(RegraDeNegocioException.class, () -> Usuario.criar("Eduardo", "Germano", null));
    }

    @Test
    void atualizarSemCamposTest() {
        Assertions.assertThrows(RegraDeNegocioException.class, () -> Usuario.atualizar(null, null, null));
    }

    @Test
    void atualizarComNomeVazioTest() {
        Assertions.assertThrows(RegraDeNegocioException.class, () -> Usuario.atualizar("   ", null, null));
    }

    @Test
    void atualizarComSobrenomeVazioTest() {
        Assertions.assertThrows(RegraDeNegocioException.class, () -> Usuario.atualizar(null, "   ", null));
    }

    @Test
    void atualizarSomenteNomeTest() {
        Assertions.assertDoesNotThrow(() -> Usuario.atualizar("Novo nome", null, null));
    }

    @Test
    void atualizarSomenteSobrenomeTest() {
        Assertions.assertDoesNotThrow(() -> Usuario.atualizar(null, "Novo sobrenome", null));
    }

    @Test
    void atualizarSomenteTipoUsuarioTest() {
        Assertions.assertDoesNotThrow(() -> Usuario.atualizar(null, null, new TipoUsuario(2)));
    }

    @Test
    void dominioNaoDeveValidarTipoUsuarioExistenteTest() {
        Assertions.assertDoesNotThrow(() -> Usuario.criar("Eduardo", "Germano", new TipoUsuario(999)));
    }
}