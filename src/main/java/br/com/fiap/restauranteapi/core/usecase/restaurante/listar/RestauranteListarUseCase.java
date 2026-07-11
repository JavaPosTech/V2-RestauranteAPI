package br.com.fiap.restauranteapi.core.usecase.restaurante.listar;

import br.com.fiap.restauranteapi.core.dto.restaurante.RestauranteDTO;
import br.com.fiap.restauranteapi.core.exceptions.RegistroNaoEncontradoException;
import br.com.fiap.restauranteapi.core.gateway.restaurante.RestauranteGateway;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class RestauranteListarUseCase {

    private final RestauranteGateway restauranteGateway;

    public List<RestauranteDTO> executar() {
        return restauranteGateway.findAll().stream()
                .map(restaurante -> new RestauranteDTO(
                        restaurante.getId(),
                        restaurante.getNome(),
                        restaurante.getEndereco(),
                        restaurante.getTipoCozinha(),
                        restaurante.getHoraAbertura(),
                        restaurante.getHoraFechamento(),
                        restaurante.getDataCriacao())
                ).toList();
    }

    public RestauranteDTO executar(Integer id) {
        var restaurante = restauranteGateway.findById(id).orElseThrow(() -> new RegistroNaoEncontradoException("Restaurante não encontrado!"));

        return new RestauranteDTO(
                restaurante.getId(),
                restaurante.getNome(),
                restaurante.getEndereco(),
                restaurante.getTipoCozinha(),
                restaurante.getHoraAbertura(),
                restaurante.getHoraFechamento(),
                restaurante.getDataCriacao());
    }
}