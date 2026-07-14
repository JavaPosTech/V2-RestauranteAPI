package br.com.fiap.restauranteapi.core.usecase.cardapio.listar;

import br.com.fiap.restauranteapi.core.dto.cardapio.CardapioDTO;
import br.com.fiap.restauranteapi.core.exceptions.RegistroNaoEncontradoException;
import br.com.fiap.restauranteapi.core.gateway.cardapio.CardapioGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
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
                )).toList();
    }

    public List<CardapioDTO> executarPorRestaurante(Integer restauranteId) {
        if (cardapioGateway.findByRestauranteId(restauranteId).isEmpty()) {
            log.error("Nenhum cardápio encontrado para o restaurante com ID: {}", restauranteId);
            throw new RegistroNaoEncontradoException("Nenhum cardápio encontrado para o restaurante com ID: " + restauranteId);
        }

        return cardapioGateway.findByRestauranteId(restauranteId).stream()
                .map(cardapio -> new CardapioDTO(
                        cardapio.getId(),
                        cardapio.getRestaurante().getId(),
                        cardapio.getNome(),
                        cardapio.getDescricao(),
                        cardapio.getPreco(),
                        cardapio.isConsumoLocal(),
                        cardapio.getFoto()
                )).toList();
    }
}