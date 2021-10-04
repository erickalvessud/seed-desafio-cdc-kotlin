package com.deveficiente.controller

import com.deveficiente.dto.Categoria
import com.deveficiente.dto.LivroRequest
import com.deveficiente.repository.LivroRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.persistence.EntityManager
import javax.transaction.Transactional
import javax.validation.Valid

@RestController
@RequestMapping("/livros")
class LivroController(val manager: EntityManager, val livroRepository: LivroRepository) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    fun cadastra(@Valid @RequestBody livroRequest: LivroRequest){
        println(livroRequest)
        this.manager.persist(livroRequest.toEntity(manager))
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun buscarTodos(){


    }
}