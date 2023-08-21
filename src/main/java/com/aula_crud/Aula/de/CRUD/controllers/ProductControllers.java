package com.aula_crud.Aula.de.CRUD.controllers;

import com.aula_crud.Aula.de.CRUD.DTOS.ProductRecordDTO;
import com.aula_crud.Aula.de.CRUD.models.ProductModel;
import com.aula_crud.Aula.de.CRUD.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ProductControllers {
    /**
     * Controllers: Os Controllers são responsáveis por
     * receber as requisições HTTP do cliente e encaminhá-las
     * para o processamento adequado. Eles geralmente contêm métodos
     * anotados com @RequestMapping, @GetMapping, @PostMapping, etc.,
     * que mapeiam as URLs e métodos HTTP para as ações corretas no backend.
     *
     */

    final
    ProductRepository productRepository;

    public ProductControllers(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //Post usado para persistencia de dados na tabela
    // Muito da estrtura abaixo ainda tenho que estudar mais para entende-la 100%
    // abaixo usamos as classes ProductModel (Entitie) o DTO (Recebe os valores do Front)
    // BeanUils e copyprops de DTO para Model, oque nao entendi 100%, 35%
    // e o return, usa a classe com @autowired, e a funcão JPA de save dados

    @PostMapping("/products")
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductRecordDTO productRecordDTO){
         var productModel = new ProductModel();
        BeanUtils.copyProperties(productRecordDTO, productModel);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productRepository.save(productModel));
    }

    // Get é usado para amostragem de dados
    // Listar todos produtos
    @GetMapping("/products")
    public ResponseEntity<List<ProductModel>> getAllProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.findAll());
    }

     // Listar produto unico por ID
    @GetMapping("/products/{id}")
    public ResponseEntity<Object> getOneProduct(@PathVariable(value = "id") UUID id){
        Optional<ProductModel> product0 = productRepository.findById(id);
        return product0.<ResponseEntity<Object>>map(productModel -> ResponseEntity.status(HttpStatus.OK).body(productModel)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found."));
    }

    // Put para dar um UPDATE
    @PutMapping("/products/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value = "id") UUID id, @RequestBody @Valid ProductRecordDTO productRecordDTO){

        Optional<ProductModel> product0 = productRepository.findById(id);

        if (product0.isEmpty()){
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found on Update");
        }
        var productModel = product0.get(); // pegando o produto em si

        BeanUtils.copyProperties(productRecordDTO, productModel); //novamente esse loko de feijao

        return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productModel));


    }


    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value = "id") UUID id){
        Optional<ProductModel> product0 = productRepository.findById(id);
        if (product0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found on Delete");
        }
        productRepository.delete(product0.get());

        return ResponseEntity.status(HttpStatus.OK).body("Product deteleted successfully.");
    }




}
