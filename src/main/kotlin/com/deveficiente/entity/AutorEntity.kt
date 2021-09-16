package com.deveficiente.entity

import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "autor")
class AutorEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @Column(length = 255, nullable = false)
        val nome: String,

        @Column(length = 255, nullable = false)
        val email: String,

        @Column(length = 400, nullable = false)
        val descricao: String
) {

    @CreationTimestamp
    @Column(name = "data_registro")
    lateinit var dataRegistro: LocalDateTime
        private set
}