package br.com.fiap.restauranteapi.infra.config.bean.restaurante;

import br.com.fiap.restauranteapi.core.controller.RestauranteController;
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
    public RestauranteCriarUseCase criarRestauranteUseCase(UsuarioGateway usuarioGateway, RestauranteGateway restauranteGateway){

        return new RestauranteCriarUseCase(usuarioGateway, restauranteGateway);
    }

    @Bean
    RestauranteListarUseCase listarRestauranteUseCase(RestauranteGateway gateway){

        return new RestauranteListarUseCase(gateway);
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
                restauranteAtualizarUseCase,
                restauranteDeletarUseCase);
    }
}