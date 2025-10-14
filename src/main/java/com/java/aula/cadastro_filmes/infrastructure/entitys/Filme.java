package com.java.aula.cadastro_filmes.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "filme")
@Entity

public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "diretor")
    private String diretor;

    @Column(name = "ano_lancamento")
    private Integer anoLancamento;
}
