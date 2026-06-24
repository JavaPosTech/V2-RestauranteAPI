package br.com.fiap.restauranteapi.core.domain.usuario;

import br.com.fiap.restauranteapi.core.domain.tipousuario.TipoUsuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Usuario {

    private Integer id;

    private String nome;

    private String sobrenome;

    private TipoUsuario tipoUsuario;

    private LocalDateTime dataCriacao;

}