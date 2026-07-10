package br.com.fiap.restauranteapi.core.dto.restaurante;

import java.time.LocalDateTime;

public record RestauranteDTO(

        Integer id,

        String nome,

        String endereco,

        String tipoCozinha,

        String horaAbertura,

        String horaFechamento,

        LocalDateTime dataCriacao

) {}