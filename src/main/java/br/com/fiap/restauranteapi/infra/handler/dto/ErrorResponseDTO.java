package br.com.fiap.restauranteapi.infra.handler.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.net.URI;
import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ErrorResponseDTO(

        int status,

        String title,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy - HH:mm:ss")
        LocalDateTime timestamp,

        String instance,

        URI type,

        String detail,

        Object errors

) {
    public ErrorResponseDTO(int pStatus, String pTitle, String pInstance, String pType, String pDetail, Object pErrors) {
        this(pStatus, pTitle, LocalDateTime.now(), pInstance, URI.create(pType), pDetail, pErrors);
    }

    public ErrorResponseDTO(int pStatus, String pTitle, String pInstance, String pType, String pDetail) {
        this(pStatus, pTitle, LocalDateTime.now(), pInstance, URI.create(pType), pDetail, null);
    }
}