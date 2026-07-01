package br.com.fiap.restauranteapi.infra.adapter.gateway.restaurante;

import br.com.fiap.restauranteapi.core.domain.restaurante.Restaurante;
import br.com.fiap.restauranteapi.core.gateway.restaurante.RestauranteGateway;
import br.com.fiap.restauranteapi.infra.adapter.database.repository.restaurante.RestauranteRepository;
import br.com.fiap.restauranteapi.infra.adapter.mapper.RestauranteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RestauranteJpaGateway implements RestauranteGateway {

    private final RestauranteRepository restauranteRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<Restaurante> findById(Integer id) {
        return restauranteRepository.findById(id).map(RestauranteMapper::toDomain);
    }

    @Override
    @Transactional
    public void save(Restaurante restaurante) {
        restauranteRepository.save(RestauranteMapper.toEntity(restaurante));
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        restauranteRepository.deleteById(id);
    }
}