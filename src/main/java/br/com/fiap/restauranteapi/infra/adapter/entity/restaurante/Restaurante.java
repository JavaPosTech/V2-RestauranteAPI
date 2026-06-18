package br.com.fiap.restauranteapi.infra.adapter.entity.restaurante;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "restaurante", schema = "public")
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "id_usuario", nullable = false)
    private Integer usuarioId;

    @NotBlank
    @Column(nullable = false, length = 50)
    private String nome;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String endereco;

    @NotNull
    @Column(name = "id_tipocozinha", nullable = false)
    private Integer tipoCozinhaId;

    @Column(name = "hora_abertura", nullable = false)
    private LocalTime horaAbertura;

    @Column(name = "hora_fechamento", nullable = false)
    private LocalTime horaFechamento;

    @Column(name = "data_criacao", insertable = false, updatable = false)
    private LocalDateTime dataCriacao;

}