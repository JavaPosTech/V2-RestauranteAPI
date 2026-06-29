package br.com.fiap.restauranteapi.infra.controller.web;

import br.com.fiap.restauranteapi.core.controller.RestauranteController;
import br.com.fiap.restauranteapi.core.dto.response.MensagemSucessoResponse;
import br.com.fiap.restauranteapi.infra.adapter.mapper.RestauranteMapper;
import br.com.fiap.restauranteapi.infra.controller.dto.RestauranteDeleteRequest;
import br.com.fiap.restauranteapi.infra.controller.dto.RestauranteRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/restaurante")
public class RestauranteWebController {

    private final RestauranteController restauranteController;

    @PatchMapping("/{id}")
    public ResponseEntity<MensagemSucessoResponse> atualizar(
            @PathVariable Integer id,
            @RequestBody @Valid RestauranteRequest request) {
        return ResponseEntity.ok(restauranteController.atualizar(id, RestauranteMapper.toDomain(request)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @PathVariable Integer id,
            @RequestBody @Valid RestauranteDeleteRequest request) {
        restauranteController.deletar(id, request.usuarioId());
        return ResponseEntity.noContent().build();
    }
}
