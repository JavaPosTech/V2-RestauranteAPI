package br.com.fiap.restauranteapi.infra.controller;

import br.com.fiap.restauranteapi.core.domain.tipousuario.TipoUsuario;
import br.com.fiap.restauranteapi.core.dto.request.TipoUsuarioRequest;
import br.com.fiap.restauranteapi.core.dto.response.SuccessMessageResponse;
import br.com.fiap.restauranteapi.core.usecase.tipousuario.atualizar.AtualizarTipoUsuarioUseCase;
import br.com.fiap.restauranteapi.core.usecase.tipousuario.criar.CriarTipoUsuarioUseCase;
import br.com.fiap.restauranteapi.core.usecase.tipousuario.deletar.DeletarTipoUsuarioUseCase;
import br.com.fiap.restauranteapi.core.usecase.tipousuario.listar.ListarTipoUsuarioUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/tipousuario")
public class TipoUsuarioController {

    private final CriarTipoUsuarioUseCase criarTipoUsuarioUseCase;

    private final ListarTipoUsuarioUseCase listarTipoUsuarioUseCase;

    private final DeletarTipoUsuarioUseCase deletarTipoUsuarioUseCase;

    private final AtualizarTipoUsuarioUseCase atualizarTipoUsuarioUseCase;

    @GetMapping
    public ResponseEntity<List<TipoUsuario>> listar() {
        return ResponseEntity.ok(listarTipoUsuarioUseCase.executar());
    }

    @PostMapping
    public ResponseEntity<SuccessMessageResponse> salvar(@RequestBody TipoUsuarioRequest tipoUsuarioRequest) {
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(criarTipoUsuarioUseCase.executar(TipoUsuario.toDomain(tipoUsuarioRequest.descricao())));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Integer id, @RequestBody TipoUsuarioRequest tipoUsuarioRequest) {
        atualizarTipoUsuarioUseCase.executar(id, TipoUsuario.toDomain(tipoUsuarioRequest.descricao()));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        deletarTipoUsuarioUseCase.executar(id);
        return ResponseEntity.noContent().build();
    }
}