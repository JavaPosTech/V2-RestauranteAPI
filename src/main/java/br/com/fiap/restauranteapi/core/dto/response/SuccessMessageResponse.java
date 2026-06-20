package br.com.fiap.restauranteapi.core.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public record SuccessMessageResponse(

        int status,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy - HH:mm:ss")
        LocalDateTime timestamp,

        String mensagem

) {
    public SuccessMessageResponse(int pStatus, String pMessage) {
        this(pStatus, LocalDateTime.now(), pMessage);
    }
}