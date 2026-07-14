package br.com.fiap.restauranteapi.core.usecase.cardapio.atualizar;

import br.com.fiap.restauranteapi.core.domain.cardapio.Cardapio;
import br.com.fiap.restauranteapi.core.domain.restaurante.Restaurante;
import br.com.fiap.restauranteapi.core.dto.response.MensagemSucessoResponse;
import br.com.fiap.restauranteapi.core.gateway.cardapio.CardapioGateway;
import br.com.fiap.restauranteapi.core.gateway.restaurante.RestauranteGateway;
import br.com.fiap.restauranteapi.core.usecase.cardapio.CardapioAbstractUseCase;

public class AtualizarCardapioUseCase extends CardapioAbstractUseCase {

    public AtualizarCardapioUseCase(CardapioGateway cardapioGateway, RestauranteGateway restauranteGateway) {
        super(cardapioGateway, restauranteGateway);
    }

    public MensagemSucessoResponse executar(Integer id, Cardapio cardapio) {
        Cardapio cardapioExistente = buscarCardapioPorId(id);

        validarCardapioPertenceAoRestaurante(cardapioExistente, cardapio.getRestaurante().getId());

        Restaurante restaurante = buscarRestaurantePorId(cardapioExistente.getRestaurante().getId());

        validarDonoRestaurante(restaurante, cardapio.getRestaurante().getUsuario().getId());

        cardapioGateway.save(new Cardapio(
                id,
                restaurante,
                cardapio.getNome(),
                cardapio.getDescricao(),
                cardapio.getPreco(),
                cardapio.isConsumoLocal(),
                cardapio.getFoto()));

        return new MensagemSucessoResponse(200, "Item do cardápio atualizado com sucesso!");
    }
}