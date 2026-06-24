package br.com.fiap.restauranteapi.infra.adapter.database.repository.cardapio;

import br.com.fiap.restauranteapi.infra.adapter.database.entity.cardapio.CardapioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardapioRepository extends JpaRepository<CardapioEntity, Integer> {

}