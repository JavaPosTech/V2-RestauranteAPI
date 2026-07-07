package br.com.fiap.restauranteapi.infra.adapter.mapper.cardapio;

import br.com.fiap.restauranteapi.core.domain.cardapio.Cardapio;
import br.com.fiap.restauranteapi.core.domain.restaurante.Restaurante;
import br.com.fiap.restauranteapi.core.domain.usuario.Usuario;
import br.com.fiap.restauranteapi.infra.adapter.database.entity.cardapio.CardapioEntity;
import br.com.fiap.restauranteapi.infra.controller.dto.cardapio.CardapioRequest;

public class CardapioMapper {

    private CardapioMapper() {}

    public static Cardapio toDomain(CardapioRequest request) {
        Usuario usuario = new Usuario(request.usuarioId(), null, null, null, null);
        Restaurante restaurante = new Restaurante(request.restauranteId(), usuario, null, null, null, null, null, null);

        return new Cardapio(
                null,
                restaurante,
                request.nome(),
                request.descricao(),
                request.preco(),
                request.consumoLocal(),
                request.foto()
        );
    }

    public static Cardapio toDomain(CardapioEntity entity) {
        Restaurante restaurante = new Restaurante(entity.getRestauranteId(), null, null, null, null, null, null, null);

        return new Cardapio(
                entity.getId(),
                restaurante,
                entity.getNome(),
                entity.getDescricao(),
                entity.getPreco(),
                entity.isConsumoLocal(),
                entity.getFoto()
        );
    }

    public static CardapioEntity toEntity(Cardapio domain) {
        CardapioEntity entity = new CardapioEntity();

        entity.setId(domain.getId());
        entity.setRestauranteId(domain.getRestaurante().getId());
        entity.setNome(domain.getNome());
        entity.setDescricao(domain.getDescricao());
        entity.setPreco(domain.getPreco());
        entity.setConsumoLocal(domain.isConsumoLocal());
        entity.setFoto(domain.getFoto());

        return entity;
    }
}