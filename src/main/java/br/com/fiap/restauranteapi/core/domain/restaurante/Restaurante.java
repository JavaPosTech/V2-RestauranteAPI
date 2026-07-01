package br.com.fiap.restauranteapi.core.domain.restaurante;

import br.com.fiap.restauranteapi.core.domain.usuario.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Restaurante {

    private Integer id;

    private Usuario usuario;

    private String nome;

    private String endereco;

    private String tipoCozinha;

    private String horaAbertura;

    private String horaFechamento;

    private String dataCriacao;

    public boolean pertenceAoUsuario(Integer usuarioId) {
        return !this.usuario.getId().equals(usuarioId);
    }
}