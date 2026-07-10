package br.com.fiap.restauranteapi.core.usecase.cardapio.deletar;

import br.com.fiap.restauranteapi.core.domain.cardapio.Cardapio;
import br.com.fiap.restauranteapi.core.domain.restaurante.Restaurante;
import br.com.fiap.restauranteapi.core.gateway.cardapio.CardapioGateway;
import br.com.fiap.restauranteapi.core.gateway.restaurante.RestauranteGateway;
import br.com.fiap.restauranteapi.core.usecase.cardapio.CardapioAbstractUseCase;

public class DeletarCardapioUseCase extends CardapioAbstractUseCase {

    public DeletarCardapioUseCase(CardapioGateway cardapioGateway, RestauranteGateway restauranteGateway) {
        super(cardapioGateway, restauranteGateway);
    }

    public void executar(Integer id, Integer usuarioId) {
        Cardapio cardapio = buscarCardapioPorId(id);

        Restaurante restaurante = buscarRestaurantePorId(cardapio.getRestaurante().getId());

        validarDonoRestaurante(restaurante, usuarioId);

        cardapioGateway.deleteById(id);
    }
}