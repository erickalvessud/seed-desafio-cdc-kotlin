package com.deveficiente.repository

import com.deveficiente.entity.AutorEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AutorRepository: CrudRepository<AutorEntity, Long>