package br.com.fiap.restauranteapi.core.usecase.restaurante.atualizar;

import br.com.fiap.restauranteapi.core.domain.restaurante.Restaurante;
import br.com.fiap.restauranteapi.core.dto.response.MensagemSucessoResponse;
import br.com.fiap.restauranteapi.core.gateway.restaurante.RestauranteGateway;
import br.com.fiap.restauranteapi.core.gateway.usuario.UsuarioGateway;
import br.com.fiap.restauranteapi.core.usecase.restaurante.RestauranteAbstractUseCase;

public class RestauranteAtualizarUseCase extends RestauranteAbstractUseCase {

    public RestauranteAtualizarUseCase(UsuarioGateway usuarioGateway, RestauranteGateway restauranteGateway) {
        super(usuarioGateway, restauranteGateway);
    }

    public MensagemSucessoResponse executar(Integer id, Restaurante restaurante) {
        Integer usuarioId = restaurante.getUsuario().getId();

        validarUsuarioExistencia(usuarioId);

        Restaurante restauranteExistente = buscarRestaurantePorId(id);

        validarDonoRestaurante(restauranteExistente, usuarioId);

        restauranteGateway.save(new Restaurante(
                id,
                restaurante.getUsuario(),
                restaurante.getNome(),
                restaurante.getEndereco(),
                restaurante.getTipoCozinha(),
                restaurante.getHoraAbertura(),
                restaurante.getHoraFechamento(),
                restauranteExistente.getDataCriacao()));

        return new MensagemSucessoResponse(200, "Restaurante atualizado com sucesso!");
    }
}