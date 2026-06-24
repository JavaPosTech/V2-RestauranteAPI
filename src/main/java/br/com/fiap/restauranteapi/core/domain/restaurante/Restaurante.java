package br.com.fiap.restauranteapi.core.domain.restaurante;

import br.com.fiap.restauranteapi.core.domain.usuario.Usuario;

public record Restaurante(

        Integer id,

        Usuario usuario,

        String nome,

        String endereco,

        Integer tipoCozinhaId,

        String horaAbertura,

        String horaFechamento,

        String dataCriacao

) {}