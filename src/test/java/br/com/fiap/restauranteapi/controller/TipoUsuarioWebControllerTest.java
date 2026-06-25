package br.com.fiap.restauranteapi.controller;

import br.com.fiap.restauranteapi.config.AbstractControllerTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootTest
class TipoUsuarioWebControllerTest extends AbstractControllerTest {

    @Test
    void listarTest() throws Exception {
        testGet("/v1/tipousuario");
    }

    @Test
    void salvarTest() throws Exception {
        String salvarTipoUsuario = new String(Files.readAllBytes(Paths.get("src/test/resources/tipousuario/salvarTipoUsuario.json")));
        testPost("/v1/tipousuario", salvarTipoUsuario);
    }

    @Test
    void atualizarTest() throws Exception {
        String atualizarTipoUsuario = new String(Files.readAllBytes(Paths.get("src/test/resources/tipousuario/atualizarTipoUsuario.json")));
        testPatch("/v1/tipousuario/1", atualizarTipoUsuario);
    }

    @Test
    void deletarTest() throws Exception {
        testDelete("/v1/tipousuario/1");
    }
}