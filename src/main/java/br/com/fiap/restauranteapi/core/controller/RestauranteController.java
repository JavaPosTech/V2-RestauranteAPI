package br.com.fiap.restauranteapi.core.controller;

import br.com.fiap.restauranteapi.core.domain.restaurante.Restaurante;
import br.com.fiap.restauranteapi.core.dto.response.MensagemSucessoResponse;
import br.com.fiap.restauranteapi.core.dto.restaurante.RestauranteDTO;
import br.com.fiap.restauranteapi.core.usecase.restaurante.atualizar.RestauranteAtualizarUseCase;
import br.com.fiap.restauranteapi.core.usecase.restaurante.criar.RestauranteCriarUseCase;
import br.com.fiap.restauranteapi.core.usecase.restaurante.deletar.RestauranteDeletarUseCase;
import br.com.fiap.restauranteapi.core.usecase.restaurante.listar.RestauranteListarUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RestauranteController {

    private final RestauranteCriarUseCase restauranteCriarUseCase;
    private final RestauranteListarUseCase restauranteListarUseCase;
    private final RestauranteAtualizarUseCase restauranteAtualizarUseCase;
    private final RestauranteDeletarUseCase restauranteDeletarUseCase;

    public MensagemSucessoResponse salvar(Restaurante restaurante){
        return restauranteCriarUseCase.executar(restaurante);
    }

    public RestauranteDTO buscar(Integer id) {
        return restauranteListarUseCase.executar(id);
    }

    public MensagemSucessoResponse atualizar(Integer id, Restaurante restaurante) {
        return restauranteAtualizarUseCase.executar(id, restaurante);
    }

    public void deletar(Integer id, Integer usuarioId) {
        restauranteDeletarUseCase.executar(id, usuarioId);
    }
}