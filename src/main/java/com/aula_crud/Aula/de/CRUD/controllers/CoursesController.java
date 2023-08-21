package com.aula_crud.Aula.de.CRUD.controllers;

import com.aula_crud.Aula.de.CRUD.DTOS.CoursesDTO;
import com.aula_crud.Aula.de.CRUD.DTOS.ProductRecordDTO;
import com.aula_crud.Aula.de.CRUD.models.Courses;
import com.aula_crud.Aula.de.CRUD.models.ProductModel;
import com.aula_crud.Aula.de.CRUD.repositories.CoursesRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CoursesController {
     //o final é uma boa pratica, para evitar com que de alguma forma
    // essa instancia seja alterada
    private final CoursesRepository coursesRepository;

    //aqui podemos usar o @autowired
    //porem uma boa pratica é usar o constrctor
    // o lombok fornece uma anotação para colocar todos args em um construtor, reduzindo codigo

    //aqui o certo é usar paginação, pois listar todos os dados de uma tabela
    // iria explodir o sistema :)

    @GetMapping
    public List<Courses> list(){

         return coursesRepository.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Courses> saveCourse(@RequestBody @Valid  CoursesDTO coursesDTO){
         var courses = new Courses();
        BeanUtils.copyProperties(coursesDTO, courses);    //q q isso faz expecificamente
        return ResponseEntity.status(HttpStatus.CREATED).body(coursesRepository.save(courses));

    }


    // Put para dar um UPDATE
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Object> updateCourse(@PathVariable(value = "id") Long id, @RequestBody @Valid CoursesDTO coursesDTO){

        Optional<Courses> courseSelected = coursesRepository.findById(id);

        if (courseSelected.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso Não encontrado, tente novamente.");
        }
        var course = courseSelected.get(); // pegando o valor

        BeanUtils.copyProperties(coursesDTO, course); //novamente esse loko de feijao

        return ResponseEntity.status(HttpStatus.OK).body(coursesRepository.save(course));


    }


    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Object> deleteCourse(@PathVariable(value = "id") Long id){
        //pega a instancia de curso pelo id
        Optional<Courses> courseSelected = coursesRepository.findById(id);
        //verifica se o curso existe
        if (courseSelected.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso Não encontrado, tente novamente.");
        }
        //acessa a Entity e usa o metodo delete, como parametro temos o dado em si, apartir do .get obtemos seu valor
        coursesRepository.delete(courseSelected.get());


        return ResponseEntity.status(HttpStatus.OK).body("Curso Deletado com sucesso!");
    }




}
