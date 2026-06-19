package br.com.fiap.restauranteapi.infra.adapter.repository.tipocozinha;

import br.com.fiap.restauranteapi.infra.adapter.entity.tipocozinha.TipoCozinhaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCozinhaRepository extends JpaRepository<TipoCozinhaEntity, Integer> {

}