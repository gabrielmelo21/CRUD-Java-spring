package com.aula_crud.Aula.de.CRUD.models;

import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Entity
@Table(name = "TB_PRODUCTS")
public class ProductModel implements Serializable {
    /**
     * Models ou Entities: Representam os objetos de domínio
     * do seu aplicativo, refletindo a estrutura do banco de
     * dados ou as entidades de negócio relevantes. Essas classes
     * geralmente são anotadas com @Entity e são mapeadas para tabelas do banco de dados.
     */
    private static final long serialVersionUID = 1L;
    // GET E SETTERS
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idProduct;
    private String name;
    private BigDecimal value;


    public void setIdProduct(UUID idProduct) {
        this.idProduct = idProduct;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
