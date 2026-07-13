package br.com.fiap.restauranteapi.core.dto.restaurante;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record RestauranteDTO(

        Integer id,

        String nome,

        String endereco,

        String tipoCozinha,

        String horaAbertura,

        String horaFechamento,

        String dataCriacao
) {
    public RestauranteDTO(Integer id, String nome, String endereco, String tipoCozinha, String horaAbertura, String horaFechamento, LocalDateTime dataCriacao) {
        this(id, nome, endereco, tipoCozinha, horaAbertura, horaFechamento, dataCriacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss")));
    }
}