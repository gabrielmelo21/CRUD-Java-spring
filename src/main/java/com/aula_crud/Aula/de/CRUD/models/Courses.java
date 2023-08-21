package com.aula_crud.Aula.de.CRUD.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


@Data
@Entity
@Table(name = "cursos")
public class Courses  implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;

    @Column(name = "nome", length = 30, nullable = false)
    private String nome;

    @Column(name = "categoria", length = 12, nullable = false)
    private String categoria;

    @Column(name = "dificuldade", length = 12, nullable = false)
    private String dificuldade;

}
