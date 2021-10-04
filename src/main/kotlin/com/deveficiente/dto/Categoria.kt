package com.deveficiente.dto

import com.deveficiente.entity.CategoriaEntity
import com.deveficiente.validators.annotations.ValorUnico
import javax.validation.constraints.NotBlank

data class Categoria(
        var id: Long? = 0,

        @field:NotBlank
        @ValorUnico(fieldName = "nome", domainClass = CategoriaEntity::class)
        val nome: String?
){
    fun toEntity()
        = CategoriaEntity(id!!, this.nome!!)

    companion object {
        fun fromEntities(categoriasEntities: MutableIterable<CategoriaEntity>) = categoriasEntities.map(::fromEntity)

        fun fromEntity(categoriaEntity: CategoriaEntity) = categoriaEntity.run {
            Categoria(
                    this.id,
                    this.nome
            )
        }
    }
}

