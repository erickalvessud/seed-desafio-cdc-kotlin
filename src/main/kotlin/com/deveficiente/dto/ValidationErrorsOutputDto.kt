package com.deveficiente.dto

class ValidationErrorsOutputDto {

    val globalErrroMessages = ArrayList<String>()
    val fieldErrorMessages = ArrayList<FieldErrorOutputDto>()

    fun addError(error: String){
        globalErrroMessages.add(error)
    }

    fun addFieldError(field: String, errorMessage: String){
        fieldErrorMessages.add(FieldErrorOutputDto(field, errorMessage))
    }
}