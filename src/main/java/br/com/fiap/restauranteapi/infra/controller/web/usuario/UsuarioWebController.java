package br.com.fiap.restauranteapi.infra.controller.web.usuario;

import br.com.fiap.restauranteapi.core.controller.usuario.UsuarioController;
import br.com.fiap.restauranteapi.core.dto.usuario.UsuarioDTO;
import br.com.fiap.restauranteapi.core.dto.response.MensagemSucessoResponse;
import br.com.fiap.restauranteapi.infra.adapter.mapper.usuario.UsuarioMapper;
import br.com.fiap.restauranteapi.infra.controller.dto.usuario.AtualizarUsuarioRequest;
import br.com.fiap.restauranteapi.infra.controller.dto.usuario.UsuarioRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/usuario")
public class UsuarioWebController {

    private final UsuarioController usuarioController;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listar() {
        return ResponseEntity.ok(usuarioController.listar());
    }

    @PostMapping
    public ResponseEntity<MensagemSucessoResponse> salvar(@RequestBody @Valid UsuarioRequest usuarioRequest) {
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(usuarioController.salvar(UsuarioMapper.toDomain(usuarioRequest)));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MensagemSucessoResponse> atualizar(@PathVariable Integer id, @RequestBody @Valid AtualizarUsuarioRequest atualizarUsuarioRequest) {
        return ResponseEntity.ok(usuarioController.atualizar(id, UsuarioMapper.toDomain(atualizarUsuarioRequest)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        usuarioController.deletar(id);
        return ResponseEntity.noContent().build();
    }
}