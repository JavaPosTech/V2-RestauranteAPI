package br.com.fiap.restauranteapi.controller;

import br.com.fiap.restauranteapi.config.AbstractControllerTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootTest
class CardapioWebControllerTest extends AbstractControllerTest {

    @Test
    void listarTest() throws Exception {
        testGet("/v1/cardapio");
    }

    @Test
    void listarPorRestauranteTest() throws Exception {
        testGet("/v1/cardapio/restaurante/1");
    }

    @Test
    void salvarTest() throws Exception {
        String salvarCardapio = new String(Files.readAllBytes(Paths.get("src/test/resources/cardapio/salvarCardapio.json")));
        testPost("/v1/cardapio", salvarCardapio);
    }

    @Test
    void atualizarTest() throws Exception {
        String atualizarCardapio = new String(Files.readAllBytes(Paths.get("src/test/resources/cardapio/atualizarCardapio.json")));
        testPatch("/v1/cardapio/1", atualizarCardapio);
    }

    @Test
    void deletarTest() throws Exception {
        String deletarCardapio = new String(Files.readAllBytes(Paths.get("src/test/resources/cardapio/deletarCardapio.json")));
        testDelete("/v1/cardapio/1", deletarCardapio);
    }
}