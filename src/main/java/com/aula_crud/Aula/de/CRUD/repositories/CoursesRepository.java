package com.aula_crud.Aula.de.CRUD.repositories;

import com.aula_crud.Aula.de.CRUD.models.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository extends JpaRepository<Courses, Long> {
    /**
     * Repository: O padrão Repository é comumente usado no Spring Boot
     * para encapsular a interação com o banco de dados.
     * Ele fornece métodos para criar, ler, atualizar e excluir
     * registros no banco de dados relacionado à entidade correspondente.
     * Esses métodos são usados pelos serviços para persistência e recuperação de dados.
     * **/
}
