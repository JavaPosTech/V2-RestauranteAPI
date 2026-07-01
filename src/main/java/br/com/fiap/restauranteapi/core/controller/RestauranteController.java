package br.com.fiap.restauranteapi.core.controller;

import br.com.fiap.restauranteapi.core.domain.restaurante.Restaurante;
import br.com.fiap.restauranteapi.core.dto.response.MensagemSucessoResponse;
import br.com.fiap.restauranteapi.core.usecase.restaurante.atualizar.RestauranteAtualizarUseCase;
import br.com.fiap.restauranteapi.core.usecase.restaurante.deletar.RestauranteDeletarUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RestauranteController {

    private final RestauranteDeletarUseCase restauranteDeletarUseCase;

    private final RestauranteAtualizarUseCase restauranteAtualizarUseCase;

    public MensagemSucessoResponse atualizar(Integer id, Restaurante restaurante) {
        return restauranteAtualizarUseCase.executar(id, restaurante);
    }

    public void deletar(Integer id, Integer usuarioId) {
        restauranteDeletarUseCase.executar(id, usuarioId);
    }
}