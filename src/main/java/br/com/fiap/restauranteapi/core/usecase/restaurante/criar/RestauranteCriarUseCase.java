package br.com.fiap.restauranteapi.core.usecase.restaurante.criar;

import br.com.fiap.restauranteapi.core.domain.restaurante.Restaurante;
import br.com.fiap.restauranteapi.core.dto.response.MensagemSucessoResponse;
import br.com.fiap.restauranteapi.core.gateway.restaurante.RestauranteGateway;
import br.com.fiap.restauranteapi.core.gateway.usuario.UsuarioGateway;
import br.com.fiap.restauranteapi.core.usecase.restaurante.RestauranteAbstractUseCase;

public class RestauranteCriarUseCase extends RestauranteAbstractUseCase {

    public RestauranteCriarUseCase(UsuarioGateway usuarioGateway, RestauranteGateway restauranteGateway) {
        super(usuarioGateway, restauranteGateway);
    }

    public MensagemSucessoResponse executar(Restaurante restaurante) {
        validarUsuarioDonoRestaurante(restaurante.getUsuario().getId());

        restauranteGateway.save(restaurante);

        return new MensagemSucessoResponse(201, "Restaurante cadastrado com sucesso!");
    }
}