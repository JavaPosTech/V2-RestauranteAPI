package br.com.fiap.restauranteapi.infra.adapter.entity.tipousuario;

import br.com.fiap.restauranteapi.core.domain.tipousuario.TipoUsuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tipo_usuario", schema = "public")
public class TipoUsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column(nullable = false, unique = true, length = 50)
    private String descricao;

    public TipoUsuario toDomain() {
        return new TipoUsuario(id, descricao);
    }

    public static TipoUsuarioEntity fromDomain(TipoUsuario tipoUsuario) {
        TipoUsuarioEntity tipoUsuarioEntity = new TipoUsuarioEntity();

        tipoUsuarioEntity.setId(tipoUsuario.id());
        tipoUsuarioEntity.setDescricao(tipoUsuario.descricao());

        return tipoUsuarioEntity;
    }
}