package br.com.fiap.restauranteapi.core.dto.usuario;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record UsuarioDTO(

        Integer id,

        String nome,

        String sobrenome,

        String tipoUsuario,

        String situacaoCadastro,

        String dataCriacao

) {
    public UsuarioDTO(Integer id, String nome, String sobrenome, String tipoUsuarioId, String situacaoCadastro, LocalDateTime dataCriacao) {
        this(id, nome, sobrenome, tipoUsuarioId, situacaoCadastro, dataCriacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss")));
    }
}