package br.com.fiap.restauranteapi.core.usecase.cardapio.criar;

import br.com.fiap.restauranteapi.core.domain.cardapio.Cardapio;
import br.com.fiap.restauranteapi.core.domain.restaurante.Restaurante;
import br.com.fiap.restauranteapi.core.dto.response.MensagemSucessoResponse;
import br.com.fiap.restauranteapi.core.gateway.cardapio.CardapioGateway;
import br.com.fiap.restauranteapi.core.gateway.restaurante.RestauranteGateway;
import br.com.fiap.restauranteapi.core.gateway.usuario.UsuarioGateway;
import br.com.fiap.restauranteapi.core.usecase.cardapio.CardapioAbstractUseCase;

public class CriarCardapioUseCase extends CardapioAbstractUseCase {

    public CriarCardapioUseCase(UsuarioGateway usuarioGateway, CardapioGateway cardapioGateway, RestauranteGateway restauranteGateway) {
        super(usuarioGateway, cardapioGateway, restauranteGateway);
    }

    public MensagemSucessoResponse executar(Cardapio cardapio) {
        validarTipoUsuario(cardapio.getRestaurante().getUsuario().getId());

        Restaurante restaurante = buscarRestaurantePorId(cardapio.getRestaurante().getId());

        validarDonoRestaurante(restaurante, cardapio.getRestaurante().getUsuario().getId());

        cardapioGateway.save(new Cardapio(
                null,
                restaurante,
                cardapio.getNome().toUpperCase(),
                cardapio.getDescricao().toUpperCase(),
                cardapio.getPreco(),
                cardapio.isConsumoLocal(),
                cardapio.getFoto()
        ));

        return new MensagemSucessoResponse(201, "Item do cardápio criado com sucesso!");
    }
}