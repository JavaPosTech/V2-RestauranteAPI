package br.com.fiap.restauranteapi.core.domain.tipousuario;

import br.com.fiap.restauranteapi.core.exceptions.RegraDeNegocioException;
import lombok.Getter;

@Getter
public class TipoUsuario {

    private Integer id;

    private String descricao;

    public TipoUsuario(Integer id) {
        this.id = id;
    }

    public TipoUsuario(Integer id, String descricao) {
        if (descricao == null || descricao.isBlank()) {
            throw new RegraDeNegocioException("A descrição do Tipo de Usuário é obrigatória!");
        }

        this.id = id;
        this.descricao = descricao.toUpperCase();
    }

    public static TipoUsuario criar(String descricao) {
        return new TipoUsuario(null, descricao);
    }
}