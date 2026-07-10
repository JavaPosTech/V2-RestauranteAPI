package br.com.fiap.restauranteapi.core.gateway.restaurante;

import br.com.fiap.restauranteapi.core.domain.restaurante.Restaurante;

import java.util.Optional;

public interface RestauranteGateway {

    void save(Restaurante restaurante);

    void deleteById(Integer id);

    Optional<Restaurante> findById(Integer id);
    
}