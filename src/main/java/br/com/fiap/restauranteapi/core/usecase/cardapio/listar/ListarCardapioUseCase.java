package br.com.fiap.restauranteapi.core.usecase.cardapio.listar;

import br.com.fiap.restauranteapi.core.dto.cardapio.CardapioDTO;
import br.com.fiap.restauranteapi.core.gateway.cardapio.CardapioGateway;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ListarCardapioUseCase {

    private final CardapioGateway cardapioGateway;

    public List<CardapioDTO> executar() {
        return cardapioGateway.findAll().stream()
                .map(cardapio -> new CardapioDTO(
                        cardapio.getId(),
                        cardapio.getRestaurante().getId(),
                        cardapio.getNome(),
                        cardapio.getDescricao(),
                        cardapio.getPreco(),
                        cardapio.isConsumoLocal(),
                        cardapio.getFoto()
                ))
                .toList();
    }

    public List<CardapioDTO> executarPorRestaurante(Integer restauranteId) {
        return cardapioGateway.findByRestauranteId(restauranteId).stream()
                .map(cardapio -> new CardapioDTO(
                        cardapio.getId(),
                        cardapio.getRestaurante().getId(),
                        cardapio.getNome(),
                        cardapio.getDescricao(),
                        cardapio.getPreco(),
                        cardapio.isConsumoLocal(),
                        cardapio.getFoto()
                ))
                .toList();
    }
}