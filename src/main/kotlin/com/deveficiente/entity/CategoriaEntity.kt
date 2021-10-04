package com.deveficiente.entity

import javax.persistence.*

@Entity
@Table(name = "categoria")
data class CategoriaEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @Column(length = 255, nullable = false)
        val nome: String
)
