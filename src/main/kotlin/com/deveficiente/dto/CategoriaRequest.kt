package com.deveficiente.dto

import com.deveficiente.entity.CategoriaEntity
import javax.validation.constraints.NotBlank

data class CategoriaRequest(@field:NotBlank val nome: String?) {
    fun toEntity(categoriaRequest: CategoriaRequest)
        = CategoriaEntity(0, this.nome!!)
}
