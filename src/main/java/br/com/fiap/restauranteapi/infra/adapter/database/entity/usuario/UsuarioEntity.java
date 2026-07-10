package br.com.fiap.restauranteapi.infra.adapter.database.entity.usuario;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "usuario", schema = "public")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column(nullable = false, length = 50)
    private String nome;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String sobrenome;

    @NotNull
    @Column(name = "id_tipousuario", nullable = false)
    private Integer tipoUsuarioId;

    @Column(name = "data_criacao", insertable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @NotNull
    @Column(name = "id_situacaocadastro", nullable = false)
    private Integer situacaoCadastroId;

}