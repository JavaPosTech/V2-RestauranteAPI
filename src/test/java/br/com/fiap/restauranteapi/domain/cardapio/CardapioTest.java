package br.com.fiap.restauranteapi.domain.cardapio;

import br.com.fiap.restauranteapi.config.AbstractTest;
import br.com.fiap.restauranteapi.core.domain.cardapio.Cardapio;
import br.com.fiap.restauranteapi.core.domain.restaurante.Restaurante;
import br.com.fiap.restauranteapi.core.domain.usuario.Usuario;
import br.com.fiap.restauranteapi.core.enums.ESituacaoCadastro;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CardapioTest extends AbstractTest {

    @Test
    void deveCriarCardapioComDadosValidos() {
        Restaurante restaurante = criarRestauranteValido();

        Cardapio cardapio = new Cardapio(
                1,
                restaurante,
                "Pizza Calabresa",
                "Pizza com calabresa, queijo e cebola",
                BigDecimal.valueOf(49.90),
                true,
                "foto-pizza.jpg"
        );

        assertNotNull(cardapio);
        assertEquals(1, cardapio.getId());
        assertEquals(restaurante, cardapio.getRestaurante());
        assertEquals("Pizza Calabresa", cardapio.getNome());
        assertEquals("Pizza com calabresa, queijo e cebola", cardapio.getDescricao());
        assertEquals(BigDecimal.valueOf(49.90), cardapio.getPreco());
        assertTrue(cardapio.isConsumoLocal());
        assertEquals("foto-pizza.jpg", cardapio.getFoto());
    }

    @Test
    void deveRemoverEspacosDoNomeAoCriarCardapio() {
        Restaurante restaurante = criarRestauranteValido();

        Cardapio cardapio = new Cardapio(
                1,
                restaurante,
                "   Pizza Calabresa   ",
                "Pizza com calabresa",
                BigDecimal.valueOf(49.90),
                true,
                "foto.jpg"
        );

        assertEquals("Pizza Calabresa", cardapio.getNome());
    }

    @Test
    void devePermitirCriarCardapioComIdNulo() {
        Restaurante restaurante = criarRestauranteValido();

        Cardapio cardapio = new Cardapio(
                null,
                restaurante,
                "Pizza Calabresa",
                "Pizza com calabresa",
                BigDecimal.valueOf(49.90),
                true,
                "foto.jpg"
        );

        assertNotNull(cardapio);
        assertNull(cardapio.getId());
    }

    @Test
    void deveLancarExcecaoQuandoIdForMenorOuIgualAZero() {
        Restaurante restaurante = criarRestauranteValido();

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Cardapio(
                        0,
                        restaurante,
                        "Pizza Calabresa",
                        "Pizza com calabresa",
                        BigDecimal.valueOf(49.90),
                        true,
                        "foto.jpg"
                )
        );

        assertEquals("O id do cardápio deve ser maior que zero!", exception.getMessage());
    }

    @Test
    void deveLancarExcecaoQuandoRestauranteForNulo() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Cardapio(
                        1,
                        null,
                        "Pizza Calabresa",
                        "Pizza com calabresa",
                        BigDecimal.valueOf(49.90),
                        true,
                        "foto.jpg"
                )
        );

        assertEquals("O restaurante é obrigatório!", exception.getMessage());
    }

    @Test
    void deveLancarExcecaoQuandoNomeForNulo() {
        Restaurante restaurante = criarRestauranteValido();

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Cardapio(
                        1,
                        restaurante,
                        null,
                        "Pizza com calabresa",
                        BigDecimal.valueOf(49.90),
                        true,
                        "foto.jpg"
                )
        );

        assertEquals("O nome do item do cardápio é obrigatório!", exception.getMessage());
    }

    @Test
    void deveLancarExcecaoQuandoNomeForVazio() {
        Restaurante restaurante = criarRestauranteValido();

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Cardapio(
                        1,
                        restaurante,
                        "",
                        "Pizza com calabresa",
                        BigDecimal.valueOf(49.90),
                        true,
                        "foto.jpg"
                )
        );

        assertEquals("O nome do item do cardápio é obrigatório!", exception.getMessage());
    }

    @Test
    void deveLancarExcecaoQuandoNomeForEmBranco() {
        Restaurante restaurante = criarRestauranteValido();

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Cardapio(
                        1,
                        restaurante,
                        "     ",
                        "Pizza com calabresa",
                        BigDecimal.valueOf(49.90),
                        true,
                        "foto.jpg"
                )
        );

        assertEquals("O nome do item do cardápio é obrigatório!", exception.getMessage());
    }

    @Test
    void deveLancarExcecaoQuandoNomeForMaiorQueCemCaracteres() {
        Restaurante restaurante = criarRestauranteValido();
        String nomeGrande = "A".repeat(101);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Cardapio(
                        1,
                        restaurante,
                        nomeGrande,
                        "Descrição",
                        BigDecimal.valueOf(49.90),
                        true,
                        "foto.jpg"
                )
        );

        assertEquals("O nome do item do cardápio deve ter no máximo 100 caracteres!", exception.getMessage());
    }

    @Test
    void deveLancarExcecaoQuandoPrecoForNulo() {
        Restaurante restaurante = criarRestauranteValido();

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Cardapio(
                        1,
                        restaurante,
                        "Pizza Calabresa",
                        "Pizza com calabresa",
                        null,
                        true,
                        "foto.jpg"
                )
        );

        assertEquals("O preço do item do cardápio é obrigatório!", exception.getMessage());
    }

    @Test
    void deveLancarExcecaoQuandoPrecoForZero() {
        Restaurante restaurante = criarRestauranteValido();

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Cardapio(
                        1,
                        restaurante,
                        "Pizza Calabresa",
                        "Pizza com calabresa",
                        BigDecimal.ZERO,
                        true,
                        "foto.jpg"
                )
        );

        assertEquals("O preço do item do cardápio deve ser maior que zero!", exception.getMessage());
    }

    @Test
    void deveLancarExcecaoQuandoPrecoForNegativo() {
        Restaurante restaurante = criarRestauranteValido();

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Cardapio(
                        1,
                        restaurante,
                        "Pizza Calabresa",
                        "Pizza com calabresa",
                        BigDecimal.valueOf(-10),
                        true,
                        "foto.jpg"
                )
        );

        assertEquals("O preço do item do cardápio deve ser maior que zero!", exception.getMessage());
    }

    @Test
    void deveAtualizarDadosDoCardapio() {
        Restaurante restaurante = criarRestauranteValido();

        Cardapio cardapio = new Cardapio(
                1,
                restaurante,
                "Pizza Calabresa",
                "Pizza com calabresa",
                BigDecimal.valueOf(49.90),
                true,
                "foto-antiga.jpg"
        );

        cardapio.atualizarDados(
                "Pizza Frango",
                "Pizza com frango e catupiry",
                BigDecimal.valueOf(59.90),
                false,
                "foto-nova.jpg"
        );

        assertEquals("Pizza Frango", cardapio.getNome());
        assertEquals("Pizza com frango e catupiry", cardapio.getDescricao());
        assertEquals(BigDecimal.valueOf(59.90), cardapio.getPreco());
        assertFalse(cardapio.isConsumoLocal());
        assertEquals("foto-nova.jpg", cardapio.getFoto());
    }

    @Test
    void deveLancarExcecaoAoAtualizarComNomeInvalido() {
        Restaurante restaurante = criarRestauranteValido();

        Cardapio cardapio = new Cardapio(
                1,
                restaurante,
                "Pizza Calabresa",
                "Pizza com calabresa",
                BigDecimal.valueOf(49.90),
                true,
                "foto.jpg"
        );

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> cardapio.atualizarDados(
                        "",
                        "Nova descrição",
                        BigDecimal.valueOf(59.90),
                        true,
                        "nova-foto.jpg"
                )
        );

        assertEquals("O nome do item do cardápio é obrigatório!", exception.getMessage());
    }

    @Test
    void deveLancarExcecaoAoAtualizarComPrecoInvalido() {
        Restaurante restaurante = criarRestauranteValido();

        Cardapio cardapio = new Cardapio(
                1,
                restaurante,
                "Pizza Calabresa",
                "Pizza com calabresa",
                BigDecimal.valueOf(49.90),
                true,
                "foto.jpg"
        );

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> cardapio.atualizarDados(
                        "Pizza Frango",
                        "Nova descrição",
                        BigDecimal.ZERO,
                        true,
                        "nova-foto.jpg"
                )
        );

        assertEquals("O preço do item do cardápio deve ser maior que zero!", exception.getMessage());
    }

    @Test
    void deveVerificarSeCardapioPertenceAoRestaurante() {
        Restaurante restaurante = criarRestauranteValido();

        Cardapio cardapio = new Cardapio(
                1,
                restaurante,
                "Pizza Calabresa",
                "Pizza com calabresa",
                BigDecimal.valueOf(49.90),
                true,
                "foto.jpg"
        );

        assertTrue(cardapio.pertenceAoRestaurante(1));
    }

    @Test
    void deveRetornarFalsoQuandoCardapioNaoPertenceAoRestaurante() {
        Restaurante restaurante = criarRestauranteValido();

        Cardapio cardapio = new Cardapio(
                1,
                restaurante,
                "Pizza Calabresa",
                "Pizza com calabresa",
                BigDecimal.valueOf(49.90),
                true,
                "foto.jpg"
        );

        assertFalse(cardapio.pertenceAoRestaurante(2));
    }

    @Test
    void deveVerificarSePermiteConsumoLocal() {
        Restaurante restaurante = criarRestauranteValido();

        Cardapio cardapio = new Cardapio(
                1,
                restaurante,
                "Pizza Calabresa",
                "Pizza com calabresa",
                BigDecimal.valueOf(49.90),
                true,
                "foto.jpg"
        );

        assertTrue(cardapio.permiteConsumoLocal());
    }

    private Restaurante criarRestauranteValido() {
        return new Restaurante(
                1,
                new Usuario(1, "João", "Silva", 1, LocalDateTime.now(), ESituacaoCadastro.ATIVO),
                "TESTE",
                "Rua de Teste, 1234",
                "BRASILEIRA", "12:00",
                "22:00",
                LocalDateTime.now());
    }
}