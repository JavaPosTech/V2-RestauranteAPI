package br.com.fiap.restauranteapi.infra.adapter.mapper.restaurante;

import br.com.fiap.restauranteapi.core.domain.restaurante.Restaurante;
import br.com.fiap.restauranteapi.core.domain.usuario.Usuario;
import br.com.fiap.restauranteapi.infra.adapter.database.entity.restaurante.RestauranteEntity;
import br.com.fiap.restauranteapi.infra.controller.dto.restaurante.RestauranteRequest;

import java.time.LocalTime;

public class RestauranteMapper {

    private RestauranteMapper() {}

    public static Restaurante toDomain(RestauranteRequest request) {
        Usuario usuario = new Usuario(request.usuarioId());
        return new Restaurante(
                null,
                usuario,
                request.nome(),
                request.endereco(),
                request.tipoCozinha(),
                request.horaAbertura(),
                request.horaFechamento(),
                null
        );
    }

    public static Restaurante toDomain(RestauranteEntity entity) {
        Usuario usuario = new Usuario(entity.getUsuarioId());
        return new Restaurante(
                entity.getId(),
                usuario,
                entity.getNome(),
                entity.getEndereco(),
                entity.getTipoCozinha(),
                entity.getHoraAbertura().toString(),
                entity.getHoraFechamento().toString(),
                entity.getDataCriacao());
    }

    public static RestauranteEntity toEntity(Restaurante domain) {
        RestauranteEntity entity = new RestauranteEntity();

        entity.setId(domain.getId());
        entity.setUsuarioId(domain.getUsuario().getId());
        entity.setNome(domain.getNome());
        entity.setEndereco(domain.getEndereco());
        entity.setTipoCozinha(domain.getTipoCozinha());
        entity.setHoraAbertura(LocalTime.parse(domain.getHoraAbertura()));
        entity.setHoraFechamento(LocalTime.parse(domain.getHoraFechamento()));

        return entity;
    }
}