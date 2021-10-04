package com.deveficiente.controller

import com.deveficiente.controller.util.unwrap
import com.deveficiente.dto.Categoria
import com.deveficiente.entity.CategoriaEntity
import com.deveficiente.repository.CategoriaRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.transaction.Transactional
import javax.validation.Valid

@RestController
@RequestMapping("/categorias")
class CategoriaController(val categoriaRepository: CategoriaRepository) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun buscarTodos(): List<Categoria> {
        return categoriaRepository.findAll().let(Categoria::fromEntities)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    fun cadastra(@RequestBody @Valid categoria: Categoria) {
        categoria.toEntity().let(categoriaRepository::save)
    }

    @PutMapping("/{idCategoria}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    fun alterar(@PathVariable("idCategoria") idCategoria: Long, @RequestBody @Valid categoria: Categoria): ResponseEntity<Any> {
        println("IdCategoria = $idCategoria, categoria $categoria")
        val categoriaEntity = categoriaRepository.findById(idCategoria).unwrap()
                ?: return ResponseEntity.badRequest().build()

        return categoriaEntity.copy(nome = categoria.nome!!)
                .let(categoriaRepository::save)
                .let(Categoria::fromEntity)
                .let {
                    ResponseEntity.ok(it)
                }
    }
}