package com.deveficiente.repository

import com.deveficiente.entity.CategoriaEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoriaRepository: CrudRepository<CategoriaEntity, Long>