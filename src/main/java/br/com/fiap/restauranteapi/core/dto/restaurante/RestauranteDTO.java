package br.com.fiap.restauranteapi.core.dto.restaurante;

public record RestauranteDTO(

        Integer id,

        String nome,

        String endereco,

        String tipoCozinha,

        String horaAbertura,

        String horaFechamento,

        String dataCriacao

) {}