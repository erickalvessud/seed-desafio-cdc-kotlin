package com.deveficiente.controller

import com.deveficiente.dto.AutorRequest
import com.deveficiente.repository.AutorRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/autor")
class AutorController(val autorRepository: AutorRepository) {

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    fun cadastra(@RequestBody @Valid  autor: AutorRequest){
        println("Cadastra autor $autor")
        this.autorRepository.save(autor.toEntity())
    }
}