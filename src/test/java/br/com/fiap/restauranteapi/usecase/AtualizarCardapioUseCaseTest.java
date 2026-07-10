package br.com.fiap.restauranteapi.usecase;

import br.com.fiap.restauranteapi.config.AbstractTest;
import br.com.fiap.restauranteapi.core.domain.cardapio.Cardapio;
import br.com.fiap.restauranteapi.core.domain.restaurante.Restaurante;
import br.com.fiap.restauranteapi.core.domain.usuario.Usuario;
import br.com.fiap.restauranteapi.core.exceptions.RegistroNaoEncontradoException;
import br.com.fiap.restauranteapi.core.exceptions.RegraDeNegocioException;
import br.com.fiap.restauranteapi.core.usecase.cardapio.atualizar.AtualizarCardapioUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class AtualizarCardapioUseCaseTest extends AbstractTest {

    @Autowired
    private AtualizarCardapioUseCase atualizarCardapioUseCase;

    private Cardapio cardapioValido(Integer usuarioId) {
        Usuario usuario = new Usuario(usuarioId);
        Restaurante restaurante = new Restaurante(1, usuario);

        return new Cardapio(
                null,
                restaurante,
                "Feijoada Especial",
                "Feijoada completa com arroz, couve e farofa",
                BigDecimal.valueOf(45.90),
                true,
                "feijoada-especial.jpg"
        );
    }

    @Test
    void executarTest() {
        Assertions.assertDoesNotThrow(() -> atualizarCardapioUseCase.executar(1, cardapioValido(1)));
    }

    @Test
    void executarTestComCardapioInexistente() {
        Assertions.assertThrows(RegistroNaoEncontradoException.class, () -> atualizarCardapioUseCase.executar(999, cardapioValido(1)));
    }

    @Test
    void executarTestComUsuarioNaoDono() {
        Assertions.assertThrows(RegraDeNegocioException.class, () -> atualizarCardapioUseCase.executar(1, cardapioValido(2)));
    }
}