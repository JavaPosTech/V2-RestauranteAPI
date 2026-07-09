package br.com.fiap.restauranteapi.controller;

import br.com.fiap.restauranteapi.config.AbstractControllerTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootTest
class UsuarioWebControllerTest extends AbstractControllerTest {

    @Test
    void listarTest() throws Exception {
        testGet("/v1/usuario");
    }

    @Test
    void salvarTest() throws Exception {
        String json = Files.readString(
                Paths.get("src/test/resources/usuario/salvarUsuario.json")
        );

        testPost("/v1/usuario", json);
    }

    @Test
    void atualizarTest() throws Exception {
        String json = Files.readString(
                Paths.get("src/test/resources/usuario/atualizarUsuario.json")
        );

        testPatch("/v1/usuario/1", json);
    }

    @Test
    void deletarTest() throws Exception {
        testDelete("/v1/usuario/1");
    }
}