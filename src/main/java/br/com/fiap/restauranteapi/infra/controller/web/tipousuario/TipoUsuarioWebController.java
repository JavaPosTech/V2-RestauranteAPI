package br.com.fiap.restauranteapi.infra.controller.web.tipousuario;

import br.com.fiap.restauranteapi.core.controller.tipousuario.TipoUsuarioController;
import br.com.fiap.restauranteapi.core.dto.response.MensagemSucessoResponse;
import br.com.fiap.restauranteapi.core.dto.tipousuario.TipoUsuarioDTO;
import br.com.fiap.restauranteapi.infra.adapter.mapper.tipousuario.TipoUsuarioMapper;
import br.com.fiap.restauranteapi.infra.controller.dto.tipousuario.TipoUsuarioRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/tipousuario")
@Tag(name = "Tipo de Usuário", description = "Endpoints para gerenciamento de tipos de usuário")
public class TipoUsuarioWebController {

    private final TipoUsuarioController tipoUsuarioController;

    @GetMapping
    public ResponseEntity<List<TipoUsuarioDTO>> listar() {
        return ResponseEntity.ok(tipoUsuarioController.listar());
    }

    @PostMapping
    public ResponseEntity<MensagemSucessoResponse> salvar(@RequestBody @Valid TipoUsuarioRequest tipoUsuarioRequest) {
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(tipoUsuarioController.salvar(TipoUsuarioMapper.toDomain(tipoUsuarioRequest)));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MensagemSucessoResponse> atualizar(@PathVariable Integer id, @RequestBody @Valid TipoUsuarioRequest tipoUsuarioRequest) {
        return ResponseEntity.ok(tipoUsuarioController.atualizar(id, TipoUsuarioMapper.toDomain(tipoUsuarioRequest)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        tipoUsuarioController.deletar(id);
        return ResponseEntity.noContent().build();
    }
}