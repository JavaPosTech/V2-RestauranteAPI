package br.com.fiap.restauranteapi.infra.handler.dto;

public record MethodArgumentNotValidResponseDTO(

        String campo,

        String mensagem

) {}