package br.com.fiap.restauranteapi.usecase;

import br.com.fiap.restauranteapi.config.AbstractTest;
import br.com.fiap.restauranteapi.core.domain.cardapio.Cardapio;
import br.com.fiap.restauranteapi.core.domain.restaurante.Restaurante;
import br.com.fiap.restauranteapi.core.domain.usuario.Usuario;
import br.com.fiap.restauranteapi.core.exceptions.RegistroNaoEncontradoException;
import br.com.fiap.restauranteapi.core.exceptions.RegraDeNegocioException;
import br.com.fiap.restauranteapi.core.usecase.cardapio.criar.CriarCardapioUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class CriarCardapioUseCaseTest extends AbstractTest {

    @Autowired
    private CriarCardapioUseCase criarCardapioUseCase;

    private Cardapio cardapioValido(Integer restauranteId, Integer usuarioId) {
        Usuario usuario = new Usuario(usuarioId);
        Restaurante restaurante = new Restaurante(restauranteId, usuario);

        return new Cardapio(
                null,
                restaurante,
                "X-Burger Artesanal",
                "Hambúrguer artesanal com queijo e molho especial",
                BigDecimal.valueOf(29.90),
                true,
                "x-burger.jpg"
        );
    }

    @Test
    void executarTest() {
        Assertions.assertDoesNotThrow(() -> criarCardapioUseCase.executar(cardapioValido(1, 1)));
    }

    @Test
    void executarTestComRestauranteInexistente() {
        Assertions.assertThrows(RegistroNaoEncontradoException.class, () -> criarCardapioUseCase.executar(cardapioValido(999, 1)));
    }

    @Test
    void executarTestComUsuarioNaoDono() {
        Assertions.assertThrows(RegraDeNegocioException.class, () -> criarCardapioUseCase.executar(cardapioValido(1, 2)));
    }
}