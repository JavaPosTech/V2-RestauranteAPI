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
            UsuarioGateway usuarioGateway,
            RestauranteGateway restauranteGateway) {
        return new RestauranteAtualizarUseCase(usuarioGateway, restauranteGateway);
    }

    @Bean
    public RestauranteDeletarUseCase restauranteDeletarUseCase(
            UsuarioGateway usuarioGateway,
            RestauranteGateway restauranteGateway) {
        return new RestauranteDeletarUseCase(usuarioGateway, restauranteGateway);
    }

    @Bean
    public RestauranteController restauranteController(
            RestauranteDeletarUseCase restauranteDeletarUseCase,
            RestauranteAtualizarUseCase restauranteAtualizarUseCase) {
        return new RestauranteController(restauranteDeletarUseCase, restauranteAtualizarUseCase);
    }
}