package br.com.fiap.restauranteapi.controller;

import br.com.fiap.restauranteapi.config.AbstractControllerTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootTest
class RestauranteWebControllerTest extends AbstractControllerTest {

    @Test
    void atualizarTest() throws Exception {
        String atualizarRestaurante = new String(Files.readAllBytes(Paths.get("src/test/resources/restaurante/atualizarRestaurante.json")));
        testPatch("/v1/restaurante/1", atualizarRestaurante);
    }

    @Test
    void deletarTest() throws Exception {
        String deletarRestaurante = new String(Files.readAllBytes(Paths.get("src/test/resources/restaurante/deletarRestaurante.json")));
        testDelete("/v1/restaurante/1", deletarRestaurante);
    }
}
