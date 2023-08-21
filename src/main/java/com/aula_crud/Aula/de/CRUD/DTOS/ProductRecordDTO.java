package com.aula_crud.Aula.de.CRUD.DTOS;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductRecordDTO(@NotBlank  String name, @NotNull BigDecimal value) {
/**
 * Resumidamente: Codigos de conexão com o frontend
 * DTOs (): DTOs são objetos que carregam dados
 *  * entre o frontend e o backend.
 *  * Eles servem como um envelope para transmitir dados entre os Controllers
 *  * e os Services, fornecendo uma maneira estruturada de transportar informações
 *  * sem expor diretamente os modelos de domínio (Entities).Data Transfer Objects
 */
}
