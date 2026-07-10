package br.com.fiap.restauranteapi.core.usecase.cardapio;

import br.com.fiap.restauranteapi.core.domain.cardapio.Cardapio;
import br.com.fiap.restauranteapi.core.domain.restaurante.Restaurante;
import br.com.fiap.restauranteapi.core.exceptions.RegistroNaoEncontradoException;
import br.com.fiap.restauranteapi.core.exceptions.RegraDeNegocioException;
import br.com.fiap.restauranteapi.core.gateway.cardapio.CardapioGateway;
import br.com.fiap.restauranteapi.core.gateway.restaurante.RestauranteGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public abstract class CardapioAbstractUseCase {

    protected final CardapioGateway cardapioGateway;

    protected final RestauranteGateway restauranteGateway;

    protected Restaurante buscarRestaurantePorId(Integer restauranteId) {
        return restauranteGateway.findById(restauranteId).orElseThrow(() -> {
            log.error("Restaurante não encontrado! ID: {}", restauranteId);
            return new RegistroNaoEncontradoException("Restaurante não encontrado!");
        });
    }

    protected Cardapio buscarCardapioPorId(Integer id) {
        return cardapioGateway.findById(id).orElseThrow(() -> {
            log.error("Item do cardápio não encontrado! ID: {}", id);
            return new RegistroNaoEncontradoException("Item do cardápio não encontrado!");
        });
    }

    protected void validarDonoRestaurante(Restaurante restaurante, Integer usuarioId) {
        if (usuarioId == null
                || restaurante == null
                || restaurante.getUsuario() == null
                || restaurante.getUsuario().getId() == null
                || !restaurante.getUsuario().getId().equals(usuarioId)) {

            log.error("Usuário {} tentou alterar o Cardápio sem ser o Dono do Restaurante!", usuarioId);
            throw new RegraDeNegocioException("Somente o Dono do Restaurante pode alterar o Cardápio!");
        }
    }
}