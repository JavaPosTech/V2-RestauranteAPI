package br.com.fiap.restauranteapi.core.domain.tipousuario;

public record TipoUsuario(

        Integer id,

        String descricao

) {
    public static TipoUsuario toDomain(String descricao) {
        return new TipoUsuario(null, descricao);
    }
}