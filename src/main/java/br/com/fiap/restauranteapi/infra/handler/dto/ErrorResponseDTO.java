package br.com.fiap.restauranteapi.infra.handler.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.net.URI;
import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ErrorResponseDTO(

        int status,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy - HH:mm:ss")
        LocalDateTime timestamp,

        String title,

        String instance,

        URI type,

        String detail,

        Object errors

) {
    public ErrorResponseDTO(int pStatus, String pTitle, String pInstance, String pType, String pDetail, Object pErrors) {
        this(pStatus, LocalDateTime.now(), pTitle, pInstance, URI.create(pType), pDetail, pErrors);
    }

    public ErrorResponseDTO(int pStatus, String pTitle, String pInstance, String pType, String pDetail) {
        this(pStatus, LocalDateTime.now(), pTitle, pInstance, URI.create(pType), pDetail, null);
    }
}