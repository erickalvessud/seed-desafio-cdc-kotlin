package com.deveficiente.validators

import com.deveficiente.validators.annotations.ValorUnico
import java.util.*
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext
import kotlin.reflect.KClass

class ValorUnicoValidator(@PersistenceContext val manager: EntityManager): ConstraintValidator<ValorUnico, Any> {

    lateinit var clazz: KClass<*>
    lateinit var fieldName: String

    override fun initialize(constraintAnnotation: ValorUnico) {
        clazz = constraintAnnotation.domainClass
        fieldName = constraintAnnotation.fieldName
    }

    override fun isValid(value: Any?, context: ConstraintValidatorContext?) =
        manager.createQuery("SELECT t FROM ${clazz.simpleName} t WHERE t.$fieldName = :value", clazz.java)
            .setParameter("value", value)
            .resultList.isEmpty()
}
