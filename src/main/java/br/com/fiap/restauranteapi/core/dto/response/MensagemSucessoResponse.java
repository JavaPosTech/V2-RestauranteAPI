package br.com.fiap.restauranteapi.core.dto.response;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record MensagemSucessoResponse(

        int status,

        String timestamp,

        String mensagem

) {
    public MensagemSucessoResponse(int pStatus, String pMessage) {
        this(pStatus, LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), pMessage);
    }
}