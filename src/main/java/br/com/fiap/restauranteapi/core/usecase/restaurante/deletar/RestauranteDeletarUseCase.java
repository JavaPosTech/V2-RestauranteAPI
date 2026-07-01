package br.com.fiap.restauranteapi.core.usecase.restaurante.deletar;

import br.com.fiap.restauranteapi.core.domain.restaurante.Restaurante;
import br.com.fiap.restauranteapi.core.gateway.restaurante.RestauranteGateway;
import br.com.fiap.restauranteapi.core.gateway.usuario.UsuarioGateway;
import br.com.fiap.restauranteapi.core.usecase.restaurante.RestauranteAbstractUseCase;

public class RestauranteDeletarUseCase extends RestauranteAbstractUseCase {

    public RestauranteDeletarUseCase(UsuarioGateway usuarioGateway, RestauranteGateway restauranteGateway) {
        super(usuarioGateway, restauranteGateway);
    }

    public void executar(Integer id, Integer usuarioId) {
        validarUsuarioExistencia(usuarioId);

        Restaurante restauranteExistente = buscarRestaurantePorId(id);

        validarDonoRestaurante(restauranteExistente, usuarioId);

        restauranteGateway.deleteById(id);
    }
}