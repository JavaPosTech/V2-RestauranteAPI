package br.com.fiap.restauranteapi.infra.config.bean.restaurante;

import br.com.fiap.restauranteapi.core.controller.RestauranteController;
import br.com.fiap.restauranteapi.core.gateway.restaurante.RestauranteGateway;
import br.com.fiap.restauranteapi.core.gateway.usuario.UsuarioGateway;
import br.com.fiap.restauranteapi.core.usecase.restaurante.atualizar.RestauranteAtualizarUseCase;
import br.com.fiap.restauranteapi.core.usecase.restaurante.deletar.RestauranteDeletarUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestauranteBean {

    @Bean
    public RestauranteAtualizarUseCase restauranteAtualizarUseCase(
            RestauranteGateway restauranteGateway,
            UsuarioGateway usuarioGateway) {
        return new RestauranteAtualizarUseCase(restauranteGateway, usuarioGateway);
    }

    @Bean
    public RestauranteDeletarUseCase restauranteDeletarUseCase(
            RestauranteGateway restauranteGateway,
            UsuarioGateway usuarioGateway) {
        return new RestauranteDeletarUseCase(restauranteGateway, usuarioGateway);
    }

    @Bean
    public RestauranteController restauranteController(
            RestauranteAtualizarUseCase restauranteAtualizarUseCase,
            RestauranteDeletarUseCase restauranteDeletarUseCase) {
        return new RestauranteController(restauranteAtualizarUseCase, restauranteDeletarUseCase);
    }
}
