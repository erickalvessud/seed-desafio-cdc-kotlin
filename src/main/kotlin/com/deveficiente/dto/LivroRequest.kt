package com.deveficiente.dto

import com.deveficiente.entity.AutorEntity
import com.deveficiente.entity.CategoriaEntity
import com.deveficiente.entity.LivroEntity
import com.deveficiente.validators.annotations.ValorUnico
import com.fasterxml.jackson.annotation.JsonFormat
import org.hibernate.validator.constraints.Length
import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.EntityManager
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class LivroRequest(

        @field:NotBlank
        @ValorUnico(fieldName = "titulo", domainClass = LivroEntity::class)
        val titulo: String?,

        @field:NotBlank
        @field:Length(max = 500)
        val resumo: String?,

        var sumario: String? = "",

        @field:NotNull
        @field:Min(20)
        val preco: BigDecimal?,

        @field:NotNull
        @field:Min(100)
        val numeroPagina: Int?,

        @field:NotNull
        @ValorUnico(fieldName = "isbn", domainClass = LivroEntity::class)
        val isbn: String?,

        @field:NotNull
        @field:JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
        val dataPublicacao: LocalDate?,

        @field:NotNull
        val idCategoria: Long?,

        @field:NotNull
        val idAutor: Long?
){

        fun toEntity(manager: EntityManager): LivroEntity {
                val categoriaEntity = manager.find(CategoriaEntity::class.java, idCategoria)
                val autorEntity = manager.find(AutorEntity::class.java, idAutor)

                return LivroEntity(0, titulo!!, resumo!!, sumario!!, preco!!, numeroPagina!!, isbn!!, dataPublicacao!!, categoriaEntity, autorEntity)
        }
}
