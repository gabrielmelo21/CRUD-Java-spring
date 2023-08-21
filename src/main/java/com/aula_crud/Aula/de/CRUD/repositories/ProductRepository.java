package com.aula_crud.Aula.de.CRUD.repositories;

import com.aula_crud.Aula.de.CRUD.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ProductRepository extends JpaRepository<ProductModel, UUID> {
    /**
     * Repository: O padrão Repository é comumente usado no Spring Boot
     * para encapsular a interação com o banco de dados.
     * Ele fornece métodos para criar, ler, atualizar e excluir
     * registros no banco de dados relacionado à entidade correspondente.
     * Esses métodos são usados pelos serviços para persistência e recuperação de dados.
     * **/
}
