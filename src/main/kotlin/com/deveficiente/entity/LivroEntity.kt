package com.deveficiente.entity

import com.deveficiente.validators.annotations.ValorUnico
import org.hibernate.validator.constraints.Length
import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
@Table(name = "livro")
class LivroEntity(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @Column(unique = true, nullable = false, columnDefinition = "VARCHAR(255)")
        val titulo: String,

        @Column(nullable = false, columnDefinition = "VARCHAR(500)")
        val resumo: String,

        @Column(columnDefinition = "VARCHAR(4000)")
        var sumario: String? = "",

        val preco: BigDecimal,

        val numeroPagina: Int,

        val isbn: String,

        val dataPublicacao: LocalDate,

        @ManyToOne
        val categoria: CategoriaEntity,

        @ManyToOne
        val autor: AutorEntity
)