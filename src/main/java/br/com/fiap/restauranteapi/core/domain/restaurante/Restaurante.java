package br.com.fiap.restauranteapi.core.domain.restaurante;

public record Restaurante(

        Integer id,

        Integer usuarioId,

        String nome,

        String endereco,

        Integer tipoCozinhaId,

        String horaAbertura,

        String horaFechamento,

        String dataCriacao

) {}