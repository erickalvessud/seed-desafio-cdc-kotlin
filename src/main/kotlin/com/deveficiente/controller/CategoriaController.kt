package com.deveficiente.controller

import com.deveficiente.dto.CategoriaRequest
import com.deveficiente.repository.CategoriaRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/categoria")
class CategoriaController(val categoriaRepository: CategoriaRepository) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun cadastra(@RequestBody @Valid categoriaRequest: CategoriaRequest){
        categoriaRequest.toEntity(categoriaRequest).let(categoriaRepository::save)
    }
}