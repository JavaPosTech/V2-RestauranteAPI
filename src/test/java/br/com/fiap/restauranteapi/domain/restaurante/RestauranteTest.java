package br.com.fiap.restauranteapi.domain.restaurante;

import br.com.fiap.restauranteapi.config.AbstractTest;
import br.com.fiap.restauranteapi.core.domain.restaurante.Restaurante;
import br.com.fiap.restauranteapi.core.domain.tipousuario.TipoUsuario;
import br.com.fiap.restauranteapi.core.domain.usuario.Usuario;
import br.com.fiap.restauranteapi.core.enums.ESituacaoCadastro;
import br.com.fiap.restauranteapi.core.exceptions.RegraDeNegocioException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class RestauranteTest extends AbstractTest {

    private Usuario usuarioValido() {
        return new Usuario(1, "João", "Silva", new TipoUsuario(1), LocalDateTime.now(), ESituacaoCadastro.ATIVO);
    }

    private Restaurante criarRestaurante(
            Usuario usuario,
            String nome,
            String endereco,
            String tipoCozinha,
            String horaAbertura,
            String horaFechamento,
            LocalDateTime dataCriacao
    ) {
        return new Restaurante(1, usuario, nome, endereco, tipoCozinha, horaAbertura, horaFechamento, dataCriacao);
    }

    @Test
    void domainTest() {
        Restaurante restaurante = new Restaurante(
                1,
                new Usuario(1, "João", "Silva", new TipoUsuario(1), LocalDateTime.now(), ESituacaoCadastro.ATIVO),
                "TESTE",
                "Rua de Teste, 1234",
                "BRASILEIRA", "12:00",
                "22:00",
                LocalDateTime.now());

        Assertions.assertEquals(1, restaurante.getId());
        Assertions.assertEquals("BRASILEIRA", restaurante.getTipoCozinha());
    }

    @Test
    void usuarioNuloTest() {
        Assertions.assertThrows(RegraDeNegocioException.class, () ->
                criarRestaurante(null, "TESTE", "Rua de Teste, 1234", "BRASILEIRA", "12:00", "22:00", LocalDateTime.now()));
    }

    @Test
    void usuarioSemIdTest() {
        Usuario usuarioSemId = new Usuario(null, "João", "Silva", new TipoUsuario(1), LocalDateTime.now(), ESituacaoCadastro.ATIVO);

        Assertions.assertThrows(RegraDeNegocioException.class, () ->
                criarRestaurante(usuarioSemId, "TESTE", "Rua de Teste, 1234", "BRASILEIRA", "12:00", "22:00", LocalDateTime.now()));
    }

    @Test
    void nomeNuloTest() {
        Assertions.assertThrows(RegraDeNegocioException.class, () ->
                criarRestaurante(usuarioValido(), null, "Rua de Teste, 1234", "BRASILEIRA", "12:00", "22:00", LocalDateTime.now()));
    }

    @Test
    void nomeVazioTest() {
        Assertions.assertThrows(RegraDeNegocioException.class, () ->
                criarRestaurante(usuarioValido(), "", "Rua de Teste, 1234", "BRASILEIRA", "12:00", "22:00", LocalDateTime.now()));
    }

    @Test
    void enderecoNuloTest() {
        Assertions.assertThrows(RegraDeNegocioException.class, () ->
                criarRestaurante(usuarioValido(), "TESTE", null, "BRASILEIRA", "12:00", "22:00", LocalDateTime.now()));
    }

    @Test
    void enderecoVazioTest() {
        Assertions.assertThrows(RegraDeNegocioException.class, () ->
                criarRestaurante(usuarioValido(), "TESTE", "", "BRASILEIRA", "12:00", "22:00", LocalDateTime.now()));
    }

    @Test
    void tipoCozinhaNuloTest() {
        Assertions.assertThrows(RegraDeNegocioException.class, () ->
                criarRestaurante(usuarioValido(), "TESTE", "Rua de Teste, 1234", null, "12:00", "22:00", LocalDateTime.now()));
    }

    @Test
    void tipoCozinhaVazioTest() {
        Assertions.assertThrows(RegraDeNegocioException.class, () ->
                criarRestaurante(usuarioValido(), "TESTE", "Rua de Teste, 1234", "", "12:00", "22:00", LocalDateTime.now()));
    }

    @Test
    void horaAberturaNulaTest() {
        Assertions.assertThrows(RegraDeNegocioException.class, () ->
                criarRestaurante(usuarioValido(), "TESTE", "Rua de Teste, 1234", "BRASILEIRA", null, "22:00", LocalDateTime.now()));
    }

    @Test
    void horaAberturaVaziaTest() {
        Assertions.assertThrows(RegraDeNegocioException.class, () ->
                criarRestaurante(usuarioValido(), "TESTE", "Rua de Teste, 1234", "BRASILEIRA", "", "22:00", LocalDateTime.now()));
    }

    @Test
    void horaAberturaFormatoInvalidoTest() {
        Assertions.assertThrows(RegraDeNegocioException.class, () ->
                criarRestaurante(usuarioValido(), "TESTE", "Rua de Teste, 1234", "BRASILEIRA", "25:00", "22:00", LocalDateTime.now()));
    }

    @Test
    void horaFechamentoNulaTest() {
        Assertions.assertThrows(RegraDeNegocioException.class, () ->
                criarRestaurante(usuarioValido(), "TESTE", "Rua de Teste, 1234", "BRASILEIRA", "12:00", null, LocalDateTime.now()));
    }

    @Test
    void horaFechamentoVaziaTest() {
        Assertions.assertThrows(RegraDeNegocioException.class, () ->
                criarRestaurante(usuarioValido(), "TESTE", "Rua de Teste, 1234", "BRASILEIRA", "12:00", "", LocalDateTime.now()));
    }

    @Test
    void horaFechamentoFormatoInvalidoTest() {
        Assertions.assertThrows(RegraDeNegocioException.class, () ->
                criarRestaurante(usuarioValido(), "TESTE", "Rua de Teste, 1234", "BRASILEIRA", "12:00", "abc", LocalDateTime.now()));
    }

    @Test
    void horaAberturaIgualHoraFechamentoTest() {
        Assertions.assertThrows(RegraDeNegocioException.class, () ->
                criarRestaurante(usuarioValido(), "TESTE", "Rua de Teste, 1234", "BRASILEIRA", "12:00", "12:00", LocalDateTime.now()));
    }

    @Test
    void horaAberturaDepoisDaHoraFechamentoTest() {
        Assertions.assertThrows(RegraDeNegocioException.class, () ->
                criarRestaurante(usuarioValido(), "TESTE", "Rua de Teste, 1234", "BRASILEIRA", "22:00", "12:00", LocalDateTime.now()));
    }

    @Test
    void dataCriacaoNulaNaoLancaExcecaoTest() {
        Assertions.assertDoesNotThrow(() ->
                criarRestaurante(usuarioValido(), "TESTE", "Rua de Teste, 1234", "BRASILEIRA", "12:00", "22:00", null));
    }

    @Test
    void pertenceAoUsuarioTest() {
        Restaurante restaurante = new Restaurante(
                1,
                new Usuario(1, "João", "Silva", new TipoUsuario(1), LocalDateTime.now(), ESituacaoCadastro.ATIVO),
                "TESTE",
                "Rua de Teste, 1234",
                "BRASILEIRA", "12:00",
                "22:00",
                LocalDateTime.now());

        Assertions.assertTrue(restaurante.pertenceAoUsuario(1));
    }

    @Test
    void naoPertenceAoUsuarioTest() {
        Restaurante restaurante = new Restaurante(
                1,
                new Usuario(1, "João", "Silva", new TipoUsuario(1), LocalDateTime.now(), ESituacaoCadastro.ATIVO),
                "TESTE",
                "Rua de Teste, 1234",
                "BRASILEIRA", "12:00",
                "22:00",
                LocalDateTime.now());

        Assertions.assertFalse(restaurante.pertenceAoUsuario(2));
    }
}