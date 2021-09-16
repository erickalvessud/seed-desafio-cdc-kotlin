package com.deveficiente.validators.annotations

import com.deveficiente.validators.ValorUnicoValidator
import java.lang.annotation.Documented
import javax.validation.Constraint
import kotlin.reflect.KClass

@Documented
@Constraint(validatedBy = [ValorUnicoValidator::class])
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class ValorUnico(
        val message: String = "{com.deveficiente.beanvalidation.uniquevalue}",
        val groups: Array<KClass<Any>> = [],
        val payload: Array<KClass<Any>> = [],
        val fieldName: String,
        val domainClass: KClass<*>
)
