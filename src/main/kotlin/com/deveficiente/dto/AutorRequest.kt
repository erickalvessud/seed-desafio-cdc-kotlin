package com.deveficiente.dto

import com.deveficiente.entity.AutorEntity
import com.deveficiente.validators.annotations.ValorUnico
import org.hibernate.validator.constraints.Length
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

data class AutorRequest(
        @field:NotBlank
        val nome: String?,

        @field:NotBlank
        @field:Email
        @ValorUnico(fieldName = "email", domainClass = AutorEntity::class)
        val email: String?,

        @field:NotBlank
        @field:Length(max = 400)
        val descricao: String?
) {
        fun toEntity() = AutorEntity(0, this.nome!!, this.email!!, this.descricao!!)
}
