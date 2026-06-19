package br.com.fiap.restauranteapi.domain.tipocozinha;

import br.com.fiap.restauranteapi.config.AbstractTest;
import br.com.fiap.restauranteapi.core.domain.tipocozinha.TipoCozinha;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TipoCozinhaTest extends AbstractTest {

    @Test
    void domainTest() {
        TipoCozinha tipoCozinha = new TipoCozinha(1, "TESTE");

        Assertions.assertEquals(1, tipoCozinha.id());
        Assertions.assertEquals("TESTE", tipoCozinha.descricao());
    }
}