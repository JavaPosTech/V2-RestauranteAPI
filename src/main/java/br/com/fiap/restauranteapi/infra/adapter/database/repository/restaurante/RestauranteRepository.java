package br.com.fiap.restauranteapi.infra.adapter.database.repository.restaurante;

import br.com.fiap.restauranteapi.infra.adapter.database.entity.restaurante.RestauranteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestauranteRepository extends JpaRepository<RestauranteEntity, Integer> {

}