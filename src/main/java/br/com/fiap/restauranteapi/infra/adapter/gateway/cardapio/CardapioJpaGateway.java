package br.com.fiap.restauranteapi.infra.adapter.gateway.cardapio;

import br.com.fiap.restauranteapi.core.domain.cardapio.Cardapio;
import br.com.fiap.restauranteapi.core.gateway.cardapio.CardapioGateway;
import br.com.fiap.restauranteapi.infra.adapter.database.repository.cardapio.CardapioRepository;
import br.com.fiap.restauranteapi.infra.adapter.mapper.cardapio.CardapioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CardapioJpaGateway implements CardapioGateway {

    private final CardapioRepository cardapioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Cardapio> findAll() {
        return cardapioRepository.findAll().stream()
                .map(CardapioMapper::toDomain)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cardapio> findByRestauranteId(Integer restauranteId) {
        return cardapioRepository.findByRestauranteId(restauranteId).stream()
                .map(CardapioMapper::toDomain)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Cardapio> findById(Integer id) {
        return cardapioRepository.findById(id).map(CardapioMapper::toDomain);
    }

    @Override
    @Transactional
    public void save(Cardapio cardapio) {
        cardapioRepository.save(CardapioMapper.toEntity(cardapio));
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        cardapioRepository.deleteById(id);
    }
}