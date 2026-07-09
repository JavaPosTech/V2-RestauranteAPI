package br.com.fiap.restauranteapi.infra.controller.web.restaurante;

import br.com.fiap.restauranteapi.core.controller.restaurante.RestauranteController;
import br.com.fiap.restauranteapi.core.dto.response.MensagemSucessoResponse;
import br.com.fiap.restauranteapi.core.dto.restaurante.RestauranteDTO;
import br.com.fiap.restauranteapi.infra.adapter.mapper.restaurante.RestauranteMapper;
import br.com.fiap.restauranteapi.infra.controller.dto.restaurante.RestauranteDeleteRequest;
import br.com.fiap.restauranteapi.infra.controller.dto.restaurante.RestauranteRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/restaurante")
public class RestauranteWebController {

    private final RestauranteController restauranteController;

    @GetMapping("/{id}")
    public ResponseEntity<RestauranteDTO> buscar(@PathVariable Integer id) {
        return ResponseEntity.ok(restauranteController.buscar(id));
    }

    @PostMapping
    public ResponseEntity<MensagemSucessoResponse> salvar(@RequestBody @Valid RestauranteRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(restauranteController.salvar(RestauranteMapper.toDomain(request)));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MensagemSucessoResponse> atualizar(@PathVariable Integer id, @RequestBody @Valid RestauranteRequest request) {
        return ResponseEntity.ok(restauranteController.atualizar(id, RestauranteMapper.toDomain(request)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id, @RequestBody @Valid RestauranteDeleteRequest request) {
        restauranteController.deletar(id, request.usuarioId());
        return ResponseEntity.noContent().build();
    }
}