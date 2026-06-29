package br.com.fiap.restauranteapi.core.gateway.restaurante;

import java.util.Optional;

import br.com.fiap.restauranteapi.core.domain.restaurante.Restaurante;

public interface RestauranteGateway {

    void save(Restaurante restaurante, Integer id);

    void deleteById(Integer id);

    Optional<Restaurante> findById(Integer id);
    
}
