package br.com.fiap.restauranteapi.infra.config.bean.restaurante;

import br.com.fiap.restauranteapi.core.controller.restaurante.RestauranteController;
import br.com.fiap.restauranteapi.core.gateway.restaurante.RestauranteGateway;
import br.com.fiap.restauranteapi.core.gateway.usuario.UsuarioGateway;
import br.com.fiap.restauranteapi.core.usecase.restaurante.atualizar.RestauranteAtualizarUseCase;
import br.com.fiap.restauranteapi.core.usecase.restaurante.criar.RestauranteCriarUseCase;
import br.com.fiap.restauranteapi.core.usecase.restaurante.deletar.RestauranteDeletarUseCase;
import br.com.fiap.restauranteapi.core.usecase.restaurante.listar.RestauranteListarUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestauranteBean {

    @Bean
    public RestauranteListarUseCase restauranteListarUseCase(RestauranteGateway gateway) {
        return new RestauranteListarUseCase(gateway);
    }

    @Bean
    public RestauranteCriarUseCase restauranteCriarUseCase(UsuarioGateway usuarioGateway, RestauranteGateway restauranteGateway) {
        return new RestauranteCriarUseCase(usuarioGateway, restauranteGateway);
    }

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
            RestauranteCriarUseCase restauranteCriarUseCase,
            RestauranteListarUseCase restauranteListarUseCase,
            RestauranteDeletarUseCase restauranteDeletarUseCase,
            RestauranteAtualizarUseCase restauranteAtualizarUseCase) {

        return new RestauranteController(
                restauranteCriarUseCase,
                restauranteListarUseCase,
                restauranteDeletarUseCase,
                restauranteAtualizarUseCase);
    }
}