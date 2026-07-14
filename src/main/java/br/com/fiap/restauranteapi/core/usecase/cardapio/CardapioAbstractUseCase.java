package br.com.fiap.restauranteapi.core.usecase.cardapio;

import br.com.fiap.restauranteapi.core.domain.cardapio.Cardapio;
import br.com.fiap.restauranteapi.core.domain.restaurante.Restaurante;
import br.com.fiap.restauranteapi.core.enums.ETipoUsuario;
import br.com.fiap.restauranteapi.core.exceptions.RegistroNaoEncontradoException;
import br.com.fiap.restauranteapi.core.exceptions.RegraDeNegocioException;
import br.com.fiap.restauranteapi.core.gateway.cardapio.CardapioGateway;
import br.com.fiap.restauranteapi.core.gateway.restaurante.RestauranteGateway;
import br.com.fiap.restauranteapi.core.gateway.usuario.UsuarioGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
public abstract class CardapioAbstractUseCase {

    protected final UsuarioGateway usuarioGateway;

    protected final CardapioGateway cardapioGateway;

    protected final RestauranteGateway restauranteGateway;

    protected void validarTipoUsuario(Integer usuarioId) {
        var usuario = usuarioGateway.findById(usuarioId).orElseThrow(() -> {
            log.error("O Usuário informado não foi encontrado! ID: {}", usuarioId);
            return new RegistroNaoEncontradoException("O Usuário informado não foi encontrado!");
        });

        if (!Objects.equals(usuario.getTipoUsuario().getId(), ETipoUsuario.DONO_RESTAURANTE.getId())) {
            log.error("Somente Usuários do Tipo Dono de Restaurante podem alterar um Cardápio! ID: {}", usuarioId);
            throw new RegraDeNegocioException("Somente Usuários do Tipo Dono de Restaurante podem alterar um Cardápio!");
        }
    }

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
        if (restaurante == null || restaurante.getUsuario() == null || restaurante.getUsuario().getId() == null || !restaurante.getUsuario().getId().equals(usuarioId)) {
            log.error("Usuário {} tentou alterar o Cardápio sem ser o Dono do Restaurante!", usuarioId);
            throw new RegraDeNegocioException("Somente o Dono do Restaurante pode alterar o Cardápio!");
        }
    }

    protected void validarCardapioPertenceAoRestaurante(Cardapio cardapio, Integer restauranteId) {
        if (!cardapio.getRestaurante().getId().equals(restauranteId)) {
            log.error("O Item do Cardápio: [{}] não pertence ao Restaurante: [{}]", cardapio.getId(), restauranteId);
            throw new RegraDeNegocioException("O Item do Cardápio não pertence ao Restaurante informado!");
        }
    }
}