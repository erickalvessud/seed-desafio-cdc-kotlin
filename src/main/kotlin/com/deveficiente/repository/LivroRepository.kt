package com.deveficiente.repository

import com.deveficiente.entity.LivroEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface LivroRepository: CrudRepository<LivroEntity, Long>