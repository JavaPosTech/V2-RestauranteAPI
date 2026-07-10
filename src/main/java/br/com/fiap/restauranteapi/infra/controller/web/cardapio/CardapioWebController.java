package br.com.fiap.restauranteapi.infra.controller.web.cardapio;

import br.com.fiap.restauranteapi.core.controller.cardapio.CardapioController;
import br.com.fiap.restauranteapi.core.dto.cardapio.CardapioDTO;
import br.com.fiap.restauranteapi.core.dto.response.MensagemSucessoResponse;
import br.com.fiap.restauranteapi.infra.adapter.mapper.cardapio.CardapioMapper;
import br.com.fiap.restauranteapi.infra.controller.dto.cardapio.CardapioDeleteRequest;
import br.com.fiap.restauranteapi.infra.controller.dto.cardapio.CardapioRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/cardapio")
public class CardapioWebController {

    private final CardapioController cardapioController;

    @GetMapping
    public ResponseEntity<List<CardapioDTO>> listar() {
        return ResponseEntity.ok(cardapioController.listar());
    }

    @GetMapping("/restaurante/{restauranteId}")
    public ResponseEntity<List<CardapioDTO>> listarPorRestaurante(@PathVariable Integer restauranteId) {
        return ResponseEntity.ok(cardapioController.listarPorRestaurante(restauranteId));
    }

    @PostMapping
    public ResponseEntity<MensagemSucessoResponse> salvar(@RequestBody @Valid CardapioRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cardapioController.salvar(CardapioMapper.toDomain(request)));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MensagemSucessoResponse> atualizar(@PathVariable Integer id, @RequestBody @Valid CardapioRequest request) {
        return ResponseEntity.ok(cardapioController.atualizar(id, CardapioMapper.toDomain(request)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id, @RequestBody @Valid CardapioDeleteRequest request) {
        cardapioController.deletar(id, request.usuarioId());
        return ResponseEntity.noContent().build();
    }
}