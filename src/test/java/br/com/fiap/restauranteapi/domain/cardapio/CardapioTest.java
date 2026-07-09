package br.com.fiap.restauranteapi.domain.cardapio;

import br.com.fiap.restauranteapi.config.AbstractTest;
import br.com.fiap.restauranteapi.core.domain.cardapio.Cardapio;
import br.com.fiap.restauranteapi.core.domain.restaurante.Restaurante;
import br.com.fiap.restauranteapi.core.domain.usuario.Usuario;
import br.com.fiap.restauranteapi.core.enums.ESituacaoCadastro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringBootTest
class CardapioTest extends AbstractTest {

    @Test
    void domainTest() {
        Usuario usuario = new Usuario(1, "João", "Silva", 1, LocalDateTime.now(), ESituacaoCadastro.ATIVO);

        Restaurante restaurante = new Restaurante(
                1,
                usuario,
                "Restaurante Teste",
                "Rua Teste",
                "Brasileira",
                "08:00",
                "22:00",
                LocalDateTime.now()
        );

        Cardapio cardapio = new Cardapio(
                1,
                restaurante,
                "Hambúrguer",
                "Hambúrguer Artesanal",
                BigDecimal.TEN,
                true,
                "foto.png"
        );

        Assertions.assertEquals(1, cardapio.getId());
        Assertions.assertEquals("Hambúrguer Artesanal", cardapio.getDescricao());
        Assertions.assertEquals("Restaurante Teste", cardapio.getRestaurante().getNome());
        Assertions.assertEquals("João", cardapio.getRestaurante().getUsuario().getNome());
    }
}