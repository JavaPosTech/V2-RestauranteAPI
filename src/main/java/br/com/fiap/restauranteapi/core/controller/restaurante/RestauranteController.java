package br.com.fiap.restauranteapi.core.controller.restaurante;

import br.com.fiap.restauranteapi.core.domain.restaurante.Restaurante;
import br.com.fiap.restauranteapi.core.dto.response.MensagemSucessoResponse;
import br.com.fiap.restauranteapi.core.dto.restaurante.RestauranteDTO;
import br.com.fiap.restauranteapi.core.usecase.restaurante.atualizar.RestauranteAtualizarUseCase;
import br.com.fiap.restauranteapi.core.usecase.restaurante.criar.RestauranteCriarUseCase;
import br.com.fiap.restauranteapi.core.usecase.restaurante.deletar.RestauranteDeletarUseCase;
import br.com.fiap.restauranteapi.core.usecase.restaurante.listar.RestauranteListarUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class RestauranteController {

    private final RestauranteCriarUseCase restauranteCriarUseCase;

    private final RestauranteListarUseCase restauranteListarUseCase;

    private final RestauranteDeletarUseCase restauranteDeletarUseCase;

    private final RestauranteAtualizarUseCase restauranteAtualizarUseCase;

    public List<RestauranteDTO> buscar() {
        return restauranteListarUseCase.executar();
    }

    public RestauranteDTO buscarPorId(Integer id) {
        return restauranteListarUseCase.executar(id);
    }

    public MensagemSucessoResponse salvar(Restaurante restaurante){
        return restauranteCriarUseCase.executar(restaurante);
    }

    public MensagemSucessoResponse atualizar(Integer id, Restaurante restaurante) {
        return restauranteAtualizarUseCase.executar(id, restaurante);
    }

    public void deletar(Integer id, Integer usuarioId) {
        restauranteDeletarUseCase.executar(id, usuarioId);
    }
}