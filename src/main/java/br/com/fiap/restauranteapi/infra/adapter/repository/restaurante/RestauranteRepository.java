package br.com.fiap.restauranteapi.infra.adapter.repository.restaurante;

import br.com.fiap.restauranteapi.infra.adapter.entity.restaurante.RestauranteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestauranteRepository extends JpaRepository<RestauranteEntity, Integer> {

}