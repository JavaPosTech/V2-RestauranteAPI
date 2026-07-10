package br.com.fiap.restauranteapi.core.gateway.cardapio;

import br.com.fiap.restauranteapi.core.domain.cardapio.Cardapio;

import java.util.List;
import java.util.Optional;

public interface CardapioGateway {

    List<Cardapio> findAll();

    List<Cardapio> findByRestauranteId(Integer restauranteId);

    Optional<Cardapio> findById(Integer id);

    void save(Cardapio cardapio);

    void deleteById(Integer id);
}