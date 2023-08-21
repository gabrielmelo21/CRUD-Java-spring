package com.aula_crud.Aula.de.CRUD.DTOS;

import jakarta.validation.constraints.NotBlank;

public record CoursesDTO(@NotBlank String categoria, @NotBlank String nome, @NotBlank String dificuldade) {
}
