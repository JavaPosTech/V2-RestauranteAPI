package br.com.fiap.restauranteapi.core.usecase.restaurante.listar;

import br.com.fiap.restauranteapi.core.domain.restaurante.Restaurante;
import br.com.fiap.restauranteapi.core.dto.restaurante.RestauranteDTO;
import br.com.fiap.restauranteapi.core.exceptions.RegistroNaoEncontradoException;
import br.com.fiap.restauranteapi.core.gateway.restaurante.RestauranteGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RestauranteListarUseCase {

    private final RestauranteGateway restauranteGateway;

    public RestauranteDTO executar(Integer id) {

        Restaurante restaurante = restauranteGateway.findById(id)
                .orElseThrow(() ->
                        new RegistroNaoEncontradoException("Restaurante não encontrado."));

        return new RestauranteDTO(
                restaurante.getId(),
                restaurante.getNome(),
                restaurante.getEndereco(),
                restaurante.getTipoCozinha(),
                restaurante.getHoraAbertura(),
                restaurante.getHoraFechamento(),
                restaurante.getDataCriacao()
        );
    }

}
